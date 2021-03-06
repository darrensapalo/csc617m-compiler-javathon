package main.javathon;

/**
 * This method handles checking the length
 * of a string or a list.
 * @author Darren
 *
 */
public class SizeNode implements JNode {

	private JNode expression;

	public SizeNode(JNode e) {
		expression = e;
	}

	@Override
	public JValue evaluate() {
		JValue value = expression.evaluate();

		if (value.isString()) {
			return new JValue(value.asString().length());
		}

		if (value.isList()) {
			return new JValue(value.asList().size());
		}

		throw new RuntimeException("Illegal function call: " + this +". You can only check for the size or length of a list or a string.");
	}

	@Override
	public String toString() {
		return String.format("size(%s)", expression);
	}
}
