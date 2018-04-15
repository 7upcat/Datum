grammar DatumExpression;

import DatumExpressionCommonLexer;


calculations : 
    (native_expression|arithmetic_expression|string_expression|date_expression|bool_expression) ';'
    |comment_expression
;


arithmetic_expression : 
    <assoc=right> arithmetic_expression '^' arithmetic_expression
    |arithmetic_expression ('*'|'/'|'%') arithmetic_expression
    | arithmetic_expression ('+'|'-') arithmetic_expression
    | ('-')? (numeric_literal|field|functions_returning_numerics|native_expression|'(' arithmetic_expression ')')
;

functions_returning_numerics :
   'PI' '(' ')'
   |('ABS'|'ACOS'|'ASIN'|'ATAN'|'CEILING'|'COS'|'COT'|'DEGREES'|'EXP'|'FLOOR'|'LN'|'RADIANS'|'SIGN'|'SIN'|'SQRT'|'TAN') '(' arithmetic_expression ')'
   |('ATAN2'|'DIV'|'POWER') '(' arithmetic_expression ',' arithmetic_expression ')'
   |('ROUND'|'LOG') '(' arithmetic_expression (',' arithmetic_expression)? ')'
   |('ASCII'|'LEN') '(' string_expression ')'
   |'FIND' '(' string_expression ',' string_expression (',' arithmetic_expression)? ')'
   |'DATE_PART' '(' (date_expression|field) ',' ('YEAR'|'QUARTER'|'MONTH'|'DAY'|'WEEK'|'HOUR'|'MINUTE'|'SECOND')  ')'
   |('DAY'|'MONTH'|'YEAR') '(' (date_expression|field) ')'
   |'DATE_DIFF' '(' (date_expression|field) ',' (date_expression|field) ',' ('YEAR'|'QUARTER'|'MONTH'|'DAY'|'WEEK'|'HOUR'|'MINUTE'|'SECOND') ')'
;

numeric_literal : NUMBER;

string_expression :
    string_literal
    | functions_returning_strings
    | string_expression '+' string_expression
    | field
    | native_expression
;

functions_returning_strings :
    ('CHAR'|'SPACE')   '(' arithmetic_expression ')'
    |('LOWER'|'LTRIM'|'RTRIM'|'TRIM'|'UPPER')   '(' string_expression ')'
    |'MID' '(' string_expression ',' arithmetic_expression (',' arithmetic_expression)? ')'
    |('LEFT'|'RIGHT') '(' string_expression ',' arithmetic_expression ')'
    |'REPLACE' '(' string_expression ',' string_expression  ',' string_expression ')'
;

string_literal : STRING;

date_expression :
    date_literal
    |functions_returning_dates
;

functions_returning_dates:
  ('DATE_ADD'|'DATE_SUB')  '(' (date_expression|field) ',' ('YEAR'|'QUARTER'|'MONTH'|'DAY'|'WEEK'|'HOUR'|'MINUTE'|'SECOND')  ',' arithmetic_expression ')'
  |'NOW' '(' ')'
  |'TODAY' '(' ')'
;

date_literal : '#' DATE '#' ;

bool_expression :
    arithmetic_expression ( COMPARISON_OPERATOR ) ( arithmetic_expression|field|native_expression )
    | string_expression ( COMPARISON_OPERATOR ) ( string_expression|field|native_expression )
    | date_expression ( COMPARISON_OPERATOR ) ( date_expression|field|native_expression )
    | field ( COMPARISON_OPERATOR ) ( arithmetic_expression|string_expression|date_expression|native_expression )
    | bool_expression ( 'AND'|'OR' ) bool_expression
    | '(' bool_expression ')'
    | functions_returning_bools
;

functions_returning_bools:
    ('CONTAINS'|'ENDSWITH'|'STARTSWITH') '(' string_expression ',' string_expression ')'
;

native_expression: 'NATIVE' '(' string_expression (','(arithmetic_expression|string_expression|date_expression))* ')';


comment_expression : COMMENT | LINE_COMMENT;

field : '[' FIELD ']';
