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

package org.mipha.olap.datasource.sql.support;

import org.junit.Before;
import org.junit.Test;
import org.mipha.common.TestConstants;
import org.mipha.factory.ConnectorFactory;
import org.mipha.olap.OlapService;
import org.mipha.olap.datasource.sql.SqlTranslator;
import org.mipha.olap.datasource.sql.support.JdbcOlapService;
import org.mipha.olap.domain.Condition;
import org.mipha.olap.domain.Connector;
import org.mipha.olap.domain.ConnectorRepository;
import org.mipha.olap.domain.Cube;
import org.mipha.olap.domain.Dimension;
import org.mipha.olap.domain.Field;
import org.mipha.olap.domain.JoinExpression;
import org.mipha.olap.domain.PhysicalTable;
import org.mipha.olap.domain.TableLike;
import org.mipha.test.BaseTest;
import org.mipha.util.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

/**
 * @author 7cat
 * @since 1.0
 */
public class JooqSqlTranslatorTest extends BaseTest {

	@Autowired
	private ConnectorRepository connectorRepository;

	@Autowired
	private SqlTranslator sqlTranslator;

	private OlapService<PhysicalTable> metadataResolver = new JdbcOlapService();

	private JdbcTemplate jdbcTemplate;

	private TableLike bankVoucher;

	private TableLike account;

	private TableLike custBasicInfo;

	private Cube cube;

	@Before
	public void init() {
		Connector connector = ConnectorFactory.newSampleDBConnector();
		connectorRepository.save(connector);
		jdbcTemplate = new JdbcTemplate(DBUtils.newDataSource(connector));
		bankVoucher = metadataResolver.resolveTable(connector, PhysicalTable.newTable(TestConstants.TABLE_BANK_VOUCHER));
		account = metadataResolver.resolveTable(connector, PhysicalTable.newTable(TestConstants.TABLE_ACCOUNT));
		custBasicInfo = metadataResolver.resolveTable(connector,
					PhysicalTable.newTable(TestConstants.TABLE_CUST_BASIC_INFO));
		cube = new Cube("demoCube", bankVoucher);
	}

	/**
	 * 测试仅涉及到单表不涉及到关联关系的查询.
	 */
	@Test
	public void testSimpleQuery() {
		assertEquals(2, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} left join 查询.
	 */
	@Test
	public void testLeftJoinAccount() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, account, new Condition(leftAccountNo, rightAccountNo));
		assertEquals(2, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} left join 查询,关联条件
	 * {@link Condition#COMPARATOR_GREATER}.
	 */
	@Test
	public void testLeftJoinAccountGreater() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, account,
				new Condition(leftAccountNo, rightAccountNo, Condition.COMPARATOR_GREATER));
		assertEquals(12, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} inner join 查询.
	 */
	@Test
	public void testInnerJoinAccount() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, account, new Condition(leftAccountNo, rightAccountNo));
		assertEquals(1, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} inner join 查询,关联查询的左边使用了
	 * {@link JoinExpression} 导致无法查询出数据.
	 */
	@Test
	public void testInnerJoinAccountWithJoinExpression() {
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, account,
				new Condition(new JoinExpression(bankVoucher, "concat(BANK_VOUCHER.ACCOUNT_NO,'1')"), rightAccountNo));
		assertEquals(0, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} 及
	 * {@link TestConstants#TABLE_CUST_BASIC_INFO} 表进行 left join 查询.
	 */
	@Test
	public void testLeftJoinAccountAndCusBasicInfo() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, account, new Condition(leftAccountNo, rightAccountNo));
		Field leftCusId = account.filterByName(TestConstants.FIELD_CUS_ID);
		Field rightCusId = custBasicInfo.filterByName(TestConstants.FIELD_CUS_ID);
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, custBasicInfo, new Condition(leftCusId, rightCusId));
		assertEquals(2, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} 及
	 * {@link TestConstants#TABLE_CUST_BASIC_INFO} 表进行 Inner join 查询.
	 */
	@Test
	public void testInnerJoinAccountAndCusBasicInfo() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, account, new Condition(leftAccountNo, rightAccountNo));
		Field leftCusId = account.filterByName(TestConstants.FIELD_CUS_ID);
		Field rightCusId = custBasicInfo.filterByName(TestConstants.FIELD_CUS_ID);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, custBasicInfo, new Condition(leftCusId, rightCusId));
		assertEquals(0, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

}
