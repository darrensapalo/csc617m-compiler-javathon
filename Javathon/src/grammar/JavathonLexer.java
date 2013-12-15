package grammar;

// $ANTLR 3.5.1 Javathon.g 2013-12-15 16:28:41

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JavathonLexer extends Lexer {
	public static final int EOF=-1;
	public static final int Comma=4;
	public static final int LineBreak=5;
	public static final int QuotedValue=6;
	public static final int SimpleValue=7;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public JavathonLexer() {} 
	public JavathonLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public JavathonLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Javathon.g"; }

	// $ANTLR start "Comma"
	public final void mComma() throws RecognitionException {
		try {
			int _type = Comma;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Javathon.g:17:3: ( ',' )
			// Javathon.g:17:6: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Comma"

	// $ANTLR start "LineBreak"
	public final void mLineBreak() throws RecognitionException {
		try {
			int _type = LineBreak;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Javathon.g:21:3: ( ( '\\r' )? '\\n' | '\\r' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1=='\n') ) {
					alt2=1;
				}

				else {
					alt2=2;
				}

			}
			else if ( (LA2_0=='\n') ) {
				alt2=1;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// Javathon.g:21:6: ( '\\r' )? '\\n'
					{
					// Javathon.g:21:6: ( '\\r' )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0=='\r') ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// Javathon.g:21:6: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					}
					break;
				case 2 :
					// Javathon.g:22:6: '\\r'
					{
					match('\r'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LineBreak"

	// $ANTLR start "SimpleValue"
	public final void mSimpleValue() throws RecognitionException {
		try {
			int _type = SimpleValue;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Javathon.g:26:3: ( (~ ( ',' | '\\r' | '\\n' | '\"' ) )+ )
			// Javathon.g:26:6: (~ ( ',' | '\\r' | '\\n' | '\"' ) )+
			{
			// Javathon.g:26:6: (~ ( ',' | '\\r' | '\\n' | '\"' ) )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '+')||(LA3_0 >= '-' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Javathon.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '+')||(input.LA(1) >= '-' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SimpleValue"

	// $ANTLR start "QuotedValue"
	public final void mQuotedValue() throws RecognitionException {
		try {
			int _type = QuotedValue;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Javathon.g:30:3: ( '\"' ( '\"\"' |~ '\"' )* '\"' )
			// Javathon.g:30:6: '\"' ( '\"\"' |~ '\"' )* '\"'
			{
			match('\"'); 
			// Javathon.g:30:10: ( '\"\"' |~ '\"' )*
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\"') ) {
					int LA4_1 = input.LA(2);
					if ( (LA4_1=='\"') ) {
						alt4=1;
					}

				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// Javathon.g:30:11: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 2 :
					// Javathon.g:30:18: ~ '\"'
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QuotedValue"

	@Override
	public void mTokens() throws RecognitionException {
		// Javathon.g:1:8: ( Comma | LineBreak | SimpleValue | QuotedValue )
		int alt5=4;
		int LA5_0 = input.LA(1);
		if ( (LA5_0==',') ) {
			alt5=1;
		}
		else if ( (LA5_0=='\n'||LA5_0=='\r') ) {
			alt5=2;
		}
		else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '+')||(LA5_0 >= '-' && LA5_0 <= '\uFFFF')) ) {
			alt5=3;
		}
		else if ( (LA5_0=='\"') ) {
			alt5=4;
		}

		else {
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}

		switch (alt5) {
			case 1 :
				// Javathon.g:1:10: Comma
				{
				mComma(); 

				}
				break;
			case 2 :
				// Javathon.g:1:16: LineBreak
				{
				mLineBreak(); 

				}
				break;
			case 3 :
				// Javathon.g:1:26: SimpleValue
				{
				mSimpleValue(); 

				}
				break;
			case 4 :
				// Javathon.g:1:38: QuotedValue
				{
				mQuotedValue(); 

				}
				break;

		}
	}



}
