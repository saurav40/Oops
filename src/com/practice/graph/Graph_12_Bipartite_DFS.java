package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph_12_Bipartite_DFS {
	public static void main(String[] args) {
		int[][] adjList = { { 2 }, { 1, 3, 6 }, { 2, 4 }, { 3, 7 }, { 6, 7 }, { 2, 5 }, { 4, 5, 8 } };
		//int [][] adjList = {{2},{1,3,6},{2,4},{3,5,7},{4,6},{2,5},{4,8}};
		int v = 8;
		int start = 1;
		System.out.println(isBipartite(v,start, adjList));
	}
	private static boolean isBipartite(int v,int start,int[][] edges)
	{
		//Create an adjacency List
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		for(int i=0;i<=v;i++)
		{
			adj.add(new ArrayList());
		}
		for(int i=0;i<edges.length;i++)
		{
		   for(int j=0;j<edges[i].length;j++)
		   {
			   adj.get(i+1).add(edges[i][j]);
		   }
		}
		int []color = new int[v+1];
		Arrays.fill(color, -1);
		for(int i=0;i<=v;i++)
		{
			if(dfs(start,0,color,adj)==false)
			{
				return false;
			}
		}
		return true;
	}
	private static boolean dfs(int node,int col,int []color,ArrayList<ArrayList<Integer>> adj)
	{
		color[node] = col;
		for(int x : adj.get(node))
		{
			if(color[x] == -1)
			{
				if(dfs(x,1-col,color,adj)==false)
				{
					return false;
				}
			}
			else if(col == color[x])
			{
				return false;
			}
		}
		return true;
	}
}
