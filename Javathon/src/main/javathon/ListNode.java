package main.javathon;

import main.javathon.JValue;

import java.util.ArrayList;
import java.util.List;

public class ListNode implements JNode {
	private List<JNode> expressionNodes;

	public ListNode(List<JNode> nodes) {
		expressionNodes = (nodes == null) ? new ArrayList<JNode>() : nodes;
	}

	@Override
	public JValue evaluate() {
		List<JValue> evaluated = new ArrayList<JValue>();
		for (JNode node : expressionNodes) {
			evaluated.add(node.evaluate());
		}
		return new JValue(evaluated);
	}

	@Override
	public String toString() {
		return expressionNodes.toString();
	}
}