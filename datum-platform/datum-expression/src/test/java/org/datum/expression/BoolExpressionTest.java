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

package org.datum.expression;

import org.junit.Test;

/**
 * @author 7cat
 * @since 1.0
 */
public class BoolExpressionTest {

	@Test
	public void testExpression() {
		// arithmetic
		ExpressionUtils.parse("15>25;");
		ExpressionUtils.parse("15<25;");
		ExpressionUtils.parse("15=15;");
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
		ExpressionUtils.parse("'abcd'>='abc' AND 15<5;");
		ExpressionUtils.parse("'abcd'>='22' OR '55'<'22';");
		ExpressionUtils.parse("('abcd'>='22') OR '55'<='22';");
		ExpressionUtils.parse("('abcd'>='22' AND 123>456) OR ('55'<'22');");

		// field
		ExpressionUtils.parse("[TABLE.FIELD]> 'abc';");
		ExpressionUtils.parse("[TABLE.FIELD]<= (22+23-55/ABS(33));");
		ExpressionUtils.parse("[TABLE.FIELD]<= #2018-02-02#;");
		ExpressionUtils.parse("[TABLE.FIELD] <= #2018-02-02# AND [TABLE.FIELD2] >= 'abcd';");
		ExpressionUtils.parse("([TABLE.FIELD] <= #2018-02-02# AND [TABLE.FIELD2] >= 'abcd');");
		ExpressionUtils.parse("([TABLE.FIELD] <= #2018-02-02# AND [TABLE.FIELD2] >= 'abcd') OR 4>5;");
	}
}
