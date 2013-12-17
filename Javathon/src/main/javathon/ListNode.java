package main.javathon;

import main.javathon.JValue;  
import java.util.List;  
  
public class ListNode implements JNode {  
    
    List<JNode> exprList;

    public ListNode(List<JNode> exprList) {  
        this.exprList = exprList;
    }  

    @Override  
    public JValue evaluate() {  

        throw new RuntimeException("illegal expression: " + this);  
    }  

    @Override  
    public String toString() {  
        return String.format("expression list(%s)", exprList.toString());  
    }  
}  