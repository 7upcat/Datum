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
public class StringExpressionTest {

	@Test
	public void test() {
		ExpressionUtils.parse("'str1';");
		ExpressionUtils.parse("('str1');");
		ExpressionUtils.parse("'str1' + 'str2';");
		ExpressionUtils.parse("('str1' + 'str2');");
		ExpressionUtils.parse("'str1' + ('str2');");
		ExpressionUtils.parse("'str1' + 'str2'+'str3';");
		ExpressionUtils.parse("LOWER('ABCD');");
//		ExpressionUtils.parse("LOWER('ABCD')+'abcd';");
		ExpressionUtils.parse("'str1' + LOWER('ABCD');");
		ExpressionUtils.parse("'str1'+LOWER([TABLE.FIELD1]);");
		try {
			ExpressionUtils.parse("'str1'+LOWER([TABLE.FIELD1])+;");
			Assert.fail("'str1'+LOWER([TABLE.FIELD1])+;");
		}
		catch (FloraException e) {
		}
		ExpressionUtils.parse("[TABLE1.FIELD2]+'abcde';");
	}
}

