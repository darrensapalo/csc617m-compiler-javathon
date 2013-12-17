package main.javathon;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import grammar.JavathonTreeWalker;
import main.javathon.JNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JFunction {

  private String id;
  private List<String> identifiers;
  private CommonTree code;
  private Scope scope;

  public JFunction(String i, CommonTree ids, CommonTree block) {
    id = i;
    identifiers = toList(ids);
    code = block;
    scope = new Scope();
  }

  public JFunction(JFunction original) {
    // Used for recursively calling JFunctions
    id = original.id;
    identifiers = original.identifiers;
    code = original.code;
    scope = original.scope.copy();
  }

  public JValue invoke(List<JNode> params, Map<String, JFunction> JFunctions) {

    if(params.size() != identifiers.size()) {
      throw new RuntimeException("illegal JFunction call: " + identifiers.size() +
          " parameters expected for JFunction `" + id + "`");
    }

    // Assign all expression parameters to this JFunction's identifiers
    for(int i = 0; i < identifiers.size(); i++) {
      scope.assign(identifiers.get(i), params.get(i).evaluate());
    }

    try {
      // Create a tree walker to evaluate this JFunction's code block
      CommonTreeNodeStream nodes = new CommonTreeNodeStream(code);
      JavathonTreeWalker walker = new JavathonTreeWalker(nodes, scope, JFunctions);
      return walker.walk().evaluate();
    } catch (RecognitionException e) {
      // do not recover from this
      throw new RuntimeException("something went wrong, terminating", e);
    }
  }

  private List<String> toList(CommonTree tree) {
    List<String> ids = new ArrayList<String>();
    
    // convert the tree to a List of Strings
    for(int i = 0; i < tree.getChildCount(); i++) {
      CommonTree child = (CommonTree)tree.getChild(i);
      ids.add(child.getText());
    }
    return ids;
  }
}
