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

package org.mipha.util;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.mipha.factory.ConnectorFactory;
import org.mipha.olap.domain.Connector;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * {@link DBUtils} 的单元测试案例.
 * 
 * @author 7cat
 * @since 1.0
 */
public class DBUtilsTest {

	@Test
	public void testNewDataSource() throws SQLException {
		Connector connector = ConnectorFactory.newSampleDBConnector();
		JdbcTemplate template = new JdbcTemplate(DBUtils.newDataSource(connector));
		Integer number = template.queryForObject("SELECT 1", Integer.class);
		Assert.assertEquals(new Integer(1), number);
	}
}
