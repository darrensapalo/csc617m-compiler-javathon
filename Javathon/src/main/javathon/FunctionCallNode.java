package main.javathon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            throw new RuntimeException("no function `" + identifier + "` with " + params.size() + " parameter(s)");
        }

        JFunction function = new JFunction(f);

        return function.invoke(params, functions);
    }
}
