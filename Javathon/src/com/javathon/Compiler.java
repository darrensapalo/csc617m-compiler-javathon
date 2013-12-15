package com.javathon;

import grammar.JavathonLexer;
import grammar.JavathonParser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

public class Compiler {
	public static void main(String[] args) throws Exception {
		// the input source
		String source = "Darren is x = 52 but what";

		// create an instance of the lexer
		JavathonLexer lexer = new JavathonLexer(new ANTLRStringStream(source));

		// wrap a token-stream around the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create the parser
		JavathonParser parser = new JavathonParser(tokens);

		// invoke the entry point of our grammar
		parser.parse();

	}
}