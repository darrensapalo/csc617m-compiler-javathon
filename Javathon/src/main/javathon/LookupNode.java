package main.javathon;

import java.util.ArrayList;
import java.util.List;

public class LookupNode implements JNode {  
	  
	  private JNode expression;  
	  private List<JNode> indexes;  
	  
	  public LookupNode(JNode e, List<JNode> i) {
		  System.out.println("Looking up node: " + e.toString());
	    expression = e;  
	    indexes = i;  
	  }  
	  
	  @Override  
	  public JValue evaluate() {  
	  
	    JValue value = expression.evaluate();  
	  
	    List<JValue> indexValues = new ArrayList<JValue>();  
	  
	    for (JNode indexNode : indexes) {  
	      indexValues.add(indexNode.evaluate());  
	    }  
	  
	    for(JValue index : indexValues) {  
	  
	      if(!index.isNumber() || !(value.isList() || value.isString())) {  
	        throw new RuntimeException("illegal expression: " +   
	            expression + "[" + index + "]");  
	      }  
	  
	      int idx = index.asLong().intValue();  
	  
	      if(value.isList()) {  
	        value = value.asList().get(idx);  
	      }  
	      else if(value.isString()) {  
	        value = new JValue(String.valueOf(value.asString().charAt(idx)));  
	      }  
	    }  
	  
	    return value;  
	  }  
	}  