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

import java.sql.Driver;

import javax.sql.DataSource;

import org.mipha.BusinessException;
import org.mipha.common.Fields;
import org.mipha.common.ResponseCodes;
import org.mipha.olap.domain.Connector;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * 数据操作的脚手架方法.
 * 
 * @author 7cat
 * @since 1.0
 */
public final class DBUtils {

	public static DataSource newDataSource(Connector connector) {
		String driver = connector.getMetadata(Fields.JDBC_DRIVER);
		String url = connector.getMetadata(Fields.JDBC_URL);
		String username = connector.getMetadata(Fields.JDBC_USERNAME);
		String password = connector.getMetadata(Fields.JDBC_PASSWORD);
		try {
			SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
			dataSource.setDriverClass(Class.forName(driver).asSubclass(Driver.class));
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setUrl(url);
			return dataSource;
		}
		catch (ClassNotFoundException e) {
			throw new BusinessException(ResponseCodes.RESPONSE_CODE_DRIVER_CLASS_NOT_FOUND, driver, e);
		}

	}
}
