package grammar;

// $ANTLR 3.5.1 Javathon.g 2013-12-15 16:51:55

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JavathonParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Add", "And", "Assert", "Assign", 
		"Bool", "CBrace", "CBracket", "CParen", "Colon", "Comma", "Comment", "Def", 
		"Digit", "Divide", "Do", "Else", "End", "Equals", "Excl", "For", "GT", 
		"GTEquals", "Identifier", "If", "In", "Int", "LT", "LTEquals", "Modulus", 
		"Multiply", "NEquals", "Null", "Number", "OBrace", "OBracket", "OParen", 
		"Or", "Pow", "Print", "Println", "QMark", "Return", "SColon", "Size", 
		"Space", "String", "Subtract", "To", "While"
	};
	public static final int EOF=-1;
	public static final int Add=4;
	public static final int And=5;
	public static final int Assert=6;
	public static final int Assign=7;
	public static final int Bool=8;
	public static final int CBrace=9;
	public static final int CBracket=10;
	public static final int CParen=11;
	public static final int Colon=12;
	public static final int Comma=13;
	public static final int Comment=14;
	public static final int Def=15;
	public static final int Digit=16;
	public static final int Divide=17;
	public static final int Do=18;
	public static final int Else=19;
	public static final int End=20;
	public static final int Equals=21;
	public static final int Excl=22;
	public static final int For=23;
	public static final int GT=24;
	public static final int GTEquals=25;
	public static final int Identifier=26;
	public static final int If=27;
	public static final int In=28;
	public static final int Int=29;
	public static final int LT=30;
	public static final int LTEquals=31;
	public static final int Modulus=32;
	public static final int Multiply=33;
	public static final int NEquals=34;
	public static final int Null=35;
	public static final int Number=36;
	public static final int OBrace=37;
	public static final int OBracket=38;
	public static final int OParen=39;
	public static final int Or=40;
	public static final int Pow=41;
	public static final int Print=42;
	public static final int Println=43;
	public static final int QMark=44;
	public static final int Return=45;
	public static final int SColon=46;
	public static final int Size=47;
	public static final int Space=48;
	public static final int String=49;
	public static final int Subtract=50;
	public static final int To=51;
	public static final int While=52;

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

	@Override public String[] getTokenNames() { return JavathonParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Javathon.g"; }



	// $ANTLR start "parse"
	// Javathon.g:3:1: parse : (t= . )* EOF ;
	public final void parse() throws RecognitionException {
		Token t=null;

		try {
			// Javathon.g:4:3: ( (t= . )* EOF )
			// Javathon.g:4:6: (t= . )* EOF
			{
			// Javathon.g:4:6: (t= . )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= Add && LA1_0 <= While)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Javathon.g:4:7: t= .
					{
					t=input.LT(1);
					matchAny(input); 
					System.out.printf("text: %-7s  type: %s \n",  
					           (t!=null?t.getText():null), tokenNames[(t!=null?t.getType():0)]);
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_parse57); 
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
	// $ANTLR end "parse"

	// Delegated rules



	public static final BitSet FOLLOW_EOF_in_parse57 = new BitSet(new long[]{0x0000000000000002L});
}
