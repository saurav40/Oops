package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 *    Find the Topo Sort 
 *    and then Relax egges from src and maintain Distance array
 * 
 */
public class Graph_19_Shortest_Path_DAG {
	public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int V = 6;
        for(int i=0;i<=V;i++)
        {
        	adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(3,1));
        adj.get(2).add(new Pair(3,3));
        adj.get(4).add(new Pair(0, 3));
        adj.get(4).add(new Pair(2, 1));
        adj.get(5).add(new Pair(4, 1));
        adj.get(6).add(new Pair(4, 2));
        adj.get(6).add(new Pair(5, 1));  
       int res[] =  shortest_path_DAG(V+1, 5, adj);
        int res2[] =  shortest_path_DAG_Stack_Topo(V+1, 5, adj);
        for(int x : res)
        	System.out.print(x+" ");
        System.out.println();
        for(int x : res2)
        	System.out.print(x+" ");
	}
	
	private static int [] shortest_path_DAG(int V,int src,ArrayList<ArrayList<Pair>> adj)
	{
		int indegree[] = new int[V];
		for(int i=0;i<V;i++)
		{
			for(Pair p : adj.get(i))
			{
				int adjNode = p.first;
				indegree[adjNode]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0;i<V;i++)
		{
			if(indegree[i] == 0)
				q.add(i);
		}
		
		int topo[] = new int[V];
		int k = 0;
		while(!q.isEmpty())
		{
			int node = q.peek();
			q.remove();
			topo[k++] = node;
			for(Pair p : adj.get(node))
			{
				int adjNode = p.first;
				indegree[adjNode] --;
				if(indegree[adjNode] == 0)
				{
					q.add(adjNode);
				}
			}
		}
		
		int dist[] = new int[V];
		Arrays.fill(dist,(int)1e9);
		
		dist[src] = 0;
		int i=0;
		while(i<V && src!=topo[i])
		{
			i++;
		}
		while(i<V)
		{
			int node = topo[i];
			for(Pair p : adj.get(node))
			{
				int adjNode = p.first;
				int w = p.second;
				if(dist[adjNode] > dist[node]+w)
				{
					dist[adjNode] = dist[node]+w;
				}
			}
			i++;
		}
	    for(i=0;i<V;i++)
	    {
	    	if(dist[i] == 1e9)
	    	{
	    		dist[i] = -1;
	    	}
	    }
		return dist;
	}
	private static int[] shortest_path_DAG_Stack_Topo(int V,int src,ArrayList<ArrayList<Pair>> adj)
	{
		boolean visited[] = new boolean[V];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
			{
				dfsTopo(i,visited,st,adj);
			}
		}
		int dist[] = new int[V];
		Arrays.fill(dist, (int)(1e9));
		dist[src] = 0;
	    while(!st.isEmpty() && st.peek() != src)
	    {
	    	st.pop();
	    }
		while(!st.empty())
		{
			int node = st.pop();
			for(Pair p : adj.get(node))
			{
				int adjNode = p.first;
				int w = p.second;
				if(dist[adjNode] > w + dist[node])
				{
					dist[adjNode] = w + dist[node];
				}
			}
		}
		return dist;
	}
	private static void dfsTopo(int node,boolean visited[],Stack<Integer> st,ArrayList<ArrayList<Pair>> adj)
	{
		visited[node] = true;
		
		for(Pair p : adj.get(node))
		{
			int adjNode = p.first;
			if(!visited[adjNode])
			{
				dfsTopo(adjNode, visited, st, adj);
			}
			//It is DAG no cycle
		}
		st.push(node);
	}
}
