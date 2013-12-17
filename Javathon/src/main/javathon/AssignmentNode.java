package main.javathon;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the assignment of variables
 * while taking into account scoping and indices. 
 * @author Darren
 *
 */
public class AssignmentNode implements JNode {

	protected String identifier;
	protected List<JNode> indexNodes;
	protected JNode rhs;
	protected Scope scope;

	public AssignmentNode(String i, List<JNode> e, JNode n, Scope s) {
		/*
		 * Receive the variable name, the indices, the value, and the scope for
		 * this variable.
		 */
		identifier = i;
		indexNodes = (e == null) ? new ArrayList<JNode>() : e;
		rhs = n;
		scope = s;
	}

	@Override
	public JValue evaluate() {
		/* Evaluate the value to assign */
		JValue value = rhs.evaluate();

		/* If the value is void, you cannot assign it.
		 * e.g. 
		 * x = println("whatthehell");
		 */
		if (value == JValue.VOID) {
			throw new RuntimeException("Can't assign VOID to " + identifier +".");
		}
		
		
		/* Case 1 : Simple assignment */
		if (indexNodes.isEmpty()) { 
			scope.assign(identifier, value);
			
			
		/* Case 2 : Possible look up + reassignment */
		} else { 

			/* Find the current identifier and give the value */
			JValue list = scope.resolve(identifier);

			// iterate up to `foo[x][y]` in case of `foo[x][y][z] = 42;`
			for (int i = 0; i < indexNodes.size() - 1 && list != null; i++) {
				JValue index = indexNodes.get(i).evaluate();

				/* Ensuring the indices are valid, and that resulting 
				 * value from the iteration is still a list. 
				 * 
				 * This is because list is being modified in this 
				 * for loop (a).
				 */
				if (!index.isNumber() || !list.isList()) { 
					throw new RuntimeException("illegal statement: " + this);
				}

				int idx = index.asLong().intValue();
				list = list.asList().get(idx); /* (a) */
			}
			
			/* Accessed the necessary list */
			// list is now pointing to `foo[x][y]` in case of `foo[x][y][z] =
			// 42;`
			// get the value `z`: the last index, in `foo[x][y][z] = 42;`
			JValue lastIndex = indexNodes.get(indexNodes.size() - 1).evaluate();

			if (!lastIndex.isNumber() || !list.isList()) { // sanity checks
				throw new RuntimeException("illegal statement: " + this);
			}

			// re-assign `foo[x][y][z]`
			List<JValue> existing = list.asList();
			existing.set(lastIndex.asLong().intValue(), value);
		}

		return JValue.VOID;
	}

	@Override
	public String toString() {
		return String.format("(%s[%s] = %s)", identifier, indexNodes, rhs);
	}
}
