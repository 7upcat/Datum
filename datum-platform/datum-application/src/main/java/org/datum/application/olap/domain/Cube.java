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

package org.datum.application.olap.domain;

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
