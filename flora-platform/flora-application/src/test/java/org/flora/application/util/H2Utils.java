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

package org.flora.application.util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

import org.flora.application.olap.domain.Connector;
import org.flora.application.util.DBUtils;
import org.h2.tools.RunScript;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 单元测试中 h2 数据库常用的脚手架方法.
 * @author 7cat
 * @since 1.0
 */
public final class H2Utils {

	/**
	 * 初始化
	 * @param connector
	 * @param script
	 */
	public static void runScript(Connector connector, String script) {
		Resource resource = new ClassPathResource(String.format("scripts/%s", script));
		try (Connection connection = DBUtils.newDataSource(connector).getConnection()) {
			Reader reader = new InputStreamReader(resource.getInputStream(), "UTF-8");
			RunScript.execute(connection, reader);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
