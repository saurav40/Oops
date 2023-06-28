package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_9_Number_of_Enclaves {
	public static void main(String[] args) {
       int[][] grid= {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,1}};
       System.out.println(no_of_enclaves(grid));
	} 
	private static int no_of_enclaves(int[][] grid)
	{
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		Queue<Pair> q =new LinkedList<>();
		
		for(int i = 0; i<m; i++)
		{
			if(grid[0][i] == 1)
			{
				 q.add(new Pair(0,1));
				 visited[0][i] = true;
			}
			if(grid[n-1][i]== 1)
			{
				q.add(new Pair(n-1,i));
				visited[n-1][i] = true;
			}
		}
		for(int i = 0; i<n ;i++)
		{
			if(grid[i][0] == 1)
			{
				q.add(new Pair(i,0));
				visited[i][0] = true;
			}
			if(grid[i][m-1] == 1)
			{
				q.add(new Pair(i,m-1));
				visited[i][m-1] = true;
			}
		}
		
		int []deltaR = {-1,0,1,0};
		int []deltaC = {0,-1,0,1};
		
		while(!q.isEmpty())
		{
			int row = q.peek().first;
			int col = q.peek().second;
			q.remove();
			
			for(int i=0;i<4;i++)
			{
				int nrow = row + deltaR[i];
				int ncol = col + deltaC[i];
				if(nrow >= 0 && nrow <n && ncol >=0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol]==1)
				{
					q.add(new Pair(nrow, ncol));
					visited[nrow][ncol] = true;
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				if(!visited[i][j] && grid[i][j] ==1)
				{
					cnt++;
				}
			}
		return cnt;
	}
}
