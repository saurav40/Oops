package com.practice.graph;

import java.util.ArrayList;

public class Graph_14_Eventual_Safe_Node {
	public static void main(String[] args) {
       int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
       int [][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
      // [[1,2,3,4],[1,2],[3,4],[0,4],[]]
       int []res = eventualSafeNode(graph2);
       for(int i=0;i<res.length;i++)
       {
    	   System.out.print(res[i]+" ");
       }
	}
	// 1.Terminal Node & 2.Nodes that do not form cycle
	private static int[] eventualSafeNode(int[][] graph)
	{
		int v = graph.length;
	    boolean visited[]=new boolean[v];
		boolean pathVisited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				dfs(i,visited,pathVisited,graph);
			}
		}
	    ArrayList<Integer> ar= new ArrayList<>();
	    for(int i=0;i<v;i++)
	    {
	    	if(visited[i] && !pathVisited[i])
	    	{
	    		ar.add(i);
	    	}
	    }
	    int a[] = ar.stream().mapToInt(Integer::intValue).toArray();
		return a;
	}
	private static boolean dfs(int node,boolean []visited,boolean[] pathvisited,int[][] grid)
	{
		visited[node] = true;
		pathvisited[node] = true;
		for(int x:grid[node])
		{
			if(!visited[x])
			{
				if(dfs(x,visited,pathvisited,grid)==true)
				{
					return true;
				}
				
			}
			else if(pathvisited[x]==true)
			{
				return true;
			}
		}
		pathvisited[node] = false;
		return false;
	}
}
