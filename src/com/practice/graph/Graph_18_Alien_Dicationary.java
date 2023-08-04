package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_18_Alien_Dicationary {
	public static void main(String[] args) {
       String dict[] = {"baa",
    		            "abcd",
    		            "abca",
    		            "cab",
    		            "cad"};
       int N = dict.length;
       int K = 4;
       String res = alphabetsOrder(N, K, dict);
       System.out.println(res);
	}
	private static String alphabetsOrder(int N,int K,String dict[])
	{
		//Make adjList for K charaters [k=4 -> a,b,c,d]->{0,1,2,3}] 
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<K;i++)
			adjList.add(new ArrayList<>());
		
		for(int i=0;i<N-1;i++)
		{
			String s1 = dict[i];
			String s2 = dict[i+1];
			
			int len = Math.min(s1.length(), s2.length());
			
			for(int j=0;j<len;j++)
			{
				if(s1.charAt(j) != s2.charAt(j))
				{
					int u = s1.charAt(j)-'a';
					int v = s2.charAt(j)-'a';
					adjList.get(u).add(v);
					break;
				}
			}
		}
		int res[] = topoSort(K,adjList);
		String order = "";
		for(int node :res)
		{
			order += (char)(node+(int)('a'));
		}
		return order;
	}
	private static int[] topoSort(int K,ArrayList<ArrayList<Integer>> adj)
	{
		int indegree[] = new int[K];
		
		for(int i=0;i<K;i++)
		{
			for(int adjNode : adj.get(i))
			{
				indegree[adjNode]++;
			}
		}
        
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<K;i++)
		{
			if(indegree[i]==0)
				q.add(i);
		}
		
		ArrayList<Integer> topo = new ArrayList<>();
		while(!q.isEmpty())
		{
			int node = q.peek();
			q.remove();
			
			topo.add(node);
			for(int adjNode : adj.get(node))
			{
				indegree[adjNode]--;
				if(indegree[adjNode] == 0)
				{
					q.add(adjNode);
				}
			}
		}
		return topo.stream().mapToInt(Integer::intValue).toArray();
	}
}
