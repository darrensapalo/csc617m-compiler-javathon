tree grammar JavathonTreeWalker;  
  
options { 
  tokenVocab=Javathon; 
  ASTLabelType=CommonTree; 
}  
  
@header { 
  package grammar;
  import main.javathon.*; 
  import java.util.Map; 
  import java.util.HashMap; 
}  
  
@members { 
  public Map<String, JFunction> functions = null; 
  Scope currentScope = null; 
   
  public JavathonTreeWalker(CommonTreeNodeStream nodes, Map<String, JFunction> fns) { 
    this(nodes, null, fns); 
  } 
   
  public JavathonTreeWalker(CommonTreeNodeStream nds, Scope sc, Map<String, JFunction> fns) { 
    super(nds); 
    currentScope = sc; 
    functions = fns; 
  } 
}  
  
walk returns [JNode node]  
  :  block {node = null;}  
  ;  
  
block  
  :  ^(BLOCK ^(STATEMENTS statement*) ^(RETURN expression?))  
  ;  
  
statement  
  :  assignment  
  |  functionCall  
  |  ifStatement   
  |  whileStatement  
  ;  
  
assignment  
  :  ^(ASSIGNMENT Identifier indexes? expression)  
  ;  
  
functionCall  
  :  ^(FUNC_CALL Identifier exprList?)  
  |  ^(FUNC_CALL Println expression?)  
  |  ^(FUNC_CALL Print expression)  
  |  ^(FUNC_CALL Assert expression)  
  |  ^(FUNC_CALL Size expression)  
  ;  
  
ifStatement  
  :  ^(IF ifStat elseIfStat* elseStat?)  
  ;  
  
ifStat  
  :  ^(EXP expression block)  
  ;  
  
elseIfStat  
  :  ^(EXP expression block)  
  ;  
  
elseStat  
  :  ^(EXP block)  
  ;  
  
whileStatement  
  :  ^(While expression block)  
  ;  
  
idList  
  :  ^(ID_LIST Identifier+)  
  ;  
  
exprList  
  :  ^(EXP_LIST expression+)  
  ;  
  
expression  
  :  ^(TERNARY expression expression expression)  
  |  ^(In expression expression)  
  |  ^('||' expression expression)  
  |  ^('&&' expression expression)  
  |  ^('==' expression expression)  
  |  ^('!=' expression expression)  
  |  ^('>=' expression expression)  
  |  ^('<=' expression expression)  
  |  ^('>' expression expression)  
  |  ^('<' expression expression)  
  |  ^('+' expression expression)  
  |  ^('-' expression expression)  
  |  ^('*' expression expression)  
  |  ^('/' expression expression)  
  |  ^('%' expression expression)  
  |  ^('^' expression expression)  
  |  ^(UNARY_MIN expression)  
  |  ^(NEGATE expression)  
  |  Number  
  |  Bool  
  |  Null  
  |  lookup             
  ;  
  
list  
  :  ^(LIST exprList?)  
  ;  
  
lookup  
  :  ^(LOOKUP functionCall indexes?)  
  |  ^(LOOKUP list indexes?)  
  |  ^(LOOKUP expression indexes?)   
  |  ^(LOOKUP Identifier indexes?)  
  |  ^(LOOKUP String indexes?)  
  ;  
  
indexes  
  :  ^(INDEXES expression+)  
  ;  