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

package org.flora.expression.literals;

import org.junit.Test;

/**
 * @author 7cat
 * @since 1.0
 */
public class ComparisonExpressionTest {

//	  arithmetic_expression (COMPARISON_OPERATOR) (arithmetic_expression|field)
//	  | string_expression (COMPARISON_OPERATOR) (string_expression|field)
//	  | date_expression (COMPARISON_OPERATOR) (date_expression|field)
//	  | field (COMPARISON_OPERATOR) ( arithmetic_expression|string_expression|date_expression)
//	  | comparison_expression (LOGICAL_OPERATOR) comparison_expression
//	  | '(' comparison_expression ')'
	
	@Test
	public void testExpression() {
		// arithmetic
		ExpressionUtils.parse("15>25;");
		ExpressionUtils.parse("15<25;");
		ExpressionUtils.parse("15==15;");
		ExpressionUtils.parse("15>=25;");
		ExpressionUtils.parse("15>=25 OR 15<5;");
		ExpressionUtils.parse("(15>=25) OR 15<5;");
		ExpressionUtils.parse("15>=25 OR (15<5);");
		ExpressionUtils.parse("(15>=25) OR (15<5);");
		ExpressionUtils.parse("15>=25 AND 15<5;");
		ExpressionUtils.parse("(15>=25) AND 15<5;");
		ExpressionUtils.parse("15>=25 AND (15<5);");
		ExpressionUtils.parse("(15>=25) AND (15<5);");
		// string
		ExpressionUtils.parse("'abcd'>'abc';");
		ExpressionUtils.parse("'abcd'>='abc';");
		ExpressionUtils.parse("'abcd'AND 15<5;");
		ExpressionUtils.parse("'abcd'>='22' OR '55'<'22';");
//		ExpressionUtils.parse("('abcd'>='22') OR '55'<'22';");
		ExpressionUtils.parse("('abcd'>='22') OR ('55'<'22');");
		
//		ExpressionUtils.parse("('abcd'>='22') AND '55'<'22';");
		
	}
}
