package main.javathon;
/**
 * This class handles ternary if statement evaluation.
 * @author Darren
 *
 */
public class TernaryNode implements JNode {
    private JNode b;
	private JNode a;
	private JNode c;

	public TernaryNode(JNode a, JNode b, JNode c) {
		this.a = a;
		this.b = b;
		this.c = c;  
    }  

    @Override  
    public JValue evaluate() {  
        JValue condition = a.evaluate();
        JValue action = b.evaluate();
        JValue alternate = c.evaluate();
        
        if(!condition.isBoolean()) {  
            throw new RuntimeException("illegal boolean expression in ternary: " + a);  
        }
        
        if (condition.asBoolean()) {
            return action;
        }
        
        return alternate;  
    }  

    @Override  
    public String toString() {  
        return String.format("Ternary if statement (%s)", a);  
    }  
}  