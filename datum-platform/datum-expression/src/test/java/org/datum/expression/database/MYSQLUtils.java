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

package org.datum.expression.database;

import java.sql.Driver;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * @author 7cat
 * @since 1.0
 */
public final class MYSQLUtils {

	public static final String TEST_DB_JDBC_URL = "jdbc:h2:mem:MYSQLDB;MODE=MySQL";

	public static final String TEST_DB_JDBC_DRIVER = "org.h2.Driver";

	public static final String TEST_DB_JDBC_USERNAME = "";

	public static final String TEST_DB_JDBC_PASSWPRD = "";

	public static <T>T execute(String expression, Class<T> clazz) {
		try {
			SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
			dataSource.setDriverClass(Class.forName(TEST_DB_JDBC_DRIVER).asSubclass(Driver.class));
			dataSource.setUsername(TEST_DB_JDBC_USERNAME);
			dataSource.setPassword(TEST_DB_JDBC_PASSWPRD);
			dataSource.setUrl(TEST_DB_JDBC_URL);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			return jdbcTemplate.queryForObject(String.format("SELECT %s ", new Object[] { expression }), clazz);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}