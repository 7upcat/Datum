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

import org.datum.DatumCoreException;
import org.datum.expression.common.ErrorCodes;
import org.datum.expression.dialect.h2.H2Dialect;
import org.datum.expression.dialect.mysql.MYSQLDialect;

/**
 * 所有支持的关联型数据库.
 * 
 * @author 7cat
 * @since 1.0
 */
public enum Database {

	H2 {

		@Override
		public Class<? extends Dialect> latestDialect() {
			return H2Dialect.class;
		}

		@Override
		public Dialect resolveDialect(DialectResolutionInfo info) {
			final String databaseName = info.getDatabaseName();

			if ("H2".equals(databaseName)) {
				return latestDialectInstance(this);
			}

			return null;
		}
	},

	MYSQL {

		@Override
		public Class<? extends Dialect> latestDialect() {
			return MYSQLDialect.class;
		}

		@Override
		public Dialect resolveDialect(DialectResolutionInfo info) {
			final String databaseName = info.getDatabaseName();
			if ("MySQL".equals(databaseName)) {
				return latestDialectInstance(this);
			}

			return null;
		}
	};

	public abstract Class<? extends Dialect> latestDialect();

	public abstract Dialect resolveDialect(DialectResolutionInfo info);

	private static Dialect latestDialectInstance(Database database) {
		try {
			return database.latestDialect().newInstance();
		}
		catch (InstantiationException | IllegalAccessException e) {
			throw new DatumCoreException(ErrorCodes.RESOLVE_DIALECT_ERROR, e);
		}
	}
}
