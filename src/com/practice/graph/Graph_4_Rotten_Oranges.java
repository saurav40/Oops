package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_4_Rotten_Oranges {
	public static void main(String[] args) {
      int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
      // 2-> rotten,1->fresh,0->empty cell
      // return -1 if all fress oranges are not rotten
      System.out.println(rotten_oranges(grid));
	}
	//using bfs
	private static int rotten_oranges(int[][] grid)
	{
		Queue<Node> q = new LinkedList<Node>();
		int count_fresh = 0;
		int n = grid.length;
		int m = grid[0].length;
		boolean [][] visited = new boolean[n][m];
		for(int i = 0; i<n; i++)
			for(int j=0;j<m;j++)
			{
				if(grid[i][j] == 2)
				{
					q.add(new Node(i,j,0));
					visited[i][j] = true;
				}
				if(grid[i][j] == 1)
				{
					count_fresh++;
				}
			}
		int cnt = 0;
		int time = 0;
		int deltaR[] = {-1,0,1,0};
		int deltaC[] = {0,-1,0,1};
		while(!q.isEmpty())
		{
			int row = q.peek().x;
			int col = q.peek().y;
			int tx = q.peek().distance;
			q.remove();
			time = Math.max(time, tx);
			for(int i=0;i<4;i++)
			{
				int nrow = row + deltaR[i];
				int ncol = col + deltaC[i];
				if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] 
						&&grid[nrow][ncol] == 1 )
				{
					cnt++;
					q.add(new Node(nrow,ncol,tx+1));
					visited[nrow][ncol] = true;
				}
			}
		}
		if(cnt != count_fresh)
			return -1;
		return time;
	}
}
