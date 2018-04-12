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

package org.flora.expression.dialect;

import java.util.HashMap;
import java.util.Map;

import org.flora.expression.dialect.function.Function;
import org.flora.expression.dialect.function.StandardFunction;
import org.flora.expression.dialect.function.mysql.CONTAINSFunction;
import org.flora.expression.dialect.function.mysql.ENDSWITHFunction;
import org.flora.expression.dialect.function.mysql.FINDFunction;
import org.flora.expression.dialect.function.mysql.STARTSWITHFunction;

/**
 * MYSQL 数据库的方言.
 * 
 * @author 7cat
 * @since 1.0
 */
public class MYSQLDialect implements Dialect {

	private Map<String, Function> functionMapping = new HashMap<>();

	public MYSQLDialect() {
		// 计算函数
		// 暂不支持以下函数 HEXBINX/HEXBINY/MIN/MAX/SQUARE/ZN
		functionMapping.put("ABS", new StandardFunction("ABS"));
		functionMapping.put("ACOS", new StandardFunction("ACOS"));
		functionMapping.put("ASIN", new StandardFunction("ASIN"));
		functionMapping.put("ATAN", new StandardFunction("ATAN"));
		functionMapping.put("ATAN2", new StandardFunction("ATAN2"));
		functionMapping.put("CEILING", new StandardFunction("CEILING"));
		functionMapping.put("COS", new StandardFunction("COS"));
		functionMapping.put("COT", new StandardFunction("COT"));
		functionMapping.put("DEGREES", new StandardFunction("DEGREES"));
		functionMapping.put("DIV", new StandardFunction("DIV"));
		functionMapping.put("EXP", new StandardFunction("EXP"));
		functionMapping.put("FLOOR", new StandardFunction("FLOOR"));
		functionMapping.put("LN", new StandardFunction("LN"));
		functionMapping.put("LOG", new StandardFunction("LOG"));
		functionMapping.put("PI", new StandardFunction("PI"));
		functionMapping.put("POWER", new StandardFunction("POWER"));
		functionMapping.put("RADIANS", new StandardFunction("RADIANS"));
		functionMapping.put("ROUND", new StandardFunction("ROUND"));
		functionMapping.put("SIGN", new StandardFunction("SIGN"));
		functionMapping.put("SIN", new StandardFunction("SIN"));
		functionMapping.put("SQRT", new StandardFunction("SQRT"));
		functionMapping.put("TAN", new StandardFunction("TAN"));
		// 字符函数
		// 暂不支持 SPLIT、MAX、MIN
		functionMapping.put("ASCII", new StandardFunction("ASCII"));
		functionMapping.put("CHAR", new StandardFunction("CHAR"));
		functionMapping.put("CONTAINS", new CONTAINSFunction());
		functionMapping.put("ENDSWITH", new ENDSWITHFunction());
		// FIND/FINDNTH 使用同一个函数只是参数不同
		functionMapping.put("FIND", new FINDFunction());
		functionMapping.put("LEFT", new StandardFunction("LEFT"));
		functionMapping.put("LEN", new StandardFunction("LENGTH"));
		functionMapping.put("LOWER", new StandardFunction("LOWER"));
		functionMapping.put("LTRIM", new StandardFunction("LTRIM"));
		// functionMapping.put("MAX", new StandardFunction(""));
		// functionMapping.put("MIN", new StandardFunction(""));
		functionMapping.put("MID", new StandardFunction("MID"));
		functionMapping.put("REPLACE", new StandardFunction("REPLACE"));
		functionMapping.put("RIGHT", new StandardFunction("RIGHT"));
		functionMapping.put("RTRIM", new StandardFunction("RTRIM"));
		functionMapping.put("SPACE", new StandardFunction("SPACE"));
		functionMapping.put("STARTSWITH", new STARTSWITHFunction());
		functionMapping.put("TRIM", new StandardFunction("TRIM"));
		functionMapping.put("UPPER", new StandardFunction("UPPER"));
	}

	@Override
	public String renderFunction(String name, String... arguments) {
		return functionMapping.get(name).render(arguments);
	}
}
