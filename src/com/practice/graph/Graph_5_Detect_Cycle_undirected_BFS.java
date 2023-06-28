package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_5_Detect_Cycle_undirected_BFS {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(1).add(3);
		adj.get(2).add(1);
		adj.get(2).add(5);
		adj.get(3).add(1);
		adj.get(3).add(4);
		adj.get(3).add(6);
		adj.get(4).add(3);
		adj.get(5).add(2);
		adj.get(5).add(7);
		adj.get(6).add(3);
		adj.get(6).add(7);
		adj.get(7).add(5);
		adj.get(7).add(6);

		System.out.println("Cycle Found : " + detectCycleBFS(adj, 8));
	}
	private static boolean detectCycleBFS(ArrayList<ArrayList<Integer>> adj,int v)
	{
		Queue<Pair> q = new LinkedList<>();
		boolean visited[] = new boolean[v];
		q.add(new Pair(1, -1));
		visited[1] = true;
		while(!q.isEmpty())
		{
			int node = q.peek().first;
			int parent = q.peek().second;
			q.remove();
			for(int adjNode:adj.get(node))
			{
				if(!visited[adjNode])
				{
					q.add(new Pair(adjNode,node));
					visited[adjNode] = true;
				}
				else if( adjNode != parent)
				{
					return true;
				}
			}
		}
		return false;
	}
	//practice
	private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj,int v)
	{
		Queue<int[]> q = new LinkedList<>();
		boolean visited[] = new boolean[v];
		q.add(new int[] {1,-1});
		visited[1]=true;
		while(!q.isEmpty())
		{
			int[] ar=q.peek();
			q.remove();
			int node = ar[0];
			int parent = ar[1];
			
			for(int adjNode : adj.get(node))
			{
				if(!visited[adjNode])
				{
					q.add(new int[]{adjNode,node});
					visited[adjNode] =true;
				}
				else if(parent!=adjNode)
				{
					return true;
				}
			}
		}
		return false;
	}
}
