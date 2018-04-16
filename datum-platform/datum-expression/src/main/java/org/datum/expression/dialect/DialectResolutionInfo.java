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

package org.datum.expression.dialect;


/**
 * Exposes information about the database and JDBC driver that can be used in resolving the appropriate Dialect
 * to use.
 * <p/>
 * The information here mimics part of the JDBC {@link java.sql.DatabaseMetaData} contract, specifically the portions
 * about database and driver names and versions.
 *
 * @author Steve Ebersole
 */
public interface DialectResolutionInfo {
	/**
	 * Constant used to indicate that no version is defined
	 */
	public static final int NO_VERSION = -9999;

	/**
	 * Obtain access to the database name, as returned from {@link java.sql.DatabaseMetaData#getDatabaseProductName()}
	 * for the target database
	 *
	 * @return The database name
	 *
	 * @see java.sql.DatabaseMetaData#getDatabaseProductName()
	 */
	public String getDatabaseName();

	/**
	 * Obtain access to the database major version, as returned from
	 * {@link java.sql.DatabaseMetaData#getDatabaseMajorVersion()} for the target database.
	 *
	 * @return The database major version, or {@value #NO_VERSION} to indicate "no version information"
	 *
	 * @see java.sql.DatabaseMetaData#getDatabaseMajorVersion()
	 */
	public int getDatabaseMajorVersion();

	/**
	 * Obtain access to the database minor version, as returned from
	 * {@link java.sql.DatabaseMetaData#getDatabaseMinorVersion()} for the target database.
	 *
	 * @return The database minor version, or {@value #NO_VERSION} to indicate "no version information"
	 *
	 * @see java.sql.DatabaseMetaData#getDatabaseMinorVersion()
	 */
	public int getDatabaseMinorVersion();

	/**
	 * Obtain access to the name of the JDBC driver, as returned from {@link java.sql.DatabaseMetaData#getDriverName()}
	 * for the target database
	 *
	 * @return The JDBC driver name
	 *
	 * @see java.sql.DatabaseMetaData#getDriverName()
	 */
	public String getDriverName();

	/**
	 * Obtain access to the major version of the JDBC driver, as returned from
	 * {@link java.sql.DatabaseMetaData#getDriverMajorVersion()} ()} for the target database.
	 *
	 * @return The JDBC driver major version, or {@value #NO_VERSION} to indicate "no version information"
	 *
	 * @see java.sql.DatabaseMetaData#getDriverMajorVersion()
	 */
	public int getDriverMajorVersion();

	/**
	 * Obtain access to the minor version of the JDBC driver, as returned from
	 * {@link java.sql.DatabaseMetaData#getDriverMinorVersion()} for the target database.
	 *
	 * @return The JDBC driver minor version, or {@value #NO_VERSION} to indicate "no version information"
	 *
	 * @see java.sql.DatabaseMetaData#getDriverMinorVersion()
	 */
	public int getDriverMinorVersion();


}
