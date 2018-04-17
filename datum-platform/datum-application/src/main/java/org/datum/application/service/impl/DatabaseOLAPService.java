/*
 * Copyright (c) 2018-present the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.datum.application.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.datum.DatumCoreException;
import org.datum.application.common.Constants;
import org.datum.application.common.ErrorCodes;
import org.datum.application.domain.Connector;
import org.datum.application.domain.Cube;
import org.datum.application.domain.DataSet;
import org.datum.application.domain.Dimension;
import org.datum.application.domain.Field;
import org.datum.application.domain.PhysicalTable;
import org.datum.application.service.OLAPService;
import org.datum.application.util.DBUtils;
import org.datum.expression.dialect.Database;
import org.datum.expression.dialect.Dialect;
import org.datum.expression.dialect.DialectResolutionInfo;
import org.datum.expression.dialect.MetaDataDialectResolutionInfo;
import org.jooq.JoinType;
import org.jooq.Record;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnStep;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.MetaDataAccessException;

import static org.jooq.impl.DSL.*;

/**
 * 关系型数据库类型的数据源元数据解析器.
 * 
 * @author 7cat
 * @since 1.0
 */
public class DatabaseOLAPService implements OLAPService<PhysicalTable, Field> {

	private static final String COLUMN_NAME_PATTERN_ANY = "%";

	private Map<String, JoinType> joinTypesMapping = new HashMap<>();

	public DatabaseOLAPService() {
		joinTypesMapping.put(Dimension.JOIN_TYPE_INNER, JoinType.JOIN);
		joinTypesMapping.put(Dimension.JOIN_TYPE_LEFT, JoinType.LEFT_OUTER_JOIN);
		joinTypesMapping.put(Dimension.JOIN_TYPE_RIGHT, JoinType.RIGHT_OUTER_JOIN);
	}

	@Override
	public List<PhysicalTable> resolveTables(Connector connector) {
		return extractDatabaseMetaData(connector, (dbmd) -> {
			try (ResultSet rs = dbmd.getTables(null, null, null,
					new String[] { Constants.TABLE_TYPE_TABLE, Constants.TABLE_TYPE_VIEW });) {
				List<PhysicalTable> tables = extractDataSet(rs, PhysicalTable.class);
				tables.stream().forEach(s -> s.setConnectorId(connector.getId()));
				return tables;
			}
		});
	}

	@Override
	public List<Field> resolveFields(Connector connector, PhysicalTable table) {

		return extractDatabaseMetaData(connector, (bdmd) -> {
			try (ResultSet rs = bdmd.getColumns(table.getTableCatalog(), table.getTableSchema(), table.getTableName(),
					DatabaseOLAPService.COLUMN_NAME_PATTERN_ANY);) {
				return extractDataSet(rs, Field.class);
			}
		});
	}

	@Override
	public PhysicalTable resolveTable(Connector connector, PhysicalTable table) {

		return extractDatabaseMetaData(connector, (dbmd) -> {
			try (ResultSet rs = dbmd.getTables(table.getTableCatalog(), table.getTableSchema(), table.getTableName(),
					new String[] { Constants.TABLE_TYPE_TABLE, Constants.TABLE_TYPE_VIEW });) {
				PhysicalTable t = extractDataSet(rs, PhysicalTable.class).get(0);
				t.setConnectorId(connector.getId());
				try (ResultSet columnRs = dbmd.getColumns(t.getTableCatalog(), t.getTableSchema(), t.getTableName(),
						DatabaseOLAPService.COLUMN_NAME_PATTERN_ANY);) {
					t.setColumns(extractDataSet(columnRs, Field.class));
				}
				return t;
			}
		});
	}

	@Override
	public DataSet<Field> fetchData(Connector connector, Cube cube) {
		SelectJoinStep<Record> fact = using((DataSource) null, null).select(cube.getFields().stream().map((c) -> {
			return field(c.asField()).as(c.getColumnNameAlias());
		}).collect(Collectors.toList())).from(cube.getFact().getTableName());

		cube.getDimensions().stream().forEach(d -> {
			SelectOnStep<Record> joinStep = fact.join(table(d.getTarget().getTableName()),
					joinTypesMapping.get(d.getType()));
			Arrays.stream(d.getConditions()).forEach(c -> joinStep.on(c.asCondition(resolveDialect(connector))));
		});

		JdbcTemplate template = new JdbcTemplate(DBUtils.newDataSource(connector));
		return new DataSet<Field>(cube.getFields(), template.queryForList(fact.getSQL()));
	}
	
	
	private <T> List<T> extractDataSet(ResultSet resultSet, Class<T> clazz) throws SQLException {
		return new RowMapperResultSetExtractor<>(new BeanPropertyRowMapper<>(clazz)).extractData(resultSet);
	}

	@SuppressWarnings("unchecked")
	private <T> T extractDatabaseMetaData(Connector connector, DatabaseMetaDataCallback databaseMetaDataCallback) {
		try {
			return (T) JdbcUtils.extractDatabaseMetaData(DBUtils.newDataSource(connector), databaseMetaDataCallback);
		}
		catch (MetaDataAccessException e) {
			throw new DatumCoreException(ErrorCodes.EXTRACT_TABLE_METADATA_ERROR, e);
		}
	}

	private  Dialect resolveDialect(Connector connector) {
		return extractDatabaseMetaData(connector, (dbmd) -> {
			DialectResolutionInfo info = new MetaDataDialectResolutionInfo(dbmd);
			for (Database database : Database.values()) {
				Dialect dialect = database.resolveDialect(info);
				if (dialect != null) {
					return dialect;
				}
			}
			throw new DatumCoreException(ErrorCodes.DIALECT_NOT_FOUND);
		});
	}
}
