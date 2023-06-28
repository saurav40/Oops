package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_3_flood_fill {
	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int newColor = 2;

		int res[][] = solve(grid, sr, sc, newColor);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++)
			{
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] solve(int[][] grid, int sr, int sc, int newColor) {
		int iniColor = grid[sr][sc];
		int n = grid.length;
		int m = grid[0].length;
		boolean visited[][] = new boolean[n][m];
		//bfs(sr, sc, iniColor, newColor, grid, visited);
		dfs(sr, sc, iniColor, newColor, grid, visited);
		return grid;
	}
	private static void dfs(int sr,int sc,int ini,int newColor,int[][] grid,boolean[][] visited)
	{
		visited[sr][sc] = true;
		grid[sr][sc] = newColor;
		
		int deltaR[] = {-1,0,1,0};
		int deltaC[] = {0,-1,0,1};
		
		for(int i = 0; i < 4; i++)
		{
			int nrow = sr + deltaR[i];
			int ncol = sc + deltaC[i];
			if(nrow >=0 && nrow < grid.length && ncol >= 0
					&& ncol < grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol]==ini)
			{
				dfs(nrow,ncol,ini,newColor,grid,visited);
			}
		}
	}

	private static void bfs(int sr, int sc, int ini, int newColor, int[][] grid, boolean[][] visited) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sr, sc));
		visited[sr][sc] = true;
		grid[sr][sc] = newColor;
        int deltaR[] = {-1,0,1,0};
        int deltaC[] = {0,-1,0,1};
		while (!q.isEmpty()) {
           int row = q.peek().first;
           int col = q.peek().second;
           q.remove();
           for(int i=0;i<4;i++)
           {
        	   int nrow = row + deltaR[i];
        	   int ncol = col + deltaC[i];
        	   if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == ini
   					&& !visited[nrow][ncol]) {
        		   q.add(new Pair(nrow, ncol));
        		   visited[nrow][ncol] = true;
        		   grid[nrow][ncol] = newColor;
        	   }
           }
           
		}
	}
}
