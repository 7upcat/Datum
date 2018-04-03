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

import java.sql.Types;
import java.util.List;

import org.junit.Test;
import org.mipha.common.TestConstants;
import org.mipha.factory.ConnectorFactory;
import org.mipha.olap.datasource.sql.support.JdbcOlapService;
import org.mipha.olap.domain.Connector;
import org.mipha.olap.domain.Field;
import org.mipha.olap.domain.TableLike;
import org.mipha.test.BaseTest;

import static org.junit.Assert.*;

/**
 * @author 7cat
 * @since 1.0
 */
public class JdbcOlapServiceTest extends BaseTest {

	@Test
	public void testResolveTables() {
		JdbcOlapService resolver = new JdbcOlapService();
		List<TableLike> tables = resolver.resolveTables(ConnectorFactory.newSampleDBConnector());
		assertEquals(3, tables.size());
	}

	@Test
	public void testResolveFields() {
		JdbcOlapService resolver = new JdbcOlapService();
		Connector connector = ConnectorFactory.newSampleDBConnector();
		TableLike table = resolver.resolveTables(connector).stream().filter(
				t -> TestConstants.TABLE_CUST_BASIC_INFO.equals(t.getTableName())).findAny().get();
		Field cusIdColumn = resolver.resolveFields(connector, table).stream().filter(
				c -> TestConstants.FIELD_CUS_ID.equals(c.getColumnName())).findAny().get();
		assertEquals(Types.CHAR, cusIdColumn.getDataType());
	}
}
