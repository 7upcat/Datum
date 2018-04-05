grammar FloraExpression;

import FloraExpressionCommonLexer;
// 语法包含  函数、数据域引用、参数、字面量、操作符、注释

grammars
:
	expression
;

expression
:
	arithmetic_expression
	| string_expression
	| date_expression
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
	'ABS' '('
	(
		arithmetic_expression
	) ')'
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
	| field
	| string_functions
	| '('+ string_expression+ ')'
;

string_literal
:
	STRING
;

//所有返回值为String的函数列表(注意并非和 StringFunctions 完全一致)

string_functions
:
	lower
;

lower
:
	'LOWER' '(' string_expression ')'
;

date_expression
:
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
	| field
	| date_literal
;

date_literal
:
	DATE
;

field
:
	'[' FIELD ']'
;