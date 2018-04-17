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

package org.datum.application.service.impl;

import java.sql.Types;
import java.util.List;

import org.datum.application.common.TestConstants;
import org.datum.application.domain.Connector;
import org.datum.application.domain.ConnectorRepository;
import org.datum.application.domain.Cube;
import org.datum.application.factory.ConnectorFactory;
import org.datum.application.olap.CompareCondition;
import org.datum.application.olap.Condition;
import org.datum.application.olap.Dimension;
import org.datum.application.olap.ExpressionCondition;
import org.datum.application.olap.Field;
import org.datum.application.olap.JoinExpression;
import org.datum.application.olap.PhysicalTable;
import org.datum.application.olap.TableLike;
import org.datum.application.service.OLAPService;
import org.datum.application.test.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author 7cat
 * @since 1.0
 */
public class DatabaseOLAPServiceTest extends BaseTest {

	@Autowired
	private ConnectorRepository connectorRepository;

	private OLAPService<PhysicalTable, Field> olapService = new DatabaseOLAPService();

	private TableLike bankVoucher;

	private TableLike account;

	private TableLike custBasicInfo;

	private Cube cube;

	private Connector connector;

	@Before
	public void init() {
		connector = ConnectorFactory.newSampleDBConnector();
		connectorRepository.save(connector);
		bankVoucher = olapService.resolveTable(connector, PhysicalTable.newTable(TestConstants.TABLE_BANK_VOUCHER));
		account = olapService.resolveTable(connector, PhysicalTable.newTable(TestConstants.TABLE_ACCOUNT));
		custBasicInfo = olapService.resolveTable(connector,
				PhysicalTable.newTable(TestConstants.TABLE_CUST_BASIC_INFO));
		cube = new Cube("demoCube", bankVoucher);
	}

	/**
	 * 测试仅涉及到单表不涉及到关联关系的查询.
	 */
	@Test
	public void testSimpleQuery() {
		assertEquals(2, olapService.fetchData(connector, cube).getDatas().size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} left join 查询.
	 */
	@Test
	public void testLeftJoinAccount() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_LEFT, account, new CompareCondition(leftAccountNo, rightAccountNo));
		assertEquals(2, olapService.fetchData(connector, cube).getDatas().size());
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
		assertEquals(12, olapService.fetchData(connector, cube).getDatas().size());
	}

	/**
	 * 测试 {@link TestConstants#TABLE_BANK_VOUCHER} 表同 {@link TestConstants#TABLE_ACCOUNT} inner join 查询.
	 */
	@Test
	public void testInnerJoinAccount() {
		Field leftAccountNo = bankVoucher.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		Field rightAccountNo = account.filterByName(TestConstants.FIELD_ACCOUNT_NO);
		cube.addDimension(Dimension.JOIN_TYPE_INNER, account, new CompareCondition(leftAccountNo, rightAccountNo));
		assertEquals(1, olapService.fetchData(connector, cube).getDatas().size());
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
		assertEquals(0, olapService.fetchData(connector, cube).getDatas().size());
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

		Condition condition = new ExpressionCondition(
				String.format("([%s] = [%s] AND 2=2);", new Object[] { leftCusId.asField(), rightCusId.asField() }));

		cube.addDimension(Dimension.JOIN_TYPE_LEFT, custBasicInfo, condition);
		assertEquals(2, olapService.fetchData(connector, cube).getDatas().size());
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
		assertEquals(0, olapService.fetchData(connector, cube).getDatas().size());
	}

	@Test
	public void testResolveTables() {
		List<PhysicalTable> tables = olapService.resolveTables(ConnectorFactory.newSampleDBConnector());
		assertEquals(3, tables.size());
	}

	@Test
	public void testResolveFields() {
		Connector connector = ConnectorFactory.newSampleDBConnector();
		PhysicalTable table = olapService.resolveTables(connector).stream().filter(
				t -> TestConstants.TABLE_CUST_BASIC_INFO.equals(t.getTableName())).findAny().get();
		Field cusIdColumn = olapService.resolveFields(connector, table).stream().filter(
				c -> TestConstants.FIELD_CUS_ID.equals(c.getColumnName())).findAny().get();
		assertEquals(Types.CHAR, cusIdColumn.getDataType());
	}
}
