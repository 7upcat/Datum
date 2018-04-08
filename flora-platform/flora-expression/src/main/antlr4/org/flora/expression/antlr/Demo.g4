grammar Demo;

expressions
:
	string_expression ';'
;

string_expression
:
	string_expression '+' string_expression
	| string_literal
	| 'CONCAT' '(' string_expression  ')'
;

string_literal
:
	STRING
;

//STRING : ('\'' (~ ('\''))* '\'');

STRING: '\'' (.)*? '\'' ;

WS
:
	[ \t\r\n] -> skip
;