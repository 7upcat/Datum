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

package org.datum.application.service;

import java.util.List;

import org.datum.application.domain.Connector;
import org.datum.application.domain.Cube;
import org.datum.application.domain.DataSet;
import org.datum.application.domain.FieldLike;
import org.datum.application.domain.TableLike;

/**
 * 数据源元数据解析器.
 * 
 * @author 7cat
 * @since 1.0
 */
public interface OLAPService<T extends TableLike, F extends FieldLike> {

	/**
	 * 根据指定的 {@link Connector} 解析此连接包含的 {@link TableLike}列表 .
	 * 
	 * @param connector 连接器
	 * @return 连接器所拥有的 {@link TableLike} 列表
	 */
	List<T> resolveTables(Connector connector);

	/**
	 * 根据指定的 {@link Connector} 及表名获取表信息，包含了 {@link Field1} 信息.
	 * 
	 * @param connector 连接器
	 * @param table 表基础信息
	 * @return 完整的表信息,包含列信息
	 */
	T resolveTable(Connector connector, T table);

	/**
	 * 根据指定的 {@link Connector} 及 {@link TableLike} 获取栏位列表.
	 * 
	 * @param connector 连接器
	 * @param table 指定连接器下的表
	 * @return 指定 table 下的栏位列表
	 */
	List<F> resolveFields(Connector connector, T table);

	/**
	 * 根据指定的 {@link Cube} 获取数据集.
	 * 
	 * @param cube 立方体
	 * @return 预览的数据
	 */
	DataSet<F> fetchData(Connector connector, Cube cube);
}
