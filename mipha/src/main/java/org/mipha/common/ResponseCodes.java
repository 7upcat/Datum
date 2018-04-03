
package org.mipha.common;

/**
 * 集中的定义系统中的响应码，格式如下：
 * <ul>
 * <li>成功：统一使用 {@link #RESPONSE_CODE_SUCCESS}
 * <li>失败：ER【2位模块】【2位错误编码】，示例 'ER0001'
 * </ul>
 * 
 * @author 7cat
 */
public final class ResponseCodes {

	/** 响应码：成功. */
	public static final String RESPONSE_CODE_SUCCESS = "SC0000";

	/** 响应码：默认的系统处理异常，用于非预期的运行时异常. */
	public static final String RESPONSE_CODE_SYSTEM_ERROR = "ER0001";

	// ----------------------------------------------数据源模块 01

	/** 响应码：JDBC 驱动类无法加载. */
	public static final String RESPONSE_CODE_DRIVER_CLASS_NOT_FOUND = "ER0101";

	/** 响应码：无法连接数据库. */
	public static final String RESPONSE_CODE_CONNECT_DB_FAIL = "ER0102";

	/** 响应码：无法正常提取数据库表元信息. */
	public static final String RESPONSE_CODE_EXTRACT_TABLE_METADATA_ERROR = "ER0103";

	/** 响应码：数据源连接器不存在. */
	public static final String RESPONSE_CODE_CONNECTOR_NOT_FOUND = "ER0104";
}
