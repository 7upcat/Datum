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

package org.mipha.olap.datasource.sql.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mipha.BusinessException;
import org.mipha.common.Constants;
import org.mipha.common.ResponseCodes;
import org.mipha.olap.OlapService;
import org.mipha.olap.domain.Connector;
import org.mipha.olap.domain.Field;
import org.mipha.olap.domain.PhysicalTable;
import org.mipha.util.DBUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.MetaDataAccessException;

/**
 * 关系型数据库类型的数据源元数据解析器.
 * 
 * @author 7cat
 * @since 1.0
 */
public class JdbcOlapService implements OlapService<PhysicalTable> {

	private static final String COLUMN_NAME_PATTERN_ANY = "%";

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
					JdbcOlapService.COLUMN_NAME_PATTERN_ANY);) {
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
						JdbcOlapService.COLUMN_NAME_PATTERN_ANY);) {
					t.setColumns(extractDataSet(columnRs, Field.class));
				}
				return t;
			}
		});
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
			throw new BusinessException(ResponseCodes.RESPONSE_CODE_EXTRACT_TABLE_METADATA_ERROR, e);
		}
	}
}
