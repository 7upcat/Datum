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

import org.datum.DatumCoreException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 7cat
 * @since 1.0
 */
public class ArithmeticExpressionTest {

	@Test
	public void testSimpleExpression() {
		ExpressionUtils.parse("2;");
		ExpressionUtils.parse("-2;");
		ExpressionUtils.parse("2+5;");
		ExpressionUtils.parse("2^5;");
		ExpressionUtils.parse("2+(5);");
		ExpressionUtils.parse("2+5+3;");
		ExpressionUtils.parse("2+(5+3);");
		ExpressionUtils.parse("-(2+5);");
		try {
			ExpressionUtils.parse("2+;");
			Assert.fail("2+;");
		}
		catch (DatumCoreException e) {
		}
		ExpressionUtils.parse("ABS(55);");
		ExpressionUtils.parse("ABS(-55);");

		assertEquals("ABS ( - 55 ) - 20", ExpressionUtils.parse("ABS(-55)-20;"));
		ExpressionUtils.parse("-ABS(-55)-20;");
		ExpressionUtils.parse("22-ABS(-55);");
		ExpressionUtils.parse("22-(ABS(-55-20)+25);");
		try {
			ExpressionUtils.parse("-ABS(-55)+;");
			Assert.fail("-ABS(-55)+;");
		}
		catch (DatumCoreException e) {
		}

		ExpressionUtils.parse("-ABS([TABLE.FIELD])-[TABLE.FIELD2];");

		ExpressionUtils.parse("[TABLE1.FIELD2]+1234;");
	}

	@Test
	public void testLOGFunction() {
		assertEquals("LOG ( 10, 100 )", ExpressionUtils.parse("LOG(100);"));
	}

	@Test
	public void testASCIIFunction() {
		assertEquals("ASCII ( 'a' )", ExpressionUtils.parse("ASCII('a');"));
	}

	@Test
	public void testLENFunction() {
		assertEquals("LENGTH ( 'abcd' )", ExpressionUtils.parse("LEN('abcd');"));
	}

	@Test
	public void testFINDFunction() {
		assertEquals("LOCATE ( 'a', 'abcd' )", ExpressionUtils.parse("FIND ( 'abcd' , 'a' );"));
		assertEquals("LOCATE ( 'a', 'abcd', 2 )", ExpressionUtils.parse("FIND ( 'abcd' , 'a', 2 );"));
	}
}
