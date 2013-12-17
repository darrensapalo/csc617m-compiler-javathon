package main.javathon;

public class AtomNode implements JNode {  
  
  private JValue value;  
  
  public AtomNode(Object v) {  
    value = (v == null) ? JValue.NULL : new JValue(v);  
  }  
  
  @Override  
  public JValue evaluate() {  
    return value;  
  }  
  
  @Override  
  public String toString() {  
    return value.toString();  
  }  
}  