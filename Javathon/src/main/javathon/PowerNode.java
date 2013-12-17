package main.javathon;

import java.util.List;

// LITERALLY MADE OF POWER
public class PowerNode implements JNode {
    private JNode lhs;  
    private JNode rhs;  

    public PowerNode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        // number + number  
        if(a.isNumber() && b.isNumber()) {  
            return new JValue(Math.pow(a.asDouble(), b.asDouble()));  
        }  

        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s ^ %s)", lhs, rhs);  
    } 
}
