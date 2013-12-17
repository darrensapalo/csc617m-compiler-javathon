package main.javathon;

import java.util.List;

public class MultiplyNode implements JNode {
    private JNode lhs;  
    private JNode rhs;  

    public MultiplyNode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override
    public JValue evaluate() {

        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  
        
        // number - number  
        if(a.isNumber() && b.isNumber()) {  
            return new JValue(a.asDouble() * b.asDouble());  
        }  

        // string * number: "ab" * 3 = "ababab"
        if(a.isString() && a.isNumber() && b.asDouble().intValue() >= 0) {
            int iterations = b.asDouble().intValue();
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < iterations; i++) {
                string.append(a.asString());
            }
            return new JValue(string.toString());  
        }  

        // list - any  
        if(a.isList()) {  
            List<JValue> list = a.asList();  
            list.remove(b);  
            return new JValue(list);  
        }  

        throw new RuntimeException("illegal expression: " + this);  
    }
    
    
    @Override  
    public String toString() {  
      return String.format("(%s * %s)", lhs, rhs);  
    }  
}
