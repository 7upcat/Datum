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
