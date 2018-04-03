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

package org.mipha.olap;

import java.util.List;

import org.mipha.olap.domain.Connector;
import org.mipha.olap.domain.Field;
import org.mipha.olap.domain.TableLike;

/**
 * 数据源元数据解析器.
 * 
 * @author 7cat
 * @since 1.0
 */
public interface OlapService {

	/**
	 * 根据指定的 {@link Connector} 解析此连接包含的 {@link TableLike}列表 .
	 * 
	 * @param connector 连接器
	 * @return 连接器所拥有的 {@link TableLike} 列表
	 */
	List<TableLike> resolveTables(Connector connector);

	/**
	 * 根据指定的 {@link Connector} 及表名获取表信息，包含了 {@link Field1} 信息.
	 * 
	 * @param connector 连接器
	 * @param table 表基础信息
	 * @return 完整的表信息,包含列信息
	 */
	TableLike resolveTable(Connector connector, TableLike table);

	/**
	 * 根据指定的 {@link Connector} 及 {@link TableLike} 获取栏位列表.
	 * 
	 * @param connector 连接器
	 * @param table 指定连接器下的表
	 * @return 指定 table 下的栏位列表
	 */
	List<Field> resolveFields(Connector connector, TableLike table);
}
