package main.javathon;

import java.util.List;

public class ModuloNode implements JNode {

    private JNode lhs;  
    private JNode rhs;  

    public ModuloNode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        // number % number  (forced integer)
        if(a.isNumber() && b.isNumber()) {  
            return new JValue(a.asDouble().intValue() % b.asDouble().intValue());  
        }  
        
        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s % %s)", lhs, rhs);  
    }  

}
