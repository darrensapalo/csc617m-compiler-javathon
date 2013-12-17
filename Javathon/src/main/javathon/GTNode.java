package main.javathon;

public class GTNode implements JNode {  
	  
	  private JNode lhs;  
	  private JNode rhs;  
	  
	  public GTNode(JNode lhs, JNode rhs) {  
	    this.lhs = lhs;  
	    this.rhs = rhs;  
	  }  
	  
	  @Override  
	  public JValue evaluate() {  
	  
	    JValue a = lhs.evaluate();  
	    JValue b = rhs.evaluate();  
	  
	    if(a.isNumber() && b.isNumber()) {  
	      return new JValue(a.asDouble() < b.asDouble());  
	    }  
	  
	    if(a.isString() && b.isString()) {  
	      return new JValue(a.asString().compareTo(b.asString()) < 0);  
	    }  
	  
	    throw new RuntimeException("illegal expression: " + this);  
	  }  
	  
	  @Override  
	  public String toString() {  
	    return String.format("(%s < %s)", lhs, rhs);  
	  }  
	}  