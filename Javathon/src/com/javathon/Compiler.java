package com.javathon;

import grammar.JavathonLexer;
import grammar.JavathonParser;

import org.antlr.runtime.*;  
  

/**
 * Before the program works, you need to compile the grammar file (.g).
 * 
 * To do so, (1) run the "compilegrammar.bat" file.
 * This uses antlr to produce the .java file and the .tokens file.
 * 
 * (2) Next, press F5 on the Package Explorer on the left. This will produce
 * an error in the Javathon.java file in the grammar package. This is because
 * step 1 merely produces the file. It was not imported into the correct package
 * yet.
 * 
 * (3) Go to Javathon.java, find the line error, and set the package details
 * by pressing CTRL + 1 and select "Add package declaration 'grammar' "
 * 
 * (4) Done! You may now run the program
 * @author Darren
 *
 */
public class Compiler {  
  public static void main(String[] args) throws Exception {  
    // the input source  
    String source =   
        "a,\"b,c";  
          
    // create an instance of the lexer
    JavathonLexer lexer = new JavathonLexer(new ANTLRStringStream(source));  
          
    // wrap a token-stream around the lexer  
    CommonTokenStream tokens = new CommonTokenStream(lexer);  
      
    JavathonParser parser = new JavathonParser(tokens);
    
    parser.file();
  }  
}  