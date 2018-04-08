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

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.flora.expression.antlr.FloraExpressionBaseListener;
import org.flora.expression.antlr.FloraExpressionParser;

/**
 * 数据库类型数据源的 {@link ParseTreeListener}实现.
 * 
 * @author 7cat
 * @since 1.0
 */
public class FloraExpressioListener extends FloraExpressionBaseListener {
	
	@Override
	public void enterCalculations(FloraExpressionParser.CalculationsContext ctx) {
	}

	@Override
	public void exitCalculations(FloraExpressionParser.CalculationsContext ctx) {
		
	}

	@Override
	public void enterArithmetic_expression(FloraExpressionParser.Arithmetic_expressionContext ctx) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<ctx.getChildCount();i++) {
			ParseTree tree = ctx.getChild(i);
			if(tree instanceof TerminalNode) {
				sb.append(tree.getText());
			} else {
				
			}
		}
	}

	@Override
	public void exitArithmetic_expression(FloraExpressionParser.Arithmetic_expressionContext ctx) {
	}

	@Override
	public void enterFunctions_returning_numerics(FloraExpressionParser.Functions_returning_numericsContext ctx) {
	}

	@Override
	public void exitFunctions_returning_numerics(FloraExpressionParser.Functions_returning_numericsContext ctx) {
	}

	@Override
	public void enterAbs(FloraExpressionParser.AbsContext ctx) {
	}

	@Override
	public void exitAbs(FloraExpressionParser.AbsContext ctx) {
	}

	@Override
	public void enterDiv(FloraExpressionParser.DivContext ctx) {
	}

	@Override
	public void exitDiv(FloraExpressionParser.DivContext ctx) {
	}

	@Override
	public void enterNumeric_literal(FloraExpressionParser.Numeric_literalContext ctx) {
		System.out.println(ctx);
	}

	@Override
	public void exitNumeric_literal(FloraExpressionParser.Numeric_literalContext ctx) {
	}

	@Override
	public void enterString_expression(FloraExpressionParser.String_expressionContext ctx) {
	}

	@Override
	public void exitString_expression(FloraExpressionParser.String_expressionContext ctx) {
	}

	@Override
	public void enterFunctions_returning_strings(FloraExpressionParser.Functions_returning_stringsContext ctx) {
	}

	@Override
	public void exitFunctions_returning_strings(FloraExpressionParser.Functions_returning_stringsContext ctx) {
	}

	@Override
	public void enterLower(FloraExpressionParser.LowerContext ctx) {
	}

	@Override
	public void exitLower(FloraExpressionParser.LowerContext ctx) {
	}

	@Override
	public void enterString_literal(FloraExpressionParser.String_literalContext ctx) {
	}

	@Override
	public void exitString_literal(FloraExpressionParser.String_literalContext ctx) {
	}

	@Override
	public void enterDate_expression(FloraExpressionParser.Date_expressionContext ctx) {
	}

	@Override
	public void exitDate_expression(FloraExpressionParser.Date_expressionContext ctx) {
	}

	@Override
	public void enterDate_literal(FloraExpressionParser.Date_literalContext ctx) {
	}

	@Override
	public void exitDate_literal(FloraExpressionParser.Date_literalContext ctx) {
	}

	@Override
	public void enterBool_expression(FloraExpressionParser.Bool_expressionContext ctx) {
	}

	@Override
	public void exitBool_expression(FloraExpressionParser.Bool_expressionContext ctx) {
	}

	@Override
	public void enterComment_expression(FloraExpressionParser.Comment_expressionContext ctx) {
	}

	@Override
	public void exitComment_expression(FloraExpressionParser.Comment_expressionContext ctx) {
	}

	@Override
	public void enterField(FloraExpressionParser.FieldContext ctx) {
	}

	@Override
	public void exitField(FloraExpressionParser.FieldContext ctx) {
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
	}

	@Override
	public void visitTerminal(TerminalNode node) {
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
	}
}
