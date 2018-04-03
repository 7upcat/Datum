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

/**
 * 值对象用来定义抽象的表.
 * 
 * @author 7cat
 * @since 1.0
 */
public class TableLike {

	private Long connectorId;

	private String tableCatalog;

	private String tableSchema;

	private String tableName;

	private String tableNameAlias;

	private String remarks;

	private List<Field> fields = new ArrayList<>();

	private List<Dimension> joins = new ArrayList<>();

	public static TableLike newTable(String tableName) {
		TableLike table = new TableLike();
		table.setTableName(tableName);
		return table;
	}

	public Field filterByName(String fieldName) {
		return this.fields.stream().filter(c -> c.getColumnName().equals(fieldName)).findAny().get();
	}

	public String getTableCatalog() {
		return tableCatalog;
	}

	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
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

	public List<Dimension> getJoins() {
		return joins;
	}

	public void setJoins(List<Dimension> joins) {
		this.joins = joins;
	}

	@Override
	public String toString() {
		return "Table [tableCatalog=" + tableCatalog + ", tableSchema=" + tableSchema + ", tableName=" + tableName
				+ ", tableNameAlias=" + tableNameAlias + ", remarks=" + remarks + "]";
	}
}
