grammar Javathon;

options { 
  output=AST;
}


tokens { 
  BLOCK; 
  RETURN; 
  STATEMENTS; 
  ASSIGNMENT; 
  FUNC_CALL; 
  EXP; 
  EXP_LIST; 
  ID_LIST; 
  IF; 
  TERNARY; 
  UNARY_MIN; 
  NEGATE; 
  FUNCTION; 
  INDEXES; 
  LIST; 
  LOOKUP; 
}  

@parser::header { 
  package grammar; 
}  
  
@lexer::header { 
  package grammar; 
}

parse  
  :  block EOF -> block  
  ;  
  
block  
  :  (statement | functionDecl)* (Return expression ';')?   
     -> ^(BLOCK ^(STATEMENTS statement*) ^(RETURN expression?))  
  ;  
  
statement  
  :  assignment ';' 	-> assignment 
  |  functionCall ';'  	-> functionCall
  |  ifStatement   
  |  whileStatement  
  ;  
  

/* Assignment */  
assignment  
  :  Identifier indexes? '=' expression  
  	 -> ^(ASSIGNMENT Identifier indexes? expression)
  ;
  
functionCall  
  :  Identifier '(' exprList? ')' -> ^(FUNC_CALL Identifier exprList?)  
  |  Println '(' expression? ')'  -> ^(FUNC_CALL Println expression?)  
  |  Print '(' expression ')'     -> ^(FUNC_CALL Print expression)  
  |  Assert '(' expression ')'    -> ^(FUNC_CALL Assert expression)  
  |  Size '(' expression ')'      -> ^(FUNC_CALL Size expression)  
  ;  
  
   

/* if statements */
ifStatement  
  :  ifStat elseIfStat* elseStat? End -> ^(IF ifStat elseIfStat* elseStat?)  
  ;  
  
ifStat  
  :  If expression Do block -> ^(EXP expression block)  
  ;  
  
elseIfStat  
  :  Else If expression Do block -> ^(EXP expression block)  
  ;  
  
elseStat  
  :  Else Do block -> ^(EXP block)  
  ;
  

/* function declaration */
  
  functionDecl  
  :  Def Identifier '(' idList? ')' block End {/* implemented later */}  
  ;  
  
whileStatement  
  :  While expression Do block End -> ^(While expression block)  
  ;  
  
idList  
  :  Identifier (',' Identifier)* -> ^(ID_LIST Identifier+)  
  ;  
  
exprList  
  :  expression (',' expression)* -> ^(EXP_LIST expression+)  
  ;  

/* Expressions */  
expression  
  :  condExpr  
  ;  
  
condExpr  
  :  (orExpr -> orExpr)   
     ( '?' a=expression ':' b=expression -> ^(TERNARY orExpr $a $b)  
     | In expression                     -> ^(In orExpr expression)  
     )?  
  ;  
  
orExpr  
  :  andExpr ('||'^ andExpr)*  
  ;  
  
andExpr  
  :  equExpr ('&&'^ equExpr)*  
  ;  
  
equExpr  
  :  relExpr (('==' | '!=')^ relExpr)*  
  ;  
  
relExpr  
  :  addExpr (('>=' | '<=' | '>' | '<')^ addExpr)*  
  ;  
  
addExpr  
  :  mulExpr (('+' | '-')^ mulExpr)*  
  ;  
  
mulExpr  
  :  powExpr (('*' | '/' | '%')^ powExpr)*  
  ;  
  
powExpr  
  :  unaryExpr ('^'^ unaryExpr)*  
  ;  
    
unaryExpr  
  :  '-' atom -> ^(UNARY_MIN atom)  
  |  '!' atom -> ^(NEGATE atom)  
  |  atom  
  ;  
  
atom  
  :  Number  
  |  Bool  
  |  Null  
  |  lookup  
  ;  

list  
  :  '[' exprList? ']' -> ^(LIST exprList?)  
  ;  
  

/* Look up */
lookup  
  :  functionCall indexes?  
  |  '(' expression ')' indexes?  
  |  list indexes?  
  |  Identifier indexes?  
  |  String indexes?  
  ;  
  
  
/* Indices, used for arrays */
indexes  
  :  ('[' expression ']')+ -> ^(INDEXES expression+)  
  ;  
      
/* Keywords */
Println  : 'println';  
Print    : 'print';  
Assert   : 'assert';  
Size     : 'size';  
Def      : 'def';  
If       : 'if';  
Else     : 'else';  
Return   : 'return';  
For      : 'for';  
While    : 'while';  
To       : 'to';  
Do       : 'do';  
End      : 'end';  
In       : 'in';  
Null     : 'null';  
  
Or       : '||';  
And      : '&&';  
Equals   : '==';  
NEquals  : '!=';  
GTEquals : '>=';  
LTEquals : '<=';  
Pow      : '^';  
Excl     : '!';  
GT       : '>';  
LT       : '<';  
Add      : '+';  
Subtract : '-';  
Multiply : '*';  
Divide   : '/';  
Modulus  : '%';  
OBrace   : '{';  
CBrace   : '}';  
OBracket : '[';  
CBracket : ']';  
OParen   : '(';  
CParen   : ')';  
SColon   : ';';  
Assign   : '=';  
Comma    : ',';  
QMark    : '?';  
Colon    : ':';  
  
Bool  
  :  'true'   
  |  'false'  
  ;  
  
Number  
  :  Int ('.' Digit*)?  
  ;  
  
Identifier  
  :  ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | Digit)*  
  ;  
  
String  
@after { 
  setText(getText().substring(1, getText().length()-1).replaceAll("\\\\(.)", "$1")); 
}  
  :  '"'  (~('"' | '\\')  | '\\' .)* '"'   
  |  '\'' (~('\'' | '\\') | '\\' .)* '\''   
  ;  
  
Comment  
  :  '//' ~('\r' | '\n')* {skip();}  
  |  '/*' .* '*/'         {skip();}  
  ;  
  
Space  
  :  (' ' | '\t' | '\r' | '\n' | '\u000C') {skip();}  
  ;  
  
fragment Int  
  :  '1'..'9' Digit*  
  |  '0'  
  ;  
    
fragment Digit   
  :  '0'..'9'  
  ;  