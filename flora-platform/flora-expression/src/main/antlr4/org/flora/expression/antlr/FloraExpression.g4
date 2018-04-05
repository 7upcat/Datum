grammar FloraExpression;

grammars
:
	functions
	| fields
	| parameters
	| literals
	| comments
;

functions
:
	number_functions
;

fields
:
	'[' FIELD ']'
;

parameters
:
	'{' PARAMETER '}'
;

literals
:
	NUMBER
	| DATE
;

comments
:
	COMMENT
	| LINE_COMMENT
;

COMMENT
:
	'/*' .*? '*/' -> skip
;

LINE_COMMENT
:
	'//' ~[\r\n]* -> skip
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

arithmetic_expression
:
	(
		arithmetic_term
	)
	(
		(
			'+'
			| '-'
		) arithmetic_term
	)*
;

arithmetic_term
:
	(
		arithmetic_factor
	)
	(
		(
			'*'
			| '/'
		) arithmetic_factor
	)*
;

arithmetic_factor
:
	(
		'+'
		| '-'
	)? arithmetic_primary
;

arithmetic_primary
:
	fields
	| numeric_literal
	| '(' arithmetic_expression ')'
;

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
