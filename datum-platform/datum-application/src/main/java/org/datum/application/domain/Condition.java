/**
 * 
 */
package org.datum.application.domain;

import org.datum.expression.dialect.Dialect;

/**
 * 
 * 值对象用来描述事实表和维度表之间关联的条件.
 * 
 * @author 7cat
 * @see ExpressionCondition
 * @see CompareCondition
 */
public interface Condition{
	org.jooq.Condition asCondition(Dialect dialect);
}
