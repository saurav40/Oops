package com.testA;


public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
		// TODO Auto-generated constructor stub
		this.left = null;
		this.right = null;

	}

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		inorder(root);
		
	}
  private static void inorder(TreeNode root) {
	  if(root == null) {
		  return;
	  }
	  inorder(root.left);
	  System.out.print(root.data+" ");
	  inorder(root.right);
  }
}
