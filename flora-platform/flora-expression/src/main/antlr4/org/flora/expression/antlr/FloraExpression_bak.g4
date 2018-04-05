grammar FloraExpression_bak;


// 语法包含  函数、数据域引用、参数、字面量、操作符、注释

grammars
:
//	functions
//	| fields
//	| parameters
	| literals
	//	| operators

	| comments
;

// 函数包含 数值函数、字符串函数、日期函数、聚合函数、原生函数（bypass 给数据源处理）
// TODO 后续慢慢补充其他的函数,先使用数值函数来进行验证

functions
:
	number_functions
	//	| string_functions
	//	| date_functions
	//	| aggregate_functions
	//	| native_functions

;

// 数据域引用的格式为 [表名.数据域名],其中表名可选

fields
:
	'[' FIELD ']'
;

// 参数的格式为 {参数名}

parameters
:
	'{' PARAMETER '}'
;

// 字面量包含 数字、日期、字符串、布尔、空值(NULL)

literals
:
	numeric_literal
//	| date_literal
//	| string_literal
//	| boolean_literal
//	| null_literal
;

// 仅支持多行注释，当然你也可以把它放在一行充当单行注释  '/**/'

comments
:
	COMMENT
;

COMMENT
:
	'/*' .*? '*/' -> skip
;

number_functions
:
	abs
	| div
;

abs
:
	'ABS' '(' arithmetic_expression ')'
;

div
:
	'DIV' '(' arithmetic_expression ',' arithmetic_expression ')'
;

//string_expression
//:
//	string_expression
//	(
//		'+'
//	) string_expression
//	| string_literal
//	| '(' string_expression ')'
//;

arithmetic_expression
:
	arithmetic_expression
	(
		'*'
		| '/'
	) arithmetic_expression arithmetic_expression
	(
		'+'
		| '-'
	) arithmetic_expression
//	| fields
	| numeric_literal
//	| number_functions
	| '(' arithmetic_expression ')'
;

//
//arithmetic_expression
//:
//	(
//		arithmetic_term
//	)
//	(
//		(
//			'+'
//			| '-'
//		) arithmetic_term
//	)*
//;
//
//arithmetic_term
//:
//	(
//		arithmetic_factor
//	)
//	(
//		(
//			'*'
//			| '/'
//			| '%'
//		) arithmetic_factor
//	)*
//;
//
//arithmetic_factor
//:
//	(
//		'+'
//		| '-'
//	)? arithmetic_primary
//;
//
//arithmetic_primary
//:
//	fields
//	| numeric_literal
//	| '(' arithmetic_expression ')'
//	| number_functions
//;

numeric_literal
:
	NUMBER
;

NUMBER
:
	[0-9]+
;

date_literal
:
	DATE
;

DATE
:
	'#' [0-9] [0-9] [0-9] [0-9] '-'
	(
		(
			[0] [1-9]
		)
		|
		(
			[1] [0-2]
		)
	) '-'
	(
		(
			[0] [1-9]
		)
		|
		(
			[1] [0-9]
		)
		|
		(
			[2] [0-9]
		)
		|
		(
			[3] [0-1]
		)
	) '#'
;

//string_literal
//:
//	(
//		'\''
//		(
//			~( '\\' | '"' )
//		)* '\''
//	)
//;

boolean_literal
:
	TRUE
	| FALSE
;

TRUE
:
	'TRUE'
;

FALSE
:
	'FALSE'
;

null_literal
:
	NULL
;

NULL
:
	'NULL'
;

FIELD
:
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '_'
	)
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '0' .. '9'
		| '_'
	)* '.'
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '_'
	)
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '0' .. '9'
		| '_'
	)*
;

PARAMETER
:
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '_'
	)
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '0' .. '9'
		| '_'
	)*
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '_'
	)
	(
		'a' .. 'z'
		| 'A' .. 'Z'
		| '0' .. '9'
		| '_'
	)*
;

WS
:
	[ \t\r\n] -> skip
;
