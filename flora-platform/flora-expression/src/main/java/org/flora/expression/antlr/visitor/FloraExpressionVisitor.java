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

package org.flora.expression.antlr.visitor;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.flora.expression.antlr.FloraExpressionParser.FieldContext;
import org.flora.expression.antlr.FloraExpressionParser.Functions_returning_stringsContext;
import org.flora.expression.antlr.FloraExpressionParser.Native_expressionContext;
import org.flora.expression.antlr.FloraExpressionParser.String_expressionContext;
import org.flora.expression.antlr.FloraExpressionParser.String_literalContext;
import org.flora.expression.antlr.VisitorResolver;

/**
 * 表达式的顶层访问者,同时也是一个 {@link VisitorResolver} 根据当前的上下文件获取适合的解析观察者进行处理.
 * 
 * @author 7cat
 * @since 1.0
 * @see BaseParseTreeVisitor
 */
public class FloraExpressionVisitor implements VisitorResolver, ParseTreeVisitor<String> {

	private Map<String, ParseTreeVisitor<String>> visitorMapping = new HashMap<>();

	public FloraExpressionVisitor() {
		visitorMapping.put(String_literalContext.class.getTypeName(), new StringLiteralVisitor(this));
		visitorMapping.put(Functions_returning_stringsContext.class.getTypeName(),
				new FunctionsReturningStringsVisitor(this));
		visitorMapping.put(String_expressionContext.class.getTypeName(), new StringExpressionVisitor(this));
		visitorMapping.put(FieldContext.class.getTypeName(), new FieldVisitor(this));
		visitorMapping.put(Native_expressionContext.class.getTypeName(), new NativeExpressionVisitor(this));
		visitorMapping.put(Native_expressionContext.class.getTypeName(), new NativeExpressionVisitor(this));
	}

	@Override
	public String visitChildren(RuleNode node) {
		return node.getChild(0).accept(resolve(node.getChild(0)));
	}

	@Override
	public ParseTreeVisitor<String> resolve(ParseTree parseTree) {
		return visitorMapping.get(parseTree.getClass().getTypeName());
	}

	public void setVisitorMapping(Map<String, ParseTreeVisitor<String>> visitorMapping) {
		this.visitorMapping = visitorMapping;
	}

	@Override
	public String visit(ParseTree tree) {
		throw new UnsupportedOperationException("Auto-generated method stub");
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		throw new UnsupportedOperationException("Auto-generated method stub");
	}

	@Override
	public String visitErrorNode(ErrorNode node) {
		throw new UnsupportedOperationException("Auto-generated method stub");
	}
}
