package com.practice.graph;

import java.util.ArrayList;

public class Graph_13_Detect_Cycle_Directed_DFS {
	public static void main(String[] args) {
		int[][] edges = { { 2 }, { 3 }, { 4, 7 }, { 5 }, { 6 }, {}, { 5 }, { 9 }, { 10 }, { 8 } };
		int v = 10;
		if (detectCycle(v, edges)) {
			System.out.println("Cycle found..");
		} else {
			System.out.println("Cycle Not found");
		}
	}

	private static boolean detectCycle(int v, int[][] edges) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList());
		}
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].length; j++) {
                  adj.get(i+1).add(edges[i][j]);
			}
		}
		 for(int i=0;i<=v;i++)
		   {
			   for(int x : adj.get(i))
			   {
				   System.out.print(x+" ");
			   }
			   System.out.println();
		   }
		boolean [] visited  = new boolean[v+1];
		boolean [] pathVisited = new boolean[v+1];
		for(int i=1;i<=v;i++)
		{
			if(!visited[i])
			{
				if(dfs(i,visited,pathVisited,adj))
					return true;
			}
		}
		return false;
	}
	private static boolean dfs(int node,boolean[] visited,boolean[] pathVisited,ArrayList<ArrayList<Integer>> adj)
	{
		visited[node] = true;
		pathVisited[node] = true;
		for(int adjNode : adj.get(node)) {
			if(!visited[adjNode])
			{
				if(dfs(adjNode,visited,pathVisited,adj))
				{
					return true;
				}
			}
			else if(pathVisited[adjNode] == true)
				return true;
		}
		pathVisited[node] = false;
		return false;
	}
}
