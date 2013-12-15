grammar Javathon;
  
@parser::header { 
  package grammar; 
}  
  
@lexer::header { 
  package grammar; 
}
parse  
  :  (t=.   
          {System.out.printf("text: \%-7s  type: \%s \n",  
           $t.text, tokenNames[$t.type]);}  
     )*   
     EOF  
  ;  
  
block  
  :  (statement | functionDecl)* (Return expression ';')?  
  ;  
  
statement  
  :  assignment ';'  
  |  functionCall ';'  
  |  ifStatement   
  |  whileStatement  
  ;  
  
functionDecl  
  :  Def Identifier '(' idList? ')' block End  
  ;  
  
idList  
  :  Identifier (',' Identifier)*  
  ;  

/* Assignment */  
assignment  
  :  Identifier indexes? '=' expression  
  ;  
  
indexes  
  :  ('[' expression ']')+  
  ;  

/* Expressions */  
expression  
  :  condExpr  
  ;  
  
condExpr  
  :  orExpr ( '?' expression ':' expression  
            | In expression  
            )?  
  ;  
  
orExpr  
  :  andExpr ('||' andExpr)*  
  ;  
  
andExpr  
  :  equExpr ('&&' equExpr)*  
  ;  
  
equExpr  
  :  relExpr (('==' | '!=') relExpr)*  
  ;  
  
relExpr  
  :  addExpr (('>=' | '<=' | '>' | '<') addExpr)*  
  ;  
  
addExpr  
  :  mulExpr (('+' | '-') mulExpr)*  
  ;  
  
mulExpr  
  :  powExpr (('*' | '/' | '%') powExpr)*  
  ;  
  
powExpr  
  :  unaryExpr ('^' unaryExpr)*  
  ;  
    
unaryExpr  
  :  '-' atom  
  |  '!' atom  
  |  atom  
  ;  
  
atom  
  :  Null  
  |  Number  
  |  Bool  
  |  lookup  
  ;  


/* Look up */
lookup  
  :  functionCall indexes?  
  |  '(' expression ')' indexes?  
  |  list indexes?  
  |  Identifier indexes?  
  |  String indexes?  
  ;  
  
  
/* List */
list  
  :  '[' exprList? ']'  
  ;  
  
exprList  
  :  expression (',' expression)*  
  ;  
  
  
/* Function call */
functionCall  
  :  Identifier '(' exprList? ')'  
  |  Println '(' expression? ')'  
  |  Print '(' expression ')'  
  |  Assert '(' expression ')'  
  |  Size '(' expression ')'  
  ;  


/* if statements */
ifStatement  
  :  ifStat elseIfStat* elseStat? End   
  ;  
  
ifStat  
  :  If expression Do block  
  ;  
  
elseIfStat  
  :  Else If expression Do block  
  ;  
  
elseStat  
  :  Else Do block  
  ;  
  
whileStatement  
  :  While expression Do block End   
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