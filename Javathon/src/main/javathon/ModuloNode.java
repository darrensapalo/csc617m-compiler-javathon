package main.javathon;

/**
 * This class handles the modulo arithmetic operator.
 * 
 * @author Darren
 * 
 */
public class ModuloNode implements JNode {

	private JNode lhs;
	private JNode rhs;

	public ModuloNode(JNode lhs, JNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public JValue evaluate() {

		JValue a = lhs.evaluate();
		JValue b = rhs.evaluate();

		if (a.isNumber() && b.isNumber()) {
			return new JValue(a.asDouble() % b.asDouble());
		}

		throw new RuntimeException("Illegal expression: " + this +". You can only use modulo with numbers.");
	}

	@Override
	public String toString() {
		return String.format("(%s %% %s)", lhs, rhs);
	}

}
