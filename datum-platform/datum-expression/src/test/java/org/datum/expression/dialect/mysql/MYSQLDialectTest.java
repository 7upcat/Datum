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

package org.datum.expression.dialect.mysql;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.datum.expression.CalculationContext;
import org.datum.expression.CalculationExpressionParser;
import org.datum.expression.SqlCalculationExpressionParser;
import org.datum.expression.database.MYSQLUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试案例用于测试 {@link MYSQLDialect}.
 * 
 * @author 7cat
 * @since 1.0
 */
public class MYSQLDialectTest {

	private CalculationExpressionParser<String> parser = new SqlCalculationExpressionParser();

	@Test
	public void testNumberFunctions() {
		assertExpressionEquals(Integer.valueOf(22), "ABS(-22);");
		assertExpressionEquals(1.5707963267949, "ACOS(0);");
		assertExpressionEquals(0.20135792079033, "ASIN(0.2);");
		assertExpressionEquals(1.1071487177941, "ATAN(2);");
		assertExpressionEquals(1.5707963267949, "ATAN2(PI(),0);");
		assertExpressionEquals(Integer.valueOf(3), "CEILING(2.3);");
		assertExpressionEquals(-1, "COS(PI());");
		assertExpressionEquals(-1.5726734063977, "COT(12);");
		assertExpressionEquals(90, "DEGREES(PI() / 2);");
		assertExpressionEquals(Integer.valueOf(2), "DIV(4,2);");
		assertExpressionEquals(7.3890560989307, "EXP(2);");
		assertExpressionEquals(Integer.valueOf(2), "FLOOR(2.3);");
		assertExpressionEquals(0.69314718055995, "LN(2);");
		assertExpressionEquals(2, "LOG(100,10);");
		assertExpressionEquals(0.69314718055995, "LOG(2);");
		assertExpressionEquals(3.141593, "PI();");
		assertExpressionEquals(4, "POWER(2,2);");
		assertExpressionEquals(0.25, "POWER(2,-2);");
		assertExpressionEquals(1.5707963267949, "RADIANS(90);");
		assertExpressionEquals(-2, "ROUND(-1.58);");
		assertExpressionEquals(1.3, "ROUND(1.298, 1);");
		assertExpressionEquals(1, "SIGN(234);");
		assertExpressionEquals(0.70710678, "SIN(PI( )/4);");
		assertExpressionEquals(5, "SQRT(25);");
		assertExpressionEquals(1.0, "TAN(PI ( )/4);");
	}

	@Test
	public void testStringFunctions() {
		assertExpressionEquals(Integer.valueOf(50), "ASCII('2');");
		assertExpressionEquals("A", "CHAR(65);");
		assertExpressionTrue("CONTAINS('ABCD','ABC');");
		assertExpressionTrue("ENDSWITH('ABCD','BCD');");
		assertExpressionEquals(Integer.valueOf(4), "FIND('foobarbar', 'bar');");
		assertExpressionEquals(Integer.valueOf(7), "FIND('foobarbar', 'bar' , 5);");
		assertExpressionEquals("fooba", "LEFT('foobarbar', 5);");
		assertExpressionEquals(new Integer(9), "LEN('foobarbar');");
		assertExpressionEquals("abc", "LOWER('ABC');");
		assertExpressionEquals("barbar", "LTRIM('  barbar');");
		assertExpressionEquals("oo", "MID('foobar',2,2);");
		assertExpressionEquals("WwWwWw.mysql.com", "REPLACE('www.mysql.com', 'w', 'Ww');");
		assertExpressionEquals("rbar", "RIGHT('foobarbar', 4);");
		assertExpressionEquals("barbar", "RTRIM('barbar   ');");
		assertExpressionEquals("     ", "SPACE(5);");
		assertExpressionTrue("STARTSWITH('ABCD','ABC');");
		assertExpressionEquals("barbar", "TRIM('   barbar   ');");
		assertExpressionEquals("ABCD", "UPPER(TRIM('   abcd  '));");
	}

	@Test
	public void testDateFunctions() {
		assertDateEquals("2019-04-15", "DATE_ADD(#2018-04-15#, YEAR,1);");
		assertDateEquals("2017-04-15", "DATE_ADD(#2018-04-15#, YEAR,-1);");
		assertDateEquals("2017-04-15", "DATE_SUB(#2018-04-15#, YEAR,1);");
		assertDateEquals("2018-02-15", "DATE_SUB(#2018-04-15#, MONTH,2);");
		assertExpressionEquals(4, "DATE_PART(#2018-04-15#,MONTH);");
		assertExpressionEquals(15, "DATE_PART(#2018-04-15#,DAY);");
		assertExpressionEquals(0, "DATE_DIFF(#2018-04-15#,#2018-04-16#, YEAR);");
		assertExpressionEquals(15, "DAY(#2018-04-15#);");
		assertExpressionEquals(4, "MONTH(#2018-04-15#);");
		assertExpressionEquals(2018, "YEAR(#2018-04-15#);");
		assertTimestampEquals(new Date(), "NOW();");
		assertDateEquals(new Date(), "TODAY();");
	}

	private void assertDateEquals(Date expect, String expression) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(format.format(expect), format.format(eval(expression, Date.class)));
	}

	private void assertDateEquals(String expect, String expression) {
		assertEquals(expect, new SimpleDateFormat("yyyy-MM-dd").format(eval(expression, Date.class)));
	}

	private void assertTimestampEquals(Date expect, String expression) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		assertEquals(format.format(expect), format.format(eval(expression, Date.class)));
	}

	private void assertExpressionTrue(String expression) {
		assertTrue(eval(expression, Boolean.class));
	}

	private void assertExpressionEquals(String s1, String expression) {
		assertEquals(s1, eval(expression, String.class));
	}

	private void assertExpressionEquals(Integer i1, String expression) {
		assertEquals(i1, eval(expression, Integer.class));
	}

	private void assertExpressionEquals(double d1, String expression) {
		assertEquals(new BigDecimal(d1).setScale(5, RoundingMode.HALF_UP),
				new BigDecimal(eval(expression, Double.class)).setScale(5, RoundingMode.HALF_UP));
	}

	private <T> T eval(String expression, Class<T> clazz) {
		CalculationContext context = new CalculationContext();
		context.setDialect(new MYSQLDialect());
		return MYSQLUtils.execute(parser.eval(expression, context), clazz);
	}
}
