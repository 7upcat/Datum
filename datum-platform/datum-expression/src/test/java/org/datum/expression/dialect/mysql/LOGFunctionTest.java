/**
 * 
 */
package org.datum.expression.dialect.mysql;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 7cat
 *
 */
public class LOGFunctionTest {

	/**
	 * Test method for {@link org.datum.expression.dialect.mysql.LOGFunction#render(java.lang.String[])}.
	 */
	@Test
	public void testRender() {
		LOGFunction logFunction = new LOGFunction();
		assertEquals("LOG ( 100 )", logFunction.render("100"));
		assertEquals("LOG2 ( 65535 )", logFunction.render("65535" ,"2"));
	}

}
