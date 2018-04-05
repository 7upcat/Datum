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

import org.flora.FloraException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 7cat
 * @since 1.0
 */
public class ArithmeticExpressionTest {

	@Test
	public void testValidExpression() {
		ExpressionUtils.parse("-2");
		ExpressionUtils.parse("2+5");
		ExpressionUtils.parse("-(2+5)");
		try {
			ExpressionUtils.parse("2+");
			Assert.fail("2+");
		}
		catch (FloraException e) {
		}
		ExpressionUtils.parse("ABS(55)");
		ExpressionUtils.parse("ABS(-55)");
		ExpressionUtils.parse("ABS(-55)-20");
		ExpressionUtils.parse("-ABS(-55)-20");
		try {
			ExpressionUtils.parse("-ABS(-55)+");
			Assert.fail("-ABS(-55)+");
		}
		catch (FloraException e) {
		}

		ExpressionUtils.parse("-ABS([TABLE.FIELD])-[TABLE.FIELD2]");
		
		ExpressionUtils.parse("[TABLE1.FIELD2]+1234");
	}
}
