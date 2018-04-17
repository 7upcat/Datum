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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.datum.application.domain.support.MapAttributeConverter;

/**
 * 连接器实体保存了元信息用于同某一个数据源进行连接.
 *
 * @author 7cat
 */
@Entity
public class Connector implements Serializable {

	private static final long serialVersionUID = -2893500725941034493L;

	/** 连接器类型: 关系型数据库. */
	public static final String CONNECTOR_TYPE_DB = "D";

	/** 连接器类型: Excel. */
	public static final String CONNECTOR_TYPE_EXCEL = "E";

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	@Convert(converter = MapAttributeConverter.class)
	private Map<String, Object> metadatas = new HashMap<>();

	@Column
	private String describe;

	public void addMetadata(String key, Object value) {
		metadatas.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getMetadata(String key) {
		return (T) metadatas.get(key);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Map<String, Object> getMetadatas() {
		return this.metadatas;
	}

	public void setMetadatas(Map<String, Object> metadatas) {
		this.metadatas = metadatas;
	}

	@Override
	public String toString() {
		return "Connector [id=" + id + ", name=" + name + ", type=" + type
				+ ", metadatas=" + metadatas + ", describe=" + describe + "]";
	}
}
