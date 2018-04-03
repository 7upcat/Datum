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

package org.mipha.common;

/**
 * 用于进行单元测试的常量定义.
 * 
 * @author 7cat
 * @since 1.0
 */
public final class TestConstants {

	public static final String SAMPLE_DB_NAME = "SampleDB";

	public static final String SAMPLE_DB_JDBC_URL = "jdbc:h2:mem:sampleDB;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:scripts/SampleDB.sql'\\;RUNSCRIPT FROM 'classpath:scripts/SampleDBData.sql'";

	public static final String SAMPLE_DB_JDBC_DRIVER = "org.h2.Driver";

	public static final String SAMPLE_DB_JDBC_USERNAME = "";

	public static final String SAMPLE_DB_JDBC_PASSWPRD = "";

	public static final String TABLE_CUST_BASIC_INFO = "CUST_BASIC_INFO";

	public static final String TABLE_ACCOUNT = "ACCOUNT";

	public static final String TABLE_BANK_VOUCHER = "BANK_VOUCHER";

	public static final String FIELD_ACCOUNT_NO = "ACCOUNT_NO";

	public static final String FIELD_CUS_ID = "CUS_ID";

}
