package main.javathon;

import java.util.List;


/**
 * 
 * This method allows the programmer to: <br /> 
 * Add values (numbers)  <br />
 * 5 + 4.5 <br /><br />
 * Add elements to lists<br />
 * [2,3,4] + 5 = [2,3,4,5]<br /><br />
 * Use a syntactic sugar for the && keyword<br />
 *(false + true) == (false && true)<br /><br />
 * Concatenate anything with a string<br />
 * "Test" + "test" + 1<br /><br />
 * 
 * @author Darren
 *
 */
public class AddNode implements JNode {  
  
    private JNode lhs;  
    private JNode rhs;  

    public AddNode(JNode lhs, JNode rhs) {
    	/* Receive two expressions */
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  
    	
    	/* Evaluate their values */
        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        /* Determine their type and do the appropriate operation */
        
        
        if(a.isNumber() && b.isNumber()) {  // Number addition  
            return new JValue(a.asDouble() + b.asDouble());  
        }  
        
        if(a.isList()) { // Adding element to list  
            List<JValue> list = a.asList();  
            list.add(b);  
            return new JValue(list);  
        }  

        if(a.isBoolean() && b.isBoolean()) {  // boolean + boolean (syntactic sugar baby)  
            return new JValue(a.asBoolean() && b.asBoolean());  
        }  
        
          
        if(a.isString()) { // Adding anything on a string  
            return new JValue(a.asString() + "" + b.toString());  
        }  
        
        if(b.isString()) { // Adding string to anything  
            return new JValue(a.toString() + "" + b.asString());  
        }  

        // Unallowed operation
        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s + %s)", lhs, rhs);  
    }  
}  