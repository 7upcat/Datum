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

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.datum.expression.antlr.DatumExpressionLexer;
import org.datum.expression.antlr.DatumExpressionParser;
import org.datum.expression.antlr.ErrorListener;
import org.datum.expression.dialect.mysql.MYSQLDialect;

/**
 * @author 7cat
 * @since 1.0
 */
public final class ExpressionUtils {

	private static CalculationExpressionParser<String> calculationExpressionParser = new SqlCalculationExpressionParser();

	public static String parse(String expression) {
		CalculationContext context = new CalculationContext();
		context.setDialect(new MYSQLDialect());
		return calculationExpressionParser.eval(expression, context);
	}

	/**
	 * 解析表达式并通过 GUI 展示语法树,用于手工检验解析的语法树是否正确.
	 * 
	 * @param expression 被解析的表达式
	 */
	public static void showGui(String expression) {
		ErrorListener listener = new ErrorListener();
		DatumExpressionLexer lexer = new DatumExpressionLexer(CharStreams.fromString(expression));
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DatumExpressionParser parser = new DatumExpressionParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		Trees.inspect(parser.calculations(), parser);
	}
}
