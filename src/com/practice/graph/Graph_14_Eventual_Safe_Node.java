package com.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_14_Eventual_Safe_Node {
	public static void main(String[] args) {
       int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
       int [][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
      // [[1,2,3,4],[1,2],[3,4],[0,4],[]]
       //int []res = eventualSafeNode(graph);
       int [] res = safeNodes(graph);
       for(int i=0;i<res.length;i++)
       {
    	   System.out.print(res[i]+" ");
       }
	}
	// 1.Terminal Node [ A node that does not form a cycle and part of a cycle ] & 2.Nodes that do not form cycle
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
	private static int[] safeNodes(int graph[][])
	{
		int v = graph.length;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<v;i++)
		{
		   for(int adjNode : graph[i])
		   {
			   adj.get(adjNode).add(i);
		   }
		}
		
		int indegree[] = new int[v];
		
		for(int i=0;i<v;i++)
		{
			for(int adjNode : adj.get(i))
			{
				indegree[adjNode]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<v;i++)
		{
			if(indegree[i] ==0)
			{
				q.add(i);
			}
		}
		
		ArrayList<Integer> topo = new ArrayList<>();
		while(!q.isEmpty())
		{
			int node = q.peek();
			q.remove();
			
			topo.add(node);
			
			for(int adjNode : adj.get(node))
			{
				indegree[adjNode]--;
				if(indegree[adjNode] == 0)
				{
					q.add(adjNode);
				}
			}
		}
		Collections.sort(topo);
		
		int[] ans = topo.stream().mapToInt(Integer::intValue).toArray();
		return ans;
	}
}
