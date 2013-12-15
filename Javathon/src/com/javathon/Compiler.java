package com.javathon;

import grammar.JavathonLexer;
import grammar.JavathonParser;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;


/**
 * To run the program with the appropriate grammar building,
 * run compilegrammar.bat.
 * @author Darren
 *
 */
public class Compiler {
	public static void main(String[] args) throws Exception {
		
		// create an instance of the lexer
		JavathonLexer lexer = new JavathonLexer(new ANTLRFileStream("test.txt"));

		// wrap a token-stream around the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create the parser
		JavathonParser parser = new JavathonParser(tokens);

		// invoke the entry point of our grammar
		parser.parse();

	}
}