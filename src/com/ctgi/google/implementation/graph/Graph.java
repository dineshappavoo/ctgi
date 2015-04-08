package com.ctgi.google.implementation.graph;

import java.util.ArrayList;

/**
 * @author Dinesh Appavoo
 *
 */
public class Graph<T extends Comparable<T>>{

	
	public static ArrayList<Edge>[] adjacencyList=null;
	public int noOfVertices;
	
	
	public Graph(int noOfVertices)
	{
		adjacencyList=(ArrayList<Edge>[])new ArrayList[noOfVertices+1];
		this.noOfVertices=noOfVertices;
	}

	/**
	 * 
	 * @param u
	 * @param v
	 * @param w
	 * To add edges to the adjacency list graph
	 */
	public void addEdge(T u, T v, T w)
	{
		if(adjacencyList[(Integer) u]==null)
			adjacencyList[(Integer) u]=new ArrayList<Edge>();
		adjacencyList[(Integer) u].add(new Edge(u, v, w));
	}
	
	/**
	 * 
	 * @param u
	 * @param v
	 * To remove the edge from the graph
	 */
	public void removeEdge(T u, T v)
	{
		int indexToBeRemoved=-1;
		ArrayList<Edge> edgeList=adjacencyList[(Integer) u];
		for(int i=0;i<adjacencyList[(Integer) u].size();i++)
		{
			Edge e=edgeList.get(i);
			if(e.u.compareTo(u)==0&&e.v.compareTo(v)==0)
			{
				indexToBeRemoved=i;
			}
		}
		edgeList.remove(indexToBeRemoved);
	}
	
	/**
	 * 
	 * @param u
	 * @return
	 * To return the outgoing edges for the given source
	 */
	public ArrayList<Edge> getOutEdges(int u)
	{
		return adjacencyList[u];
	}
	
	/**
	 * 
	 * @param u
	 * @param v
	 * @return
	 * To get the weight given the u and v values
	 * 
	 */
	public T getWeight(int u, int v)
	{
		ArrayList<Edge> edgeList=adjacencyList[u];
		T weight = null;
		for(Edge e : edgeList)
		{
			if(e.v.compareTo(v)==0)
				weight=(T) e.w;
		}
		return weight;
	}
	
	public void printGraph()
	{
		ArrayList<Edge> edgeList;
		for(int i=1;i<=noOfVertices;i++)
		{
			edgeList=adjacencyList[i];
			if(edgeList!=null)
			{
			for(Edge e : edgeList)
				System.out.println("u : "+e.u+" v : "+e.v+" w : "+e.w);
			}
		}
	}
	/**
	 * 
	 * @param args
	 * Main function to test the graph
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph<Integer> graph=new Graph<Integer>(3);
		graph.addEdge(1, 2, 5);
		graph.addEdge(1, 3, 12);
		graph.addEdge(3, 1, 12);
		graph.addEdge(2, 1, 5);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 2, 7);
		graph.printGraph();
		
	}
	
	

}
