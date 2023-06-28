package com.practice.graph;

import java.util.ArrayList;

public class Graph_1_no_of_provinces {
	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 1 }, 
				         { 0, 1, 0 }, 
				         { 1, 0, 1 } 
				        };
		int [][] grid2 = {
				          {0,1,0,0,0},
				          {1,0,0,0,0},
				          {0,0,0,0,1},
				          {0,0,0,0,0},
				          {0,0,1,0,0}
		                 };
		
		System.out.println(countNoOfProvinces(grid2));
	}

	private static int countNoOfProvinces(int[][] grid) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < grid.length; i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length ; j++) {
				if(grid[i][j]== 1 && i != j)
				{
					adj.get(i).add(j);
					adj.get(j).add(i);
				}
			}
		}
		int cnt = 0;
		boolean visited[] = new boolean[grid.length];
		for(int i=0;i<grid.length ; i++)
		{
			if(!visited[i])
			{
				dfs(i,visited,adj);
				cnt ++;
			}
		}
		return cnt;
	}
	private static void dfs(int node, boolean []visited,ArrayList<ArrayList<Integer>> adj)
	{
		visited[node] = true;
		
		for(int adjNode : adj.get(node))
		{
			if(!visited[adjNode])
			{
				dfs(adjNode,visited,adj);
			}
		}
	}
}
