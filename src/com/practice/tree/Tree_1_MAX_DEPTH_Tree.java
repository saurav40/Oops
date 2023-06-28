package com.practice.tree;

public class Tree_1_MAX_DEPTH_Tree {
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
	     root.right.right.right.right = new Node(11);
	     System.out.println(maxDepthOfTree(root));
	}
	private static int maxDepthOfTree(Node root)
	{
		if(root == null)
			return 0;
		
		int lh = maxDepthOfTree(root.left);
		int rh = maxDepthOfTree(root.right);
		
		return 1+Math.max(lh, rh);
	}
}
