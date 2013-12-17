package main.javathon;

/**
 * A class that handles division
 * @author Darren
 *
 */
public class DivideNode implements JNode {

    private JNode lhs;  
    private JNode rhs;  
    
    public DivideNode(JNode lhs, JNode rhs) {  
      this.lhs = lhs;  
      this.rhs = rhs;  
    }  
    
    @Override  
    public JValue evaluate() {  
    
      JValue a = lhs.evaluate();  
      JValue b = rhs.evaluate();  
    
      /* Currently, the only interesting thing 
       * we could think of for division is 
       * numerical division.
       */  
      if(a.isNumber() && b.isNumber()) {  
        return new JValue(a.asDouble() / b.asDouble());  
      }  
        
      throw new RuntimeException("Illegal expression: " + this);  
    }  
    
    @Override  
    public String toString() {  
      return String.format("(%s / %s)", lhs, rhs);  
    }  
}
