package com.practice.tree;

import java.util.ArrayList;
import java.util.Stack;

public class Tree0_2_BST_Insert {
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
	      root = insert(root, 5);
	      root = insert(root, -1);
	      root = insert(root,0);
	      inorder(root);
	     
	}
	private static Node insert(Node root,int value)
	{
		if(root==null)
		{
			return new Node(value);
		}
		if(value < root.Data)
			root.left = insert(root.left,value);
		if(value > root.Data)
			root.right = insert(root.right, value);
		
		return root;
	}
	private static void inorder(Node root)
	{
		Stack<Node> st = new Stack<>();
		Node curr = root;
		ArrayList<Integer> res = new ArrayList<>();
		
		while(true)
		{
			if(curr != null)
			{
				st.add(curr);
				curr=curr.left;
			}
			else
			{
				if(st.empty())break;
				curr = st.peek();
				st.pop();
				res.add(curr.Data);
				curr=curr.right;
		   }
		}
		for(int x:res)
			System.out.print(x+" ");
	}
}
