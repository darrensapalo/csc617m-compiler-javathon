package main.javathon;

import java.io.PrintStream;  
  
public class PrintlnNode implements JNode {  
  
  private JNode expression;  
  private PrintStream out;  
  
  public PrintlnNode(JNode e) {  
    this(e, System.out);  
  }  
  
  public PrintlnNode(JNode e, PrintStream o) {  
    expression = e;  
    out = o;  
  }  
  
  @Override  
  public JValue evaluate() {  
    JValue value = expression.evaluate();  
    out.println(value);  
    return JValue.VOID;  
  }  
}  