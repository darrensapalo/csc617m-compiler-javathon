package main.javathon;

import main.javathon.JValue;  

import java.util.List;  
  
public class AndNode implements JNode {  
  
    private JNode lhs;  
    private JNode rhs;  

    public AndNode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        // boolean && boolean  
        if(a.isBoolean() && b.isBoolean()) {  
            return new JValue(a.asBoolean() && b.asBoolean());  
        }  
        
        // lhs is false: return false
        if (a.isBoolean() && !a.asBoolean()) {
            return new JValue(false);
        }
        
        // rhs is false: return false
        if (b.isBoolean() && !b.asBoolean()) {
            return new JValue(false);
        }
        
        
        // return rhs
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
        
        throw new RuntimeException("illegal expression: " + this);
    }  

    @Override  
    public String toString() {  
        return String.format("(%s && %s)", lhs, rhs);  
    }  
}  