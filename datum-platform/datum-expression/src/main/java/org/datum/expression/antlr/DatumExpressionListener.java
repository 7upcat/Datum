// Generated from DatumExpression.g4 by ANTLR 4.4
package org.datum.expression.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DatumExpressionParser}.
 */
public interface DatumExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#functions_returning_dates}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_returning_dates(@NotNull DatumExpressionParser.Functions_returning_datesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#functions_returning_dates}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_returning_dates(@NotNull DatumExpressionParser.Functions_returning_datesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_returning_numerics(@NotNull DatumExpressionParser.Functions_returning_numericsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_returning_numerics(@NotNull DatumExpressionParser.Functions_returning_numericsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#date_expression}.
	 * @param ctx the parse tree
	 */
	void enterDate_expression(@NotNull DatumExpressionParser.Date_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#date_expression}.
	 * @param ctx the parse tree
	 */
	void exitDate_expression(@NotNull DatumExpressionParser.Date_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#comment_expression}.
	 * @param ctx the parse tree
	 */
	void enterComment_expression(@NotNull DatumExpressionParser.Comment_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#comment_expression}.
	 * @param ctx the parse tree
	 */
	void exitComment_expression(@NotNull DatumExpressionParser.Comment_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void enterBool_expression(@NotNull DatumExpressionParser.Bool_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void exitBool_expression(@NotNull DatumExpressionParser.Bool_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(@NotNull DatumExpressionParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(@NotNull DatumExpressionParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void enterString_expression(@NotNull DatumExpressionParser.String_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void exitString_expression(@NotNull DatumExpressionParser.String_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull DatumExpressionParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull DatumExpressionParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expression(@NotNull DatumExpressionParser.Arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expression(@NotNull DatumExpressionParser.Arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#functions_returning_bools}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_returning_bools(@NotNull DatumExpressionParser.Functions_returning_boolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#functions_returning_bools}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_returning_bools(@NotNull DatumExpressionParser.Functions_returning_boolsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#calculations}.
	 * @param ctx the parse tree
	 */
	void enterCalculations(@NotNull DatumExpressionParser.CalculationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#calculations}.
	 * @param ctx the parse tree
	 */
	void exitCalculations(@NotNull DatumExpressionParser.CalculationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_returning_strings(@NotNull DatumExpressionParser.Functions_returning_stringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_returning_strings(@NotNull DatumExpressionParser.Functions_returning_stringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#native_expression}.
	 * @param ctx the parse tree
	 */
	void enterNative_expression(@NotNull DatumExpressionParser.Native_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#native_expression}.
	 * @param ctx the parse tree
	 */
	void exitNative_expression(@NotNull DatumExpressionParser.Native_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void enterDate_literal(@NotNull DatumExpressionParser.Date_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void exitDate_literal(@NotNull DatumExpressionParser.Date_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DatumExpressionParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(@NotNull DatumExpressionParser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatumExpressionParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(@NotNull DatumExpressionParser.Numeric_literalContext ctx);
}