package com.practice.tree;

import java.util.Stack;

public class Tree_3_Diameter_BT {
	public static void main(String[] args) {
       Node root = new Node(1);
       root.left =new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.left.left.left = new Node(8);
       root.left.left.right = new Node(9);
       root.left.right.left = new Node(10);
       root.left.right.right = new Node(11);
       root.left.left.left.left = new Node(12);
       root.left.left.left.left.left = new Node(13);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
       
      // inOrder(root);
       
       System.out.println("Diameter Of BT : "+diameterBT(root));
    		   
	}
	private static int diameterBT(Node root)
	{
		int max[]= {0};
		heightTree(root, max);
		return max[0];
	}
	private static int heightTree(Node root,int []max)
	{
		if(root == null)
			return 0;
		
		int lh = heightTree(root.left, max);
		int rh = heightTree(root.right, max);
		
		max[0]=Math.max(lh+rh,max[0]);
		
		return 1+Math.max(lh, rh);
	}
	private static void inOrder(Node root)
	{
	  Node curr = root;
	  Stack<Node> st = new Stack();
	  while(true)
	  {
		if(curr!=null)
		{
			st.push(curr);
			curr=curr.left;
		}
		else
		{
			if(st.isEmpty())break;
		    curr = st.pop();
			System.out.print(curr.Data+" ");
			curr = curr.right;
		}
	  }
	}
}
