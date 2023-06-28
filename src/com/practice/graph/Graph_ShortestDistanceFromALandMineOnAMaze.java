package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_ShortestDistanceFromALandMineOnAMaze {

	public static void main(String[] args) {
		char [][] graph = {
				{'O','M','O','O','X'},
				{'O','X','X','O','M'},
				{'O','O','O','O','O'},
				{'O','X','X','X','O'},
				{'O','O','M','O','O'},
				{'O','X','X','M','O'}};
		
		int[][] distances = findDistance(graph);
		for(int i = 0 ; i < distances.length;i++) {
			for(int j = 0 ; j < distances[0].length;j++)
			{
				System.out.print(distances[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static int[][] findDistance(char [][] grid)
	{ 
		int n = grid.length;
		int m = grid[0].length;
		int res [][]= new int[n][m];
		Queue<Node>  q = new LinkedList<>();
		for(int i = 0 ; i < n;i++)
			for(int j = 0; j< m; j++)
			{
				 if(grid[i][j] == 'M')
				 {
					 q.add(new Node(i,j,0));
					 res[i][j]=0;
				 }
				 else
					 res[i][j]=-1;
			}
		int []deltaR = {-1,0,1,0};
		int []deltaC = {0,-1,0,1};
		while(!q.isEmpty())
		{
			int row = q.peek().x;
			int col = q.peek().y;
			int dist = q.peek().distance;
			q.remove();
			for(int i = 0 ; i < 4; i++)
			{
				int nrow = row + deltaR[i];
				int ncol = col + deltaC[i];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 'O' && res[nrow][ncol] == -1) {
                    res[nrow][ncol] = dist + 1;
                    q.add(new Node(nrow,ncol,dist+1));
				}
			}
			
		}
		return res;
	}
} 
