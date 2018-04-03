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

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

import org.h2.tools.RunScript;
import org.mipha.olap.domain.Connector;
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
