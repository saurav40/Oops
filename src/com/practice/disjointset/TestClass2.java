package com.practice.disjointset;

public class TestClass2 {
  public static void main(String[] args) {
	
//	DisjointSet.v = 7;
//	DisjointSet set = new DisjointSet();
//	//print(set);
//	set.unionBySize(1, 2);
//	//print(set);
//    set.unionBySize(2, 3);
//    set.unionBySize(4, 5);
//    set.unionBySize(6, 7);
//    
//    //Check 1 & 5 belongs to same component or not
//    if(set.findUParent(4) == set.findUParent(5))
//    	System.out.println("true");
//    else System.out.println("false");
//    set.unionBySize(5, 6);
//    set.unionBySize(3, 7);
//    print(set);
	  DisjointSet.v = 4;
	  DisjointSet ds = new DisjointSet();
	  ds.unionBySize(0, 1);
	  ds.unionBySize(1, 0);
	  ds.unionBySize(1, 3);
	  ds.unionBySize(3, 1);
	  print(ds);
	
	
	
 }
 public static void print(DisjointSet set)
 {
	    System.out.print("Ultimate Parents :");
	    for(int i = 0; i <= 3 ; i++)
			System.out.print(set.findUParent(i)+" ");
		System.out.println("");
		System.out.print("Size Array :      ");
		for(int i = 0; i <= 3 ; i++)
			System.out.print(set.size[i]+" ");
		System.out.println();
 }
}
