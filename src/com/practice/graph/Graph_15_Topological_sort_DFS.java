package com.practice.graph;

import java.util.Stack;

/*
 * Topsort is a linear ordering of a vertices in DAG such that if there is an edge between
 * u and v. u always appears before v in that odering.
 * 
 * 
 */
public class Graph_15_Topological_sort_DFS {
	public static void main(String[] args) {
     int[][] graph = {{},{},{3},{1},{0,1},{0,2}};
     int res[] = topoSort(graph);
     for(int i=0;i<res.length;i++)
     {
    	 System.out.print(res[i]+" ");
     }
	}
	private static int[] topoSort(int graph[][])
	{
		int v = graph.length;
		/* 
		 *  we do a normal dfs call & while returing from node we add that node in a stack.
		 *  And that stack will be the linear order of vertices or topo sort.
		 * 
		 */
		Stack<Integer> st = new Stack<>();
		boolean []visited = new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				dfs(i,visited,graph,st);
			}
		}
		int res[] = new int[v];
		int i=0;
		while(!st.isEmpty())
		{
			int x = st.peek();
			st.pop();
			res[i++] = x;
		}
		return res;
	}
	private static void dfs(int node,boolean[] visited,int[][] grid,Stack<Integer> st)
	{
		visited[node] = true;
		
		for(int adjNode :grid[node])
		{
			if(!visited[adjNode])
			{
				dfs(adjNode,visited,grid,st);
			}
		}
		st.push(node);
	}
}
