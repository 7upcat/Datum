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

package org.datum.application.factory;

import org.datum.application.common.Fields;
import org.datum.application.common.TestConstants;
import org.datum.application.olap.domain.Connector;

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
