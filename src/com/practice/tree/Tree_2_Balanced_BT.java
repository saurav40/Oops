package com.practice.tree;

public class Tree_2_Balanced_BT {
  public static void main(String[] args) {
	     Node root = new Node(1);
	     root.left = new Node(2);
	     root.right = new Node(3);
	     root.left.left = new Node(4); 
	     root.left.right = new Node(5);
	     root.left.right.left = new Node(8);
	     root.right.left = new Node(6);
	     root.right.right = new Node(7);
	     root.right.right.left = new Node(9);
	     root.right.right.right = new Node(10);
	     //root.right.right.right.right = new Node(11);
	     System.out.println("Balanced : "+isBalalancedBT(root));
	     System.out.println("IsBalanced : "+isBalancedBinaryTree(root));
}
  //Naive approach --o(n)*o(n)
  private static boolean isBalalancedBT(Node root)
  {
	  if(root == null)
		   return true;
	  
	  int lh = height(root.left);
	  int rh = height(root.right);
	  
	  if(Math.abs(lh-rh)>1)
		   return false;
	  boolean left = isBalalancedBT(root.left);
	  boolean right = isBalalancedBT(root.right);
	  
	  return left && right;
  }
  private static int height(Node root)
  {
	  if(root == null)
		  return 0;
	  int lh = height(root.left);
	  int rh = height(root.right);
	  
	  return 1+Math.max(lh, rh);
	  
  }
  
  // Optimized 
  private static boolean isBalancedBinaryTree(Node root)
  {
	  if(root == null)
		   return true;
	  
	  if(check(root)== -1)
		  return false;
	  return true;
  }
  private static int check(Node root)
  {
	  if(root==null)
		  return 0;
	  
	  int lh = check(root.left);
	  int rh = check(root.right);
	  if(lh==-1 || rh==-1)
		  return -1;
	  if(Math.abs(lh-rh)>1)
		  return -1;
	  return 1+Math.max(lh, rh);
  }
}
