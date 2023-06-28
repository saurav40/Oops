package com.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph_10_No_Of_Distinict_Islands {
	public static void main(String[] args) {
       int[][] grid = {{1,1,0,0,1,1},
                       {1,0,0,0,0,0},
                       {0,0,0,1,1,0},
                       {1,1,0,1,0,0}
                      };
       System.out.println(no_Of_Distinct_Islands(grid));
	}
	private static int no_Of_Distinct_Islands(int[][] grid)
	{
		int n = grid.length;
		int m = grid[0].length;
		
		Set<ArrayList<String>> set = new HashSet<>();
	    boolean [][] visited = new boolean[n][m];
	    for(int i=0;i<n;i++)
	    {
	    	for(int j=0;j<m;j++)
	    	{
	    		if(!visited[i][j] && grid[i][j] == 1)
	    		{
	    			ArrayList<String> ll = new ArrayList<>();
	    			dfs(i,j,i,j,visited,grid,ll);
	    			set.add(ll);
	    		}
	    	}
	    }
		return set.size();
	}
	private static void dfs(int sr, int sc, int pr, int pc, boolean[][] visited, int[][] grid, ArrayList<String> ll) {
		visited[sr][sc] = true;
		String srsc = intoString(Math.abs(sr - pr), Math.abs(sc - pc));
		ll.add(srsc);
		
		int deltaR[] = {-1,0,1,0};
		int deltaC[] = {0,-1,0,1};
		
		for(int i=0;i<4;i++)
		{
			int nrow = sr+deltaR[i];
			int ncol = sc+deltaC[i];
			if(nrow >= 0 && nrow < grid.length && ncol >=0 && ncol < grid[0].length && 
					!visited[nrow][ncol] && grid[nrow][ncol] == 1)
			{
				dfs(nrow,ncol,sr,sc,visited,grid,ll);
			}
		}
	}

	private static String intoString(int x, int y) {
		return Integer.toString(x) + " " + Integer.toString(y);
	}
}
