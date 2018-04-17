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

package org.datum.application.olap;

import org.jooq.Comparator;

/**
 * 使用数据域比较的关联条件.
 * 
 * @author 7cat
 * @since 1.0
 */
public class CompareCondition implements Condition {

	public static final String COMPARATOR_EQUALS = "EQUALS";

	public static final String COMPARATOR_NOT_EQUALS = "NOT_EQUALS";

	public static final String COMPARATOR_LESS = "LESS";

	public static final String COMPARATOR_LESS_OR_EQUAL = "LESS_OR_EQUAL";

	public static final String COMPARATOR_GREATER = "GREATER";

	public static final String COMPARATOR_GREATER_OR_EQUAL = "GREATER_OR_EQUAL";

	private String comparator = CompareCondition.COMPARATOR_EQUALS;

	public CompareCondition(FieldLike left, FieldLike right) {
		this.left = left;
		this.right = right;
	}

	public CompareCondition(FieldLike left, FieldLike right, String comparator) {
		this.left = left;
		this.right = right;
		this.comparator = comparator;
	}

	@Override
	public org.jooq.Condition asCondition() {
		return getLeft().asField().compare(Comparator.valueOf( getComparator()), getRight().asField());
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
