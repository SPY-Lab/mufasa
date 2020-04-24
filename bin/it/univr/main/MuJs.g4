grammar MuJs;

@header {
    package it.univr.main;
}


EOL_COMMENT : '//' ~[\r\n]* -> skip;


NAN: 'NaN'
	;

BOOL: 'true' | 'false';

ID: [a-zA-Z][a-zA-Z0-9]*
	;

SIGN: '+' | '-';

INT: SIGN? [0-9]+ 
	;

STRING: '"' ~('\r' | '\n' | '"')* '"'
	| 	'\'' ~('\r' | '\n' )* '\''
	;
	
program: stmt EOF 														#ProgramExecution
	;
	
val: 	INT 															#Integer
	| 	BOOL 															#Boolean
	| 	STRING															#String
	|	NAN																#NaN
	;	

object: '{' '}'															#EmptyObject
	|	'{' (ID ':' expression) (';' ID ':' expression)* '}'			#Obj
	;
expression:	val															#PrimitiveValue
	|	expression '+' expression										#Sum
	|	expression '-' expression										#Diff
	|	expression '*' expression										#Mul
	|	expression '/' expression										#Div
	|	expression '>' expression										#Greater
	|	expression '<' expression										#Less
	|	expression '&&' expression										#And
	|	expression '||' expression										#Or
	|	expression '.' 'substring' '(' expression ',' expression ')'	#Substring
	|	expression '.' 'charAt' '(' expression ')'						#CharAt
	|	expression '.' 'indexOf' '(' expression ')'						#IndexOf
	|	expression '.' 'length'											#Length
	|	expression '.' 'includes' '(' expression ')'					#Includes
	|	expression '.' 'repeat' '(' expression ')'						#Repeat
	|	expression '.' 'startsWith' '(' expression ')'					#StartsWith
	|	expression '.' 'endsWith' '(' expression ')'					#EndsWith
	|	expression '.' 'trim' '(' ')'									#Trim
	|	expression '.' 'trimLeft' '(' ')'								#TrimLeft
	|	expression '.' 'trimRight' '(' ')'								#TrimRight
	|	expression '.' 'slice' '(' expression ',' expression ')'		#Slice
	|	expression '.' 'toLowerCase' '(' ')'							#ToLowerCase
	|	expression '.' 'toUpperCase' '(' ')'							#ToUpperCase
	|	expression '.' 'replace' '(' expression ',' expression')'		#Replace
	|	'(' expression ')'												#Parenthesis
	|	expression '==' expression										#Equals
	|	ID																#Identifier
	|	'!' expression													#Not
	|	object															#ObjectExpression
	|	ID'[' expression ']'											#PropLookup
	|	ID '(' expression ( ',' expression )* ')'						#FunctionCall
	|	'randInt' '(' ')'												#RandomInt
	;
	
		
stmt:
	   ID '=' expression ';'											#AssignmentStmt
	| 'if' '(' expression ')' block 'else' block						#IfStmt
	| 'for' '(' ID 'in' ID ')'	block									#ForEach
	| 'while' '(' expression ')' block									#WhileStmt
	|  block															#BlockStmt
	|  'return' expression ';'											#ReturnStmt				
	|  <assoc=right> stmt stmt											#Composition
	|  ID '=' 'new' object ';'		 									#ObjectAsg
	|  ID '[' expression ']' '=' expression ';'		 					#PropUpdate
	| 'function' ID '(' ID ( ',' ID)* ')' '{' stmt '}'					#FunctionDeclaration
	;

block:  '{' '}'
	|	'{' stmt '}'
	;	
	
WS: [ \r\n\t] + -> skip
   ;