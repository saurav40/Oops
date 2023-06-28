package com.practice.tree;

import java.util.Stack;

public class Tree_914_Flatten_BT_into_LinkedList {
	public static void main(String[] args) {
           Node root = new Node(1);
           root.left = new Node(2);
           root.right = new Node(5);
           root.left.left = new Node(3);
           root.left.right = new Node(4);
           root.right.right = new Node(6);
           root.right.right.left = new Node(7);
           
           Node root2 = root;
         //  flattenBTRecursive(root);
           flattenBTIterative(root2);
          // traversalList(root);
           traversalList(root2);
	}
	static Node prev = null;
	//1 .Recursive -O(n) & SC - O(n)
	private static void flattenBTRecursive(Node root)
	{
		if(root == null)
			return;
		
		flattenBTRecursive(root.right);
		flattenBTRecursive(root.left);
		
		root.right = prev;
		root.left = null;
		prev = root;
		
	}
	// 2. Iterative O(n) & O(n)
	private static void flattenBTIterative(Node root)
	{
		Stack<Node> st = new Stack<>();
		st.add(root);
		
		while(!st.isEmpty())
		{
			Node tmp = st.pop();
			
			if(tmp.right != null)
				st.add(tmp.right);
			if(tmp.left != null)
				st.add(tmp.left);
			
			if(!st.isEmpty()) {
				tmp.right = st.peek();
				tmp.left = null;
			}
		}
	}
	private static void traversalList(Node root)
	{
		Node curr = root;
		while(curr != null)
		{
			System.out.print(curr.Data+" ");
			curr=curr.right;
		}
	}
}
