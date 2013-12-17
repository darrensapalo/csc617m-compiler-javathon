<<<<<<< HEAD
// $ANTLR 3.5.1 src/grammar/JavathonTreeWalker.g 2013-12-17 13:06:25
 
  package grammar;
  import main.javathon.*; 
  import java.util.Map; 
  import java.util.HashMap; 


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JavathonTreeWalker extends TreeParser {
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public JavathonTreeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public JavathonTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return JavathonTreeWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "src/grammar/JavathonTreeWalker.g"; }

	 
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



	// $ANTLR start "walk"
	// src/grammar/JavathonTreeWalker.g:30:1: walk returns [JNode node] : block ;
	public final JNode walk() throws RecognitionException {
		JNode node = null;


		JNode block1 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:31:3: ( block )
			// src/grammar/JavathonTreeWalker.g:31:5: block
			{
			pushFollow(FOLLOW_block_in_walk70);
			block1=block();
			state._fsp--;

			node = block1;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "walk"



	// $ANTLR start "block"
	// src/grammar/JavathonTreeWalker.g:34:1: block returns [JNode node] : ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) ;
	public final JNode block() throws RecognitionException {
		JNode node = null;


		JNode statement2 =null;
		JNode expression3 =null;

		 
		  BlockNode bn = new BlockNode(); 
		  node = bn; 
		  Scope scope = new Scope(currentScope); 
		  currentScope = scope; 

		try {
			// src/grammar/JavathonTreeWalker.g:44:3: ( ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) )
			// src/grammar/JavathonTreeWalker.g:44:6: ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_block113); 
			match(input, Token.DOWN, null); 
			match(input,STATEMENTS,FOLLOW_STATEMENTS_in_block128); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/grammar/JavathonTreeWalker.g:45:23: ( statement )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==FUNC_CALL||LA1_0==IF||LA1_0==While) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// src/grammar/JavathonTreeWalker.g:45:24: statement
						{
						pushFollow(FOLLOW_statement_in_block131);
						statement2=statement();
						state._fsp--;

						 bn.addStatement(statement2);
						}
						break;

					default :
						break loop1;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input,RETURN,FOLLOW_RETURN_in_block153); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/grammar/JavathonTreeWalker.g:46:23: ( expression )?
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= Add && LA2_0 <= And)||LA2_0==Bool||LA2_0==Divide||LA2_0==Equals||(LA2_0 >= GT && LA2_0 <= GTEquals)||LA2_0==In||(LA2_0 >= LOOKUP && LA2_0 <= Number)||(LA2_0 >= Or && LA2_0 <= Pow)||(LA2_0 >= Subtract && LA2_0 <= TERNARY)||LA2_0==UNARY_MIN) ) {
					alt2=1;
				}
				switch (alt2) {
					case 1 :
						// src/grammar/JavathonTreeWalker.g:46:24: expression
						{
						pushFollow(FOLLOW_expression_in_block160);
						expression3=expression();
						state._fsp--;

						 bn.addReturn(expression3);  
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 

			}

			 
			  currentScope = currentScope.parent(); 

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "block"



	// $ANTLR start "statement"
	// src/grammar/JavathonTreeWalker.g:50:1: statement returns [JNode node] : ( assignment | functionCall | ifStatement | whileStatement );
	public final JNode statement() throws RecognitionException {
		JNode node = null;


		JNode assignment4 =null;
		JNode functionCall5 =null;
		JNode ifStatement6 =null;
		JNode whileStatement7 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:51:3: ( assignment | functionCall | ifStatement | whileStatement )
			int alt3=4;
			switch ( input.LA(1) ) {
			case ASSIGNMENT:
				{
				alt3=1;
				}
				break;
			case FUNC_CALL:
				{
				alt3=2;
				}
				break;
			case IF:
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
					// src/grammar/JavathonTreeWalker.g:51:6: assignment
					{
					pushFollow(FOLLOW_assignment_in_statement202);
					assignment4=assignment();
					state._fsp--;

					node = assignment4;
					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:52:6: functionCall
					{
					pushFollow(FOLLOW_functionCall_in_statement217);
					functionCall5=functionCall();
					state._fsp--;

					node = functionCall5;
					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:53:6: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement230);
					ifStatement6=ifStatement();
					state._fsp--;

					node = ifStatement6;
					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:54:6: whileStatement
					{
					pushFollow(FOLLOW_whileStatement_in_statement245);
					whileStatement7=whileStatement();
					state._fsp--;

					node = whileStatement7;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "statement"



	// $ANTLR start "assignment"
	// src/grammar/JavathonTreeWalker.g:57:1: assignment returns [JNode node] : ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression ) ;
	public final JNode assignment() throws RecognitionException {
		JNode node = null;


		CommonTree i=null;
		List<JNode> x =null;
		JNode e =null;

		try {
			// src/grammar/JavathonTreeWalker.g:58:3: ( ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression ) )
			// src/grammar/JavathonTreeWalker.g:58:6: ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_assignment274); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_assignment278); 
			// src/grammar/JavathonTreeWalker.g:58:33: (x= indexes )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==INDEXES) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:58:33: x= indexes
					{
					pushFollow(FOLLOW_indexes_in_assignment282);
					x=indexes();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_expression_in_assignment287);
			e=expression();
			state._fsp--;

			match(input, Token.UP, null); 

			node = new AssignmentNode((i!=null?i.getText():null), x, e, currentScope);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "assignment"



	// $ANTLR start "functionCall"
	// src/grammar/JavathonTreeWalker.g:62:1: functionCall returns [JNode node] : ( ^( FUNC_CALL Identifier ( exprList )? ) | ^( FUNC_CALL Println ( expression )? ) | ^( FUNC_CALL Print expression ) | ^( FUNC_CALL Assert expression ) | ^( FUNC_CALL Size expression ) );
	public final JNode functionCall() throws RecognitionException {
		JNode node = null;


		JNode expression8 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:63:3: ( ^( FUNC_CALL Identifier ( exprList )? ) | ^( FUNC_CALL Println ( expression )? ) | ^( FUNC_CALL Print expression ) | ^( FUNC_CALL Assert expression ) | ^( FUNC_CALL Size expression ) )
			int alt7=5;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==FUNC_CALL) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==DOWN) ) {
					switch ( input.LA(3) ) {
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
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:63:6: ^( FUNC_CALL Identifier ( exprList )? )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall325); 
					match(input, Token.DOWN, null); 
					match(input,Identifier,FOLLOW_Identifier_in_functionCall327); 
					// src/grammar/JavathonTreeWalker.g:63:29: ( exprList )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==EXP_LIST) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:63:29: exprList
							{
							pushFollow(FOLLOW_exprList_in_functionCall329);
							exprList();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:64:6: ^( FUNC_CALL Println ( expression )? )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall341); 
					match(input, Token.DOWN, null); 
					match(input,Println,FOLLOW_Println_in_functionCall343); 
					// src/grammar/JavathonTreeWalker.g:64:26: ( expression )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( ((LA6_0 >= Add && LA6_0 <= And)||LA6_0==Bool||LA6_0==Divide||LA6_0==Equals||(LA6_0 >= GT && LA6_0 <= GTEquals)||LA6_0==In||(LA6_0 >= LOOKUP && LA6_0 <= Number)||(LA6_0 >= Or && LA6_0 <= Pow)||(LA6_0 >= Subtract && LA6_0 <= TERNARY)||LA6_0==UNARY_MIN) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:64:26: expression
							{
							pushFollow(FOLLOW_expression_in_functionCall345);
							expression8=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					node = new PrintlnNode(expression8);
					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:65:6: ^( FUNC_CALL Print expression )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall362); 
					match(input, Token.DOWN, null); 
					match(input,Print,FOLLOW_Print_in_functionCall364); 
					pushFollow(FOLLOW_expression_in_functionCall366);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:66:6: ^( FUNC_CALL Assert expression )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall377); 
					match(input, Token.DOWN, null); 
					match(input,Assert,FOLLOW_Assert_in_functionCall379); 
					pushFollow(FOLLOW_expression_in_functionCall381);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// src/grammar/JavathonTreeWalker.g:67:6: ^( FUNC_CALL Size expression )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall392); 
					match(input, Token.DOWN, null); 
					match(input,Size,FOLLOW_Size_in_functionCall394); 
					pushFollow(FOLLOW_expression_in_functionCall396);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "functionCall"



	// $ANTLR start "ifStatement"
	// src/grammar/JavathonTreeWalker.g:70:1: ifStatement returns [JNode node] : ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? ) ;
	public final JNode ifStatement() throws RecognitionException {
		JNode node = null;


		JNode b1 =null;
		JNode b2 =null;
		JNode expression9 =null;

		 
		  IfNode ifNode = new IfNode(); 
		  node = ifNode; 

		try {
			// src/grammar/JavathonTreeWalker.g:75:3: ( ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? ) )
			// src/grammar/JavathonTreeWalker.g:75:6: ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? )
			{
			match(input,IF,FOLLOW_IF_in_ifStatement432); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:76:8: ( ^( EXP expression b1= block ) )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==EXP) ) {
					int LA8_1 = input.LA(2);
					if ( (LA8_1==DOWN) ) {
						int LA8_3 = input.LA(3);
						if ( ((LA8_3 >= Add && LA8_3 <= And)||LA8_3==Bool||LA8_3==Divide||LA8_3==Equals||(LA8_3 >= GT && LA8_3 <= GTEquals)||LA8_3==In||(LA8_3 >= LOOKUP && LA8_3 <= Number)||(LA8_3 >= Or && LA8_3 <= Pow)||(LA8_3 >= Subtract && LA8_3 <= TERNARY)||LA8_3==UNARY_MIN) ) {
							alt8=1;
						}

					}

				}

				switch (alt8) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:76:9: ^( EXP expression b1= block )
					{
					match(input,EXP,FOLLOW_EXP_in_ifStatement446); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_ifStatement448);
					expression9=expression();
					state._fsp--;

					pushFollow(FOLLOW_block_in_ifStatement452);
					b1=block();
					state._fsp--;

					match(input, Token.UP, null); 

					ifNode.addChoice(expression9,b1);
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			// src/grammar/JavathonTreeWalker.g:77:8: ( ^( EXP b2= block ) )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==EXP) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:77:9: ^( EXP b2= block )
					{
					match(input,EXP,FOLLOW_EXP_in_ifStatement471); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ifStatement475);
					b2=block();
					state._fsp--;

					match(input, Token.UP, null); 

					ifNode.addChoice(new AtomNode(true),b2);
					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "whileStatement"
	// src/grammar/JavathonTreeWalker.g:81:1: whileStatement returns [JNode node] : ^( While expression block ) ;
	public final JNode whileStatement() throws RecognitionException {
		JNode node = null;


		try {
			// src/grammar/JavathonTreeWalker.g:82:3: ( ^( While expression block ) )
			// src/grammar/JavathonTreeWalker.g:82:6: ^( While expression block )
			{
			match(input,While,FOLLOW_While_in_whileStatement524); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_whileStatement526);
			expression();
			state._fsp--;

			pushFollow(FOLLOW_block_in_whileStatement528);
			block();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "whileStatement"



	// $ANTLR start "idList"
	// src/grammar/JavathonTreeWalker.g:85:1: idList : ^( ID_LIST ( Identifier )+ ) ;
	public final void idList() throws RecognitionException {
		try {
			// src/grammar/JavathonTreeWalker.g:86:3: ( ^( ID_LIST ( Identifier )+ ) )
			// src/grammar/JavathonTreeWalker.g:86:6: ^( ID_LIST ( Identifier )+ )
			{
			match(input,ID_LIST,FOLLOW_ID_LIST_in_idList552); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:86:16: ( Identifier )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Identifier) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:86:16: Identifier
					{
					match(input,Identifier,FOLLOW_Identifier_in_idList554); 
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "idList"



	// $ANTLR start "exprList"
	// src/grammar/JavathonTreeWalker.g:89:1: exprList : ^( EXP_LIST ( expression )+ ) ;
	public final void exprList() throws RecognitionException {
		try {
			// src/grammar/JavathonTreeWalker.g:90:3: ( ^( EXP_LIST ( expression )+ ) )
			// src/grammar/JavathonTreeWalker.g:90:6: ^( EXP_LIST ( expression )+ )
			{
			match(input,EXP_LIST,FOLLOW_EXP_LIST_in_exprList579); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:90:17: ( expression )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= Add && LA11_0 <= And)||LA11_0==Bool||LA11_0==Divide||LA11_0==Equals||(LA11_0 >= GT && LA11_0 <= GTEquals)||LA11_0==In||(LA11_0 >= LOOKUP && LA11_0 <= Number)||(LA11_0 >= Or && LA11_0 <= Pow)||(LA11_0 >= Subtract && LA11_0 <= TERNARY)||LA11_0==UNARY_MIN) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:90:17: expression
					{
					pushFollow(FOLLOW_expression_in_exprList581);
					expression();
					state._fsp--;

					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exprList"



	// $ANTLR start "expression"
	// src/grammar/JavathonTreeWalker.g:93:1: expression returns [JNode node] : ( ^( TERNARY expression expression expression ) | ^( In expression expression ) | ^( '||' expression expression ) | ^( '&&' expression expression ) | ^( '==' expression expression ) | ^( '!=' expression expression ) | ^( '>=' expression expression ) | ^( '<=' expression expression ) | ^( '>' expression expression ) | ^( '<' a= expression b= expression ) | ^( '+' a= expression b= expression ) | ^( '-' a= expression b= expression ) | ^( '*' a= expression b= expression ) | ^( '/' a= expression b= expression ) | ^( '%' a= expression b= expression ) | ^( '^' a= expression b= expression ) | ^( UNARY_MIN a= expression ) | ^( NEGATE a= expression ) | Number | Bool | Null | lookup );
	public final JNode expression() throws RecognitionException {
		JNode node = null;


		CommonTree Number10=null;
		CommonTree Bool11=null;
		JNode a =null;
		JNode b =null;
		JNode lookup12 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:94:3: ( ^( TERNARY expression expression expression ) | ^( In expression expression ) | ^( '||' expression expression ) | ^( '&&' expression expression ) | ^( '==' expression expression ) | ^( '!=' expression expression ) | ^( '>=' expression expression ) | ^( '<=' expression expression ) | ^( '>' expression expression ) | ^( '<' a= expression b= expression ) | ^( '+' a= expression b= expression ) | ^( '-' a= expression b= expression ) | ^( '*' a= expression b= expression ) | ^( '/' a= expression b= expression ) | ^( '%' a= expression b= expression ) | ^( '^' a= expression b= expression ) | ^( UNARY_MIN a= expression ) | ^( NEGATE a= expression ) | Number | Bool | Null | lookup )
			int alt12=22;
			switch ( input.LA(1) ) {
			case TERNARY:
				{
				alt12=1;
				}
				break;
			case In:
				{
				alt12=2;
				}
				break;
			case Or:
				{
				alt12=3;
				}
				break;
			case And:
				{
				alt12=4;
				}
				break;
			case Equals:
				{
				alt12=5;
				}
				break;
			case NEquals:
				{
				alt12=6;
				}
				break;
			case GTEquals:
				{
				alt12=7;
				}
				break;
			case LTEquals:
				{
				alt12=8;
				}
				break;
			case GT:
				{
				alt12=9;
				}
				break;
			case LT:
				{
				alt12=10;
				}
				break;
			case Add:
				{
				alt12=11;
				}
				break;
			case Subtract:
				{
				alt12=12;
				}
				break;
			case Multiply:
				{
				alt12=13;
				}
				break;
			case Divide:
				{
				alt12=14;
				}
				break;
			case Modulus:
				{
				alt12=15;
				}
				break;
			case Pow:
				{
				alt12=16;
				}
				break;
			case UNARY_MIN:
				{
				alt12=17;
				}
				break;
			case NEGATE:
				{
				alt12=18;
				}
				break;
			case Number:
				{
				alt12=19;
				}
				break;
			case Bool:
				{
				alt12=20;
				}
				break;
			case Null:
				{
				alt12=21;
				}
				break;
			case LOOKUP:
				{
				alt12=22;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:94:6: ^( TERNARY expression expression expression )
					{
					match(input,TERNARY,FOLLOW_TERNARY_in_expression610); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression612);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression614);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression616);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:95:6: ^( In expression expression )
					{
					match(input,In,FOLLOW_In_in_expression627); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression629);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression631);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:96:6: ^( '||' expression expression )
					{
					match(input,Or,FOLLOW_Or_in_expression642); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression644);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression646);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:97:6: ^( '&&' expression expression )
					{
					match(input,And,FOLLOW_And_in_expression657); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression659);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression661);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// src/grammar/JavathonTreeWalker.g:98:6: ^( '==' expression expression )
					{
					match(input,Equals,FOLLOW_Equals_in_expression672); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression674);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression676);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// src/grammar/JavathonTreeWalker.g:99:6: ^( '!=' expression expression )
					{
					match(input,NEquals,FOLLOW_NEquals_in_expression687); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression689);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression691);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// src/grammar/JavathonTreeWalker.g:100:6: ^( '>=' expression expression )
					{
					match(input,GTEquals,FOLLOW_GTEquals_in_expression702); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression704);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression706);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// src/grammar/JavathonTreeWalker.g:101:6: ^( '<=' expression expression )
					{
					match(input,LTEquals,FOLLOW_LTEquals_in_expression717); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression719);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression721);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// src/grammar/JavathonTreeWalker.g:102:6: ^( '>' expression expression )
					{
					match(input,GT,FOLLOW_GT_in_expression732); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression734);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression736);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// src/grammar/JavathonTreeWalker.g:103:6: ^( '<' a= expression b= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression773); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression777);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression781);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new LTNode 	(a, b);
					}
					break;
				case 11 :
					// src/grammar/JavathonTreeWalker.g:104:6: ^( '+' a= expression b= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression807); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression811);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression815);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new AddNode	(a, b);
					}
					break;
				case 12 :
					// src/grammar/JavathonTreeWalker.g:105:6: ^( '-' a= expression b= expression )
					{
					match(input,Subtract,FOLLOW_Subtract_in_expression838); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression842);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression846);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new MinusNode (a, b);
					}
					break;
				case 13 :
					// src/grammar/JavathonTreeWalker.g:106:6: ^( '*' a= expression b= expression )
					{
					match(input,Multiply,FOLLOW_Multiply_in_expression875); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression879);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression883);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new MultiplyNode (a, b);
					}
					break;
				case 14 :
					// src/grammar/JavathonTreeWalker.g:107:6: ^( '/' a= expression b= expression )
					{
					match(input,Divide,FOLLOW_Divide_in_expression912); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression916);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression920);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new DivideNode (a, b);
					}
					break;
				case 15 :
					// src/grammar/JavathonTreeWalker.g:108:6: ^( '%' a= expression b= expression )
					{
					match(input,Modulus,FOLLOW_Modulus_in_expression949); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression953);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression957);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new ModuloNode (a, b);
					}
					break;
				case 16 :
					// src/grammar/JavathonTreeWalker.g:109:6: ^( '^' a= expression b= expression )
					{
					match(input,Pow,FOLLOW_Pow_in_expression984); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression988);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression992);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new PowerNode (a, b);
					}
					break;
				case 17 :
					// src/grammar/JavathonTreeWalker.g:110:6: ^( UNARY_MIN a= expression )
					{
					match(input,UNARY_MIN,FOLLOW_UNARY_MIN_in_expression1038); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1042);
					a=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new UnaryMinNode (a);
					}
					break;
				case 18 :
					// src/grammar/JavathonTreeWalker.g:111:6: ^( NEGATE a= expression )
					{
					match(input,NEGATE,FOLLOW_NEGATE_in_expression1093); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1097);
					a=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new NegateNode(a);
					}
					break;
				case 19 :
					// src/grammar/JavathonTreeWalker.g:112:6: Number
					{
					Number10=(CommonTree)match(input,Number,FOLLOW_Number_in_expression1138); 
					node = new AtomNode(Double.parseDouble((Number10!=null?Number10.getText():null)));
					}
					break;
				case 20 :
					// src/grammar/JavathonTreeWalker.g:113:6: Bool
					{
					Bool11=(CommonTree)match(input,Bool,FOLLOW_Bool_in_expression1188); 
					node = new AtomNode(Boolean.parseBoolean((Bool11!=null?Bool11.getText():null)));
					}
					break;
				case 21 :
					// src/grammar/JavathonTreeWalker.g:114:6: Null
					{
					match(input,Null,FOLLOW_Null_in_expression1264); 
					}
					break;
				case 22 :
					// src/grammar/JavathonTreeWalker.g:115:6: lookup
					{
					pushFollow(FOLLOW_lookup_in_expression1273);
					lookup12=lookup();
					state._fsp--;

					node = lookup12;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "expression"



	// $ANTLR start "list"
	// src/grammar/JavathonTreeWalker.g:118:1: list : ^( LIST ( exprList )? ) ;
	public final void list() throws RecognitionException {
		try {
			// src/grammar/JavathonTreeWalker.g:119:3: ( ^( LIST ( exprList )? ) )
			// src/grammar/JavathonTreeWalker.g:119:6: ^( LIST ( exprList )? )
			{
			match(input,LIST,FOLLOW_LIST_in_list1314); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/grammar/JavathonTreeWalker.g:119:13: ( exprList )?
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==EXP_LIST) ) {
					alt13=1;
				}
				switch (alt13) {
					case 1 :
						// src/grammar/JavathonTreeWalker.g:119:13: exprList
						{
						pushFollow(FOLLOW_exprList_in_list1316);
						exprList();
						state._fsp--;

						}
						break;

				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "list"



	// $ANTLR start "lookup"
	// src/grammar/JavathonTreeWalker.g:122:1: lookup returns [JNode node] : ( ^( LOOKUP functionCall ( indexes )? ) | ^( LOOKUP list ( indexes )? ) | ^( LOOKUP expression ( indexes )? ) | ^( LOOKUP i= Identifier (x= indexes )? ) | ^( LOOKUP String ( indexes )? ) );
	public final JNode lookup() throws RecognitionException {
		JNode node = null;


		CommonTree i=null;
		List<JNode> x =null;

		try {
			// src/grammar/JavathonTreeWalker.g:123:3: ( ^( LOOKUP functionCall ( indexes )? ) | ^( LOOKUP list ( indexes )? ) | ^( LOOKUP expression ( indexes )? ) | ^( LOOKUP i= Identifier (x= indexes )? ) | ^( LOOKUP String ( indexes )? ) )
			int alt19=5;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==LOOKUP) ) {
				int LA19_1 = input.LA(2);
				if ( (LA19_1==DOWN) ) {
					switch ( input.LA(3) ) {
					case Identifier:
						{
						alt19=4;
						}
						break;
					case String:
						{
						alt19=5;
						}
						break;
					case FUNC_CALL:
						{
						alt19=1;
						}
						break;
					case LIST:
						{
						alt19=2;
						}
						break;
					case Add:
					case And:
					case Bool:
					case Divide:
					case Equals:
					case GT:
					case GTEquals:
					case In:
					case LOOKUP:
					case LT:
					case LTEquals:
					case Modulus:
					case Multiply:
					case NEGATE:
					case NEquals:
					case Null:
					case Number:
					case Or:
					case Pow:
					case Subtract:
					case TERNARY:
					case UNARY_MIN:
						{
						alt19=3;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 19, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:123:6: ^( LOOKUP functionCall ( indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1345); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_functionCall_in_lookup1347);
					functionCall();
					state._fsp--;

					// src/grammar/JavathonTreeWalker.g:123:28: ( indexes )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==INDEXES) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:123:28: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1349);
							indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:124:6: ^( LOOKUP list ( indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1361); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_list_in_lookup1363);
					list();
					state._fsp--;

					// src/grammar/JavathonTreeWalker.g:124:20: ( indexes )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==INDEXES) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:124:20: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1365);
							indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:125:6: ^( LOOKUP expression ( indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1377); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_lookup1379);
					expression();
					state._fsp--;

					// src/grammar/JavathonTreeWalker.g:125:26: ( indexes )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==INDEXES) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:125:26: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1381);
							indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:126:6: ^( LOOKUP i= Identifier (x= indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1394); 
					match(input, Token.DOWN, null); 
					i=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_lookup1398); 
					// src/grammar/JavathonTreeWalker.g:126:29: (x= indexes )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==INDEXES) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:126:29: x= indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1402);
							x=indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					 
					        node = (x != null) 
					          ? new LookupNode(new IdentifierNode((i!=null?i.getText():null), currentScope), x) 
					          : new IdentifierNode((i!=null?i.getText():null), currentScope); 
					      
					}
					break;
				case 5 :
					// src/grammar/JavathonTreeWalker.g:132:6: ^( LOOKUP String ( indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1424); 
					match(input, Token.DOWN, null); 
					match(input,String,FOLLOW_String_in_lookup1426); 
					// src/grammar/JavathonTreeWalker.g:132:22: ( indexes )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==INDEXES) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:132:22: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1428);
							indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "lookup"



	// $ANTLR start "indexes"
	// src/grammar/JavathonTreeWalker.g:135:1: indexes returns [List<JNode> e] : ^( INDEXES ( expression )+ ) ;
	public final List<JNode> indexes() throws RecognitionException {
		List<JNode> e = null;


		JNode expression13 =null;

		e = new ArrayList<JNode>();
		try {
			// src/grammar/JavathonTreeWalker.g:137:3: ( ^( INDEXES ( expression )+ ) )
			// src/grammar/JavathonTreeWalker.g:137:6: ^( INDEXES ( expression )+ )
			{
			match(input,INDEXES,FOLLOW_INDEXES_in_indexes1464); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:137:16: ( expression )+
			int cnt20=0;
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( ((LA20_0 >= Add && LA20_0 <= And)||LA20_0==Bool||LA20_0==Divide||LA20_0==Equals||(LA20_0 >= GT && LA20_0 <= GTEquals)||LA20_0==In||(LA20_0 >= LOOKUP && LA20_0 <= Number)||(LA20_0 >= Or && LA20_0 <= Pow)||(LA20_0 >= Subtract && LA20_0 <= TERNARY)||LA20_0==UNARY_MIN) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:137:17: expression
					{
					pushFollow(FOLLOW_expression_in_indexes1467);
					expression13=expression();
					state._fsp--;

					e.add(expression13);
					}
					break;

				default :
					if ( cnt20 >= 1 ) break loop20;
					EarlyExitException eee = new EarlyExitException(20, input);
					throw eee;
				}
				cnt20++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return e;
	}
	// $ANTLR end "indexes"

	// Delegated rules



	public static final BitSet FOLLOW_block_in_walk70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block113 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_STATEMENTS_in_block128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_block131 = new BitSet(new long[]{0x0000000210000018L,0x0000000000000010L});
	public static final BitSet FOLLOW_RETURN_in_block153 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_block160 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_assignment_in_statement202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionCall_in_statement217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStatement_in_statement245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_assignment274 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_assignment278 = new BitSet(new long[]{0x0031FF24C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_indexes_in_assignment282 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_assignment287 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall325 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_functionCall327 = new BitSet(new long[]{0x0000000000400008L});
	public static final BitSet FOLLOW_exprList_in_functionCall329 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall341 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Println_in_functionCall343 = new BitSet(new long[]{0x0031FF20C2080468L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall345 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall362 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Print_in_functionCall364 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall366 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall377 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Assert_in_functionCall379 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall381 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall392 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Size_in_functionCall394 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall396 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_in_ifStatement432 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_EXP_in_ifStatement446 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifStatement448 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_block_in_ifStatement452 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXP_in_ifStatement471 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ifStatement475 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_While_in_whileStatement524 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_whileStatement526 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_block_in_whileStatement528 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_LIST_in_idList552 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_idList554 = new BitSet(new long[]{0x0000000800000008L});
	public static final BitSet FOLLOW_EXP_LIST_in_exprList579 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_exprList581 = new BitSet(new long[]{0x0031FF20C2080468L,0x000000000000000BL});
	public static final BitSet FOLLOW_TERNARY_in_expression610 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression612 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression614 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression616 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_In_in_expression627 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression629 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression631 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Or_in_expression642 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression644 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression646 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression657 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression659 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression661 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equals_in_expression672 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression674 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression676 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEquals_in_expression687 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression689 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression691 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEquals_in_expression702 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression704 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression706 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEquals_in_expression717 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression719 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression721 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression732 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression734 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression736 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression773 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression777 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression781 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression807 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression811 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression815 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Subtract_in_expression838 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression842 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression846 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Multiply_in_expression875 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression879 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression883 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Divide_in_expression912 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression916 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression920 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Modulus_in_expression949 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression953 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression957 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Pow_in_expression984 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression988 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression992 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MIN_in_expression1038 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1042 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATE_in_expression1093 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1097 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Number_in_expression1138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_expression1188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Null_in_expression1264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lookup_in_expression1273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIST_in_list1314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_exprList_in_list1316 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1345 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_functionCall_in_lookup1347 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1349 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1361 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_list_in_lookup1363 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1365 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1377 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_lookup1379 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1381 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1394 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_lookup1398 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1402 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1424 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_String_in_lookup1426 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1428 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INDEXES_in_indexes1464 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_indexes1467 = new BitSet(new long[]{0x0031FF20C2080468L,0x000000000000000BL});
}
=======
// $ANTLR 3.5.1 src/grammar/JavathonTreeWalker.g 2013-12-17 13:12:14
 
  package grammar;
  import main.javathon.*; 
  import java.util.Map; 
  import java.util.HashMap; 


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JavathonTreeWalker extends TreeParser {
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public JavathonTreeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public JavathonTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return JavathonTreeWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "src/grammar/JavathonTreeWalker.g"; }

	 
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



	// $ANTLR start "walk"
	// src/grammar/JavathonTreeWalker.g:30:1: walk returns [JNode node] : block ;
	public final JNode walk() throws RecognitionException {
		JNode node = null;


		JNode block1 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:31:3: ( block )
			// src/grammar/JavathonTreeWalker.g:31:5: block
			{
			pushFollow(FOLLOW_block_in_walk70);
			block1=block();
			state._fsp--;

			node = block1;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "walk"



	// $ANTLR start "block"
	// src/grammar/JavathonTreeWalker.g:34:1: block returns [JNode node] : ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) ;
	public final JNode block() throws RecognitionException {
		JNode node = null;


		JNode statement2 =null;
		JNode expression3 =null;

		 
		  BlockNode bn = new BlockNode(); 
		  node = bn; 
		  Scope scope = new Scope(currentScope); 
		  currentScope = scope; 

		try {
			// src/grammar/JavathonTreeWalker.g:44:3: ( ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) ) )
			// src/grammar/JavathonTreeWalker.g:44:6: ^( BLOCK ^( STATEMENTS ( statement )* ) ^( RETURN ( expression )? ) )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_block113); 
			match(input, Token.DOWN, null); 
			match(input,STATEMENTS,FOLLOW_STATEMENTS_in_block128); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/grammar/JavathonTreeWalker.g:45:23: ( statement )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==FUNC_CALL||LA1_0==IF||LA1_0==While) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// src/grammar/JavathonTreeWalker.g:45:24: statement
						{
						pushFollow(FOLLOW_statement_in_block131);
						statement2=statement();
						state._fsp--;

						 bn.addStatement(statement2);
						}
						break;

					default :
						break loop1;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input,RETURN,FOLLOW_RETURN_in_block153); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/grammar/JavathonTreeWalker.g:46:23: ( expression )?
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= Add && LA2_0 <= And)||LA2_0==Bool||LA2_0==Divide||LA2_0==Equals||(LA2_0 >= GT && LA2_0 <= GTEquals)||LA2_0==In||(LA2_0 >= LOOKUP && LA2_0 <= Number)||(LA2_0 >= Or && LA2_0 <= Pow)||(LA2_0 >= Subtract && LA2_0 <= TERNARY)||LA2_0==UNARY_MIN) ) {
					alt2=1;
				}
				switch (alt2) {
					case 1 :
						// src/grammar/JavathonTreeWalker.g:46:24: expression
						{
						pushFollow(FOLLOW_expression_in_block160);
						expression3=expression();
						state._fsp--;

						 bn.addReturn(expression3);  
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 

			}

			 
			  currentScope = currentScope.parent(); 

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "block"



	// $ANTLR start "statement"
	// src/grammar/JavathonTreeWalker.g:50:1: statement returns [JNode node] : ( assignment | functionCall | ifStatement | whileStatement );
	public final JNode statement() throws RecognitionException {
		JNode node = null;


		JNode assignment4 =null;
		JNode functionCall5 =null;
		JNode ifStatement6 =null;
		JNode whileStatement7 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:51:3: ( assignment | functionCall | ifStatement | whileStatement )
			int alt3=4;
			switch ( input.LA(1) ) {
			case ASSIGNMENT:
				{
				alt3=1;
				}
				break;
			case FUNC_CALL:
				{
				alt3=2;
				}
				break;
			case IF:
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
					// src/grammar/JavathonTreeWalker.g:51:6: assignment
					{
					pushFollow(FOLLOW_assignment_in_statement202);
					assignment4=assignment();
					state._fsp--;

					node = assignment4;
					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:52:6: functionCall
					{
					pushFollow(FOLLOW_functionCall_in_statement217);
					functionCall5=functionCall();
					state._fsp--;

					node = functionCall5;
					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:53:6: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement230);
					ifStatement6=ifStatement();
					state._fsp--;

					node = ifStatement6;
					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:54:6: whileStatement
					{
					pushFollow(FOLLOW_whileStatement_in_statement245);
					whileStatement7=whileStatement();
					state._fsp--;

					node = whileStatement7;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "statement"



	// $ANTLR start "assignment"
	// src/grammar/JavathonTreeWalker.g:57:1: assignment returns [JNode node] : ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression ) ;
	public final JNode assignment() throws RecognitionException {
		JNode node = null;


		CommonTree i=null;
		List<JNode> x =null;
		JNode e =null;

		try {
			// src/grammar/JavathonTreeWalker.g:58:3: ( ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression ) )
			// src/grammar/JavathonTreeWalker.g:58:6: ^( ASSIGNMENT i= Identifier (x= indexes )? e= expression )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_assignment274); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_assignment278); 
			// src/grammar/JavathonTreeWalker.g:58:33: (x= indexes )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==INDEXES) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:58:33: x= indexes
					{
					pushFollow(FOLLOW_indexes_in_assignment282);
					x=indexes();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_expression_in_assignment287);
			e=expression();
			state._fsp--;

			match(input, Token.UP, null); 

			node = new AssignmentNode((i!=null?i.getText():null), x, e, currentScope);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "assignment"



	// $ANTLR start "functionCall"
	// src/grammar/JavathonTreeWalker.g:62:1: functionCall returns [JNode node] : ( ^( FUNC_CALL Identifier ( exprList )? ) | ^( FUNC_CALL Println ( expression )? ) | ^( FUNC_CALL Print expression ) | ^( FUNC_CALL Assert expression ) | ^( FUNC_CALL Size expression ) );
	public final JNode functionCall() throws RecognitionException {
		JNode node = null;


		JNode expression8 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:63:3: ( ^( FUNC_CALL Identifier ( exprList )? ) | ^( FUNC_CALL Println ( expression )? ) | ^( FUNC_CALL Print expression ) | ^( FUNC_CALL Assert expression ) | ^( FUNC_CALL Size expression ) )
			int alt7=5;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==FUNC_CALL) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==DOWN) ) {
					switch ( input.LA(3) ) {
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
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:63:6: ^( FUNC_CALL Identifier ( exprList )? )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall325); 
					match(input, Token.DOWN, null); 
					match(input,Identifier,FOLLOW_Identifier_in_functionCall327); 
					// src/grammar/JavathonTreeWalker.g:63:29: ( exprList )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==EXP_LIST) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:63:29: exprList
							{
							pushFollow(FOLLOW_exprList_in_functionCall329);
							exprList();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:64:6: ^( FUNC_CALL Println ( expression )? )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall341); 
					match(input, Token.DOWN, null); 
					match(input,Println,FOLLOW_Println_in_functionCall343); 
					// src/grammar/JavathonTreeWalker.g:64:26: ( expression )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( ((LA6_0 >= Add && LA6_0 <= And)||LA6_0==Bool||LA6_0==Divide||LA6_0==Equals||(LA6_0 >= GT && LA6_0 <= GTEquals)||LA6_0==In||(LA6_0 >= LOOKUP && LA6_0 <= Number)||(LA6_0 >= Or && LA6_0 <= Pow)||(LA6_0 >= Subtract && LA6_0 <= TERNARY)||LA6_0==UNARY_MIN) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:64:26: expression
							{
							pushFollow(FOLLOW_expression_in_functionCall345);
							expression8=expression();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					node = new PrintlnNode(expression8);
					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:65:6: ^( FUNC_CALL Print expression )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall362); 
					match(input, Token.DOWN, null); 
					match(input,Print,FOLLOW_Print_in_functionCall364); 
					pushFollow(FOLLOW_expression_in_functionCall366);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:66:6: ^( FUNC_CALL Assert expression )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall377); 
					match(input, Token.DOWN, null); 
					match(input,Assert,FOLLOW_Assert_in_functionCall379); 
					pushFollow(FOLLOW_expression_in_functionCall381);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// src/grammar/JavathonTreeWalker.g:67:6: ^( FUNC_CALL Size expression )
					{
					match(input,FUNC_CALL,FOLLOW_FUNC_CALL_in_functionCall392); 
					match(input, Token.DOWN, null); 
					match(input,Size,FOLLOW_Size_in_functionCall394); 
					pushFollow(FOLLOW_expression_in_functionCall396);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "functionCall"



	// $ANTLR start "ifStatement"
	// src/grammar/JavathonTreeWalker.g:70:1: ifStatement returns [JNode node] : ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? ) ;
	public final JNode ifStatement() throws RecognitionException {
		JNode node = null;


		JNode b1 =null;
		JNode b2 =null;
		JNode expression9 =null;

		 
		  IfNode ifNode = new IfNode(); 
		  node = ifNode; 

		try {
			// src/grammar/JavathonTreeWalker.g:75:3: ( ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? ) )
			// src/grammar/JavathonTreeWalker.g:75:6: ^( IF ( ^( EXP expression b1= block ) )+ ( ^( EXP b2= block ) )? )
			{
			match(input,IF,FOLLOW_IF_in_ifStatement432); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:76:8: ( ^( EXP expression b1= block ) )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==EXP) ) {
					int LA8_1 = input.LA(2);
					if ( (LA8_1==DOWN) ) {
						int LA8_3 = input.LA(3);
						if ( ((LA8_3 >= Add && LA8_3 <= And)||LA8_3==Bool||LA8_3==Divide||LA8_3==Equals||(LA8_3 >= GT && LA8_3 <= GTEquals)||LA8_3==In||(LA8_3 >= LOOKUP && LA8_3 <= Number)||(LA8_3 >= Or && LA8_3 <= Pow)||(LA8_3 >= Subtract && LA8_3 <= TERNARY)||LA8_3==UNARY_MIN) ) {
							alt8=1;
						}

					}

				}

				switch (alt8) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:76:9: ^( EXP expression b1= block )
					{
					match(input,EXP,FOLLOW_EXP_in_ifStatement446); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_ifStatement448);
					expression9=expression();
					state._fsp--;

					pushFollow(FOLLOW_block_in_ifStatement452);
					b1=block();
					state._fsp--;

					match(input, Token.UP, null); 

					ifNode.addChoice(expression9,b1);
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			// src/grammar/JavathonTreeWalker.g:77:8: ( ^( EXP b2= block ) )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==EXP) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:77:9: ^( EXP b2= block )
					{
					match(input,EXP,FOLLOW_EXP_in_ifStatement471); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_block_in_ifStatement475);
					b2=block();
					state._fsp--;

					match(input, Token.UP, null); 

					ifNode.addChoice(new AtomNode(true),b2);
					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "whileStatement"
	// src/grammar/JavathonTreeWalker.g:81:1: whileStatement returns [JNode node] : ^( While expression block ) ;
	public final JNode whileStatement() throws RecognitionException {
		JNode node = null;


		try {
			// src/grammar/JavathonTreeWalker.g:82:3: ( ^( While expression block ) )
			// src/grammar/JavathonTreeWalker.g:82:6: ^( While expression block )
			{
			match(input,While,FOLLOW_While_in_whileStatement524); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_whileStatement526);
			expression();
			state._fsp--;

			pushFollow(FOLLOW_block_in_whileStatement528);
			block();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "whileStatement"



	// $ANTLR start "idList"
	// src/grammar/JavathonTreeWalker.g:85:1: idList : ^( ID_LIST ( Identifier )+ ) ;
	public final void idList() throws RecognitionException {
		try {
			// src/grammar/JavathonTreeWalker.g:86:3: ( ^( ID_LIST ( Identifier )+ ) )
			// src/grammar/JavathonTreeWalker.g:86:6: ^( ID_LIST ( Identifier )+ )
			{
			match(input,ID_LIST,FOLLOW_ID_LIST_in_idList552); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:86:16: ( Identifier )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Identifier) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:86:16: Identifier
					{
					match(input,Identifier,FOLLOW_Identifier_in_idList554); 
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "idList"



	// $ANTLR start "exprList"
	// src/grammar/JavathonTreeWalker.g:89:1: exprList : ^( EXP_LIST ( expression )+ ) ;
	public final void exprList() throws RecognitionException {
		try {
			// src/grammar/JavathonTreeWalker.g:90:3: ( ^( EXP_LIST ( expression )+ ) )
			// src/grammar/JavathonTreeWalker.g:90:6: ^( EXP_LIST ( expression )+ )
			{
			match(input,EXP_LIST,FOLLOW_EXP_LIST_in_exprList579); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:90:17: ( expression )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= Add && LA11_0 <= And)||LA11_0==Bool||LA11_0==Divide||LA11_0==Equals||(LA11_0 >= GT && LA11_0 <= GTEquals)||LA11_0==In||(LA11_0 >= LOOKUP && LA11_0 <= Number)||(LA11_0 >= Or && LA11_0 <= Pow)||(LA11_0 >= Subtract && LA11_0 <= TERNARY)||LA11_0==UNARY_MIN) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:90:17: expression
					{
					pushFollow(FOLLOW_expression_in_exprList581);
					expression();
					state._fsp--;

					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exprList"



	// $ANTLR start "expression"
	// src/grammar/JavathonTreeWalker.g:93:1: expression returns [JNode node] : ( ^( TERNARY expression expression expression ) | ^( In expression expression ) | ^( '||' a= expression b= expression ) | ^( '&&' a= expression b= expression ) | ^( '==' a= expression b= expression ) | ^( '!=' a= expression b= expression ) | ^( '>=' a= expression b= expression ) | ^( '<=' a= expression b= expression ) | ^( '>' a= expression b= expression ) | ^( '<' a= expression b= expression ) | ^( '+' a= expression b= expression ) | ^( '-' a= expression b= expression ) | ^( '*' a= expression b= expression ) | ^( '/' a= expression b= expression ) | ^( '%' a= expression b= expression ) | ^( '^' a= expression b= expression ) | ^( UNARY_MIN a= expression ) | ^( NEGATE a= expression ) | Number | Bool | Null | lookup );
	public final JNode expression() throws RecognitionException {
		JNode node = null;


		CommonTree Number10=null;
		CommonTree Bool11=null;
		JNode a =null;
		JNode b =null;
		JNode lookup12 =null;

		try {
			// src/grammar/JavathonTreeWalker.g:94:3: ( ^( TERNARY expression expression expression ) | ^( In expression expression ) | ^( '||' a= expression b= expression ) | ^( '&&' a= expression b= expression ) | ^( '==' a= expression b= expression ) | ^( '!=' a= expression b= expression ) | ^( '>=' a= expression b= expression ) | ^( '<=' a= expression b= expression ) | ^( '>' a= expression b= expression ) | ^( '<' a= expression b= expression ) | ^( '+' a= expression b= expression ) | ^( '-' a= expression b= expression ) | ^( '*' a= expression b= expression ) | ^( '/' a= expression b= expression ) | ^( '%' a= expression b= expression ) | ^( '^' a= expression b= expression ) | ^( UNARY_MIN a= expression ) | ^( NEGATE a= expression ) | Number | Bool | Null | lookup )
			int alt12=22;
			switch ( input.LA(1) ) {
			case TERNARY:
				{
				alt12=1;
				}
				break;
			case In:
				{
				alt12=2;
				}
				break;
			case Or:
				{
				alt12=3;
				}
				break;
			case And:
				{
				alt12=4;
				}
				break;
			case Equals:
				{
				alt12=5;
				}
				break;
			case NEquals:
				{
				alt12=6;
				}
				break;
			case GTEquals:
				{
				alt12=7;
				}
				break;
			case LTEquals:
				{
				alt12=8;
				}
				break;
			case GT:
				{
				alt12=9;
				}
				break;
			case LT:
				{
				alt12=10;
				}
				break;
			case Add:
				{
				alt12=11;
				}
				break;
			case Subtract:
				{
				alt12=12;
				}
				break;
			case Multiply:
				{
				alt12=13;
				}
				break;
			case Divide:
				{
				alt12=14;
				}
				break;
			case Modulus:
				{
				alt12=15;
				}
				break;
			case Pow:
				{
				alt12=16;
				}
				break;
			case UNARY_MIN:
				{
				alt12=17;
				}
				break;
			case NEGATE:
				{
				alt12=18;
				}
				break;
			case Number:
				{
				alt12=19;
				}
				break;
			case Bool:
				{
				alt12=20;
				}
				break;
			case Null:
				{
				alt12=21;
				}
				break;
			case LOOKUP:
				{
				alt12=22;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:94:6: ^( TERNARY expression expression expression )
					{
					match(input,TERNARY,FOLLOW_TERNARY_in_expression610); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression612);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression614);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression616);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:95:6: ^( In expression expression )
					{
					match(input,In,FOLLOW_In_in_expression627); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression629);
					expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression631);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new InNode		(a, b);
					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:96:6: ^( '||' a= expression b= expression )
					{
					match(input,Or,FOLLOW_Or_in_expression650); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression654);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression658);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new OrNode		(a, b);
					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:97:6: ^( '&&' a= expression b= expression )
					{
					match(input,And,FOLLOW_And_in_expression677); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression681);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression685);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new AndNode		(a, b);
					}
					break;
				case 5 :
					// src/grammar/JavathonTreeWalker.g:98:6: ^( '==' a= expression b= expression )
					{
					match(input,Equals,FOLLOW_Equals_in_expression704); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression708);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression712);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new EqNode		(a, b);
					}
					break;
				case 6 :
					// src/grammar/JavathonTreeWalker.g:99:6: ^( '!=' a= expression b= expression )
					{
					match(input,NEquals,FOLLOW_NEquals_in_expression731); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression735);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression739);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new NENode		(a, b);
					}
					break;
				case 7 :
					// src/grammar/JavathonTreeWalker.g:100:6: ^( '>=' a= expression b= expression )
					{
					match(input,GTEquals,FOLLOW_GTEquals_in_expression758); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression762);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression766);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new GTENode		(a, b);
					}
					break;
				case 8 :
					// src/grammar/JavathonTreeWalker.g:101:6: ^( '<=' a= expression b= expression )
					{
					match(input,LTEquals,FOLLOW_LTEquals_in_expression783); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression787);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression791);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new LTENode		(a, b);
					}
					break;
				case 9 :
					// src/grammar/JavathonTreeWalker.g:102:6: ^( '>' a= expression b= expression )
					{
					match(input,GT,FOLLOW_GT_in_expression808); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression812);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression816);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new GTNode		(a, b);
					}
					break;
				case 10 :
					// src/grammar/JavathonTreeWalker.g:103:6: ^( '<' a= expression b= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression843); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression847);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression851);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new LTNode		(a, b);
					}
					break;
				case 11 :
					// src/grammar/JavathonTreeWalker.g:104:6: ^( '+' a= expression b= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression877); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression881);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression885);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new AddNode		(a, b);
					}
					break;
				case 12 :
					// src/grammar/JavathonTreeWalker.g:105:6: ^( '-' a= expression b= expression )
					{
					match(input,Subtract,FOLLOW_Subtract_in_expression908); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression912);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression916);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new MinusNode 	(a, b);
					}
					break;
				case 13 :
					// src/grammar/JavathonTreeWalker.g:106:6: ^( '*' a= expression b= expression )
					{
					match(input,Multiply,FOLLOW_Multiply_in_expression943); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression947);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression951);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new MultiplyNode 	(a, b);
					}
					break;
				case 14 :
					// src/grammar/JavathonTreeWalker.g:107:6: ^( '/' a= expression b= expression )
					{
					match(input,Divide,FOLLOW_Divide_in_expression978); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression982);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression986);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new DivideNode 	(a, b);
					}
					break;
				case 15 :
					// src/grammar/JavathonTreeWalker.g:108:6: ^( '%' a= expression b= expression )
					{
					match(input,Modulus,FOLLOW_Modulus_in_expression1013); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1017);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1021);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new ModuloNode 	(a, b);
					}
					break;
				case 16 :
					// src/grammar/JavathonTreeWalker.g:109:6: ^( '^' a= expression b= expression )
					{
					match(input,Pow,FOLLOW_Pow_in_expression1048); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1052);
					a=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1056);
					b=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new PowerNode 	(a, b);
					}
					break;
				case 17 :
					// src/grammar/JavathonTreeWalker.g:110:6: ^( UNARY_MIN a= expression )
					{
					match(input,UNARY_MIN,FOLLOW_UNARY_MIN_in_expression1101); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1105);
					a=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new UnaryMinNode 	(a);
					}
					break;
				case 18 :
					// src/grammar/JavathonTreeWalker.g:111:6: ^( NEGATE a= expression )
					{
					match(input,NEGATE,FOLLOW_NEGATE_in_expression1155); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1159);
					a=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new NegateNode	(a);
					}
					break;
				case 19 :
					// src/grammar/JavathonTreeWalker.g:112:6: Number
					{
					Number10=(CommonTree)match(input,Number,FOLLOW_Number_in_expression1195); 
					node = new AtomNode		(Double.parseDouble((Number10!=null?Number10.getText():null)));
					}
					break;
				case 20 :
					// src/grammar/JavathonTreeWalker.g:113:6: Bool
					{
					Bool11=(CommonTree)match(input,Bool,FOLLOW_Bool_in_expression1238); 
					node = new AtomNode		(Boolean.parseBoolean((Bool11!=null?Bool11.getText():null)));
					}
					break;
				case 21 :
					// src/grammar/JavathonTreeWalker.g:114:6: Null
					{
					match(input,Null,FOLLOW_Null_in_expression1291); 
					node = new AtomNode		(null);
					}
					break;
				case 22 :
					// src/grammar/JavathonTreeWalker.g:115:6: lookup
					{
					pushFollow(FOLLOW_lookup_in_expression1314);
					lookup12=lookup();
					state._fsp--;

					node = lookup12;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "expression"



	// $ANTLR start "list"
	// src/grammar/JavathonTreeWalker.g:118:1: list : ^( LIST ( exprList )? ) ;
	public final void list() throws RecognitionException {
		try {
			// src/grammar/JavathonTreeWalker.g:119:3: ( ^( LIST ( exprList )? ) )
			// src/grammar/JavathonTreeWalker.g:119:6: ^( LIST ( exprList )? )
			{
			match(input,LIST,FOLLOW_LIST_in_list1359); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/grammar/JavathonTreeWalker.g:119:13: ( exprList )?
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==EXP_LIST) ) {
					alt13=1;
				}
				switch (alt13) {
					case 1 :
						// src/grammar/JavathonTreeWalker.g:119:13: exprList
						{
						pushFollow(FOLLOW_exprList_in_list1361);
						exprList();
						state._fsp--;

						}
						break;

				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "list"



	// $ANTLR start "lookup"
	// src/grammar/JavathonTreeWalker.g:122:1: lookup returns [JNode node] : ( ^( LOOKUP functionCall ( indexes )? ) | ^( LOOKUP list ( indexes )? ) | ^( LOOKUP expression ( indexes )? ) | ^( LOOKUP i= Identifier (x= indexes )? ) | ^( LOOKUP s= String (x= indexes )? ) );
	public final JNode lookup() throws RecognitionException {
		JNode node = null;


		CommonTree i=null;
		CommonTree s=null;
		List<JNode> x =null;

		try {
			// src/grammar/JavathonTreeWalker.g:123:3: ( ^( LOOKUP functionCall ( indexes )? ) | ^( LOOKUP list ( indexes )? ) | ^( LOOKUP expression ( indexes )? ) | ^( LOOKUP i= Identifier (x= indexes )? ) | ^( LOOKUP s= String (x= indexes )? ) )
			int alt19=5;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==LOOKUP) ) {
				int LA19_1 = input.LA(2);
				if ( (LA19_1==DOWN) ) {
					switch ( input.LA(3) ) {
					case Identifier:
						{
						alt19=4;
						}
						break;
					case String:
						{
						alt19=5;
						}
						break;
					case FUNC_CALL:
						{
						alt19=1;
						}
						break;
					case LIST:
						{
						alt19=2;
						}
						break;
					case Add:
					case And:
					case Bool:
					case Divide:
					case Equals:
					case GT:
					case GTEquals:
					case In:
					case LOOKUP:
					case LT:
					case LTEquals:
					case Modulus:
					case Multiply:
					case NEGATE:
					case NEquals:
					case Null:
					case Number:
					case Or:
					case Pow:
					case Subtract:
					case TERNARY:
					case UNARY_MIN:
						{
						alt19=3;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 19, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:123:6: ^( LOOKUP functionCall ( indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1390); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_functionCall_in_lookup1392);
					functionCall();
					state._fsp--;

					// src/grammar/JavathonTreeWalker.g:123:28: ( indexes )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==INDEXES) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:123:28: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1394);
							indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// src/grammar/JavathonTreeWalker.g:124:6: ^( LOOKUP list ( indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1406); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_list_in_lookup1408);
					list();
					state._fsp--;

					// src/grammar/JavathonTreeWalker.g:124:20: ( indexes )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==INDEXES) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:124:20: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1410);
							indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// src/grammar/JavathonTreeWalker.g:125:6: ^( LOOKUP expression ( indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1422); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_lookup1424);
					expression();
					state._fsp--;

					// src/grammar/JavathonTreeWalker.g:125:26: ( indexes )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==INDEXES) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:125:26: indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1426);
							indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// src/grammar/JavathonTreeWalker.g:126:6: ^( LOOKUP i= Identifier (x= indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1439); 
					match(input, Token.DOWN, null); 
					i=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_lookup1443); 
					// src/grammar/JavathonTreeWalker.g:126:29: (x= indexes )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==INDEXES) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:126:29: x= indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1447);
							x=indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					        node = (x != null) 
					          ? new LookupNode(new IdentifierNode((i!=null?i.getText():null), currentScope), x) 
					          : new IdentifierNode((i!=null?i.getText():null), currentScope); 
					      
					}
					break;
				case 5 :
					// src/grammar/JavathonTreeWalker.g:132:6: ^( LOOKUP s= String (x= indexes )? )
					{
					match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup1467); 
					match(input, Token.DOWN, null); 
					s=(CommonTree)match(input,String,FOLLOW_String_in_lookup1471); 
					// src/grammar/JavathonTreeWalker.g:132:25: (x= indexes )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==INDEXES) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// src/grammar/JavathonTreeWalker.g:132:25: x= indexes
							{
							pushFollow(FOLLOW_indexes_in_lookup1475);
							x=indexes();
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					  	  	System.out.println("String: " + (s!=null?s.getText():null));
					        node = new StringNode((s!=null?s.getText():null), x);
					      
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return node;
	}
	// $ANTLR end "lookup"



	// $ANTLR start "indexes"
	// src/grammar/JavathonTreeWalker.g:139:1: indexes returns [List<JNode> e] : ^( INDEXES ( expression )+ ) ;
	public final List<JNode> indexes() throws RecognitionException {
		List<JNode> e = null;


		JNode expression13 =null;

		e = new ArrayList<JNode>();
		try {
			// src/grammar/JavathonTreeWalker.g:141:3: ( ^( INDEXES ( expression )+ ) )
			// src/grammar/JavathonTreeWalker.g:141:6: ^( INDEXES ( expression )+ )
			{
			match(input,INDEXES,FOLLOW_INDEXES_in_indexes1518); 
			match(input, Token.DOWN, null); 
			// src/grammar/JavathonTreeWalker.g:141:16: ( expression )+
			int cnt20=0;
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( ((LA20_0 >= Add && LA20_0 <= And)||LA20_0==Bool||LA20_0==Divide||LA20_0==Equals||(LA20_0 >= GT && LA20_0 <= GTEquals)||LA20_0==In||(LA20_0 >= LOOKUP && LA20_0 <= Number)||(LA20_0 >= Or && LA20_0 <= Pow)||(LA20_0 >= Subtract && LA20_0 <= TERNARY)||LA20_0==UNARY_MIN) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// src/grammar/JavathonTreeWalker.g:141:17: expression
					{
					pushFollow(FOLLOW_expression_in_indexes1521);
					expression13=expression();
					state._fsp--;

					e.add(expression13);
					}
					break;

				default :
					if ( cnt20 >= 1 ) break loop20;
					EarlyExitException eee = new EarlyExitException(20, input);
					throw eee;
				}
				cnt20++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return e;
	}
	// $ANTLR end "indexes"

	// Delegated rules



	public static final BitSet FOLLOW_block_in_walk70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block113 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_STATEMENTS_in_block128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_block131 = new BitSet(new long[]{0x0000000210000018L,0x0000000000000010L});
	public static final BitSet FOLLOW_RETURN_in_block153 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_block160 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_assignment_in_statement202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionCall_in_statement217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStatement_in_statement245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_assignment274 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_assignment278 = new BitSet(new long[]{0x0031FF24C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_indexes_in_assignment282 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_assignment287 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall325 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_functionCall327 = new BitSet(new long[]{0x0000000000400008L});
	public static final BitSet FOLLOW_exprList_in_functionCall329 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall341 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Println_in_functionCall343 = new BitSet(new long[]{0x0031FF20C2080468L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall345 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall362 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Print_in_functionCall364 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall366 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall377 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Assert_in_functionCall379 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall381 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_CALL_in_functionCall392 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Size_in_functionCall394 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_functionCall396 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_in_ifStatement432 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_EXP_in_ifStatement446 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifStatement448 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_block_in_ifStatement452 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXP_in_ifStatement471 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_block_in_ifStatement475 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_While_in_whileStatement524 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_whileStatement526 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_block_in_whileStatement528 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_LIST_in_idList552 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_idList554 = new BitSet(new long[]{0x0000000800000008L});
	public static final BitSet FOLLOW_EXP_LIST_in_exprList579 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_exprList581 = new BitSet(new long[]{0x0031FF20C2080468L,0x000000000000000BL});
	public static final BitSet FOLLOW_TERNARY_in_expression610 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression612 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression614 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression616 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_In_in_expression627 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression629 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression631 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Or_in_expression650 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression654 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression658 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression677 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression681 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression685 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equals_in_expression704 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression708 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression712 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEquals_in_expression731 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression735 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression739 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEquals_in_expression758 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression762 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression766 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEquals_in_expression783 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression787 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression791 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression808 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression812 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression816 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression843 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression847 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression851 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression877 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression881 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression885 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Subtract_in_expression908 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression912 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression916 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Multiply_in_expression943 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression947 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression951 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Divide_in_expression978 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression982 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression986 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Modulus_in_expression1013 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1017 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression1021 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Pow_in_expression1048 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1052 = new BitSet(new long[]{0x0031FF20C2080460L,0x000000000000000BL});
	public static final BitSet FOLLOW_expression_in_expression1056 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MIN_in_expression1101 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1105 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATE_in_expression1155 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1159 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Number_in_expression1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_expression1238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Null_in_expression1291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lookup_in_expression1314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIST_in_list1359 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_exprList_in_list1361 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1390 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_functionCall_in_lookup1392 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1394 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1406 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_list_in_lookup1408 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1410 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1422 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_lookup1424 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1426 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1439 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Identifier_in_lookup1443 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1447 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup1467 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_String_in_lookup1471 = new BitSet(new long[]{0x0000000400000008L});
	public static final BitSet FOLLOW_indexes_in_lookup1475 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INDEXES_in_indexes1518 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_indexes1521 = new BitSet(new long[]{0x0031FF20C2080468L,0x000000000000000BL});
}
>>>>>>> refs/remotes/origin/master
