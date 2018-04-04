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

package org.mipha.olap.domain;

import org.junit.Test;
import org.mipha.common.TestConstants;
import org.mipha.factory.ConnectorFactory;
import org.mipha.olap.OlapService;
import org.mipha.olap.datasource.sql.support.JdbcOlapService;
import org.mipha.test.BaseTest;
import org.mipha.util.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 单元测试验证 {@link JoinExpression} .
 * 
 * @author 7cat
 * @since 1.0
 */

public class JoinExpressionTest extends BaseTest {

	@Autowired
	private ConnectorRepository connectorRepository;

	private OlapService<PhysicalTable> metadataResolver = new JdbcOlapService();

	private JdbcTemplate jdbcTemplate;

	@Test
	public void test() {
		Connector connector = ConnectorFactory.newSampleDBConnector();
		connectorRepository.save(connector);
		jdbcTemplate = new JdbcTemplate(DBUtils.newDataSource(connector));
		TableLike custBasicInfo = metadataResolver.resolveTable(connector,
				PhysicalTable.newTable(TestConstants.TABLE_CUST_BASIC_INFO));
		JoinExpression expression = new JoinExpression();
		expression.setExpression("concat(CUST_BASIC_INFO.ID_TYPE , CUST_BASIC_INFO.ID_NO)");
		expression.setTable(custBasicInfo);
		jdbcTemplate.execute(expression.validationSql());
	}
}
