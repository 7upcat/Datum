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

	private OlapService metadataResolver = new JdbcOlapService();

	private JdbcTemplate jdbcTemplate;

	@Test
	public void test() {
		Connector connector = ConnectorFactory.newSampleDBConnector();
		connectorRepository.save(connector);
		jdbcTemplate = new JdbcTemplate(DBUtils.newDataSource(connector));
		TableLike custBasicInfo = metadataResolver.resolveTable(connector,
				TableLike.newTable(TestConstants.TABLE_CUST_BASIC_INFO));
		JoinExpression expression = new JoinExpression();
		expression.setExpression("concat(CUST_BASIC_INFO.ID_TYPE , CUST_BASIC_INFO.ID_NO)");
		expression.setTable(custBasicInfo);
		jdbcTemplate.execute(expression.validationSql());
	}
}
