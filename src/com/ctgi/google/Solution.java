package com.ctgi.google;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution{
public static void main(String[] args){
        //10,30,1 
        //30,0,10 
        //20,30,2 
        //50,40,3 
        //40,30,4 
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node(10,30,1));
        nodes.add(new Node(30,0,10));
        nodes.add(new Node(20,30,2));
        //nodes.add(new Node(50,40,3));
        //nodes.add(new Node(40,30,4));
        Map<Node, Integer> weight =getSubTreeWeight(nodes);
        for(Node n : weight.keySet())
        {
        	System.out.println(n.weight);
        }

    }
    
    public static Map<Node, Integer> getSubTreeWeight(List<Node> nodes){
	Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
	for(int i=0; i<nodes.size();i++){
		nodeMap.put(nodes.get(i).id, nodes.get(i));
	}
	
	Map<Integer, ArrayList<Node>> childMap = new HashMap<Integer, ArrayList<Node>>();
	for(int i=0; i<nodes.size();i++){
		childMap.put(nodes.get(i).id, new ArrayList<Node>());
	}

	for(int i=0; i<nodes.size(); i++){
                if(childMap.get(nodes.get(i).parentId)!=null){
			childMap.get(nodes.get(i).parentId).add(nodes.get(i));
		}
        }

	Map<Node, Integer> weightMap = new HashMap<Node, Integer>();
	for(Node n : nodeMap.values()){
		if(weightMap.get(n)==null){
				calculateWeight(n, childMap, weightMap);
		}
	}

	return weightMap;
}

public static void calculateWeight(Node n, Map<Integer, ArrayList<Node>> childMap, Map<Node,Integer> weightMap){
	if(childMap.get(n.id).isEmpty()){//no child
		weightMap.put(n, n.weight);
	}
	else{
		int weight = n.weight;
		for(Node child : childMap.get(n.id)){
			if(weightMap.get(child)==null){
				calculateWeight(child, childMap, weightMap);
			}
			weight+= weightMap.get(child);
		}
		weightMap.put(n, weight);
	}

}

}