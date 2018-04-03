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

package org.mipha.factory;

import org.mipha.common.Fields;
import org.mipha.common.TestConstants;
import org.mipha.olap.domain.Connector;

/**
 * {@link Connector} 工厂用于构建单元测试中的使用的连接器.
 * 
 * @author 7cat
 * @since 1.0
 */
public final class ConnectorFactory {

	public static Connector newSampleDBConnector() {
		Connector connector = new Connector();
		connector.setName(TestConstants.SAMPLE_DB_NAME);
		connector.setType(Connector.CONNECTOR_TYPE_DB);
		connector.setDescribe(" A sample h2 memory db.");
		connector.addMetadata(Fields.JDBC_DRIVER, TestConstants.SAMPLE_DB_JDBC_DRIVER);
		connector.addMetadata(Fields.JDBC_URL, TestConstants.SAMPLE_DB_JDBC_URL);
		connector.addMetadata(Fields.JDBC_USERNAME, TestConstants.SAMPLE_DB_JDBC_USERNAME);
		connector.addMetadata(Fields.JDBC_PASSWORD, TestConstants.SAMPLE_DB_JDBC_PASSWPRD);
		return connector;
	}
}
