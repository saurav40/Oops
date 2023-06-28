package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree0_5_Reorder_BST {
	public static void main(String[] args) {
       Node root = new Node(7);
       root.left = new Node(5);
       root.right = new Node(9);
       root.right.left = new Node(8);
       root.right.right = new Node(11);
       root.right.right.left = new Node(10);
       root.left.left = new Node(3);
       root.left.right = new Node(6);
       root.left.left.left = new Node(2);
       root.left.left.right = new Node(4);
       inorder(root);
       reorderBST(root);
       System.out.println();
       inorder(root);
	}
	private static void reorderBST(Node root)
	{
		if(root==null)
			 return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node node = q.poll();
			
			if(node.left != null) 
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
			
			if(!q.isEmpty())
			{
				Node tmp = node.left;
				node.left = node.right;
				node.right = tmp;
			}
		}
	}
	private static void inorder(Node root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.Data+" ");
		inorder(root.right);
	}
}
