package main.javathon;

/**
 * This class handles the negation of a number or the reversal of a string.<BR />
 * <I>String reversal</I><BR />
 * &nbsp "Hello world" == "dlrow olleH"<BR />
 * <BR />
 * <I>Numerical negation</I><BR />
 * &nbsp 5 = -5 <BR />
 * WHAT DID YOU EXPECT
 * 
 * @author Darren
 * 
 */
public class UnaryMinNode implements JNode {
	private JNode expr;
	private JNode rhs;

	public UnaryMinNode(JNode expr) {
		this.expr = expr;
	}

	@Override
	public JValue evaluate() {

		JValue a = expr.evaluate();

		// - number
		if (a.isNumber()) {
			return new JValue(-a.asDouble());
		}

		// - string: -"Hello world" = "dlrow olleH". PALINDROMIC
		if (a.isString()) {
			return new JValue(new StringBuilder(a.asString()).reverse()
					.toString());
		}

		throw new RuntimeException("Illegal expression: " + this +". You are only allowed to negate a number or reverse a string.");
	}

	@Override
	public String toString() {
		return String.format("(%s + %s)", expr, rhs);
	}
}
