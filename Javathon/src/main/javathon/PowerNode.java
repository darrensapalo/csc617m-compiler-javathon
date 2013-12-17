package main.javathon;
/**
 * This class handles the exponential
 * function when encountering the "^" keyword.
 * @author Darren
 *
 */
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

        throw new RuntimeException("Illegal expression: " + this +". You may only use the exponent (^) operation with numbers.");  
    }  

    @Override  
    public String toString() {  
        return String.format("(%s ^ %s)", lhs, rhs);  
    } 
}
