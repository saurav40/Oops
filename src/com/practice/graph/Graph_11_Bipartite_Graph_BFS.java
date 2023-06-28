package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_11_Bipartite_Graph_BFS {
	public static void main(String[] args) {
        int [][] adjList= {{2},{1,3,6},{2,4},{3,7},{6,7},{2,5},{4,5,8}};
		//int [][] adjList = {{2},{1,3,6},{2,4},{3,5,7},{4,6},{2,5},{4,8}};
        int v = 8;
        System.out.println(isBipartite(v, adjList));
	}
   private static boolean isBipartite(int v,int[][] edges)
   {
	   ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	   for(int i=0;i<=v;i++)
	   {
		   adjList.add(new ArrayList());
	   }
	   for(int i = 0; i<edges.length;i++)
	   {
		   for(int j=0;j<edges[i].length;j++)
		   {
			   adjList.get(i+1).add(edges[i][j]);
		   }
		  // System.out.println();
	   }
	   
	   for(int i=0;i<=v;i++)
	   {
		   for(int x : adjList.get(i))
		   {
			   System.out.print(x+" ");
		   }
		   System.out.println();
	   }
	   int color[] = new int[v+1];
	   Arrays.fill(color, -1);
	   Queue<Integer> q = new LinkedList<>();
	   q.add(1);
	   color[1] = 0;
	   while(!q.isEmpty())
	   {
		   int node = q.peek();
		   int col = color[node];
		   q.remove();
		   
		   for(int adjNode : adjList.get(node))
		   {
			   if(color[adjNode] == -1)
			   {
				   color[adjNode] = 1-col;
				   q.add(adjNode);
			   }
			   else if(col == color[adjNode])
			   {
				   return false;
			   }
		   }
	   }
	   return true;
   }
}
