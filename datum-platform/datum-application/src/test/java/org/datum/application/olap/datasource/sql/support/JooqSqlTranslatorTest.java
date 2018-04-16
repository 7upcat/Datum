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

package org.datum.application.olap.datasource.sql.support;

import org.datum.application.common.TestConstants;
import org.datum.application.factory.ConnectorFactory;
import org.datum.application.olap.OlapService;
import org.datum.application.olap.datasource.sql.SqlTranslator;
import org.datum.application.olap.domain.CompareCondition;
import org.datum.application.olap.domain.Condition;
import org.datum.application.olap.domain.Connector;
import org.datum.application.olap.domain.ConnectorRepository;
import org.datum.application.olap.domain.Cube;
import org.datum.application.olap.domain.Dimension;
import org.datum.application.olap.domain.ExpressionCondition;
import org.datum.application.olap.domain.Field;
import org.datum.application.olap.domain.JoinExpression;
import org.datum.application.olap.domain.PhysicalTable;
import org.datum.application.olap.domain.TableLike;
import org.datum.application.test.BaseTest;
import org.datum.application.util.DBUtils;
import org.junit.Before;
import org.junit.Test;
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

	private OlapService<PhysicalTable, Field> metadataResolver = new JdbcOlapService();

	private JdbcTemplate jdbcTemplate;

	private TableLike bankVoucher;

	private TableLike account;

	private TableLike custBasicInfo;

	private Cube cube;
	
	private Connector connector;

	@Before
	public void init() {
		connector = ConnectorFactory.newSampleDBConnector();
		connectorRepository.save(connector);
		jdbcTemplate = new JdbcTemplate(DBUtils.newDataSource(connector));
		bankVoucher = metadataResolver.resolveTable(connector,
				PhysicalTable.newTable(TestConstants.TABLE_BANK_VOUCHER));
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
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, account, new CompareCondition(leftAccountNo, rightAccountNo));
		assertEquals(2, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} left join 查询,关联条件
	 * {@link CompareCondition#COMPARATOR_GREATER}.
	 */
	@Test
	public void testLeftJoinAccountGreater() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, account,
				new CompareCondition(leftAccountNo, rightAccountNo, CompareCondition.COMPARATOR_GREATER));
		assertEquals(12, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} inner join 查询.
	 */
	@Test
	public void testInnerJoinAccount() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, account, new CompareCondition(leftAccountNo, rightAccountNo));
		assertEquals(1, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} inner join 查询,关联查询的左边使用了
	 * {@link JoinExpression} 导致无法查询出数据.
	 */
	@Test
	public void testInnerJoinAccountWithJoinExpression() {
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, account, new CompareCondition(
				new JoinExpression(bankVoucher, "concat(BANK_VOUCHER.ACCOUNT_NO,'1')"), rightAccountNo));
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
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, account, new CompareCondition(leftAccountNo, rightAccountNo));
		Field leftCusId = account.filterByName(TestConstants.FIELD_CUS_ID);
		Field rightCusId = custBasicInfo.filterByName(TestConstants.FIELD_CUS_ID);
		
		Condition condition = new ExpressionCondition(String.format("([%s] = [%s] AND 2=2);", new Object[] {
			leftCusId.asField(), rightCusId.asField() }), metadataResolver.resolveDialect(connector));
		
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, custBasicInfo, condition);
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
		cube.addDimension(Dimension.JOIN_TYPE_INNER, account, new CompareCondition(leftAccountNo, rightAccountNo));
		Field leftCusId = account.filterByName(TestConstants.FIELD_CUS_ID);
		Field rightCusId = custBasicInfo.filterByName(TestConstants.FIELD_CUS_ID);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, custBasicInfo, new CompareCondition(leftCusId, rightCusId));
		assertEquals(0, jdbcTemplate.queryForList(sqlTranslator.translate(cube)).size());
	}

}
