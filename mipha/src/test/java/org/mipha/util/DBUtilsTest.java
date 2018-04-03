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
