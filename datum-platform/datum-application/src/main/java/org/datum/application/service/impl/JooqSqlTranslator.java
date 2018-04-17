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

package org.datum.application.service.impl;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;
import static org.jooq.impl.DSL.using;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.datum.application.domain.Cube;
import org.datum.application.olap.Dimension;
import org.datum.application.service.SQLTranslator;
import org.jooq.JoinType;
import org.jooq.Record;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnStep;
import org.springframework.stereotype.Component;

/**
 * 基于 Jooq 实现的 SQL 解释器,仅使用了 Jooq 的 SQL Builder 功能基于 Apache 2.0 协议即可不需要商用授权.
 * 
 * @author 7cat
 * @since 1.0
 */
@Component
public class JooqSqlTranslator implements SQLTranslator {

	private Map<String, JoinType> joinTypesMapping;

	public JooqSqlTranslator() {
		joinTypesMapping = new HashMap<>();
		joinTypesMapping.put(Dimension.JOIN_TYPE_INNER, JoinType.JOIN);
		joinTypesMapping.put(Dimension.JOIN_TYPE_LEFT, JoinType.LEFT_OUTER_JOIN);
		joinTypesMapping.put(Dimension.JOIN_TYPE_RIGHT, JoinType.RIGHT_OUTER_JOIN);
	}

	@Override
	public String translate(Cube cube) {
		SelectJoinStep<Record> fact = using((DataSource) null, null).select(cube.getFields().stream().map((c) -> {
			return field(c.asField()).as(c.getColumnNameAlias());
		}).collect(Collectors.toList())).from(cube.getFact().getTableName());

		cube.getDimensions().stream().forEach(d -> {
			SelectOnStep<Record> joinStep = fact.join(table(d.getTarget().getTableName()),
					joinTypesMapping.get(d.getType()));
			Arrays.stream(d.getConditions()).forEach(c -> joinStep.on(c.asCondition()));
		});

		return fact.getSQL();
	}

	public void setJoinTypesMapping(Map<String, JoinType> joinTypesMapping) {
		this.joinTypesMapping = joinTypesMapping;
	}
}
