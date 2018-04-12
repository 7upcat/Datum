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

package org.jooq.impl;

import org.jooq.Comparator;
import org.jooq.Condition;
import org.jooq.Field;

import static org.jooq.impl.DSL.*;

/**
 * 由于 Jooq {@link CompareCondition} 的访问的权限是包级别,通过此种 hack 方式 访问,后续优化是否有其他方式可以避免此种问题.
 * 
 * @author 7cat
 * @since 1.0
 */
public final class JooqUtils {

	public static final Condition newCompareCondition(Field<?> left, Field<?> right, String comparator) {
		return new CompareCondition(left, nullSafe(right, left.getDataType()), Comparator.valueOf(comparator));
	}

	public static final Condition falseCondition() {
		return FalseCondition.INSTANCE;
	}
}
