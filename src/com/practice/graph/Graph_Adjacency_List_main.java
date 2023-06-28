package com.practice.graph;

public class Graph_Adjacency_List_main {
	public static void main(String[] args) {
       Graph_Adjacency_List g = new Graph_Adjacency_List(4);
       g.addEdge(0, 1);
       g.addEdge(0, 3);
       g.addEdge(1, 2);
       g.addEdge(2, 3);
       g.print();
       System.out.println("");
       //Directed
       Graph_Adjacency_List g2 = new Graph_Adjacency_List(4);
       g2.addDEdge(0, 1);
       g2.addDEdge(0, 2);
       g2.addDEdge(1, 2);
       g2.addDEdge(2, 0);
       g2.addDEdge(2, 3);
       g2.addDEdge(3, 3);
       g2.print();
	}
}
