grammar FloraExpression;

import FloraExpressionCommonLexer;

calculations
:
	arithmetic_expression ';' // 计算求值表达式 

	| string_expression ';' // 字符求值表达式

	| date_expression ';' // 日期求值表达式

	| comparison_expression ';' // 比较(布尔)求值表达式

;

arithmetic_expression
:
	arithmetic_expression
	(
		'*'
		| '/'
		| '%'
	) arithmetic_expression
	| arithmetic_expression
	(
		'+'
		| '-'
	) arithmetic_expression
	|
	(
		'-'
	)? numeric_literal
	|
	(
		'-'
	)? field
	|
	(
		'-'
	)? number_functions
	|
	(
		'-'
	)? '(' arithmetic_expression ')'
;

//所有返回值为数字的函数列表(注意并非和 NumberFunctions 完全一致)

number_functions
:
	abs
	| div
;
//---------------------------------------------NumberFunctions

abs
:
	'ABS' '(' arithmetic_expression ')'
;

div
:
	'DIV' '(' arithmetic_expression ',' arithmetic_expression ')'
;

numeric_literal
:
	NUMBER
;

string_expression
:
	string_expression
	(
		'+'
	) string_expression
	| string_literal
	| string_functions
	| field
	|'(' string_expression ')' ;

//所有返回值为String的函数列表(注意并非和 StringFunctions 完全一致)

string_functions
:
	lower
;

lower
:
	'LOWER' '(' string_expression ')'
;

string_literal
:
	STRING
;

date_expression
:

// TODO 如果改成 arithmetic_expression 则无法检测出 '2+' 这类的表达式,暂时使用 numeric_literal 不支持嵌套. 
	date_expression
	(
		'+'
		| '-'
	) arithmetic_expression
	| date_expression
	(
		'+'
		| '-'
	) field
	| date_literal
	| field
	| '(' date_expression ')'
;

date_literal
:
	DATE
;

comparison_expression
:
	arithmetic_expression
	(
		COMPARISON_OPERATOR
	)
	(
		arithmetic_expression
		| field
	)
	| string_expression
	(
		COMPARISON_OPERATOR
	)
	(
		string_expression
		| field
	)
	| date_expression
	(
		COMPARISON_OPERATOR
	)
	(
		date_expression
		| field
	)
	| field
	(
		COMPARISON_OPERATOR
	)
	(
		arithmetic_expression
		| string_expression
		| date_expression
	)
	| comparison_expression
	(
		LOGICAL_OPERATOR
	) comparison_expression
	| '(' comparison_expression ')'
;

comment
:
	COMMENT
	| LINE_COMMENT
;

field
:
	'[' FIELD ']'
;
