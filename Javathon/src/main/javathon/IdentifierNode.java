package main.javathon;

/**
 * This class handles the retrieval
 * of the value owned by an identifier (or variable).
 * @author Darren
 *
 */
public class IdentifierNode implements JNode {  
  
  private String identifier;  
  private Scope scope;  
  
  public IdentifierNode(String id, Scope s) {
    identifier = id;  
    scope = s;  
  }  
  
  @Override  
  public JValue evaluate() {  
    JValue value = scope.resolve(identifier);  
    if(value == null) {  
      throw new RuntimeException("No such variable: " + this);  
    }  
    return value;  
  }  
  
  @Override  
  public String toString() {  
    return identifier;  
  }  
}  