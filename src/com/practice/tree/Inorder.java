package com.practice.tree;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {
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
    // inorder(root);
     iterativInorder(root);
	}
	//Iterative using STACK
	private static void iterativInorder(Node root)
	{
		ArrayList<Integer> inorder = new ArrayList<>();
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
				curr = st.peek();
				inorder.add(curr.Data);
				st.pop();
				curr=curr.right;
			}
		}
		for(int x:inorder)
		{
			System.out.print(x+" ");
		}
		
	}
	//Recursive
	private static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.Data);
		inorder(root.right);
	}
}
