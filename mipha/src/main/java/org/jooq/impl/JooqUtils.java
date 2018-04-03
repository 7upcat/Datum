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
