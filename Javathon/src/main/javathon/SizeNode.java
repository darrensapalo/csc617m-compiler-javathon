package main.javathon;


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

		throw new RuntimeException("Illegal function call: " + this);
	}

	@Override
	public String toString() {
		return String.format("size(%s)", expression);
	}
}
