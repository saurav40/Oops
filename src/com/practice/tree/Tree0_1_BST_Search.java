package com.practice.tree;

public class Tree0_1_BST_Search {
	public static void main(String[] args) {
      Node root = new Node(8);
      root.left = new Node(3);
      root.right = new Node(10);
      root.left.left = new Node(1);
      root.left.right = new Node(6);
      root.right.right = new Node(14);
      root.right.right.left = new Node(13);
      root.left.right.left = new Node(4);
      root.left.right.right = new Node(7);
      boolean isFound = searchBST(root,89);
      if(isFound)
    	  System.out.println("Found");
      else
    	  System.out.println("Not Found");
      
	}
	private static boolean searchBST(Node root,int val)
	{
		 if(root==null)
			 return false;
	     if(root!=null && root.Data == val)
	    	 return true;
	     boolean leftSubtree = searchBST(root.left,val);
	     boolean rightSubtree = searchBST(root.right, val);
	     if(leftSubtree || rightSubtree)
	    	 return true;
		return false;
	}
}
