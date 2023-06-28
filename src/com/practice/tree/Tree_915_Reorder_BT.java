package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_915_Reorder_BT {
	public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.left.left.left = new Node(8);
       root.left.left.right = new Node(9);
        inorder(root);
        reorderBT(root);
        System.out.println();
        inorder(root);
	}
	private static void reorderBT(Node root)
	{
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node tmp = q.peek();
			q.remove();
		    if(tmp.left != null)
		    	q.add(tmp.left);
		    if(tmp.right!=null)
		    	q.add(tmp.right);
		    
		    if(!q.isEmpty())
		    {
		    	Node tmp_node = tmp.left;
		    	tmp.left = tmp.right;
		    	tmp.right = tmp_node;
		    }
		}
	}
	private static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.Data+" ");
		inorder(root.right);
	}
}
