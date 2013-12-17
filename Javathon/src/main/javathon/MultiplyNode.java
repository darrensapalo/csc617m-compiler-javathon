package main.javathon;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles multiplication operator. It allows: <BR />
 * <I>Arithmetic multiplication</I><BR />
 * &nbsp 5 * 3 * 2<BR />
 * <BR />
 * <I>String multiplication</I><BR />
 * &nbsp "ab" * 3 == "ababab"<BR />
 * <BR />
 * <I>List multiplication</I><BR />
 * &nbsp [1,2] * 3 = [1,2,1,2,1,2]
 * 
 * @author Darren
 * 
 */
public class MultiplyNode implements JNode {
	private JNode lhs;
	private JNode rhs;

	public MultiplyNode(JNode lhs, JNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public JValue evaluate() {

		JValue a = lhs.evaluate();
		JValue b = rhs.evaluate();

		// number - number
		if (a.isNumber() && b.isNumber()) {
			return new JValue(a.asDouble() * b.asDouble());
		}

		// string * number
		if (a.isString() && b.isNumber()) {
			StringBuilder str = new StringBuilder();
			int stop = b.asDouble().intValue();
			for (int i = 0; i < stop; i++) {
				str.append(a.asString());
			}
			return new JValue(str.toString());
		}

		// list * number
		if (a.isList() && b.isNumber()) {
			List<JValue> total = new ArrayList<JValue>();
			int stop = b.asDouble().intValue();
			for (int i = 0; i < stop; i++) {
				total.addAll(a.asList());
			}
			return new JValue(total);
		}

		throw new RuntimeException("Illegal expression: " + this +". You can only multiply numbers with numbers, or strings/lists with the number of times to repeat.");
	}

	@Override
	public String toString() {
		return String.format("(%s * %s)", lhs, rhs);
	}
}
