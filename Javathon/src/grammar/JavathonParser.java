package grammar;

// $ANTLR 3.5.1 Javathon.g 2013-12-15 16:28:40

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JavathonParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Comma", "LineBreak", "QuotedValue", 
		"SimpleValue"
	};
	public static final int EOF=-1;
	public static final int Comma=4;
	public static final int LineBreak=5;
	public static final int QuotedValue=6;
	public static final int SimpleValue=7;

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



	// $ANTLR start "file"
	// Javathon.g:3:1: file : ( row )+ EOF ;
	public final void file() throws RecognitionException {
		try {
			// Javathon.g:4:3: ( ( row )+ EOF )
			// Javathon.g:4:6: ( row )+ EOF
			{
			// Javathon.g:4:6: ( row )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= QuotedValue && LA1_0 <= SimpleValue)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Javathon.g:4:6: row
					{
					pushFollow(FOLLOW_row_in_file15);
					row();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input,EOF,FOLLOW_EOF_in_file18); 
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
	// $ANTLR end "file"



	// $ANTLR start "row"
	// Javathon.g:7:1: row : value ( Comma value )* ( LineBreak | EOF ) ;
	public final void row() throws RecognitionException {
		try {
			// Javathon.g:8:3: ( value ( Comma value )* ( LineBreak | EOF ) )
			// Javathon.g:8:6: value ( Comma value )* ( LineBreak | EOF )
			{
			pushFollow(FOLLOW_value_in_row40);
			value();
			state._fsp--;

			// Javathon.g:8:12: ( Comma value )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==Comma) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Javathon.g:8:13: Comma value
					{
					match(input,Comma,FOLLOW_Comma_in_row43); 
					pushFollow(FOLLOW_value_in_row45);
					value();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			if ( input.LA(1)==EOF||input.LA(1)==LineBreak ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
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
	// $ANTLR end "row"



	// $ANTLR start "value"
	// Javathon.g:11:1: value : ( SimpleValue | QuotedValue );
	public final void value() throws RecognitionException {
		try {
			// Javathon.g:12:3: ( SimpleValue | QuotedValue )
			// Javathon.g:
			{
			if ( (input.LA(1) >= QuotedValue && input.LA(1) <= SimpleValue) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
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
	// $ANTLR end "value"

	// Delegated rules



	public static final BitSet FOLLOW_row_in_file15 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_EOF_in_file18 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_row40 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_Comma_in_row43 = new BitSet(new long[]{0x00000000000000C0L});
	public static final BitSet FOLLOW_value_in_row45 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_set_in_row49 = new BitSet(new long[]{0x0000000000000002L});
}
