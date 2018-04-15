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

package org.datum.expression.antlr.visitor;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.datum.expression.CalculationContext;
import org.datum.expression.antlr.VisitorResolver;

/**
 * 语法解析树访问者的基类.
 * 
 * @author 7cat
 * @since 1.0
 */
public class BaseParseTreeVisitor implements ParseTreeVisitor<String> {

	private VisitorResolver visitorResolver;

	public BaseParseTreeVisitor(VisitorResolver visitorResolver) {
		this.visitorResolver = visitorResolver;
	}

	protected String accept(ParseTree parseTree) {
		if (parseTree instanceof TerminalNode) {
			return parseTree.getText();
		}
		else {
			return parseTree.accept(visitorResolver.resolve(parseTree));
		}
	}

	protected CalculationContext getCalculationContext() {
		return CalculationContext.getCurrentContext();
	}

	@Override
	public String visit(ParseTree tree) {
		return null;
	}

	@Override
	public String visitChildren(RuleNode node) {
		return null;
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		return null;
	}

	@Override
	public String visitErrorNode(ErrorNode node) {
		return null;
	}
}
