package main.javathon;

import java.io.PrintStream;  
/*
 * Handles an output stream.
 */
public class PrintNode implements JNode {  
  
  private JNode expression;  
  private PrintStream out;  
  
  public PrintNode(JNode e) {  
    this(e, System.out);  
  }  
  
  public PrintNode(JNode e, PrintStream o) {  
    expression = e;  
    out = o;  
  }  
  
  @Override  
  public JValue evaluate() {  
    JValue value = expression.evaluate();  
    out.print(value);  
    return JValue.VOID;  
  }  
}  