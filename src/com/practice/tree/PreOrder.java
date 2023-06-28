package com.practice.tree;

import java.util.Stack;

public class PreOrder {
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
	     
	     preOrder(root);
	     System.out.println();
	     preOrderIterative(root);
	}
	private static void preOrder(Node root)
	{
		if(root == null)
			return;
		System.out.print(root.Data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	private static void preOrderIterative(Node root)
	{
		if(root== null)
			 return;
		Node curr = root;
		Stack<Node> st = new Stack();
		st.push(curr);
		
		while(!st.isEmpty())
		{
			Node node = st.pop();
			System.out.print(node.Data+" ");
			if(node.right!=null)
				st.push(node.right);
			if(node.left!=null)
				st.push(node.left);
		}

}
}
