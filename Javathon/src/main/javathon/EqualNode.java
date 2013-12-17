package main.javathon;


/**
 * This class handles equality checking for two expressions.
 * 
 * @author Darren
 * 
 */
public class EqualNode implements JNode {

	private JNode lhs;
	private JNode rhs;

	public EqualNode(JNode lhs, JNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public JValue evaluate() {
		/* Evaluate the expressions */
		JValue a = lhs.evaluate();
		JValue b = rhs.evaluate();

		/* Check equality */
		return new JValue(a.equals(b));

	}

	@Override
	public String toString() {
		return String.format("(%s == %s)", lhs, rhs);
	}
}