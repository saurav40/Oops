package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_Uniform_Cost_Matrix {
	public static void main(String[] args) {
		int[][] grid = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
//       int[][] grid = {{1,1,0,1,1},
//    		           {1,1,1,0,1},
//    		           {1,1,1,1,1},
//    		           {1,1,1,0,1} };
       int []src = {0,0};
       int []dst = {3,4};
       System.out.println("Cost : "+distance(grid, src, dst));
	}
	private static int distance(int[][] grid,int [] src,int [] dst)
	{
		int n = grid.length;
		int m = grid[0].length;
	    boolean[][] visited = new boolean[n][m];
	    Queue<Node> q = new LinkedList<>();
	    q.add(new Node(src[0],src[1],0));
	    visited[src[0]][src[1]] = true;
	    int []delR= {-1,0,1,0};
	    int []delC= {0,-1,0,1};
	    while(!q.isEmpty())
	    {
	    	int row = q.peek().x;
	    	int col = q.peek().y;
	    	int distance = q.peek().distance;
	    	q.remove();
	    	if(row == dst[0] && col ==dst[1])
	    	{
	    		return distance;
	    	}
	    	for(int i=0;i<4;i++)
	    	{
	    		int nrow = row + delR[i];
	    		int ncol = col + delC[i];
	    		if(nrow >=0 && nrow <n && ncol >= 0 && ncol <m && !visited[nrow][ncol] && grid[nrow][ncol]==1)
	    		{
	    			q.add(new Node(nrow,ncol,distance+1));
	    			visited[nrow][ncol] = true;
	    		}
	    	}
	    	
	    }
		return -1;
	}
}
