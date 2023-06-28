package com.practice.graph;
import java.util.*;
public class Graph_Adjacency_List {
  int v;
  ArrayList<ArrayList<Integer>> adj;
  public Graph_Adjacency_List(int v)
  {
	  this.v = v;
	  adj = new ArrayList<>(v);
	  for(int i=0;i<v;i++)
	  {
		  adj.add(new ArrayList<Integer>());
	  }
  }
  
  //undirected graph
  void addEdge(int u, int v)
  {
	  if(u >=0 && u < this.v && v>=0 && v < this.v)
	  {
		  adj.get(u).add(v);
		  adj.get(v).add(u);
	  }
  }
  //directed graph
  void addDEdge(int u,int v)
  {
	  adj.get(u).add(v);
  }
  void print()
  {
	 for(int i = 0; i < adj.size();i++)
	 {
		 System.out.print(i+"->");
		 for(int j = 0;j <adj.get(i).size();j++)
		 {
			 System.out.print(adj.get(i).get(j)+"->");
		 }
		 System.out.println();
	 }
  }
}
