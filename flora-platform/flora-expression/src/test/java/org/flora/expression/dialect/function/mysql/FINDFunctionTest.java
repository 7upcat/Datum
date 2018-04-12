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

package org.flora.expression.dialect.function.mysql;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 7cat
 * @since 1.0
 */
public class FINDFunctionTest {

	/**
	 * Test method for {@link org.flora.expression.dialect.function.mysql.FINDFunction#render(java.lang.String[])}.
	 */
	@Test
	public void testRender() {

		FINDFunction findFunction = new FINDFunction();
		assertEquals("LOCATE ( 'bar', 'foobarbar' )", findFunction.render("'foobarbar'", "'bar'"));
		assertEquals("LOCATE ( 'bar', 'foobarbar', 2 )", findFunction.render("'foobarbar'", "'bar'", "2"));
	}

}
