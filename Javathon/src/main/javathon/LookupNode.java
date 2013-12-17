package main.javathon;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles looking up of values within a list, array, or string. 
 * @author Darren
 * 
 */
public class LookupNode implements JNode {

	private JNode expression;
	private List<JNode> indexes;

	public LookupNode(JNode e, List<JNode> i) {
		expression = e;
		indexes = i;
	}

	@Override
	public JValue evaluate() {
		/* Evaluate the expression */
		JValue value = expression.evaluate();

		/* Check if there are indices */
		List<JValue> indexValues = new ArrayList<JValue>();
		for (JNode indexNode : indexes) {
			indexValues.add(indexNode.evaluate());
		}
		
		/* For each index */
		for (JValue index : indexValues) {
			
			/* Ensure that:
			 * (1) The index is a number
			 * (2) The data is being drawn from a list 
			 * (3) If not a list, then a string */
			if (!index.isNumber() || !(value.isList() || value.isString())) {
				throw new RuntimeException("Illegal expression: " + expression
						+ "[" + index + "]. The index must be a number and you must use either list or string.");
			}

			/* Get the index */
			int idx = index.asLong().intValue();

			/* Gets the element of the list or string. */
			if (value.isList()) {
				value = value.asList().get(idx);
			} else if (value.isString()) {
				// TODO: A good bonus thingy could be to modulo the index to ensure it is always within the string / list
				// And instead, a compile error will tell you that this happened.
				//
				// But then we never want the computer to assume what we want it to do. Dangerous.
				value = new JValue(String.valueOf(value.asString().charAt(idx)));
			}
		}

		return value;
	}
}