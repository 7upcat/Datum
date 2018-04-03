/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
import org.mipha.olap.domain.TableLike;
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
public class JdbcOlapService implements OlapService {

	private static final String COLUMN_NAME_PATTERN_ANY = "%";

	@Override
	public List<TableLike> resolveTables(Connector connector) {
		return extractDatabaseMetaData(connector, (dbmd) -> {
			try (ResultSet rs = dbmd.getTables(null, null, null,
					new String[] { Constants.TABLE_TYPE_TABLE, Constants.TABLE_TYPE_VIEW });) {
				List<TableLike> tables = extractDataSet(rs, TableLike.class);
				tables.stream().forEach(s -> s.setConnectorId(connector.getId()));
				return tables;
			}
		});
	}

	@Override
	public List<Field> resolveFields(Connector connector, TableLike table) {

		return extractDatabaseMetaData(connector, (bdmd) -> {
 			try (ResultSet rs = bdmd.getColumns(table.getTableCatalog(), table.getTableSchema(), table.getTableName(),
					JdbcOlapService.COLUMN_NAME_PATTERN_ANY);) {
				return extractDataSet(rs, Field.class);
			}
		});
	}

	@Override
	public TableLike resolveTable(Connector connector, TableLike table) {

		return extractDatabaseMetaData(connector, (dbmd) -> {
			try (ResultSet rs = dbmd.getTables(table.getTableCatalog(), table.getTableSchema(), table.getTableName(),
					new String[] { Constants.TABLE_TYPE_TABLE, Constants.TABLE_TYPE_VIEW });) {
				TableLike t = extractDataSet(rs, TableLike.class).get(0);
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
