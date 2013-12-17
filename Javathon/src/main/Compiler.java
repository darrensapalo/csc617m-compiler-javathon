package main;

import grammar.JavathonLexer;
import grammar.JavathonParser;
import grammar.JavathonTreeWalker;
import main.javathon.JNode;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;


/**
 * To run the program properly, clean the project first (to remove bin files)
 * and then compile. It should run the ant script to compile the necessary 
 * grammar for the lexer and the parser.
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

	    // invoke the entry point of our parser and generate a DOT image of the tree  
	    CommonTree tree = (CommonTree)parser.parse().getTree();
	    
	    CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);  
	      
	    // pass the reference to the Map of functions to the tree walker  
	    JavathonTreeWalker walker = new JavathonTreeWalker(nodes, parser.functions);  
	      
	    // get the returned node   
	    JNode returned = walker.walk();  
	    System.out.println(returned == null ? "null" : returned.evaluate());  
	    
//	    DOTTreeGenerator gen = new DOTTreeGenerator();  
//	    StringTemplate st = gen.toDOT(tree);
//	    
//	    // Check out the graph by copy-pasting the result of this here:
//	    // http://graphviz-dev.appspot.com/
//	    System.out.println(st);  

	}
}