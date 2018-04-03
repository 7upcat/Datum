
package org.mipha.olap.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.mipha.olap.support.JsonAttributeConverter;

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
	@Convert(converter = JsonAttributeConverter.class)
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
