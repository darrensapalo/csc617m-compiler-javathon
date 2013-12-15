package main.javathon;

public class IdentifierNode implements JNode {  
  
  private String identifier;  
  private Scope scope;  
  
  public IdentifierNode(String id, Scope s) {
	  System.out.println("Identified found: " + id);
    identifier = id;  
    scope = s;  
  }  
  
  @Override  
  public JValue evaluate() {  
    JValue value = scope.resolve(identifier);  
    if(value == null) {  
      throw new RuntimeException("no such variable: " + this);  
    }  
    return value;  
  }  
  
  @Override  
  public String toString() {  
    return identifier;  
  }  
}  