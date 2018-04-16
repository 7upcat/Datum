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

package org.datum.expression.dialect.h2;

import java.util.HashMap;
import java.util.Map;

import org.datum.expression.dialect.Dialect;
import org.datum.expression.dialect.function.CONTAINSFunction;
import org.datum.expression.dialect.function.ENDSWITHFunction;
import org.datum.expression.dialect.function.Function;
import org.datum.expression.dialect.function.STARTSWITHFunction;
import org.datum.expression.dialect.function.StandardFunction;
import org.datum.expression.dialect.mysql.DATEPARTFunction;
import org.datum.expression.dialect.mysql.DATE_ADDFunction;
import org.datum.expression.dialect.mysql.DATE_DIFFFunction;
import org.datum.expression.dialect.mysql.DATE_SUBFunction;
import org.datum.expression.dialect.mysql.DIVFunction;
import org.datum.expression.dialect.mysql.FINDFunction;
import org.datum.expression.dialect.mysql.LOGFunction;

/**
 * H2 数据库的方言，将 datum-expression 内置函数转义成 H2 数据库的函数.
 * 
 * @author 7cat
 * @since 1.0
 */
public class H2Dialect implements Dialect {

	private Map<String, Function> functionMapping = new HashMap<>();

	public H2Dialect() {
		functionMapping.put("ABS", new StandardFunction("ABS"));
		functionMapping.put("ACOS", new StandardFunction("ACOS"));
		functionMapping.put("ASIN", new StandardFunction("ASIN"));
		functionMapping.put("ATAN", new StandardFunction("ATAN"));
		functionMapping.put("ATAN2", new StandardFunction("ATAN2"));
		functionMapping.put("CEILING", new StandardFunction("CEILING"));
		functionMapping.put("COS", new StandardFunction("COS"));
		functionMapping.put("COT", new StandardFunction("COT"));
		functionMapping.put("DEGREES", new StandardFunction("DEGREES"));
		functionMapping.put("DIV", new DIVFunction());
		functionMapping.put("EXP", new StandardFunction("EXP"));
		functionMapping.put("FLOOR", new StandardFunction("FLOOR"));
		functionMapping.put("LN", new StandardFunction("LN"));
		functionMapping.put("LOG", new LOGFunction());
		functionMapping.put("PI", new StandardFunction("PI"));
		functionMapping.put("POWER", new StandardFunction("POWER"));
		functionMapping.put("RADIANS", new StandardFunction("RADIANS"));
		functionMapping.put("ROUND", new StandardFunction("ROUND"));
		functionMapping.put("SIGN", new StandardFunction("SIGN"));
		functionMapping.put("SIN", new StandardFunction("SIN"));
		functionMapping.put("SQRT", new StandardFunction("SQRT"));
		functionMapping.put("TAN", new StandardFunction("TAN"));
		functionMapping.put("ASCII", new StandardFunction("ASCII"));
		functionMapping.put("CHAR", new StandardFunction("CHAR"));
		functionMapping.put("CONTAINS", new CONTAINSFunction());
		functionMapping.put("ENDSWITH", new ENDSWITHFunction());
		functionMapping.put("FIND", new FINDFunction());
		functionMapping.put("LEFT", new StandardFunction("LEFT"));
		functionMapping.put("LEN", new StandardFunction("LENGTH"));
		functionMapping.put("LOWER", new StandardFunction("LOWER"));
		functionMapping.put("LTRIM", new StandardFunction("LTRIM"));
		functionMapping.put("MID", new StandardFunction("SUBSTRING"));
		functionMapping.put("REPLACE", new StandardFunction("REPLACE"));
		functionMapping.put("RIGHT", new StandardFunction("RIGHT"));
		functionMapping.put("RTRIM", new StandardFunction("RTRIM"));
		functionMapping.put("SPACE", new StandardFunction("SPACE"));
		functionMapping.put("STARTSWITH", new STARTSWITHFunction());
		functionMapping.put("TRIM", new StandardFunction("TRIM"));
		functionMapping.put("UPPER", new StandardFunction("UPPER"));
		functionMapping.put("DATE_ADD", new DATE_ADDFunction());
		functionMapping.put("DATE_SUB", new DATE_SUBFunction());
		functionMapping.put("DATE_PART", new DATEPARTFunction());
		functionMapping.put("DATE_DIFF", new DATE_DIFFFunction());
		functionMapping.put("DAY", new StandardFunction("DAYOFMONTH"));
		functionMapping.put("MONTH", new StandardFunction("MONTH"));
		functionMapping.put("NOW", new StandardFunction("NOW"));
		functionMapping.put("TODAY", new StandardFunction("CURDATE"));
		functionMapping.put("YEAR", new StandardFunction("YEAR"));
	}

	@Override
	public String renderFunction(String name, String... arguments) {
		return functionMapping.get(name).render(arguments);
	}
}
