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

package org.flora.expression;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.flora.expression.antlr.FloraExpressionLexer;
import org.flora.expression.antlr.FloraExpressionParser;
import org.flora.expression.antlr.visitor.FloraExpressionVisitor;

/**
 * @author 7cat
 * @since 1.0
 */
public final class ExpressionUtils {

	public static void parse(String expression) {
		ErrorListener listener = new ErrorListener();
		FloraExpressionLexer lexer = new FloraExpressionLexer(CharStreams.fromString(expression));
		lexer.removeErrorListeners();
		// lexer.addErrorListener(new DiagnosticErrorListener(true));
		lexer.addErrorListener(listener);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FloraExpressionParser parser = new FloraExpressionParser(tokens);
		parser.removeErrorListeners();
		// parser.addErrorListener(new DiagnosticErrorListener(true));
		parser.addErrorListener(listener);
		ParseTreeWalker walker = new ParseTreeWalker();
		// parser.calculations().accept(visitor)
		walker.walk(new FloraExpressioListener(), parser.calculations());
	}

	/**
	 * 解析表达式并通过 GUI 展示语法树,用于手工检验解析的语法树是否正确.
	 * 
	 * @param expression 被解析的表达式
	 */
	public static void showGui(String expression) {
		ErrorListener listener = new ErrorListener();
		FloraExpressionLexer lexer = new FloraExpressionLexer(CharStreams.fromString(expression));
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FloraExpressionParser parser = new FloraExpressionParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new FloraExpressioListener(), parser.calculations());
		parser.reset();
		Trees.inspect(parser.calculations(), parser);
	}

	public static String translate(String expression) {
		ErrorListener listener = new ErrorListener();
		FloraExpressionLexer lexer = new FloraExpressionLexer(CharStreams.fromString(expression));
		lexer.removeErrorListeners();
		lexer.addErrorListener(listener);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FloraExpressionParser parser = new FloraExpressionParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(listener);
		return parser.calculations().accept(new FloraExpressionVisitor());
	}

	public static void main(String[] args) {
		// showGui("-2+(3)+(ABS((33+5)*6)-5);");
		// showGui("(-2+5*3>=22.6 AND 123>[TABLE.FIELD]) OR ('55' <= '22' AND LOWER('25'+'32')> '55') AND 'str1'<>'str2'
		// AND 'str3'='str4' AND NATIVE('CONCAT','STR1','STR2')>'32';");
		// showGui("NATIVE('CONCAT','str1',23.22,#2018-02-02#);");
		// showGui("'23'+ LOWER('ABC') + [TABLE.FIELD];");

		System.out.println(translate("NATIVE('LOWER', '23333');"));
		showGui("NATIVE('LOWER', '23333');");
	}
}
