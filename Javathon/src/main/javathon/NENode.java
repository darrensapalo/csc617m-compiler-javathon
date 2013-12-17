package main.javathon;

import main.javathon.JValue;  
import java.util.List;  
  
public class NENode implements JNode {  
  
    private JNode lhs;  
    private JNode rhs;  

    public NENode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s != %s)", lhs, rhs);  
    }  
}  