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

package org.flora.expression;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 7cat
 * @since 1.0
 */
public class SqlCalculationExpressionParserTest {

	CalculationExpressionParser<String> calculationExpressionParser = new SqlCalculationExpressionParser();

	/**
	 * Test method for
	 * {@link org.flora.expression.SqlCalculationExpressionParser#eval(java.lang.String, org.flora.expression.CalculationContext)}.
	 */
	@Test
	public void testEval() {
		Assert.assertEquals(calculationExpressionParser.eval("2+2;", null), "2 + 2");
		Assert.assertEquals(calculationExpressionParser.eval("[TABLE.FIELD1]+2;", null), "TABLE.FIELD1 + 2");
		Assert.assertEquals(calculationExpressionParser.eval("#2018-03-02#;", null), "'2018-03-02'");
		Assert.assertEquals(calculationExpressionParser.eval("NATIVE('ABS',-55)-22;", null), "ABS ( - 55 ) - 22");
	}

}
