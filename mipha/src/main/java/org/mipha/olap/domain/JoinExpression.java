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

import org.jooq.Field;
import org.jooq.impl.JooqUtils;

import static org.jooq.impl.DSL.*;

/**
 * 表关联的求值表达式.
 * 
 * @author 7cat
 * @since 1.0
 */
public class JoinExpression implements FieldLike {

	private TableLike table;

	private String expression;
	
	public JoinExpression() {
	}

	public JoinExpression(TableLike table, String expression) {
		this.table = table;
		this.expression = expression;
	}

	@Override
	public Field<?> asField() {
		return field(expression);
	}

	public String validationSql() {
		return select(asField()).from(table(table.getTableName())).where(JooqUtils.falseCondition()).getSQL();
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public TableLike getTable() {
		return table;
	}

	public void setTable(TableLike table) {
		this.table = table;
	}
}
