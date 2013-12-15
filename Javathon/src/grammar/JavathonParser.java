// $ANTLR 3.5.1 src/grammar/Javathon.g 2013-12-15 20:44:28
 
  package grammar; 
  import main.javathon.*;  
  import java.util.Map; 
  import java.util.HashMap; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class JavathonParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "Add", "And", "Assert", 
		"Assign", "BLOCK", "Bool", "CBrace", "CBracket", "CParen", "Colon", "Comma", 
		"Comment", "Def", "Digit", "Divide", "Do", "EXP", "EXP_LIST", "Else", 
		"End", "Equals", "Excl", "FUNCTION", "FUNC_CALL", "For", "GT", "GTEquals", 
		"ID_LIST", "IF", "INDEXES", "Identifier", "If", "In", "Int", "LIST", "LOOKUP", 
		"LT", "LTEquals", "Modulus", "Multiply", "NEGATE", "NEquals", "Null", 
		"Number", "OBrace", "OBracket", "OParen", "Or", "Pow", "Print", "Println", 
		"QMark", "RETURN", "Return", "SColon", "STATEMENTS", "Size", "Space", 
		"String", "Subtract", "TERNARY", "To", "UNARY_MIN", "While"
	};
	public static final int EOF=-1;
	public static final int ASSIGNMENT=4;
	public static final int Add=5;
	public static final int And=6;
	public static final int Assert=7;
	public static final int Assign=8;
	public static final int BLOCK=9;
	public static final int Bool=10;
	public static final int CBrace=11;
	public static final int CBracket=12;
	public static final int CParen=13;
	public static final int Colon=14;
	public static final int Comma=15;
	public static final int Comment=16;
	public static final int Def=17;
	public static final int Digit=18;
	public static final int Divide=19;
	public static final int Do=20;
	public static final int EXP=21;
	public static final int EXP_LIST=22;
	public static final int Else=23;
	public static final int End=24;
	public static final int Equals=25;
	public static final int Excl=26;
	public static final int FUNCTION=27;
	public static final int FUNC_CALL=28;
	public static final int For=29;
	public static final int GT=30;
	public static final int GTEquals=31;
	public static final int ID_LIST=32;
	public static final int IF=33;
	public static final int INDEXES=34;
	public static final int Identifier=35;
	public static final int If=36;
	public static final int In=37;
	public static final int Int=38;
	public static final int LIST=39;
	public static final int LOOKUP=40;
	public static final int LT=41;
	public static final int LTEquals=42;
	public static final int Modulus=43;
	public static final int Multiply=44;
	public static final int NEGATE=45;
	public static final int NEquals=46;
	public static final int Null=47;
	public static final int Number=48;
	public static final int OBrace=49;
	public static final int OBracket=50;
	public static final int OParen=51;
	public static final int Or=52;
	public static final int Pow=53;
	public static final int Print=54;
	public static final int Println=55;
	public static final int QMark=56;
	public static final int RETURN=57;
	public static final int Return=58;
	public static final int SColon=59;
	public static final int STATEMENTS=60;
	public static final int Size=61;
	public static final int Space=62;
	public static final int String=63;
	public static final int Subtract=64;
	public static final int TERNARY=65;
	public static final int To=66;
	public static final int UNARY_MIN=67;
	public static final int While=68;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public JavathonParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public JavathonParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return JavathonParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/grammar/Javathon.g"; }

	 
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


	public static class parse_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// src/grammar/Javathon.g:55:1: parse : block EOF -> block ;
	public final JavathonParser.parse_return parse() throws RecognitionException {
		JavathonParser.parse_return retval = new JavathonParser.parse_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope block1 =null;

		Object EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/grammar/Javathon.g:56:3: ( block EOF -> block )
			// src/grammar/Javathon.g:56:6: block EOF
			{
			pushFollow(FOLLOW_block_in_parse166);
			block1=block();
			state._fsp--;

			stream_block.add(block1.getTree());
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse168);  
			stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 56:16: -> block
			{
				adaptor.addChild(root_0, stream_block.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parse"


	public static class block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// src/grammar/Javathon.g:59:1: block : ( statement | functionDecl )* ( Return expression ';' )? -> ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) ;
	public final JavathonParser.block_return block() throws RecognitionException {
		JavathonParser.block_return retval = new JavathonParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Return5=null;
		Token char_literal7=null;
		ParserRuleReturnScope statement3 =null;
		ParserRuleReturnScope functionDecl4 =null;
		ParserRuleReturnScope expression6 =null;

		Object Return5_tree=null;
		Object char_literal7_tree=null;
		RewriteRuleTokenStream stream_Return=new RewriteRuleTokenStream(adaptor,"token Return");
		RewriteRuleTokenStream stream_SColon=new RewriteRuleTokenStream(adaptor,"token SColon");
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_functionDecl=new RewriteRuleSubtreeStream(adaptor,"rule functionDecl");

		try {
			// src/grammar/Javathon.g:60:3: ( ( statement | functionDecl )* ( Return expression ';' )? -> ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) )
			// src/grammar/Javathon.g:60:6: ( statement | functionDecl )* ( Return expression ';' )?
			{
			// src/grammar/Javathon.g:60:6: ( statement | functionDecl )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Assert||(LA1_0 >= Identifier && LA1_0 <= If)||(LA1_0 >= Print && LA1_0 <= Println)||LA1_0==Size||LA1_0==While) ) {
					alt1=1;
				}
				else if ( (LA1_0==Def) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// src/grammar/Javathon.g:60:7: statement
					{
					pushFollow(FOLLOW_statement_in_block195);
					statement3=statement();
					state._fsp--;

					stream_statement.add(statement3.getTree());
					}
					break;
				case 2 :
					// src/grammar/Javathon.g:60:19: functionDecl
					{
					pushFollow(FOLLOW_functionDecl_in_block199);
					functionDecl4=functionDecl();
					state._fsp--;

					stream_functionDecl.add(functionDecl4.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			// src/grammar/Javathon.g:60:34: ( Return expression ';' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Return) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/grammar/Javathon.g:60:35: Return expression ';'
					{
					Return5=(Token)match(input,Return,FOLLOW_Return_in_block204);  
					stream_Return.add(Return5);

					pushFollow(FOLLOW_expression_in_block206);
					expression6=expression();
					state._fsp--;

					stream_expression.add(expression6.getTree());
					char_literal7=(Token)match(input,SColon,FOLLOW_SColon_in_block208);  
					stream_SColon.add(char_literal7);

					}
					break;

			}

			// AST REWRITE
			// elements: expression, statement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 61:6: -> ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) )
			{
				// src/grammar/Javathon.g:61:9: ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// src/grammar/Javathon.g:61:17: ^( STATEMENTS ( statement )* )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENTS, "STATEMENTS"), root_2);
				// src/grammar/Javathon.g:61:30: ( statement )*
				while ( stream_statement.hasNext() ) {
					adaptor.addChild(root_2, stream_statement.nextTree());
				}
				stream_statement.reset();

				adaptor.addChild(root_1, root_2);
				}

				// src/grammar/Javathon.g:61:42: ^( RETURN ( expression )? )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN, "RETURN"), root_2);
				// src/grammar/Javathon.g:61:51: ( expression )?
				if ( stream_expression.hasNext() ) {
					adaptor.addChild(root_2, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// src/grammar/Javathon.g:64:1: statement : ( assignment ';' -> assignment | functionCall ';' -> functionCall | ifStatement | whileStatement );
	public final JavathonParser.statement_return statement() throws RecognitionException {
		JavathonParser.statement_return retval = new JavathonParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal9=null;
		Token char_literal11=null;
		ParserRuleReturnScope assignment8 =null;
		ParserRuleReturnScope functionCall10 =null;
		ParserRuleReturnScope ifStatement12 =null;
		ParserRuleReturnScope whileStatement13 =null;

		Object char_literal9_tree=null;
		Object char_literal11_tree=null;
		RewriteRuleTokenStream stream_SColon=new RewriteRuleTokenStream(adaptor,"token SColon");
		RewriteRuleSubtreeStream stream_functionCall=new RewriteRuleSubtreeStream(adaptor,"rule functionCall");
		RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");

		try {
			// src/grammar/Javathon.g:65:3: ( assignment ';' -> assignment | functionCall ';' -> functionCall | ifStatement | whileStatement )
			int alt3=4;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				int LA3_1 = input.LA(2);
				if ( (LA3_1==OParen) ) {
					alt3=2;
				}
				else if ( (LA3_1==Assign||LA3_1==OBracket) ) {
					alt3=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case Assert:
			case Print:
			case Println:
			case Size:
				{
				alt3=2;
				}
				break;
			case If:
				{
				alt3=3;
				}
				break;
			case While:
				{
				alt3=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// src/grammar/Javathon.g:65:6: assignment ';'
					{
					pushFollow(FOLLOW_assignment_in_statement260);
					assignment8=assignment();
					state._fsp--;

					stream_assignment.add(assignment8.getTree());
					char_literal9=(Token)match(input,SColon,FOLLOW_SColon_in_statement262);  
					stream_SColon.add(char_literal9);

					// AST REWRITE
					// elements: assignment
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 65:22: -> assignment
					{
						adaptor.addChild(root_0, stream_assignment.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// src/grammar/Javathon.g:66:6: functionCall ';'
					{
					pushFollow(FOLLOW_functionCall_in_statement275);
					functionCall10=functionCall();
					state._fsp--;

					stream_functionCall.add(functionCall10.getTree());
					char_literal11=(Token)match(input,SColon,FOLLOW_SColon_in_statement277);  
					stream_SColon.add(char_literal11);

					// AST REWRITE
					// elements: functionCall
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 66:25: -> functionCall
					{
						adaptor.addChild(root_0, stream_functionCall.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// src/grammar/Javathon.g:67:6: ifStatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ifStatement_in_statement290);
					ifStatement12=ifStatement();
					state._fsp--;

					adaptor.addChild(root_0, ifStatement12.getTree());

					}
					break;
				case 4 :
					// src/grammar/Javathon.g:68:6: whileStatement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_whileStatement_in_statement300);
					whileStatement13=whileStatement();
					state._fsp--;

					adaptor.addChild(root_0, whileStatement13.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class assignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// src/grammar/Javathon.g:73:1: assignment : Identifier ( indexes )? '=' expression -> ^( ASSIGNMENT Identifier ( indexes )? expression ) ;
	public final JavathonParser.assignment_return assignment() throws RecognitionException {
		JavathonParser.assignment_return retval = new JavathonParser.assignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Identifier14=null;
		Token char_literal16=null;
		ParserRuleReturnScope indexes15 =null;
		ParserRuleReturnScope expression17 =null;

		Object Identifier14_tree=null;
		Object char_literal16_tree=null;
		RewriteRuleTokenStream stream_Assign=new RewriteRuleTokenStream(adaptor,"token Assign");
		RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_indexes=new RewriteRuleSubtreeStream(adaptor,"rule indexes");

		try {
			// src/grammar/Javathon.g:74:3: ( Identifier ( indexes )? '=' expression -> ^( ASSIGNMENT Identifier ( indexes )? expression ) )
			// src/grammar/Javathon.g:74:6: Identifier ( indexes )? '=' expression
			{
			Identifier14=(Token)match(input,Identifier,FOLLOW_Identifier_in_assignment327);  
			stream_Identifier.add(Identifier14);

			// src/grammar/Javathon.g:74:17: ( indexes )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==OBracket) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/grammar/Javathon.g:74:17: indexes
					{
					pushFollow(FOLLOW_indexes_in_assignment329);
					indexes15=indexes();
					state._fsp--;

					stream_indexes.add(indexes15.getTree());
					}
					break;

			}

			char_literal16=(Token)match(input,Assign,FOLLOW_Assign_in_assignment332);  
			stream_Assign.add(char_literal16);

			pushFollow(FOLLOW_expression_in_assignment334);
			expression17=expression();
			state._fsp--;

			stream_expression.add(expression17.getTree());
			// AST REWRITE
			// elements: expression, Identifier, indexes
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 75:5: -> ^( ASSIGNMENT Identifier ( indexes )? expression )
			{
				// src/grammar/Javathon.g:75:8: ^( ASSIGNMENT Identifier ( indexes )? expression )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				adaptor.addChild(root_1, stream_Identifier.nextNode());
				// src/grammar/Javathon.g:75:32: ( indexes )?
				if ( stream_indexes.hasNext() ) {
					adaptor.addChild(root_1, stream_indexes.nextTree());
				}
				stream_indexes.reset();

				adaptor.addChild(root_1, stream_expression.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment"


	public static class functionCall_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "functionCall"
	// src/grammar/Javathon.g:78:1: functionCall : ( Identifier '(' ( exprList )? ')' -> ^( FUNC_CALL Identifier ( exprList )? ) | Println '(' ( expression )? ')' -> ^( FUNC_CALL Println ( expression )? ) | Print '(' expression ')' -> ^( FUNC_CALL Print expression ) | Assert '(' expression ')' -> ^( FUNC_CALL Assert expression ) | Size '(' expression ')' -> ^( FUNC_CALL Size expression ) );
	public final JavathonParser.functionCall_return functionCall() throws RecognitionException {
		JavathonParser.functionCall_return retval = new JavathonParser.functionCall_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Identifier18=null;
		Token char_literal19=null;
		Token char_literal21=null;
		Token Println22=null;
		Token char_literal23=null;
		Token char_literal25=null;
		Token Print26=null;
		Token char_literal27=null;
		Token char_literal29=null;
		Token Assert30=null;
		Token char_literal31=null;
		Token char_literal33=null;
		Token Size34=null;
		Token char_literal35=null;
		Token char_literal37=null;
		ParserRuleReturnScope exprList20 =null;
		ParserRuleReturnScope expression24 =null;
		ParserRuleReturnScope expression28 =null;
		ParserRuleReturnScope expression32 =null;
		ParserRuleReturnScope expression36 =null;

		Object Identifier18_tree=null;
		Object char_literal19_tree=null;
		Object char_literal21_tree=null;
		Object Println22_tree=null;
		Object char_literal23_tree=null;
		Object char_literal25_tree=null;
		Object Print26_tree=null;
		Object char_literal27_tree=null;
		Object char_literal29_tree=null;
		Object Assert30_tree=null;
		Object char_literal31_tree=null;
		Object char_literal33_tree=null;
		Object Size34_tree=null;
		Object char_literal35_tree=null;
		Object char_literal37_tree=null;
		RewriteRuleTokenStream stream_Println=new RewriteRuleTokenStream(adaptor,"token Println");
		RewriteRuleTokenStream stream_OParen=new RewriteRuleTokenStream(adaptor,"token OParen");
		RewriteRuleTokenStream stream_CParen=new RewriteRuleTokenStream(adaptor,"token CParen");
		RewriteRuleTokenStream stream_Assert=new RewriteRuleTokenStream(adaptor,"token Assert");
		RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
		RewriteRuleTokenStream stream_Print=new RewriteRuleTokenStream(adaptor,"token Print");
		RewriteRuleTokenStream stream_Size=new RewriteRuleTokenStream(adaptor,"token Size");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprList=new RewriteRuleSubtreeStream(adaptor,"rule exprList");

		try {
			// src/grammar/Javathon.g:79:3: ( Identifier '(' ( exprList )? ')' -> ^( FUNC_CALL Identifier ( exprList )? ) | Println '(' ( expression )? ')' -> ^( FUNC_CALL Println ( expression )? ) | Print '(' expression ')' -> ^( FUNC_CALL Print expression ) | Assert '(' expression ')' -> ^( FUNC_CALL Assert expression ) | Size '(' expression ')' -> ^( FUNC_CALL Size expression ) )
			int alt7=5;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				alt7=1;
				}
				break;
			case Println:
				{
				alt7=2;
				}
				break;
			case Print:
				{
				alt7=3;
				}
				break;
			case Assert:
				{
				alt7=4;
				}
				break;
			case Size:
				{
				alt7=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// src/grammar/Javathon.g:79:6: Identifier '(' ( exprList )? ')'
					{
					Identifier18=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionCall371);  
					stream_Identifier.add(Identifier18);

					char_literal19=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall373);  
					stream_OParen.add(char_literal19);

					// src/grammar/Javathon.g:79:21: ( exprList )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==Assert||LA5_0==Bool||LA5_0==Excl||LA5_0==Identifier||(LA5_0 >= Null && LA5_0 <= Number)||(LA5_0 >= OBracket && LA5_0 <= OParen)||(LA5_0 >= Print && LA5_0 <= Println)||LA5_0==Size||(LA5_0 >= String && LA5_0 <= Subtract)) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// src/grammar/Javathon.g:79:21: exprList
							{
							pushFollow(FOLLOW_exprList_in_functionCall375);
							exprList20=exprList();
							state._fsp--;

							stream_exprList.add(exprList20.getTree());
							}
							break;

					}

					char_literal21=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall378);  
					stream_CParen.add(char_literal21);

					// AST REWRITE
					// elements: Identifier, exprList
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 79:35: -> ^( FUNC_CALL Identifier ( exprList )? )
					{
						// src/grammar/Javathon.g:79:38: ^( FUNC_CALL Identifier ( exprList )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);
						adaptor.addChild(root_1, stream_Identifier.nextNode());
						// src/grammar/Javathon.g:79:61: ( exprList )?
						if ( stream_exprList.hasNext() ) {
							adaptor.addChild(root_1, stream_exprList.nextTree());
						}
						stream_exprList.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// src/grammar/Javathon.g:80:6: Println '(' ( expression )? ')'
					{
					Println22=(Token)match(input,Println,FOLLOW_Println_in_functionCall398);  
					stream_Println.add(Println22);

					char_literal23=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall400);  
					stream_OParen.add(char_literal23);

					// src/grammar/Javathon.g:80:18: ( expression )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==Assert||LA6_0==Bool||LA6_0==Excl||LA6_0==Identifier||(LA6_0 >= Null && LA6_0 <= Number)||(LA6_0 >= OBracket && LA6_0 <= OParen)||(LA6_0 >= Print && LA6_0 <= Println)||LA6_0==Size||(LA6_0 >= String && LA6_0 <= Subtract)) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// src/grammar/Javathon.g:80:18: expression
							{
							pushFollow(FOLLOW_expression_in_functionCall402);
							expression24=expression();
							state._fsp--;

							stream_expression.add(expression24.getTree());
							}
							break;

					}

					char_literal25=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall405);  
					stream_CParen.add(char_literal25);

					// AST REWRITE
					// elements: Println, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 80:35: -> ^( FUNC_CALL Println ( expression )? )
					{
						// src/grammar/Javathon.g:80:38: ^( FUNC_CALL Println ( expression )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);
						adaptor.addChild(root_1, stream_Println.nextNode());
						// src/grammar/Javathon.g:80:58: ( expression )?
						if ( stream_expression.hasNext() ) {
							adaptor.addChild(root_1, stream_expression.nextTree());
						}
						stream_expression.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// src/grammar/Javathon.g:81:6: Print '(' expression ')'
					{
					Print26=(Token)match(input,Print,FOLLOW_Print_in_functionCall426);  
					stream_Print.add(Print26);

					char_literal27=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall428);  
					stream_OParen.add(char_literal27);

					pushFollow(FOLLOW_expression_in_functionCall430);
					expression28=expression();
					state._fsp--;

					stream_expression.add(expression28.getTree());
					char_literal29=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall432);  
					stream_CParen.add(char_literal29);

					// AST REWRITE
					// elements: Print, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 81:35: -> ^( FUNC_CALL Print expression )
					{
						// src/grammar/Javathon.g:81:38: ^( FUNC_CALL Print expression )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);
						adaptor.addChild(root_1, stream_Print.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// src/grammar/Javathon.g:82:6: Assert '(' expression ')'
					{
					Assert30=(Token)match(input,Assert,FOLLOW_Assert_in_functionCall455);  
					stream_Assert.add(Assert30);

					char_literal31=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall457);  
					stream_OParen.add(char_literal31);

					pushFollow(FOLLOW_expression_in_functionCall459);
					expression32=expression();
					state._fsp--;

					stream_expression.add(expression32.getTree());
					char_literal33=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall461);  
					stream_CParen.add(char_literal33);

					// AST REWRITE
					// elements: Assert, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 82:35: -> ^( FUNC_CALL Assert expression )
					{
						// src/grammar/Javathon.g:82:38: ^( FUNC_CALL Assert expression )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);
						adaptor.addChild(root_1, stream_Assert.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// src/grammar/Javathon.g:83:6: Size '(' expression ')'
					{
					Size34=(Token)match(input,Size,FOLLOW_Size_in_functionCall483);  
					stream_Size.add(Size34);

					char_literal35=(Token)match(input,OParen,FOLLOW_OParen_in_functionCall485);  
					stream_OParen.add(char_literal35);

					pushFollow(FOLLOW_expression_in_functionCall487);
					expression36=expression();
					state._fsp--;

					stream_expression.add(expression36.getTree());
					char_literal37=(Token)match(input,CParen,FOLLOW_CParen_in_functionCall489);  
					stream_CParen.add(char_literal37);

					// AST REWRITE
					// elements: expression, Size
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 83:35: -> ^( FUNC_CALL Size expression )
					{
						// src/grammar/Javathon.g:83:38: ^( FUNC_CALL Size expression )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);
						adaptor.addChild(root_1, stream_Size.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "functionCall"


	public static class ifStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatement"
	// src/grammar/Javathon.g:89:1: ifStatement : ifStat ( elseIfStat )* ( elseStat )? End -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) ;
	public final JavathonParser.ifStatement_return ifStatement() throws RecognitionException {
		JavathonParser.ifStatement_return retval = new JavathonParser.ifStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token End41=null;
		ParserRuleReturnScope ifStat38 =null;
		ParserRuleReturnScope elseIfStat39 =null;
		ParserRuleReturnScope elseStat40 =null;

		Object End41_tree=null;
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleSubtreeStream stream_elseIfStat=new RewriteRuleSubtreeStream(adaptor,"rule elseIfStat");
		RewriteRuleSubtreeStream stream_ifStat=new RewriteRuleSubtreeStream(adaptor,"rule ifStat");
		RewriteRuleSubtreeStream stream_elseStat=new RewriteRuleSubtreeStream(adaptor,"rule elseStat");

		try {
			// src/grammar/Javathon.g:90:3: ( ifStat ( elseIfStat )* ( elseStat )? End -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) )
			// src/grammar/Javathon.g:90:6: ifStat ( elseIfStat )* ( elseStat )? End
			{
			pushFollow(FOLLOW_ifStat_in_ifStatement533);
			ifStat38=ifStat();
			state._fsp--;

			stream_ifStat.add(ifStat38.getTree());
			// src/grammar/Javathon.g:90:13: ( elseIfStat )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==Else) ) {
					int LA8_1 = input.LA(2);
					if ( (LA8_1==If) ) {
						alt8=1;
					}

				}

				switch (alt8) {
				case 1 :
					// src/grammar/Javathon.g:90:13: elseIfStat
					{
					pushFollow(FOLLOW_elseIfStat_in_ifStatement535);
					elseIfStat39=elseIfStat();
					state._fsp--;

					stream_elseIfStat.add(elseIfStat39.getTree());
					}
					break;

				default :
					break loop8;
				}
			}

			// src/grammar/Javathon.g:90:25: ( elseStat )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==Else) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// src/grammar/Javathon.g:90:25: elseStat
					{
					pushFollow(FOLLOW_elseStat_in_ifStatement538);
					elseStat40=elseStat();
					state._fsp--;

					stream_elseStat.add(elseStat40.getTree());
					}
					break;

			}

			End41=(Token)match(input,End,FOLLOW_End_in_ifStatement541);  
			stream_End.add(End41);

			// AST REWRITE
			// elements: elseStat, elseIfStat, ifStat
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 90:39: -> ^( IF ifStat ( elseIfStat )* ( elseStat )? )
			{
				// src/grammar/Javathon.g:90:42: ^( IF ifStat ( elseIfStat )* ( elseStat )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
				adaptor.addChild(root_1, stream_ifStat.nextTree());
				// src/grammar/Javathon.g:90:54: ( elseIfStat )*
				while ( stream_elseIfStat.hasNext() ) {
					adaptor.addChild(root_1, stream_elseIfStat.nextTree());
				}
				stream_elseIfStat.reset();

				// src/grammar/Javathon.g:90:66: ( elseStat )?
				if ( stream_elseStat.hasNext() ) {
					adaptor.addChild(root_1, stream_elseStat.nextTree());
				}
				stream_elseStat.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ifStatement"


	public static class ifStat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStat"
	// src/grammar/Javathon.g:93:1: ifStat : If expression Do block -> ^( EXP expression block ) ;
	public final JavathonParser.ifStat_return ifStat() throws RecognitionException {
		JavathonParser.ifStat_return retval = new JavathonParser.ifStat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token If42=null;
		Token Do44=null;
		ParserRuleReturnScope expression43 =null;
		ParserRuleReturnScope block45 =null;

		Object If42_tree=null;
		Object Do44_tree=null;
		RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/grammar/Javathon.g:94:3: ( If expression Do block -> ^( EXP expression block ) )
			// src/grammar/Javathon.g:94:6: If expression Do block
			{
			If42=(Token)match(input,If,FOLLOW_If_in_ifStat577);  
			stream_If.add(If42);

			pushFollow(FOLLOW_expression_in_ifStat579);
			expression43=expression();
			state._fsp--;

			stream_expression.add(expression43.getTree());
			Do44=(Token)match(input,Do,FOLLOW_Do_in_ifStat581);  
			stream_Do.add(Do44);

			pushFollow(FOLLOW_block_in_ifStat583);
			block45=block();
			state._fsp--;

			stream_block.add(block45.getTree());
			// AST REWRITE
			// elements: expression, block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 94:29: -> ^( EXP expression block )
			{
				// src/grammar/Javathon.g:94:32: ^( EXP expression block )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP, "EXP"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				adaptor.addChild(root_1, stream_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ifStat"


	public static class elseIfStat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "elseIfStat"
	// src/grammar/Javathon.g:97:1: elseIfStat : Else If expression Do block -> ^( EXP expression block ) ;
	public final JavathonParser.elseIfStat_return elseIfStat() throws RecognitionException {
		JavathonParser.elseIfStat_return retval = new JavathonParser.elseIfStat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Else46=null;
		Token If47=null;
		Token Do49=null;
		ParserRuleReturnScope expression48 =null;
		ParserRuleReturnScope block50 =null;

		Object Else46_tree=null;
		Object If47_tree=null;
		Object Do49_tree=null;
		RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/grammar/Javathon.g:98:3: ( Else If expression Do block -> ^( EXP expression block ) )
			// src/grammar/Javathon.g:98:6: Else If expression Do block
			{
			Else46=(Token)match(input,Else,FOLLOW_Else_in_elseIfStat615);  
			stream_Else.add(Else46);

			If47=(Token)match(input,If,FOLLOW_If_in_elseIfStat617);  
			stream_If.add(If47);

			pushFollow(FOLLOW_expression_in_elseIfStat619);
			expression48=expression();
			state._fsp--;

			stream_expression.add(expression48.getTree());
			Do49=(Token)match(input,Do,FOLLOW_Do_in_elseIfStat621);  
			stream_Do.add(Do49);

			pushFollow(FOLLOW_block_in_elseIfStat623);
			block50=block();
			state._fsp--;

			stream_block.add(block50.getTree());
			// AST REWRITE
			// elements: block, expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 98:34: -> ^( EXP expression block )
			{
				// src/grammar/Javathon.g:98:37: ^( EXP expression block )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP, "EXP"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				adaptor.addChild(root_1, stream_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elseIfStat"


	public static class elseStat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "elseStat"
	// src/grammar/Javathon.g:101:1: elseStat : Else Do block -> ^( EXP block ) ;
	public final JavathonParser.elseStat_return elseStat() throws RecognitionException {
		JavathonParser.elseStat_return retval = new JavathonParser.elseStat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Else51=null;
		Token Do52=null;
		ParserRuleReturnScope block53 =null;

		Object Else51_tree=null;
		Object Do52_tree=null;
		RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/grammar/Javathon.g:102:3: ( Else Do block -> ^( EXP block ) )
			// src/grammar/Javathon.g:102:6: Else Do block
			{
			Else51=(Token)match(input,Else,FOLLOW_Else_in_elseStat655);  
			stream_Else.add(Else51);

			Do52=(Token)match(input,Do,FOLLOW_Do_in_elseStat657);  
			stream_Do.add(Do52);

			pushFollow(FOLLOW_block_in_elseStat659);
			block53=block();
			state._fsp--;

			stream_block.add(block53.getTree());
			// AST REWRITE
			// elements: block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 102:20: -> ^( EXP block )
			{
				// src/grammar/Javathon.g:102:23: ^( EXP block )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP, "EXP"), root_1);
				adaptor.addChild(root_1, stream_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "elseStat"


	public static class functionDecl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "functionDecl"
	// src/grammar/Javathon.g:108:3: functionDecl : Def Identifier '(' ( idList )? ')' block End ;
	public final JavathonParser.functionDecl_return functionDecl() throws RecognitionException {
		JavathonParser.functionDecl_return retval = new JavathonParser.functionDecl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Def54=null;
		Token Identifier55=null;
		Token char_literal56=null;
		Token char_literal58=null;
		Token End60=null;
		ParserRuleReturnScope idList57 =null;
		ParserRuleReturnScope block59 =null;

		Object Def54_tree=null;
		Object Identifier55_tree=null;
		Object char_literal56_tree=null;
		Object char_literal58_tree=null;
		Object End60_tree=null;

		try {
			// src/grammar/Javathon.g:109:3: ( Def Identifier '(' ( idList )? ')' block End )
			// src/grammar/Javathon.g:109:6: Def Identifier '(' ( idList )? ')' block End
			{
			root_0 = (Object)adaptor.nil();


			Def54=(Token)match(input,Def,FOLLOW_Def_in_functionDecl695); 
			Def54_tree = (Object)adaptor.create(Def54);
			adaptor.addChild(root_0, Def54_tree);

			Identifier55=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionDecl697); 
			Identifier55_tree = (Object)adaptor.create(Identifier55);
			adaptor.addChild(root_0, Identifier55_tree);

			char_literal56=(Token)match(input,OParen,FOLLOW_OParen_in_functionDecl699); 
			char_literal56_tree = (Object)adaptor.create(char_literal56);
			adaptor.addChild(root_0, char_literal56_tree);

			// src/grammar/Javathon.g:109:25: ( idList )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==Identifier) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// src/grammar/Javathon.g:109:25: idList
					{
					pushFollow(FOLLOW_idList_in_functionDecl701);
					idList57=idList();
					state._fsp--;

					adaptor.addChild(root_0, idList57.getTree());

					}
					break;

			}

			char_literal58=(Token)match(input,CParen,FOLLOW_CParen_in_functionDecl704); 
			char_literal58_tree = (Object)adaptor.create(char_literal58);
			adaptor.addChild(root_0, char_literal58_tree);

			pushFollow(FOLLOW_block_in_functionDecl706);
			block59=block();
			state._fsp--;

			adaptor.addChild(root_0, block59.getTree());

			End60=(Token)match(input,End,FOLLOW_End_in_functionDecl708); 
			End60_tree = (Object)adaptor.create(End60);
			adaptor.addChild(root_0, End60_tree);

			defineFunction((Identifier55!=null?Identifier55.getText():null), (idList57!=null?((Object)idList57.getTree()):null), (block59!=null?((Object)block59.getTree()):null));
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "functionDecl"


	public static class whileStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "whileStatement"
	// src/grammar/Javathon.g:113:1: whileStatement : While expression Do block End -> ^( While expression block ) ;
	public final JavathonParser.whileStatement_return whileStatement() throws RecognitionException {
		JavathonParser.whileStatement_return retval = new JavathonParser.whileStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token While61=null;
		Token Do63=null;
		Token End65=null;
		ParserRuleReturnScope expression62 =null;
		ParserRuleReturnScope block64 =null;

		Object While61_tree=null;
		Object Do63_tree=null;
		Object End65_tree=null;
		RewriteRuleTokenStream stream_Do=new RewriteRuleTokenStream(adaptor,"token Do");
		RewriteRuleTokenStream stream_End=new RewriteRuleTokenStream(adaptor,"token End");
		RewriteRuleTokenStream stream_While=new RewriteRuleTokenStream(adaptor,"token While");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try {
			// src/grammar/Javathon.g:114:3: ( While expression Do block End -> ^( While expression block ) )
			// src/grammar/Javathon.g:114:6: While expression Do block End
			{
			While61=(Token)match(input,While,FOLLOW_While_in_whileStatement740);  
			stream_While.add(While61);

			pushFollow(FOLLOW_expression_in_whileStatement742);
			expression62=expression();
			state._fsp--;

			stream_expression.add(expression62.getTree());
			Do63=(Token)match(input,Do,FOLLOW_Do_in_whileStatement744);  
			stream_Do.add(Do63);

			pushFollow(FOLLOW_block_in_whileStatement746);
			block64=block();
			state._fsp--;

			stream_block.add(block64.getTree());
			End65=(Token)match(input,End,FOLLOW_End_in_whileStatement748);  
			stream_End.add(End65);

			// AST REWRITE
			// elements: While, block, expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 114:36: -> ^( While expression block )
			{
				// src/grammar/Javathon.g:114:39: ^( While expression block )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_While.nextNode(), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				adaptor.addChild(root_1, stream_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whileStatement"


	public static class idList_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "idList"
	// src/grammar/Javathon.g:117:1: idList : Identifier ( ',' Identifier )* -> ^( ID_LIST ( Identifier )+ ) ;
	public final JavathonParser.idList_return idList() throws RecognitionException {
		JavathonParser.idList_return retval = new JavathonParser.idList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Identifier66=null;
		Token char_literal67=null;
		Token Identifier68=null;

		Object Identifier66_tree=null;
		Object char_literal67_tree=null;
		Object Identifier68_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

		try {
			// src/grammar/Javathon.g:118:3: ( Identifier ( ',' Identifier )* -> ^( ID_LIST ( Identifier )+ ) )
			// src/grammar/Javathon.g:118:6: Identifier ( ',' Identifier )*
			{
			Identifier66=(Token)match(input,Identifier,FOLLOW_Identifier_in_idList780);  
			stream_Identifier.add(Identifier66);

			// src/grammar/Javathon.g:118:17: ( ',' Identifier )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==Comma) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/grammar/Javathon.g:118:18: ',' Identifier
					{
					char_literal67=(Token)match(input,Comma,FOLLOW_Comma_in_idList783);  
					stream_Comma.add(char_literal67);

					Identifier68=(Token)match(input,Identifier,FOLLOW_Identifier_in_idList785);  
					stream_Identifier.add(Identifier68);

					}
					break;

				default :
					break loop11;
				}
			}

			// AST REWRITE
			// elements: Identifier
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 118:35: -> ^( ID_LIST ( Identifier )+ )
			{
				// src/grammar/Javathon.g:118:38: ^( ID_LIST ( Identifier )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ID_LIST, "ID_LIST"), root_1);
				if ( !(stream_Identifier.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Identifier.hasNext() ) {
					adaptor.addChild(root_1, stream_Identifier.nextNode());
				}
				stream_Identifier.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "idList"


	public static class exprList_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprList"
	// src/grammar/Javathon.g:121:1: exprList : expression ( ',' expression )* -> ^( EXP_LIST ( expression )+ ) ;
	public final JavathonParser.exprList_return exprList() throws RecognitionException {
		JavathonParser.exprList_return retval = new JavathonParser.exprList_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal70=null;
		ParserRuleReturnScope expression69 =null;
		ParserRuleReturnScope expression71 =null;

		Object char_literal70_tree=null;
		RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// src/grammar/Javathon.g:122:3: ( expression ( ',' expression )* -> ^( EXP_LIST ( expression )+ ) )
			// src/grammar/Javathon.g:122:6: expression ( ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprList818);
			expression69=expression();
			state._fsp--;

			stream_expression.add(expression69.getTree());
			// src/grammar/Javathon.g:122:17: ( ',' expression )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==Comma) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// src/grammar/Javathon.g:122:18: ',' expression
					{
					char_literal70=(Token)match(input,Comma,FOLLOW_Comma_in_exprList821);  
					stream_Comma.add(char_literal70);

					pushFollow(FOLLOW_expression_in_exprList823);
					expression71=expression();
					state._fsp--;

					stream_expression.add(expression71.getTree());
					}
					break;

				default :
					break loop12;
				}
			}

			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 122:35: -> ^( EXP_LIST ( expression )+ )
			{
				// src/grammar/Javathon.g:122:38: ^( EXP_LIST ( expression )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP_LIST, "EXP_LIST"), root_1);
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprList"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// src/grammar/Javathon.g:126:1: expression : condExpr ;
	public final JavathonParser.expression_return expression() throws RecognitionException {
		JavathonParser.expression_return retval = new JavathonParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope condExpr72 =null;


		try {
			// src/grammar/Javathon.g:127:3: ( condExpr )
			// src/grammar/Javathon.g:127:6: condExpr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_condExpr_in_expression858);
			condExpr72=condExpr();
			state._fsp--;

			adaptor.addChild(root_0, condExpr72.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class condExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "condExpr"
	// src/grammar/Javathon.g:130:1: condExpr : ( orExpr -> orExpr ) ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )? ;
	public final JavathonParser.condExpr_return condExpr() throws RecognitionException {
		JavathonParser.condExpr_return retval = new JavathonParser.condExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal74=null;
		Token char_literal75=null;
		Token In76=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope orExpr73 =null;
		ParserRuleReturnScope expression77 =null;

		Object char_literal74_tree=null;
		Object char_literal75_tree=null;
		Object In76_tree=null;
		RewriteRuleTokenStream stream_In=new RewriteRuleTokenStream(adaptor,"token In");
		RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
		RewriteRuleTokenStream stream_QMark=new RewriteRuleTokenStream(adaptor,"token QMark");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try {
			// src/grammar/Javathon.g:131:3: ( ( orExpr -> orExpr ) ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )? )
			// src/grammar/Javathon.g:131:6: ( orExpr -> orExpr ) ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )?
			{
			// src/grammar/Javathon.g:131:6: ( orExpr -> orExpr )
			// src/grammar/Javathon.g:131:7: orExpr
			{
			pushFollow(FOLLOW_orExpr_in_condExpr881);
			orExpr73=orExpr();
			state._fsp--;

			stream_orExpr.add(orExpr73.getTree());
			// AST REWRITE
			// elements: orExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 131:14: -> orExpr
			{
				adaptor.addChild(root_0, stream_orExpr.nextTree());
			}


			retval.tree = root_0;

			}

			// src/grammar/Javathon.g:132:6: ( '?' a= expression ':' b= expression -> ^( TERNARY orExpr $a $b) | In expression -> ^( In orExpr expression ) )?
			int alt13=3;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==QMark) ) {
				alt13=1;
			}
			else if ( (LA13_0==In) ) {
				alt13=2;
			}
			switch (alt13) {
				case 1 :
					// src/grammar/Javathon.g:132:8: '?' a= expression ':' b= expression
					{
					char_literal74=(Token)match(input,QMark,FOLLOW_QMark_in_condExpr898);  
					stream_QMark.add(char_literal74);

					pushFollow(FOLLOW_expression_in_condExpr902);
					a=expression();
					state._fsp--;

					stream_expression.add(a.getTree());
					char_literal75=(Token)match(input,Colon,FOLLOW_Colon_in_condExpr904);  
					stream_Colon.add(char_literal75);

					pushFollow(FOLLOW_expression_in_condExpr908);
					b=expression();
					state._fsp--;

					stream_expression.add(b.getTree());
					// AST REWRITE
					// elements: b, orExpr, a
					// token labels: 
					// rule labels: retval, b, a
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 132:42: -> ^( TERNARY orExpr $a $b)
					{
						// src/grammar/Javathon.g:132:45: ^( TERNARY orExpr $a $b)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TERNARY, "TERNARY"), root_1);
						adaptor.addChild(root_1, stream_orExpr.nextTree());
						adaptor.addChild(root_1, stream_a.nextTree());
						adaptor.addChild(root_1, stream_b.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// src/grammar/Javathon.g:133:8: In expression
					{
					In76=(Token)match(input,In,FOLLOW_In_in_condExpr933);  
					stream_In.add(In76);

					pushFollow(FOLLOW_expression_in_condExpr935);
					expression77=expression();
					state._fsp--;

					stream_expression.add(expression77.getTree());
					// AST REWRITE
					// elements: In, orExpr, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 133:42: -> ^( In orExpr expression )
					{
						// src/grammar/Javathon.g:133:45: ^( In orExpr expression )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_In.nextNode(), root_1);
						adaptor.addChild(root_1, stream_orExpr.nextTree());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "condExpr"


	public static class orExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orExpr"
	// src/grammar/Javathon.g:137:1: orExpr : andExpr ( '||' ^ andExpr )* ;
	public final JavathonParser.orExpr_return orExpr() throws RecognitionException {
		JavathonParser.orExpr_return retval = new JavathonParser.orExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal79=null;
		ParserRuleReturnScope andExpr78 =null;
		ParserRuleReturnScope andExpr80 =null;

		Object string_literal79_tree=null;

		try {
			// src/grammar/Javathon.g:138:3: ( andExpr ( '||' ^ andExpr )* )
			// src/grammar/Javathon.g:138:6: andExpr ( '||' ^ andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andExpr_in_orExpr997);
			andExpr78=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, andExpr78.getTree());

			// src/grammar/Javathon.g:138:14: ( '||' ^ andExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==Or) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// src/grammar/Javathon.g:138:15: '||' ^ andExpr
					{
					string_literal79=(Token)match(input,Or,FOLLOW_Or_in_orExpr1000); 
					string_literal79_tree = (Object)adaptor.create(string_literal79);
					root_0 = (Object)adaptor.becomeRoot(string_literal79_tree, root_0);

					pushFollow(FOLLOW_andExpr_in_orExpr1003);
					andExpr80=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, andExpr80.getTree());

					}
					break;

				default :
					break loop14;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "orExpr"


	public static class andExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andExpr"
	// src/grammar/Javathon.g:141:1: andExpr : equExpr ( '&&' ^ equExpr )* ;
	public final JavathonParser.andExpr_return andExpr() throws RecognitionException {
		JavathonParser.andExpr_return retval = new JavathonParser.andExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal82=null;
		ParserRuleReturnScope equExpr81 =null;
		ParserRuleReturnScope equExpr83 =null;

		Object string_literal82_tree=null;

		try {
			// src/grammar/Javathon.g:142:3: ( equExpr ( '&&' ^ equExpr )* )
			// src/grammar/Javathon.g:142:6: equExpr ( '&&' ^ equExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_equExpr_in_andExpr1027);
			equExpr81=equExpr();
			state._fsp--;

			adaptor.addChild(root_0, equExpr81.getTree());

			// src/grammar/Javathon.g:142:14: ( '&&' ^ equExpr )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==And) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// src/grammar/Javathon.g:142:15: '&&' ^ equExpr
					{
					string_literal82=(Token)match(input,And,FOLLOW_And_in_andExpr1030); 
					string_literal82_tree = (Object)adaptor.create(string_literal82);
					root_0 = (Object)adaptor.becomeRoot(string_literal82_tree, root_0);

					pushFollow(FOLLOW_equExpr_in_andExpr1033);
					equExpr83=equExpr();
					state._fsp--;

					adaptor.addChild(root_0, equExpr83.getTree());

					}
					break;

				default :
					break loop15;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "andExpr"


	public static class equExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "equExpr"
	// src/grammar/Javathon.g:145:1: equExpr : relExpr ( ( '==' | '!=' ) ^ relExpr )* ;
	public final JavathonParser.equExpr_return equExpr() throws RecognitionException {
		JavathonParser.equExpr_return retval = new JavathonParser.equExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set85=null;
		ParserRuleReturnScope relExpr84 =null;
		ParserRuleReturnScope relExpr86 =null;

		Object set85_tree=null;

		try {
			// src/grammar/Javathon.g:146:3: ( relExpr ( ( '==' | '!=' ) ^ relExpr )* )
			// src/grammar/Javathon.g:146:6: relExpr ( ( '==' | '!=' ) ^ relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_relExpr_in_equExpr1057);
			relExpr84=relExpr();
			state._fsp--;

			adaptor.addChild(root_0, relExpr84.getTree());

			// src/grammar/Javathon.g:146:14: ( ( '==' | '!=' ) ^ relExpr )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==Equals||LA16_0==NEquals) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// src/grammar/Javathon.g:146:15: ( '==' | '!=' ) ^ relExpr
					{
					set85=input.LT(1);
					set85=input.LT(1);
					if ( input.LA(1)==Equals||input.LA(1)==NEquals ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set85), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_relExpr_in_equExpr1069);
					relExpr86=relExpr();
					state._fsp--;

					adaptor.addChild(root_0, relExpr86.getTree());

					}
					break;

				default :
					break loop16;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "equExpr"


	public static class relExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "relExpr"
	// src/grammar/Javathon.g:149:1: relExpr : addExpr ( ( '>=' | '<=' | '>' | '<' ) ^ addExpr )* ;
	public final JavathonParser.relExpr_return relExpr() throws RecognitionException {
		JavathonParser.relExpr_return retval = new JavathonParser.relExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set88=null;
		ParserRuleReturnScope addExpr87 =null;
		ParserRuleReturnScope addExpr89 =null;

		Object set88_tree=null;

		try {
			// src/grammar/Javathon.g:150:3: ( addExpr ( ( '>=' | '<=' | '>' | '<' ) ^ addExpr )* )
			// src/grammar/Javathon.g:150:6: addExpr ( ( '>=' | '<=' | '>' | '<' ) ^ addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_addExpr_in_relExpr1093);
			addExpr87=addExpr();
			state._fsp--;

			adaptor.addChild(root_0, addExpr87.getTree());

			// src/grammar/Javathon.g:150:14: ( ( '>=' | '<=' | '>' | '<' ) ^ addExpr )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( ((LA17_0 >= GT && LA17_0 <= GTEquals)||(LA17_0 >= LT && LA17_0 <= LTEquals)) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// src/grammar/Javathon.g:150:15: ( '>=' | '<=' | '>' | '<' ) ^ addExpr
					{
					set88=input.LT(1);
					set88=input.LT(1);
					if ( (input.LA(1) >= GT && input.LA(1) <= GTEquals)||(input.LA(1) >= LT && input.LA(1) <= LTEquals) ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set88), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr1113);
					addExpr89=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, addExpr89.getTree());

					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relExpr"


	public static class addExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addExpr"
	// src/grammar/Javathon.g:153:1: addExpr : mulExpr ( ( '+' | '-' ) ^ mulExpr )* ;
	public final JavathonParser.addExpr_return addExpr() throws RecognitionException {
		JavathonParser.addExpr_return retval = new JavathonParser.addExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set91=null;
		ParserRuleReturnScope mulExpr90 =null;
		ParserRuleReturnScope mulExpr92 =null;

		Object set91_tree=null;

		try {
			// src/grammar/Javathon.g:154:3: ( mulExpr ( ( '+' | '-' ) ^ mulExpr )* )
			// src/grammar/Javathon.g:154:6: mulExpr ( ( '+' | '-' ) ^ mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_mulExpr_in_addExpr1137);
			mulExpr90=mulExpr();
			state._fsp--;

			adaptor.addChild(root_0, mulExpr90.getTree());

			// src/grammar/Javathon.g:154:14: ( ( '+' | '-' ) ^ mulExpr )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==Add||LA18_0==Subtract) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// src/grammar/Javathon.g:154:15: ( '+' | '-' ) ^ mulExpr
					{
					set91=input.LT(1);
					set91=input.LT(1);
					if ( input.LA(1)==Add||input.LA(1)==Subtract ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set91), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr1149);
					mulExpr92=mulExpr();
					state._fsp--;

					adaptor.addChild(root_0, mulExpr92.getTree());

					}
					break;

				default :
					break loop18;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "addExpr"


	public static class mulExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mulExpr"
	// src/grammar/Javathon.g:157:1: mulExpr : powExpr ( ( '*' | '/' | '%' ) ^ powExpr )* ;
	public final JavathonParser.mulExpr_return mulExpr() throws RecognitionException {
		JavathonParser.mulExpr_return retval = new JavathonParser.mulExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set94=null;
		ParserRuleReturnScope powExpr93 =null;
		ParserRuleReturnScope powExpr95 =null;

		Object set94_tree=null;

		try {
			// src/grammar/Javathon.g:158:3: ( powExpr ( ( '*' | '/' | '%' ) ^ powExpr )* )
			// src/grammar/Javathon.g:158:6: powExpr ( ( '*' | '/' | '%' ) ^ powExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_powExpr_in_mulExpr1173);
			powExpr93=powExpr();
			state._fsp--;

			adaptor.addChild(root_0, powExpr93.getTree());

			// src/grammar/Javathon.g:158:14: ( ( '*' | '/' | '%' ) ^ powExpr )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==Divide||(LA19_0 >= Modulus && LA19_0 <= Multiply)) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// src/grammar/Javathon.g:158:15: ( '*' | '/' | '%' ) ^ powExpr
					{
					set94=input.LT(1);
					set94=input.LT(1);
					if ( input.LA(1)==Divide||(input.LA(1) >= Modulus && input.LA(1) <= Multiply) ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set94), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_powExpr_in_mulExpr1189);
					powExpr95=powExpr();
					state._fsp--;

					adaptor.addChild(root_0, powExpr95.getTree());

					}
					break;

				default :
					break loop19;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mulExpr"


	public static class powExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "powExpr"
	// src/grammar/Javathon.g:161:1: powExpr : unaryExpr ( '^' ^ unaryExpr )* ;
	public final JavathonParser.powExpr_return powExpr() throws RecognitionException {
		JavathonParser.powExpr_return retval = new JavathonParser.powExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal97=null;
		ParserRuleReturnScope unaryExpr96 =null;
		ParserRuleReturnScope unaryExpr98 =null;

		Object char_literal97_tree=null;

		try {
			// src/grammar/Javathon.g:162:3: ( unaryExpr ( '^' ^ unaryExpr )* )
			// src/grammar/Javathon.g:162:6: unaryExpr ( '^' ^ unaryExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_unaryExpr_in_powExpr1213);
			unaryExpr96=unaryExpr();
			state._fsp--;

			adaptor.addChild(root_0, unaryExpr96.getTree());

			// src/grammar/Javathon.g:162:16: ( '^' ^ unaryExpr )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==Pow) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// src/grammar/Javathon.g:162:17: '^' ^ unaryExpr
					{
					char_literal97=(Token)match(input,Pow,FOLLOW_Pow_in_powExpr1216); 
					char_literal97_tree = (Object)adaptor.create(char_literal97);
					root_0 = (Object)adaptor.becomeRoot(char_literal97_tree, root_0);

					pushFollow(FOLLOW_unaryExpr_in_powExpr1219);
					unaryExpr98=unaryExpr();
					state._fsp--;

					adaptor.addChild(root_0, unaryExpr98.getTree());

					}
					break;

				default :
					break loop20;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "powExpr"


	public static class unaryExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unaryExpr"
	// src/grammar/Javathon.g:165:1: unaryExpr : ( '-' atom -> ^( UNARY_MIN atom ) | '!' atom -> ^( NEGATE atom ) | atom );
	public final JavathonParser.unaryExpr_return unaryExpr() throws RecognitionException {
		JavathonParser.unaryExpr_return retval = new JavathonParser.unaryExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal99=null;
		Token char_literal101=null;
		ParserRuleReturnScope atom100 =null;
		ParserRuleReturnScope atom102 =null;
		ParserRuleReturnScope atom103 =null;

		Object char_literal99_tree=null;
		Object char_literal101_tree=null;
		RewriteRuleTokenStream stream_Excl=new RewriteRuleTokenStream(adaptor,"token Excl");
		RewriteRuleTokenStream stream_Subtract=new RewriteRuleTokenStream(adaptor,"token Subtract");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try {
			// src/grammar/Javathon.g:166:3: ( '-' atom -> ^( UNARY_MIN atom ) | '!' atom -> ^( NEGATE atom ) | atom )
			int alt21=3;
			switch ( input.LA(1) ) {
			case Subtract:
				{
				alt21=1;
				}
				break;
			case Excl:
				{
				alt21=2;
				}
				break;
			case Assert:
			case Bool:
			case Identifier:
			case Null:
			case Number:
			case OBracket:
			case OParen:
			case Print:
			case Println:
			case Size:
			case String:
				{
				alt21=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// src/grammar/Javathon.g:166:6: '-' atom
					{
					char_literal99=(Token)match(input,Subtract,FOLLOW_Subtract_in_unaryExpr1245);  
					stream_Subtract.add(char_literal99);

					pushFollow(FOLLOW_atom_in_unaryExpr1247);
					atom100=atom();
					state._fsp--;

					stream_atom.add(atom100.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 166:15: -> ^( UNARY_MIN atom )
					{
						// src/grammar/Javathon.g:166:18: ^( UNARY_MIN atom )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MIN, "UNARY_MIN"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// src/grammar/Javathon.g:167:6: '!' atom
					{
					char_literal101=(Token)match(input,Excl,FOLLOW_Excl_in_unaryExpr1264);  
					stream_Excl.add(char_literal101);

					pushFollow(FOLLOW_atom_in_unaryExpr1266);
					atom102=atom();
					state._fsp--;

					stream_atom.add(atom102.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 167:15: -> ^( NEGATE atom )
					{
						// src/grammar/Javathon.g:167:18: ^( NEGATE atom )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEGATE, "NEGATE"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// src/grammar/Javathon.g:168:6: atom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom_in_unaryExpr1283);
					atom103=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom103.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unaryExpr"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// src/grammar/Javathon.g:171:1: atom : ( Number | Bool | Null | lookup );
	public final JavathonParser.atom_return atom() throws RecognitionException {
		JavathonParser.atom_return retval = new JavathonParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Number104=null;
		Token Bool105=null;
		Token Null106=null;
		ParserRuleReturnScope lookup107 =null;

		Object Number104_tree=null;
		Object Bool105_tree=null;
		Object Null106_tree=null;

		try {
			// src/grammar/Javathon.g:172:3: ( Number | Bool | Null | lookup )
			int alt22=4;
			switch ( input.LA(1) ) {
			case Number:
				{
				alt22=1;
				}
				break;
			case Bool:
				{
				alt22=2;
				}
				break;
			case Null:
				{
				alt22=3;
				}
				break;
			case Assert:
			case Identifier:
			case OBracket:
			case OParen:
			case Print:
			case Println:
			case Size:
			case String:
				{
				alt22=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// src/grammar/Javathon.g:172:6: Number
					{
					root_0 = (Object)adaptor.nil();


					Number104=(Token)match(input,Number,FOLLOW_Number_in_atom1305); 
					Number104_tree = (Object)adaptor.create(Number104);
					adaptor.addChild(root_0, Number104_tree);

					}
					break;
				case 2 :
					// src/grammar/Javathon.g:173:6: Bool
					{
					root_0 = (Object)adaptor.nil();


					Bool105=(Token)match(input,Bool,FOLLOW_Bool_in_atom1314); 
					Bool105_tree = (Object)adaptor.create(Bool105);
					adaptor.addChild(root_0, Bool105_tree);

					}
					break;
				case 3 :
					// src/grammar/Javathon.g:174:6: Null
					{
					root_0 = (Object)adaptor.nil();


					Null106=(Token)match(input,Null,FOLLOW_Null_in_atom1323); 
					Null106_tree = (Object)adaptor.create(Null106);
					adaptor.addChild(root_0, Null106_tree);

					}
					break;
				case 4 :
					// src/grammar/Javathon.g:175:6: lookup
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_lookup_in_atom1332);
					lookup107=lookup();
					state._fsp--;

					adaptor.addChild(root_0, lookup107.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "list"
	// src/grammar/Javathon.g:178:1: list : '[' ( exprList )? ']' -> ^( LIST ( exprList )? ) ;
	public final JavathonParser.list_return list() throws RecognitionException {
		JavathonParser.list_return retval = new JavathonParser.list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal108=null;
		Token char_literal110=null;
		ParserRuleReturnScope exprList109 =null;

		Object char_literal108_tree=null;
		Object char_literal110_tree=null;
		RewriteRuleTokenStream stream_CBracket=new RewriteRuleTokenStream(adaptor,"token CBracket");
		RewriteRuleTokenStream stream_OBracket=new RewriteRuleTokenStream(adaptor,"token OBracket");
		RewriteRuleSubtreeStream stream_exprList=new RewriteRuleSubtreeStream(adaptor,"rule exprList");

		try {
			// src/grammar/Javathon.g:179:3: ( '[' ( exprList )? ']' -> ^( LIST ( exprList )? ) )
			// src/grammar/Javathon.g:179:6: '[' ( exprList )? ']'
			{
			char_literal108=(Token)match(input,OBracket,FOLLOW_OBracket_in_list1352);  
			stream_OBracket.add(char_literal108);

			// src/grammar/Javathon.g:179:10: ( exprList )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==Assert||LA23_0==Bool||LA23_0==Excl||LA23_0==Identifier||(LA23_0 >= Null && LA23_0 <= Number)||(LA23_0 >= OBracket && LA23_0 <= OParen)||(LA23_0 >= Print && LA23_0 <= Println)||LA23_0==Size||(LA23_0 >= String && LA23_0 <= Subtract)) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// src/grammar/Javathon.g:179:10: exprList
					{
					pushFollow(FOLLOW_exprList_in_list1354);
					exprList109=exprList();
					state._fsp--;

					stream_exprList.add(exprList109.getTree());
					}
					break;

			}

			char_literal110=(Token)match(input,CBracket,FOLLOW_CBracket_in_list1357);  
			stream_CBracket.add(char_literal110);

			// AST REWRITE
			// elements: exprList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 179:24: -> ^( LIST ( exprList )? )
			{
				// src/grammar/Javathon.g:179:27: ^( LIST ( exprList )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);
				// src/grammar/Javathon.g:179:34: ( exprList )?
				if ( stream_exprList.hasNext() ) {
					adaptor.addChild(root_1, stream_exprList.nextTree());
				}
				stream_exprList.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "list"


	public static class lookup_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lookup"
	// src/grammar/Javathon.g:184:1: lookup : ( functionCall ( indexes )? | '(' expression ')' ( indexes )? | list ( indexes )? | Identifier ( indexes )? | String ( indexes )? );
	public final JavathonParser.lookup_return lookup() throws RecognitionException {
		JavathonParser.lookup_return retval = new JavathonParser.lookup_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal113=null;
		Token char_literal115=null;
		Token Identifier119=null;
		Token String121=null;
		ParserRuleReturnScope functionCall111 =null;
		ParserRuleReturnScope indexes112 =null;
		ParserRuleReturnScope expression114 =null;
		ParserRuleReturnScope indexes116 =null;
		ParserRuleReturnScope list117 =null;
		ParserRuleReturnScope indexes118 =null;
		ParserRuleReturnScope indexes120 =null;
		ParserRuleReturnScope indexes122 =null;

		Object char_literal113_tree=null;
		Object char_literal115_tree=null;
		Object Identifier119_tree=null;
		Object String121_tree=null;

		try {
			// src/grammar/Javathon.g:185:3: ( functionCall ( indexes )? | '(' expression ')' ( indexes )? | list ( indexes )? | Identifier ( indexes )? | String ( indexes )? )
			int alt29=5;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				int LA29_1 = input.LA(2);
				if ( (LA29_1==OParen) ) {
					alt29=1;
				}
				else if ( ((LA29_1 >= Add && LA29_1 <= And)||(LA29_1 >= CBracket && LA29_1 <= Comma)||(LA29_1 >= Divide && LA29_1 <= Do)||LA29_1==Equals||(LA29_1 >= GT && LA29_1 <= GTEquals)||LA29_1==In||(LA29_1 >= LT && LA29_1 <= Multiply)||LA29_1==NEquals||LA29_1==OBracket||(LA29_1 >= Or && LA29_1 <= Pow)||LA29_1==QMark||LA29_1==SColon||LA29_1==Subtract) ) {
					alt29=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 29, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case Assert:
			case Print:
			case Println:
			case Size:
				{
				alt29=1;
				}
				break;
			case OParen:
				{
				alt29=2;
				}
				break;
			case OBracket:
				{
				alt29=3;
				}
				break;
			case String:
				{
				alt29=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// src/grammar/Javathon.g:185:6: functionCall ( indexes )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_functionCall_in_lookup1391);
					functionCall111=functionCall();
					state._fsp--;

					adaptor.addChild(root_0, functionCall111.getTree());

					// src/grammar/Javathon.g:185:19: ( indexes )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==OBracket) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// src/grammar/Javathon.g:185:19: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1393);
							indexes112=indexes();
							state._fsp--;

							adaptor.addChild(root_0, indexes112.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// src/grammar/Javathon.g:186:6: '(' expression ')' ( indexes )?
					{
					root_0 = (Object)adaptor.nil();


					char_literal113=(Token)match(input,OParen,FOLLOW_OParen_in_lookup1403); 
					char_literal113_tree = (Object)adaptor.create(char_literal113);
					adaptor.addChild(root_0, char_literal113_tree);

					pushFollow(FOLLOW_expression_in_lookup1405);
					expression114=expression();
					state._fsp--;

					adaptor.addChild(root_0, expression114.getTree());

					char_literal115=(Token)match(input,CParen,FOLLOW_CParen_in_lookup1407); 
					char_literal115_tree = (Object)adaptor.create(char_literal115);
					adaptor.addChild(root_0, char_literal115_tree);

					// src/grammar/Javathon.g:186:25: ( indexes )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==OBracket) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// src/grammar/Javathon.g:186:25: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1409);
							indexes116=indexes();
							state._fsp--;

							adaptor.addChild(root_0, indexes116.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// src/grammar/Javathon.g:187:6: list ( indexes )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_list_in_lookup1419);
					list117=list();
					state._fsp--;

					adaptor.addChild(root_0, list117.getTree());

					// src/grammar/Javathon.g:187:11: ( indexes )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==OBracket) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// src/grammar/Javathon.g:187:11: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1421);
							indexes118=indexes();
							state._fsp--;

							adaptor.addChild(root_0, indexes118.getTree());

							}
							break;

					}

					}
					break;
				case 4 :
					// src/grammar/Javathon.g:188:6: Identifier ( indexes )?
					{
					root_0 = (Object)adaptor.nil();


					Identifier119=(Token)match(input,Identifier,FOLLOW_Identifier_in_lookup1431); 
					Identifier119_tree = (Object)adaptor.create(Identifier119);
					adaptor.addChild(root_0, Identifier119_tree);

					// src/grammar/Javathon.g:188:17: ( indexes )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==OBracket) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// src/grammar/Javathon.g:188:17: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1433);
							indexes120=indexes();
							state._fsp--;

							adaptor.addChild(root_0, indexes120.getTree());

							}
							break;

					}

					}
					break;
				case 5 :
					// src/grammar/Javathon.g:189:6: String ( indexes )?
					{
					root_0 = (Object)adaptor.nil();


					String121=(Token)match(input,String,FOLLOW_String_in_lookup1443); 
					String121_tree = (Object)adaptor.create(String121);
					adaptor.addChild(root_0, String121_tree);

					// src/grammar/Javathon.g:189:13: ( indexes )?
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==OBracket) ) {
						alt28=1;
					}
					switch (alt28) {
						case 1 :
							// src/grammar/Javathon.g:189:13: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1445);
							indexes122=indexes();
							state._fsp--;

							adaptor.addChild(root_0, indexes122.getTree());

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lookup"


	public static class indexes_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "indexes"
	// src/grammar/Javathon.g:194:1: indexes : ( '[' expression ']' )+ -> ^( INDEXES ( expression )+ ) ;
	public final JavathonParser.indexes_return indexes() throws RecognitionException {
		JavathonParser.indexes_return retval = new JavathonParser.indexes_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal123=null;
		Token char_literal125=null;
		ParserRuleReturnScope expression124 =null;

		Object char_literal123_tree=null;
		Object char_literal125_tree=null;
		RewriteRuleTokenStream stream_CBracket=new RewriteRuleTokenStream(adaptor,"token CBracket");
		RewriteRuleTokenStream stream_OBracket=new RewriteRuleTokenStream(adaptor,"token OBracket");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// src/grammar/Javathon.g:195:3: ( ( '[' expression ']' )+ -> ^( INDEXES ( expression )+ ) )
			// src/grammar/Javathon.g:195:6: ( '[' expression ']' )+
			{
			// src/grammar/Javathon.g:195:6: ( '[' expression ']' )+
			int cnt30=0;
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==OBracket) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// src/grammar/Javathon.g:195:7: '[' expression ']'
					{
					char_literal123=(Token)match(input,OBracket,FOLLOW_OBracket_in_indexes1474);  
					stream_OBracket.add(char_literal123);

					pushFollow(FOLLOW_expression_in_indexes1476);
					expression124=expression();
					state._fsp--;

					stream_expression.add(expression124.getTree());
					char_literal125=(Token)match(input,CBracket,FOLLOW_CBracket_in_indexes1478);  
					stream_CBracket.add(char_literal125);

					}
					break;

				default :
					if ( cnt30 >= 1 ) break loop30;
					EarlyExitException eee = new EarlyExitException(30, input);
					throw eee;
				}
				cnt30++;
			}

			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 195:28: -> ^( INDEXES ( expression )+ )
			{
				// src/grammar/Javathon.g:195:31: ^( INDEXES ( expression )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INDEXES, "INDEXES"), root_1);
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "indexes"

	// Delegated rules



	public static final BitSet FOLLOW_block_in_parse166 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_block195 = new BitSet(new long[]{0x24C0001800020082L,0x0000000000000010L});
	public static final BitSet FOLLOW_functionDecl_in_block199 = new BitSet(new long[]{0x24C0001800020082L,0x0000000000000010L});
	public static final BitSet FOLLOW_Return_in_block204 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_block206 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_SColon_in_block208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement260 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_SColon_in_statement262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionCall_in_statement275 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_SColon_in_statement277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStatement_in_statement300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_assignment327 = new BitSet(new long[]{0x0004000000000100L});
	public static final BitSet FOLLOW_indexes_in_assignment329 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Assign_in_assignment332 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_assignment334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_functionCall371 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_OParen_in_functionCall373 = new BitSet(new long[]{0xA0CD800804002480L,0x0000000000000001L});
	public static final BitSet FOLLOW_exprList_in_functionCall375 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CParen_in_functionCall378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Println_in_functionCall398 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_OParen_in_functionCall400 = new BitSet(new long[]{0xA0CD800804002480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_functionCall402 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CParen_in_functionCall405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Print_in_functionCall426 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_OParen_in_functionCall428 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_functionCall430 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CParen_in_functionCall432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Assert_in_functionCall455 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_OParen_in_functionCall457 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_functionCall459 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CParen_in_functionCall461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Size_in_functionCall483 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_OParen_in_functionCall485 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_functionCall487 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CParen_in_functionCall489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStat_in_ifStatement533 = new BitSet(new long[]{0x0000000001800000L});
	public static final BitSet FOLLOW_elseIfStat_in_ifStatement535 = new BitSet(new long[]{0x0000000001800000L});
	public static final BitSet FOLLOW_elseStat_in_ifStatement538 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_End_in_ifStatement541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStat577 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_ifStat579 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Do_in_ifStat581 = new BitSet(new long[]{0x24C0001800020080L,0x0000000000000010L});
	public static final BitSet FOLLOW_block_in_ifStat583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseIfStat615 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_If_in_elseIfStat617 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_elseIfStat619 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Do_in_elseIfStat621 = new BitSet(new long[]{0x24C0001800020080L,0x0000000000000010L});
	public static final BitSet FOLLOW_block_in_elseIfStat623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseStat655 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Do_in_elseStat657 = new BitSet(new long[]{0x24C0001800020080L,0x0000000000000010L});
	public static final BitSet FOLLOW_block_in_elseStat659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Def_in_functionDecl695 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Identifier_in_functionDecl697 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_OParen_in_functionDecl699 = new BitSet(new long[]{0x0000000800002000L});
	public static final BitSet FOLLOW_idList_in_functionDecl701 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CParen_in_functionDecl704 = new BitSet(new long[]{0x24C0001801020080L,0x0000000000000010L});
	public static final BitSet FOLLOW_block_in_functionDecl706 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_End_in_functionDecl708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_While_in_whileStatement740 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_whileStatement742 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Do_in_whileStatement744 = new BitSet(new long[]{0x24C0001801020080L,0x0000000000000010L});
	public static final BitSet FOLLOW_block_in_whileStatement746 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_End_in_whileStatement748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_idList780 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_Comma_in_idList783 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_Identifier_in_idList785 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_expression_in_exprList818 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_Comma_in_exprList821 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_exprList823 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_condExpr_in_expression858 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orExpr_in_condExpr881 = new BitSet(new long[]{0x0100002000000002L});
	public static final BitSet FOLLOW_QMark_in_condExpr898 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_condExpr902 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_Colon_in_condExpr904 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_condExpr908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_In_in_condExpr933 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_condExpr935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr997 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_Or_in_orExpr1000 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_andExpr_in_orExpr1003 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_equExpr_in_andExpr1027 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_And_in_andExpr1030 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_equExpr_in_andExpr1033 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_relExpr_in_equExpr1057 = new BitSet(new long[]{0x0000400002000002L});
	public static final BitSet FOLLOW_set_in_equExpr1060 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_relExpr_in_equExpr1069 = new BitSet(new long[]{0x0000400002000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr1093 = new BitSet(new long[]{0x00000600C0000002L});
	public static final BitSet FOLLOW_set_in_relExpr1096 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_addExpr_in_relExpr1113 = new BitSet(new long[]{0x00000600C0000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr1137 = new BitSet(new long[]{0x0000000000000022L,0x0000000000000001L});
	public static final BitSet FOLLOW_set_in_addExpr1140 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr1149 = new BitSet(new long[]{0x0000000000000022L,0x0000000000000001L});
	public static final BitSet FOLLOW_powExpr_in_mulExpr1173 = new BitSet(new long[]{0x0000180000080002L});
	public static final BitSet FOLLOW_set_in_mulExpr1176 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_powExpr_in_mulExpr1189 = new BitSet(new long[]{0x0000180000080002L});
	public static final BitSet FOLLOW_unaryExpr_in_powExpr1213 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_Pow_in_powExpr1216 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_unaryExpr_in_powExpr1219 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_Subtract_in_unaryExpr1245 = new BitSet(new long[]{0xA0CD800800000480L});
	public static final BitSet FOLLOW_atom_in_unaryExpr1247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Excl_in_unaryExpr1264 = new BitSet(new long[]{0xA0CD800800000480L});
	public static final BitSet FOLLOW_atom_in_unaryExpr1266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unaryExpr1283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Number_in_atom1305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_atom1314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Null_in_atom1323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lookup_in_atom1332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBracket_in_list1352 = new BitSet(new long[]{0xA0CD800804001480L,0x0000000000000001L});
	public static final BitSet FOLLOW_exprList_in_list1354 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CBracket_in_list1357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionCall_in_lookup1391 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_indexes_in_lookup1393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OParen_in_lookup1403 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_lookup1405 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_CParen_in_lookup1407 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_indexes_in_lookup1409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_list_in_lookup1419 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_indexes_in_lookup1421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_lookup1431 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_indexes_in_lookup1433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_lookup1443 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_indexes_in_lookup1445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBracket_in_indexes1474 = new BitSet(new long[]{0xA0CD800804000480L,0x0000000000000001L});
	public static final BitSet FOLLOW_expression_in_indexes1476 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CBracket_in_indexes1478 = new BitSet(new long[]{0x0004000000000002L});
}
