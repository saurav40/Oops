package com.practice.graph;

import java.util.ArrayList;

public class Graph_6_Detect_Cycle_undirected_DFS {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(1).add(3);
		adj.get(2).add(1);
		adj.get(2).add(5);
		adj.get(3).add(1);
		adj.get(3).add(4);
		adj.get(3).add(6);
		adj.get(4).add(3);
		adj.get(5).add(2);
		//adj.get(5).add(7);
		adj.get(6).add(3);
		adj.get(6).add(7);
		//adj.get(7).add(5);
		adj.get(7).add(6);

		System.out.println("Cycle Found : " + detectCycle(adj, 8));
	}

	private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj,int v)
	{
		boolean visited[] = new boolean[v];
		for(int i=0;i<adj.size();i++)
		{
			System.out.print(i+":{");
			for(int x:adj.get(i))
			{
				System.out.print(x+" ");
			}
			System.out.println("}");
		}
		for(int i=1;i<v;i++)
		{
			if(!visited[i]) {
			if(isCycleDFS(i,-1,visited,adj))
					{
				     return true;
					}
			}
		}
		return false;
	}

	private static boolean isCycleDFS(int src, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		visited[src] = true;
		for (int adjNode : adj.get(src)) {
			if (!visited[adjNode]) {
				if (isCycleDFS(adjNode, src, visited, adj)) {
					return true;
				}
			}
			else if(adjNode != parent)
			{
				return true;
			}
		}
		return false;
	}
}
