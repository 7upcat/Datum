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

package org.mipha.olap.domain;

/**
 * 值对象,同事实表相关联
 * <ul>
 * <li>Inner Join</li>
 * <li>Left Outer Join</li>
 * <li>Right Outer Join</li>
 * </ul>
 * 
 * 对于较多的数据库产品目前不支持 Full Outer Join 因此暂不支持.
 * 
 * @author 7cat
 * @since 1.0
 */
public class Dimension {

	public static final String JOIN_TYPE_INNER = "I";

	public static final String JOIN_TYPE_LEFT = "L";

	public static final String JOIN_TYPE_RIGHT = "R";

	public Dimension() {
	}

	public Dimension(String type, TableLike table, Condition... conditions) {
		this.type = type;
		this.target = table;
		this.conditions = conditions;
	}

	private String type;

	private TableLike target;

	private Condition[] conditions;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TableLike getTarget() {
		return target;
	}

	public void setTarget(TableLike target) {
		this.target = target;
	}

	public Condition[] getConditions() {
		return conditions;
	}

	public void setConditions(Condition[] conditions) {
		this.conditions = conditions;
	}

}
