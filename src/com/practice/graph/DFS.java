package com.practice.graph;

import java.util.*;

public class DFS {
	int v;
	ArrayList<ArrayList<Integer>> adj;

	public DFS(int v) {
		this.v = v;
		adj = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}
	}

	void addDEdge(int u, int v) {
		adj.get(u).add(v);
	}

	void print() {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + "->");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + "->");
			}
			System.out.println();
		}
	}

	ArrayList<Integer> dfs (int src){
		ArrayList<Integer> result = new ArrayList<>();
		boolean visited[] = new boolean[this.v];
	    //sited[src] = true;
	    dfsUtill(src,visited,result);
		return result;
	}
	private void dfsUtill(int src, boolean[] visited, ArrayList<Integer> result) {
		// TODO Auto-generated method stub
		visited[src] = true;
		result.add(src);
		
		for(int adjNode : adj.get(src))
		{
			if(!visited[adjNode])
			{
				dfsUtill(adjNode,visited,result);
			}
		}			
	}			
				
	public static void main(String[] args) {
		DFS graph = new DFS(4);
		graph.addDEdge(0, 1);
		graph.addDEdge(0, 2);
		graph.addDEdge(1, 2);
		graph.addDEdge(2, 0);
		graph.addDEdge(2, 3);
		graph.addDEdge(3, 3);

		ArrayList<Integer> res = graph.dfs(2);
		for (int vertex : res) {
			System.out.print(vertex + ",");
		}
	}
}
