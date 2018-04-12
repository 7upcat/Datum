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

package org.datum.application.util;

import java.sql.Driver;

import javax.sql.DataSource;

import org.datum.DatumCoreException;
import org.datum.application.common.ErrorCodes;
import org.datum.application.common.Fields;
import org.datum.application.olap.domain.Connector;
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
			throw new DatumCoreException(ErrorCodes.DRIVER_CLASS_NOT_FOUND, driver, e);
		}

	}
}
