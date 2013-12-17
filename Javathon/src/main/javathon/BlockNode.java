package main.javathon;
  
import java.util.ArrayList;  
import java.util.List;  

/**
 * This class handles a list of statements
 * that may or may not return a value.
 * @author Darren
 *
 */
public class BlockNode implements JNode {  
  
  private List<JNode> statements;  
  private JNode returnStatement;  
  
  public BlockNode() {  
    statements = new ArrayList<JNode>();  
    returnStatement = null;  
  }  
  
  public void addReturn(JNode stat) {  
    returnStatement = stat;  
  }  
  
  public void addStatement(JNode stat) {
	  statements.add(stat);  
  }  
  
  @Override  
	public JValue evaluate() {
		if (statements != null)
			for (JNode stat : statements) {
				JValue value = stat.evaluate();
				if (value != JValue.VOID) {
					// return early from this block if value is a return
					// statement
					return value;
				}
			}

		// return VOID or returnStatement.evaluate() if it's not null
		return returnStatement == null ? JValue.VOID : returnStatement
				.evaluate();
	}
}  