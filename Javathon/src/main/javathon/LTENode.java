package main.javathon;

/**
 * This class handles the "less than or
 * equal to" relational operation.
 * It works with numbers and with strings. 
 * @author Darren
 *
 */
public class LTENode implements JNode {

	private JNode lhs;
	private JNode rhs;

	public LTENode(JNode lhs, JNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public JValue evaluate() {

		JValue a = lhs.evaluate();
		JValue b = rhs.evaluate();

		if (a.isNumber() && b.isNumber()) {
			return new JValue(a.asDouble() <= b.asDouble());
		}

		if (a.isString() && b.isString()) {
			return new JValue(a.asString().compareTo(b.asString()) <= 0);
		}

		throw new RuntimeException("Illegal expression: " + this +". You are only allowed to use the <= operator on numbers and strings.");  
	}

	@Override
	public String toString() {
		return String.format("(%s <= %s)", lhs, rhs);
	}
}