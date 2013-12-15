package main.javathon;
 

import java.util.ArrayList;  
import java.util.List;  
  
public class IfNode implements JNode {  
  
  private List<Choice> choices;  
  
  public IfNode() {  
    choices = new ArrayList<Choice>();  
  }  
  
  public void addChoice(JNode e, JNode b) {  
    choices.add(new Choice(e, b));  
  }  
  
  @Override  
  public JValue evaluate() {  
  
    for(Choice ch : choices) {  
      JValue value = ch.expression.evaluate();  
  
      if(!value.isBoolean()) {  
        throw new RuntimeException("illegal boolean expression " +   
            "inside if-statement: " + ch.expression);  
      }  
  
      if(value.asBoolean()) {  
        return ch.block.evaluate();  
      }  
    }  
  
    return JValue.VOID;  
  }  
  
  private class Choice {  
  
    JNode expression;  
    JNode block;  
  
    Choice(JNode e, JNode b) {  
      expression = e;  
      block = b;  
    }  
  }  
}  