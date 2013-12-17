package main.javathon;

import main.javathon.JValue;  

import java.util.List;  
  
public class OrNode implements JNode {  
  
    private JNode lhs;  
    private JNode rhs;  

    public OrNode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        // boolean || boolean  
        if(a.isBoolean() && b.isBoolean()) {  
            return new JValue(a.asBoolean() || b.asBoolean());  
        }  
        
        // lhs is True: return true
        if (a.isBoolean() && a.asBoolean()) {
            return new JValue(true);
        }
        
        // lhs is False: return rhs
        if (a.isBoolean() && !a.asBoolean()) {
            if (b.isNumber()) {  
                return new JValue(b.asDouble());  
            }  
            
            if (b.isBoolean()) {  
                return new JValue(true);  
            }  
            
            if (b.isString()) {  
                return new JValue(b.asString());  
            }  
            
            if (b.isList()) {  
                return new JValue(b.asList());  
            }  
        }
        
        // return lhs
        if (a.isNumber()) {  
            return new JValue(a.asDouble());  
        }  
        
        if (a.isString()) {  
            return new JValue(a.asString());  
        }  
        
        if (a.isList()) {  
            return new JValue(a.asList());  
        }  
       
         
        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s || %s)", lhs, rhs);  
    }  
}  