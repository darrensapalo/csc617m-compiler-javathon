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
  import main.javathon.*;  
  import java.util.Map; 
  import java.util.HashMap; 
}  
  
@lexer::header { 
  package grammar; 
}

@parser::members { 
  public Map<String, JFunction> functions = new HashMap<String, JFunction>(); 
   
  private void defineFunction(String id, Object idList, Object block) { 
 
    // `idList` is possibly null!  Create an empty tree in that case.  
    CommonTree idListTree = idList == null ? new CommonTree() : (CommonTree)idList; 
 
    // `block` is never null 
    CommonTree blockTree = (CommonTree)block; 
 
    // The function name with the number of parameters after it, is the unique key 
    String key = id + idListTree.getChildCount(); 
    functions.put(key, new JFunction(id, idListTree, blockTree)); 
  } 
}  


parse  
  :  block -> block  
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
  
ifStatement  
  :  ifStat elseIfStat* elseStat? End -> ^(IF ifStat elseIfStat* elseStat?)  
  ;  
  
ifStat  
  :  If expression Colon block -> ^(EXP expression block)  
  ;  
  
elseIfStat  
  :  Else If expression Colon block -> ^(EXP expression block)  
  ;  
  
elseStat  
  :  Else Colon block -> ^(EXP block)  
  ;
  
  functionDecl  
  :  Def Identifier '(' idList? ')' block End   
     {defineFunction($Identifier.text, $idList.tree, $block.tree);}  
  ;  
  





whileStatement  
  :  While expression Colon block End -> ^(While expression block)  
  ;  
  
idList  
  :  Identifier (',' Identifier)* -> ^(ID_LIST Identifier+)  
  ;  
  
exprList returns [java.util.List<JNode> e]
  :  expression (',' expression)* -> ^(EXP_LIST expression+)  
  ;  

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
  |  Input	'(' String? ')' -> ^(Input String?)
  ;  

list  
  :  '[' exprList? ']' -> ^(LIST exprList?)  
  ;  
  
lookup  
  :  functionCall indexes?       -> ^(LOOKUP functionCall indexes?)
  |  list indexes?               -> ^(LOOKUP list indexes?)
  |  Identifier indexes?         -> ^(LOOKUP Identifier indexes?)
  |  String indexes?             -> ^(LOOKUP String indexes?)
  |  '(' expression ')' indexes? -> ^(LOOKUP expression indexes?)
  ;  
  
  
/* Indices, used for arrays */
indexes  
  :  ('[' expression ']')+ -> ^(INDEXES expression+)  
  ;  
      
/* Keywords */
Input    : 'input';
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