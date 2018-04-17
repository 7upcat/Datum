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

package org.datum.application.olap;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象用于表达抽象的表.
 * 
 * @author 7cat
 * @since 1.0
 */
public class TableLike {

	private Long connectorId;

	private String tableName;

	private String tableNameAlias;

	private String remarks;

	private List<Field> fields = new ArrayList<>();

	public Field filterByName(String fieldName) {
		return this.fields.stream().filter(c -> c.getColumnName().equals(fieldName)).findAny().get();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTableNameAlias() {
		return tableNameAlias == null ? tableName : tableNameAlias;
	}

	public void setTableNameAlias(String tableNameAlias) {
		this.tableNameAlias = tableNameAlias;
	}

	public Long getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(Long connectorId) {
		this.connectorId = connectorId;
	}

	public List<Field> getColumns() {
		return fields;
	}

	public void setColumns(List<Field> columns) {
		this.fields = columns;
	}

	@Override
	public String toString() {
		return "TableLike [connectorId=" + connectorId + ", tableName=" + tableName + ", tableNameAlias="
				+ tableNameAlias + ", remarks=" + remarks + ", fields=" + fields + "]";
	}

}
