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

import org.datum.expression.CalculationContext;
import org.datum.expression.CalculationExpressionParser;
import org.datum.expression.SqlCalculationExpressionParser;
import org.datum.expression.dialect.Dialect;
import org.jooq.impl.DSL;

/**
 * 支持 datum-expression 的条件.
 * 
 * @author 7cat
 */
public class ExpressionCondition implements Condition {

	private CalculationExpressionParser<String> calculationExpressionParser = new SqlCalculationExpressionParser();

	private String expression;

	private Dialect dialect;

	public ExpressionCondition(String expression, Dialect dialect) {
		this.expression = expression;
		this.dialect = dialect;
	}

	@Override
	public org.jooq.Condition asCondition() {
		CalculationContext context = new CalculationContext();
		context.setDialect(this.dialect);
		return DSL.condition(calculationExpressionParser.eval(expression, context));
	}
}
