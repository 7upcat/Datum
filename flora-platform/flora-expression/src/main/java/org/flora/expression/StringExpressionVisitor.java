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

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.flora.expression.antlr.FloraExpressionParser;

/**
 * @author 7cat
 * @since 1.0
 */
public class StringExpressionVisitor implements ParseTreeVisitor<String> {

	@Override
	public String visit(ParseTree tree) {
		return tree.accept(this);
	}

	@Override
	public String visitChildren(RuleNode node) {
		List<String> result = defaultResult();
		int n = node.getChildCount();
		if (node instanceof FloraExpressionParser.String_expressionContext && n == 3) {
			String left =  node.getChild(0).accept(this) ;
			String right =  node.getChild(2).accept(this) ;
			return String.format("CONCAT(%s,%s)", new Object[] {},
					node.getChild(2).accept(this));
		}
		else {
			for (int i = 0; i < n; i++) {
				String childResult = node.getChild(i).accept(this);
				result.add(childResult);
			}
			return String.join(" ", result);
		}
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		return node.getText();
	}

	@Override
	public String visitErrorNode(ErrorNode node) {
		return null;
	}

	private List<String> defaultResult() {
		return new ArrayList<>();
	}

}
