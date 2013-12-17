package main.javathon;

import main.javathon.JValue;  
import java.util.List;  
  
public class AddNode implements JNode {  
  
    private JNode lhs;  
    private JNode rhs;  

    public AddNode(JNode lhs, JNode rhs) {  
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  

        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        // number + number  
        if(a.isNumber() && b.isNumber()) {  
            return new JValue(a.asDouble() + b.asDouble());  
        }  

        // list + any  
        if(a.isList()) {  
            List<JValue> list = a.asList();  
            list.add(b);  
            return new JValue(list);  
        }  

        // string + any  
        if(a.isString()) {  
            return new JValue(a.asString() + "" + b.toString());  
        }  

        // any + string  
        if(b.isString()) {  
            return new JValue(a.toString() + "" + b.asString());  
        }  

        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s + %s)", lhs, rhs);  
    }  
}  