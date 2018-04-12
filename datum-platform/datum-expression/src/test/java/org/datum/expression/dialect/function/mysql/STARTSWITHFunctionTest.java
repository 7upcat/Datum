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

package org.datum.expression.dialect.function.mysql;

import org.junit.Test;

import static org.junit.Assert.*;

import org.datum.expression.dialect.function.mysql.STARTSWITHFunction;


/**
 * 
 * @author 7cat
 * @since 1.0
 */
public class STARTSWITHFunctionTest {

	/**
	 * Test method for {@link org.datum.expression.dialect.function.mysql.STARTSWITHFunction#render(java.lang.String[])}.
	 */
	@Test
	public void testRender() {
		STARTSWITHFunction startswithFunction = new STARTSWITHFunction();

		assertEquals("TABLE.FIELD1 LIKE '%ABCD'", startswithFunction.render("TABLE.FIELD1", "'ABCD'"));
	}

}
