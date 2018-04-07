lexer grammar FloraExpressionCommonLexer;

NUMBER
:
	[0-9]+
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

STRING
:
	(
		'\''
		(
			~( '\\' | '"' )
		)* '\''
	)
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

COMPARISON_OPERATOR
:
	'=='
	| '>'
	| '<'
	| '>='
	| '<='
	| '!='
;

LOGICAL_OPERATOR
:
	'AND'
	| 'OR'
;

TRUE
:
	'TRUE'
;

FALSE
:
	'FALSE'
;

COMMENT
:
	'/*' .*? '*/' -> channel ( HIDDEN )
;

LINE_COMMENT
:
	'//' ~[\r\n]* -> channel ( HIDDEN )
;

WS
:
	[ \t\r\n] -> skip
;