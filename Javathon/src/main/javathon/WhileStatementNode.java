package main.javathon;

import main.javathon.JValue;

/**
 * This class handles the while statement iterator.
 * 
 * @author Darren
 * 
 */
public class WhileStatementNode implements JNode {

	private JNode statement;
	private JNode block;

	public WhileStatementNode(JNode statement, JNode block) {
		/* Receive the expression and the statement list */
		this.statement = statement;
		this.block = block;
	}

	@Override
	public JValue evaluate() {

		/* As long as the statement is true */
		while (statement.evaluate().asBoolean()) {

			/* Evaluate the statements. */
			JValue returnValue = block.evaluate();

			/* If you find a return value, return it and end the while loop. */
			if (returnValue != JValue.VOID) {
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