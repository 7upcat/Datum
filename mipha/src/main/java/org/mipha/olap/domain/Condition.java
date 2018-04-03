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
 * 值对象用来描述事实表和维度表之间关联的条件,当前版本仅支持左右相等,后续增加对于函数的支持.
 * 
 * @author 7cat
 * @since 1.0
 */
public class Condition {

	public static final String COMPARATOR_EQUALS = "EQUALS";

	public static final String COMPARATOR_NOT_EQUALS = "NOT_EQUALS";

	public static final String COMPARATOR_LESS = "LESS";

	public static final String COMPARATOR_LESS_OR_EQUAL = "LESS_OR_EQUAL";

	public static final String COMPARATOR_GREATER = "GREATER";

	public static final String COMPARATOR_GREATER_OR_EQUAL = "GREATER_OR_EQUAL";

	private String comparator = Condition.COMPARATOR_EQUALS;

	public Condition(FieldLike left, FieldLike right) {
		this.left = left;
		this.right = right;
	}

	public Condition(FieldLike left, FieldLike right, String comparator) {
		this.left = left;
		this.right = right;
		this.comparator = comparator;
	}

	private FieldLike left;

	private FieldLike right;

	public FieldLike getLeft() {
		return left;
	}

	public void setLeft(FieldLike left) {
		this.left = left;
	}

	public FieldLike getRight() {
		return right;
	}

	public void setRight(FieldLike right) {
		this.right = right;
	}

	public String getComparator() {
		return comparator;
	}

	public void setComparator(String comparator) {
		this.comparator = comparator;
	}

}
