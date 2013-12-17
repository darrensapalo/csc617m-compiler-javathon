package main.javathon;

import java.util.List;


/**
 * 
 * This method allows the programmer to add values of numbers, add elements to lists, a syntactic sugar for AND, and concatenation with a string.<br /> 
 * <I>Numerical addition</I><br />
 * &nbsp 5 + 4.5 <br /><br />
 * 
 * <I>Add elements to lists</I><br />
 * &nbsp [2,3,4] + 5 = [2,3,4,5]<br /><br />
 * 
 * <I>Use a syntactic sugar for the && keyword</I><br />
 *&nbsp (false + true) == (false && true)<br /><br />
 *
 * <I>Concatenate anything with a string</I><br />
 * &nbsp "Test" + "test" + 1<br /><br />
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
        throw new RuntimeException("Illegal expression: " + this + ". You are only allowed to either add numbers, add elements to lists, or concatenate strings.");  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s + %s)", lhs, rhs);  
    }  
}  