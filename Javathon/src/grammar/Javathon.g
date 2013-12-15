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