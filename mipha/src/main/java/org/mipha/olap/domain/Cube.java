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

package org.mipha.olap.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 多维数据分析立方体实体，包含了一个 {@link #fact} 及多个 {@link #dimensions} .
 * 
 * @author 7cat
 * @since 1.0
 */
public class Cube {

	@Id
	@GeneratedValue
	private Long id;

	private String name;	

	/** 多维数据分析的事实表. */
	private TableLike fact;

	private List<Dimension> dimensions = new ArrayList<>();

	private List<Filter> filters = new ArrayList<>();
	
	public Cube() {
	}

	public Cube(String name, TableLike fact) {
		super();
		this.name = name;
		this.fact = fact;
	}



	public void addDimension(String joinType, TableLike dimension, Condition... conditions) {
		dimensions.add(new Dimension(joinType, dimension, conditions));
	}
	
	/**
	 * @return 返回整个 Cube 所包含的数据域.
	 */
	public List<Field> getFields() {
		List<Field> columns = new ArrayList<>(fact.getColumns());
		dimensions.stream().forEach((join) -> {
			columns.addAll(join.getTarget().getColumns());
		});
		return columns;
	}

	public TableLike getFact() {
		return fact;
	}

	public void setFact(TableLike fact) {
		this.fact = fact;
	}

	public List<Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

}
