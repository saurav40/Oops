package com.practice.disjointset;

public class TestClass {
 public static void main(String[] args) {
	DisjointSet.v = 7;
	DisjointSet set = new DisjointSet();
	
	for(int i = 0 ; i <= 7; i++)
	{
		System.out.print(set.findUParent(i)+" ");
	}	
	System.out.println();
	set.unionByRank(1, 2);
	set.unionByRank(2, 3);
	set.unionByRank(4, 5);
	set.unionByRank(6,7);
	set.unionByRank(5, 6);
	// 1 & 4 are in same component??
	if(set.findUParent(1) == set.findUParent(4))
		System.out.println("Yes");
	else 
		System.out.println("No");
	for(int i = 0 ; i <= 7; i++)
	{
		System.out.print(set.findUParent(i)+" ");
	}
	set.unionByRank(3, 7);
	System.out.println();
	if(set.findUParent(1) == set.findUParent(4))
		System.out.println("Yes");
	else 
		System.out.println("No");
	for(int i = 0 ; i <= 7; i++)
	{
		System.out.print(set.findUParent(i)+" ");
	}
	
}
}
