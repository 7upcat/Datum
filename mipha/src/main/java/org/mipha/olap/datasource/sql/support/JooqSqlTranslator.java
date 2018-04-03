/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mipha.olap.datasource.sql.support;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.jooq.JoinType;
import org.jooq.Record;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnStep;
import org.jooq.impl.JooqUtils;
import org.mipha.olap.datasource.sql.SqlTranslator;
import org.mipha.olap.domain.Cube;
import org.mipha.olap.domain.Dimension;
import org.springframework.stereotype.Component;

import static org.jooq.impl.DSL.*;

/**
 * 基于 Jooq 实现的 SQL 解释器,仅使用了 Jooq 的 SQL Builder 功能基于 Apache 2.0 协议即可不需要商用授权.
 * 
 * @author 7cat
 * @since 1.0
 */
@Component
public class JooqSqlTranslator implements SqlTranslator {

	private Map<String, JoinType> joinTypesMapping;

	public JooqSqlTranslator() {
		joinTypesMapping = new HashMap<>();
		joinTypesMapping.put(Dimension.JOIN_TYPE_INNER, JoinType.JOIN);
		joinTypesMapping.put(Dimension.JOIN_TYPE_LEFT, JoinType.LEFT_OUTER_JOIN);
		joinTypesMapping.put(Dimension.JOIN_TYPE_RIGHT, JoinType.RIGHT_OUTER_JOIN);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mipha.dsl.sql.SqlTranslator#translate(org.mipha.vo.db.Table)
	 */
	@Override
	public String translate(Cube cube) {
		SelectJoinStep<Record> fact = using((DataSource) null, null).select(cube.getFields().stream().map((c) -> {
			return field(c.asField()).as(c.getColumnNameAlias());
		}).collect(Collectors.toList())).from(cube.getFact().getTableName());

		cube.getDimensions().stream().forEach(d -> {
			SelectOnStep<Record> joinStep = fact.join(table(d.getTarget().getTableName()),
					joinTypesMapping.get(d.getType()));
			Arrays.stream(d.getConditions()).forEach((c) -> {
				joinStep.on(JooqUtils.newCompareCondition(c.getLeft().asField(), c.getRight().asField(), c.getComparator()));
			});
		});

		return fact.getSQL();
	}

	public void setJoinTypesMapping(Map<String, JoinType> joinTypesMapping) {
		this.joinTypesMapping = joinTypesMapping;
	}
}
