package main.javathon;

/**
 * This class handles the "less than" 
 * relational operation. This works with
 * numbers as well as strings.
 * @author Darren
 *
 */
public class LTNode implements JNode {  
	  
	  private JNode lhs;  
	  private JNode rhs;  
	  
	  public LTNode(JNode lhs, JNode rhs) {  
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
	  
	    throw new RuntimeException("Illegal expression: " + this +". You are only allowed to use the < operator on numbers and strings.");    
	  }  
	  
	  @Override  
	  public String toString() {  
	    return String.format("(%s < %s)", lhs, rhs);  
	  }  
	}  