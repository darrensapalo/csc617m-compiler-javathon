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
  : block {node = $block.node;}  
  ;  
  
block returns [JNode node]  
@init { 
  BlockNode bn = new BlockNode(); 
  node = bn; 
  Scope scope = new Scope(currentScope); 
  currentScope = scope; 
}  
@after { 
  currentScope = currentScope.parent(); 
}  
  :  ^(BLOCK   
        ^( STATEMENTS (statement  { bn.addStatement($statement.node);})* )   
        ^( RETURN     (expression { bn.addReturn($expression.node);  })? )  
      )  
  ;  
  
statement returns [JNode node]  
  :  assignment     {node = $assignment.node;}  
  |  functionCall   {node = $functionCall.node;}  
  |  ifStatement    {node = $ifStatement.node;}   
  |  whileStatement {node = $whileStatement.node;}  
  ;  
  
assignment returns [JNode node]  
  :  ^(ASSIGNMENT i=Identifier x=indexes? e=expression)   
     {node = new AssignmentNode($i.text, $x.e, $e.node, currentScope);}  
  ; 
  
functionCall  returns [JNode node]  
  :  ^(FUNC_CALL Identifier exprList?)   {node = new FunctionCallNode($Identifier.text, $exprList.e, functions);}
  |  ^(FUNC_CALL Println expression?)    {node = new PrintlnNode($expression.node);}  
  |  ^(FUNC_CALL Print expression)  	 {node = new PrintNode($expression.node);}
  |  ^(FUNC_CALL Assert expression)  	 {node = new AssertNode($expression.node);}
  |  ^(FUNC_CALL Size expression)  	 	 {node = new SizeNode($expression.node);}
  ;  
  
ifStatement returns [JNode node]  
@init  { 
  IfNode ifNode = new IfNode(); 
  node = ifNode; 
}  
  :  ^(IF   
       (^(EXP expression b1=block) 		{ifNode.addChoice($expression.node,$b1.node);})+   
       (^(EXP b2=block)           		{ifNode.addChoice(new AtomNode(true),$b2.node);})?  
     )  
  ;  
  
whileStatement returns [JNode node]
  :  ^(While expression block)  		{node = new WhileStatementNode($expression.node, $block.node);}
  ;  
  
idList  returns [java.util.List<String> i]
@init {i = new java.util.ArrayList<String>();}
  :  ^(ID_LIST (Identifier {i.add($Identifier.text);})+)
  ;
  
exprList returns [java.util.List<JNode> e]
@init  {e = new java.util.ArrayList<JNode>();}
  :  ^(EXP_LIST (expression {e.add($expression.node);})+)
  ;
  
expression returns [JNode node]  
  :  ^(TERNARY a=expression b=expression c=expression){node = new TernaryNode($a.node, $b.node, $c.node);}
  |  ^(In a=expression b=expression)  				  {node = new InNode		($a.node, $b.node);}
  |  ^('||' a=expression b=expression)    			  {node = new OrNode		($a.node, $b.node);}
  |  ^('&&' a=expression b=expression)    			  {node = new AndNode		($a.node, $b.node);}
  |  ^('==' a=expression b=expression)    			  {node = new EqualNode		($a.node, $b.node);}
  |  ^('!=' a=expression b=expression)    			  {node = new NotEqualNode	($a.node, $b.node);}
  |  ^('>=' a=expression b=expression)  			  {node = new GTENode		($a.node, $b.node);}
  |  ^('<=' a=expression b=expression)  			  {node = new LTENode		($a.node, $b.node);}
  |  ^('>' a=expression b=expression)                 {node = new GTNode		($a.node, $b.node);}
  |  ^('<' a=expression b=expression)  		          {node = new LTNode		($a.node, $b.node);}  
  |  ^('+' a=expression b=expression) 		          {node = new AddNode		($a.node, $b.node);}
  |  ^('-' a=expression b=expression)                 {node = new MinusNode 	($a.node, $b.node);}
  |  ^('*' a=expression b=expression)                 {node = new MultiplyNode 	($a.node, $b.node);}
  |  ^('/' a=expression b=expression)                 {node = new DivideNode 	($a.node, $b.node);}
  |  ^('%' a=expression b=expression)                 {node = new ModuloNode 	($a.node, $b.node);}
  |  ^('^' a=expression b=expression)                 {node = new PowerNode 	($a.node, $b.node);}                  
  |  ^(UNARY_MIN a=expression)                        {node = new UnaryMinNode 	($a.node);}                
  |  ^(NEGATE a=expression)                           {node = new NegateNode	($a.node);}
  |  Number  		                         		  {node = new AtomNode		(Double.parseDouble($Number.text));}  
  |  Bool                                             {node = new AtomNode		(Boolean.parseBoolean($Bool.text));}
  |  Null  											  {node = new AtomNode		(null);}
  |  lookup 										  {node = $lookup.node;}         
  ;  
  
list returns [JNode node]
  :  ^(LIST exprList?) {node = new ListNode($exprList.e);}
  ;
  
lookup returns [JNode node]  
  :  ^(LOOKUP functionCall i=indexes?)  
  		{node = $i.e != null ? new LookupNode($functionCall.node, $indexes.e) : $functionCall.node;}
  		
  |  ^(LOOKUP list i=indexes?)
  		{node = $i.e != null ? new LookupNode($list.node, $indexes.e) : $list.node;}
  		  
  |  ^(LOOKUP expression i=indexes?)
  		{node = $i.e != null ? new LookupNode($expression.node, $indexes.e) : $expression.node;}
  		   
  |  ^(LOOKUP Identifier i=indexes?)  
      {
      	node = $i.e != null 
      	? new LookupNode(new IdentifierNode($Identifier.text, currentScope), $indexes.e)
      	: new IdentifierNode($Identifier.text, currentScope);}
  |  ^(LOOKUP s=String x=indexes?)
  	  {
        node = new StringNode($s.text, $x.e);
      }  
  ;  
  
indexes returns [List<JNode> e]  
@init {e = new ArrayList<JNode>();}  
  :  ^(INDEXES (expression {e.add($expression.node);})+)  
  ;  
