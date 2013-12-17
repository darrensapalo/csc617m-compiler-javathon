package main.javathon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class handles calling of functions.
 * Functions have their unique identifiers as
 * the name of the function concatenated with
 * the number of parameters.<BR /><BR />
 * 
 * Before the function is called, it is first
 * checked whether it is a valid function saved
 * in the map of available functions.
 * 
 * Further, the number of parameters is verified
 * before calling the functions.
 * @author Darren
 *
 */
public class FunctionCallNode implements JNode {

    private String identifier;
    private List<JNode> params;
    private Map<String, JFunction> functions;

    public FunctionCallNode(String id, List<JNode> ps, Map<String, JFunction> fs) {
        identifier = id;
        params = ps == null ? new ArrayList<JNode>() : ps;
        functions = fs;
    }

    @Override
    public JValue evaluate() {

        JFunction f = functions.get(identifier + params.size());

        if(f == null) {
            throw new RuntimeException("There was no function `" + identifier + "` found that had " + params.size() + " parameter(s).");
        }

        JFunction function = new JFunction(f);

        return function.invoke(params, functions);
    }
}
