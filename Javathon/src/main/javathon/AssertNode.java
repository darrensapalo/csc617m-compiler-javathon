package main.javathon;

/**
 * This class allows the programmer to 
 * ensure parts of his code is receiving
 * the correct values. <BR /><BR />
 * 
 * Note that only boolean expressions are 
 * allowed for the parameter of assert.
 * @author Darren
 *
 */
public class AssertNode implements JNode {
    private JNode expr;  

    public AssertNode(JNode expr) {
    	/* Receives the expression to assert */
        this.expr = expr;    
    }  

    @Override  
    public JValue evaluate() {  

    	/* Evaluates the expression inside */
        JValue value = expr.evaluate();

        /* Only allow boolean expressions for assertions */
        if(!value.isBoolean()) {
            throw new RuntimeException("The assert function only takes in boolean expressions.");
        }

        /* Throw an error if resulted to false */
        if(!value.asBoolean()) {
            throw new AssertionError(expr.toString());
        }

        /* Do nothing if assertion worked */
        return JValue.VOID;  
    }  

    @Override  
    public String toString() {  
        return String.format("Assert (%s)", expr);  
    }  
}
