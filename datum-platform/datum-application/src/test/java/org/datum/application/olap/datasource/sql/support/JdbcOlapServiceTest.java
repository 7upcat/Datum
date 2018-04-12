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

package org.datum.application.olap.datasource.sql.support;

import java.sql.Types;
import java.util.List;

import org.datum.application.common.TestConstants;
import org.datum.application.factory.ConnectorFactory;
import org.datum.application.olap.OlapService;
import org.datum.application.olap.datasource.sql.support.JdbcOlapService;
import org.datum.application.olap.domain.Connector;
import org.datum.application.olap.domain.Field;
import org.datum.application.olap.domain.PhysicalTable;
import org.datum.application.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 7cat
 * @since 1.0
 */
public class JdbcOlapServiceTest extends BaseTest {

	@Test
	public void testResolveTables() {
		OlapService<PhysicalTable> resolver = new JdbcOlapService();
		List<PhysicalTable> tables = resolver.resolveTables(ConnectorFactory.newSampleDBConnector());
		assertEquals(3, tables.size());
	}

	@Test
	public void testResolveFields() {
		JdbcOlapService resolver = new JdbcOlapService();
		Connector connector = ConnectorFactory.newSampleDBConnector();
		PhysicalTable table = resolver.resolveTables(connector).stream().filter(
				t -> TestConstants.TABLE_CUST_BASIC_INFO.equals(t.getTableName())).findAny().get();
		Field cusIdColumn = resolver.resolveFields(connector, table).stream().filter(
				c -> TestConstants.FIELD_CUS_ID.equals(c.getColumnName())).findAny().get();
		assertEquals(Types.CHAR, cusIdColumn.getDataType());
	}
}
