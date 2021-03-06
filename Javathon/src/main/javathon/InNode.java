package main.javathon;

import main.javathon.JValue;  

import java.util.List;  
  
public class InNode implements JNode {  
  
    private JNode lhs;  
    private JNode rhs;  

    public InNode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  
        
        JValue value = lhs.evaluate();  
        JValue container = rhs.evaluate();  

        if (container.isString()) {
            boolean contains = container.asString().contains(value.toString());
            return new JValue(contains);
        }else if (container.isList()) {
            boolean contains = false;
            for (JValue contained : container.asList()) {
                if (value.equals(contained)) { 
                    contains = true;
                    break;
                }
            }
            
            return new JValue(contains);
        }else
        	throw new RuntimeException("Illegal expression: " + this +". The container must either be a list or a string.");  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s in %s)", lhs, rhs);  
    }  
}  