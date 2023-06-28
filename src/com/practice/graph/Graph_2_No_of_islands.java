package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_2_No_of_islands {
	public static void main(String[] args) {
		char[][] grid =  {
				{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
//			{ { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
//				{ '0', '0', '0', '0', '0' } };
		char [][] grid2 = {
		          {'0','1','0','0','0'},
		          {'1','0','0','0','0'},
		          {'0','0','0','0','1'},
		          {'0','0','0','0','0'},
		          {'0','0','1','0','0'}
               };
		System.out.println(noOfIslands(grid2));
	}

	public static int noOfIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		boolean visited[][] = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					//dfs(i, j, visited, grid);
					bfs(i,j,visited,grid);
					cnt++;
				}
			}
		return cnt;
	}
    public static void bfs(int row,int col,boolean[][] visited,char[][] grid)
    {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        visited[row][col] = true;
        int deltaR[] = { -1, 0, 1, 0 };
		int deltaC[] = { 0, -1, 0, 1 };
        while(!q.isEmpty())
        {
        	int ro = q.peek().first;
        	int co = q.peek().second;
        	q.remove();
        	for(int i=0;i<4;i++)
        	{
        		int nrow = ro + deltaR[i];
        		int ncol = co + deltaC[i];
        		if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == '1'
    					&& !visited[nrow][ncol]) {
        		   visited[nrow][ncol] = true;
        		   q.add(new Pair(nrow, ncol));
        		}
        	}
        	
        }
    }
	public static void dfs(int row, int col, boolean[][] visited, char[][] grid) {
		visited[row][col] = true;

		// loop through adjacent nodes - horizontal & vertical
		int deltaR[] = { -1, 0, 1, 0 };
		int deltaC[] = { 0, -1, 0, 1 };

		for (int i = 0; i < 4; i++) {
			int nrow = row + deltaR[i];
			int ncol = col + deltaC[i];
			if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == '1'
					&& !visited[nrow][ncol]) {
				dfs(nrow, ncol, visited, grid);
			}
		}
	}
}
