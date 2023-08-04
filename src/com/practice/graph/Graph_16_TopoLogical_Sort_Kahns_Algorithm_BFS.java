package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_16_TopoLogical_Sort_Kahns_Algorithm_BFS {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int V = 5;
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(3).add(4);
		if (isCyclic(V, adj))
			System.out.println("YES");
		else
			System.out.println("No");
	}

	private static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		/*
		 * Using Topological Sort : Kahn's alogorithm
		 */
		int indegree[] = new int[V];
		for (int i = 0; i < V; i++) {
			for (int node : adj.get(i)) {
				indegree[node]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int cnt = 0;

		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			cnt++;

			for (int adjNode : adj.get(node)) {
				indegree[adjNode]--;
				if (indegree[adjNode] == 0) {
					q.add(adjNode);
				}
			}
		}
		if (cnt != V) // cycle present
			return true;
		return false;
	}
}
