package main.javathon;

  
/**
 * This operator ensures that both expressions
 * are booleans and returns its logical AND result.
 * @author Darren
 *
 */
public class AndNode implements JNode {  
    private JNode lhs;  
    private JNode rhs;  

    public AndNode(JNode lhs, JNode rhs) {
    	/* Receive the two expressions to be evaluated */
        this.lhs = lhs;  
        this.rhs = rhs;  
    }  

    @Override  
    public JValue evaluate() {  
    	/* Evaluate both expressions */
        JValue a = lhs.evaluate();  
        JValue b = rhs.evaluate();  

        /* Ensure both values are boolean */
        if(!a.isBoolean() || !b.isBoolean()) {
            throw new RuntimeException("illegal expression: " + this +". One of the expressions is not a boolean.");
        }
        
        /* Return the value */
        return new JValue(a.asBoolean() && b.asBoolean());
    }  

    @Override  
    public String toString() {  
        return String.format("(%s && %s)", lhs, rhs);  
    }  
}  