package main.javathon;

import java.util.List;

public class NegateNode implements JNode {
    private JNode expr;  
    
    public NegateNode(JNode expr) {  
        this.expr = expr;    
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = expr.evaluate();  
        
        // number + number  
        if(a.isBoolean()) {  
            return new JValue(!a.asBoolean());  
        }  
        
        // copies python's behavior of not
        if(a.isList() || a.isString() || a.isNumber()) {  
            return new JValue(false);  
        }  

        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(!%s)", expr);  
    }  
}
