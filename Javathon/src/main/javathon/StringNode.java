package main.javathon;

import java.util.ArrayList;
import java.util.List;

/**
 * This method allows the user to 
 * get a character from the string and returns it as a single character in a string.<BR />
 * "Hello World"[4] == "o".<BR />
 * @author Darren
 *
 */
public class StringNode implements JNode {

	private String expression;
	private List<JNode> indexes;

	public StringNode(String e, List<JNode> i) {
		expression = e;
		indexes = (i == null) ? new ArrayList<JNode>() : i;
	}

	@Override
	public JValue evaluate() {
		String string = expression;
		
		if (string.equalsIgnoreCase(""))
			return new JValue("");
		
		int indices = indexes.size();
		switch(indices){
		case 0:
			return new JValue(string);
			
		case 1:
			JValue index = indexes.get(0).evaluate();
			
			if (!index.isNumber()) // sanity checks
				throw new RuntimeException("invalid index statement: " + this);
			if (index.asDouble() < 0)
				throw new RuntimeException("array out of bounds statement: " + this);
			
			/* Gets the sub element of the string */
			char character[] = {string.charAt(index.asDouble().intValue())};
			Object charAsString = new String(character);
			return new JValue(charAsString);
		}
		return JValue.NULL;
	}
}