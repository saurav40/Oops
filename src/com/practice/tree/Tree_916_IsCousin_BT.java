package com.practice.tree;

import java.util.Stack;

public class Tree_916_IsCousin_BT {
  public static void main(String[] args) {
	 Node root = new Node(1);
	 root.left = new Node(2);
	 root.right = new Node(3);
	 root.left.left = new Node(4);
	 root.left.right = new Node(5);
	 root.right.left = new Node(6);
	 root.right.right = new Node(7);
	 root.left.left.left = new Node(8);
	 root.left.left.right = new Node(9);
	 root.left.right.left = new Node(10);
	 root.left.right.right = new Node(11);
	 root.right.left.left = new Node(12);
	 root.right.left.right = new Node(13);
	 root.right.right.left = new Node(14);
	 root.right.right.right = new Node(15);
	 //inorder(root);
	 
	 System.out.println(isCousin(root, 8, 9));
  }
  static int found = 0;
  private static int checkCousin(Node root,int x,int y,int depth)
  {
	  if(root == null)
		  return -1;
	  if(root.Data == x || root.Data == y)
	  {
		  found++;
		  return depth;
	  }
	  
	  int lh = checkCousin(root.left, x, y, depth+1);
	  int rh = checkCousin(root.right, x, y, depth+1);
	  
	  if(lh == -1 || rh == -1)
		  return Math.max(lh, rh);
	  if(lh == rh && lh-1 > depth)
		  return depth;
	  return -1;
  }
  private static boolean isCousin(Node root,int x,int y)
  {
	  int pos = checkCousin(root,x,y,0);
	  return pos != -1 && found == 2;
  }
  private static void inorder(Node root)
  {
	  if(root == null)return;
	  
	  Node curr = root;
	  
	  Stack<Node> st = new Stack<>();
	  while(true)
	  {
		  if(curr != null)
		  {
			   st.push(curr);
			   curr = curr.left;
		  }
		  else
		  {
			   if(st.isEmpty())break;
			   curr = st.peek();
			   System.out.print(curr.Data+" ");
			   st.pop();
			   curr = curr.right;
		  }
	  }
  }
}

