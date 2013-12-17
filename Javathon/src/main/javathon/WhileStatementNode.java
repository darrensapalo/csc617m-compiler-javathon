package main.javathon;

import main.javathon.JValue;  

import java.util.List;  
  
public class WhileStatementNode implements JNode {  
  
    private JNode statement;  
    private JNode block;  

    public WhileStatementNode(JNode statement, JNode block) {  
        this.statement = statement;  
        this.block = block;  
    }  

    @Override  
    public JValue evaluate() {  

        while(statement.evaluate().asBoolean()) {

            JValue returnValue = block.evaluate();

            if(returnValue != JValue.VOID) {
                return returnValue;
            }
            
        }
        return JValue.VOID;
    }  

    @Override  
    public String toString() {  
        return String.format("While statement (%s)", statement);  
    }  
}  