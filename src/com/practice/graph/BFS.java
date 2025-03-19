package com.practice.graph;

import java.util.*;

public class BFS {
	int v; 
	ArrayList<ArrayList<Integer>> adj;

	public BFS(int v) {
		this.v = v;
		adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++)
		{
			adj.add(new ArrayList<>());
		}
	}

	void addDEdge(int u, int v) {
		adj.get(u).add(v);
		//adj.get(v).add(u);
	}

	void print() {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + "->");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + "->");
			}
			System.out.println();
		}
	}
   ArrayList<Integer> bfs(int src)
   {
	   ArrayList<Integer> result = new ArrayList<>();
	   boolean visited[] = new boolean[this.v];
	   Queue<Integer>  q = new LinkedList<>();
	   q.add(src);
	   visited[src]=true;
	   while(!q.isEmpty())
	   {
		   int node = q.peek();
		   result.add(node);
		   q.remove();
		   
		   for(int adjNode : adj.get(node))
		   {
			   if(!visited[adjNode])
			   {
				   visited[adjNode] = true;
				   q.add(adjNode);
			   }
		   }
	   }
	   
	   return result;
   }
	public static void main(String[] args) {
       BFS graph = new BFS(4);
       graph.addDEdge(0, 1);
       graph.addDEdge(0, 2);
       graph.addDEdge(1, 2);
       graph.addDEdge(2, 0);
       graph.addDEdge(2, 3);
       graph.addDEdge(3, 3);
       
       ArrayList<Integer> res = graph.bfs(3 );
       for(int vertex : res)
       {
    	   System.out.print(vertex+",");
       }
	}
}
