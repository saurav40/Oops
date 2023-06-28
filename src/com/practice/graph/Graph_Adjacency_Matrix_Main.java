package com.practice.graph;

public class Graph_Adjacency_Matrix_Main {
	public static void main(String[] args) {
      Graph_Adjacency_Matrix graph = new Graph_Adjacency_Matrix(4);
      graph.addEdge(0, 1);
      graph.addEdge(0, 3);
      graph.addEdge(1, 2);
      graph.addEdge(2, 3);
      
      int adj_matrix [][] = graph.getAdj_matrix();
      for(int i = 0 ; i < adj_matrix.length;i++) {
    	  for(int j = 0 ; j < adj_matrix[0].length;j++)
    	  {
    		  System.out.print(adj_matrix[i][j]+" ");
    	  }
    	  System.out.println();
      }
	}
}

