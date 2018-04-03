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

import static org.jooq.impl.DSL.*;

/**
 * 值对象用来定义抽象的数据域.
 * 
 * @author 7cat
 * @since 1.0
 */
public class Field implements FieldLike {

	private String tableCat;

	private String tableSchem;

	private String tableName;

	private String columnName;

	private String columnNameAlias;

	private int dataType;

	private String typeName;

	public String getColumnNameWithTableNameAlias() {
		return tableName + "." + columnName;
	}

	@Override
	public org.jooq.Field<?> asField() {
		return field(getColumnNameWithTableNameAlias());
	}

	public String getTableCat() {
		return tableCat;
	}

	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}

	public String getTableSchem() {
		return tableSchem;
	}

	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getColumnNameAlias() {
		return columnNameAlias == null ? columnName : columnNameAlias;
	}

	public void setColumnNameAlias(String columnNameAlias) {
		this.columnNameAlias = columnNameAlias;
	}

	@Override
	public String toString() {
		return "Column [tableCat=" + tableCat + ", tableSchem=" + tableSchem + ", tableName=" + tableName
				+ ", columnName=" + columnName + ", columnNameAlias=" + columnNameAlias + ", dataType=" + dataType
				+ ", typeName=" + typeName + "]";
	}

}
