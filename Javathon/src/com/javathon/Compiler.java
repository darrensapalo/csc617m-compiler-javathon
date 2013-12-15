package com.javathon;

import java.io.File;
import java.util.Scanner;

import grammar.JavathonLexer;
import grammar.JavathonParser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;


/**
 * To run the program with the appropriate grammar building,
 * run compilegrammar.bat.
 * @author Darren
 *
 */
public class Compiler {
	public static void main(String[] args) throws Exception {
		// the input source
		String source = "Darren is x = 52 but what";
		File f = new File("test.txt");
		Scanner s = new Scanner(f);
		
		StringBuilder sb = new StringBuilder();
		while(s.hasNext())
			sb.append(s.nextLine());
		
		// create an instance of the lexer
		JavathonLexer lexer = new JavathonLexer(new ANTLRStringStream(sb.toString()));

		// wrap a token-stream around the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create the parser
		JavathonParser parser = new JavathonParser(tokens);

		// invoke the entry point of our grammar
		parser.parse();

	}
}