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

package org.flora.application.common;

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
