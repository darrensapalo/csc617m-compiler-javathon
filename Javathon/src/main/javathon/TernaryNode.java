package main.javathon;

import main.javathon.JValue;  

import java.util.List;  
  
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
        a.evaluate();
        b.evaluate();
        c.evaluate();
        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("Ternary if statement (%s)", a);  
    }  
}  