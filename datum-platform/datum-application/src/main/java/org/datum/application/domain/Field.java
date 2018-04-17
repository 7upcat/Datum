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

package org.datum.application.domain;

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
	public org.jooq.Field<Object> asField() {
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
