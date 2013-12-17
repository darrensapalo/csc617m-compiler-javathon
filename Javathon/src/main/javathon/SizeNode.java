package main.javathon;

import java.util.List;

public class SizeNode implements JNode {
    private JNode expr;  
    private JNode rhs;  

    public SizeNode(JNode expr) {  
        this.expr = expr;    
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = expr.evaluate();  
        
        // - number  
        if(a.isNumber()) {  
            return new JValue(-a.asDouble());  
        }  
        
        // - string: -"Hello world" = "dlrow olleH". PALINDROMIC  
        if(a.isString()) {  
            return new JValue(new StringBuilder(a.asString()).reverse().toString());  
        }  

        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s + %s)", expr, rhs);  
    }  
}
