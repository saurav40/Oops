package com.practice.graph;

public class Graph_Adjacency_Matrix {
	int vertext;
	int adj_matrix[][];

	public Graph_Adjacency_Matrix(int v) {
		this.vertext = v;
		adj_matrix = new int[v][v];
	}

	// undirected
	void addEdge(int u, int v) {
		if (u >= 0 && u < this.vertext && v >= 0 && v < this.vertext) {
			adj_matrix[u][v] = 1;
			adj_matrix[v][u] = 1;
		}
	}

	public int[][] getAdj_matrix() {
		return adj_matrix;
	}

	public void setAdj_matrix(int[][] adj_matrix) {
		this.adj_matrix = adj_matrix;
	}

}
