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

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.flora.expression.antlr.VisitorResolver;

/**
 * 字符表达式节点的解析树访问者实现.
 * 
 * @author 7cat
 * @since 1.0
 */
public class StringExpressionVisitor extends BaseParseTreeVisitor {

	public StringExpressionVisitor(VisitorResolver visitorResolver) {
		super(visitorResolver);
	}

	@Override
	public String visitChildren(RuleNode node) {
		StringBuffer sb = new StringBuffer();
		int count = node.getChildCount();
		if (count == 3) {
			ParseTree left = node.getChild(0);
			ParseTree right = node.getChild(2);
			sb.append(String.format("CONCAT(%s , %s)", new Object[] { accept(left), accept(right) }));
		}
		else {

			for (int i = 0; i < count; i++) {
				ParseTree child = node.getChild(i);
				sb.append((child instanceof TerminalNode) ? child.getText() : accept(child));
			}

		}
		return sb.toString();
	}
}
