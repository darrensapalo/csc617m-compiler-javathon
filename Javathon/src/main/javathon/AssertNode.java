package main.javathon;

import java.util.List;

public class AssertNode implements JNode {
    private JNode expr;  

    public AssertNode(JNode expr) {  
        this.expr = expr;    
    }  

    @Override  
    public JValue evaluate() {  

        JValue value = expr.evaluate();

        if(!value.isBoolean()) {
            throw new RuntimeException("assert(...) only takes boolean expressions");
        }

        if(!value.asBoolean()) {
            throw new AssertionError(expr.toString());
        }

        return JValue.VOID;  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s == %s)", expr);  
    }  
}
