package main.javathon;

/**
 * This class handles the "not equal" relational operation. It works for
 * numbers, booleans, and strings.
 * 
 * @author Darren
 * 
 */
public class NotEqualNode implements JNode {

	private JNode lhs;
	private JNode rhs;

	public NotEqualNode(JNode lhs, JNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public JValue evaluate() {

		JValue a = lhs.evaluate();
		JValue b = rhs.evaluate();

		// number + number
		if (a.isNumber() && b.isNumber()) {
			return new JValue(a.asDouble() != b.asDouble());
		}

		if (a.isBoolean() && b.isBoolean()) {
			return new JValue(a.asBoolean() != b.asBoolean());
		}

		// string + any
		if (a.isString()) {
			return new JValue(!a.asString().equals(b.toString()));
		}

		// any + string
		if (b.isString()) {
			return new JValue(!b.asString().equals(a.toString()));
		}

		throw new RuntimeException("illegal expression: " + this);
	}

	@Override
	public String toString() {
		return String.format("(%s != %s)", lhs, rhs);
	}
}
