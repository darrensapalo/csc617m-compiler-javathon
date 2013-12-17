package main.javathon;

import java.util.ArrayList;
import java.util.List;

public class AssignmentNode implements JNode {

  protected String identifier;
  protected List<JNode> indexNodes;
  protected JNode rhs;
  protected Scope scope;

  public AssignmentNode(String i, List<JNode> e, JNode n, Scope s) {
    identifier = i;
    indexNodes = (e == null) ? new ArrayList<JNode>() : e;
    rhs = n;
    scope = s;
  }

  @Override
  public JValue evaluate() {

    JValue value = rhs.evaluate();

    if (value == JValue.VOID) {
      throw new RuntimeException("can't assign VOID to " + identifier);
    }

    if (indexNodes.isEmpty()) { // a simple assignment
      scope.assign(identifier, value);
    }
    else { // a possible list-lookup and reassignment

      JValue list = scope.resolve(identifier);

      // iterate up to `foo[x][y]` in case of `foo[x][y][z] = 42;`
      for (int i = 0; i < indexNodes.size() - 1 && list != null; i++) {
        JValue index = indexNodes.get(i).evaluate();

        if (!index.isNumber() || !list.isList()) { // sanity checks
          throw new RuntimeException("illegal statement: " + this);
        }

        int idx = index.asLong().intValue();
        list = list.asList().get(idx);
      }
      // list is now pointing to `foo[x][y]` in case of `foo[x][y][z] = 42;`

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
