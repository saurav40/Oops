package com.practice.tree;

public class Tree0_4_BST_Validate_BST {
	public static void main(String[] args) {
        Node root = new Node(13);
        root.left = new Node(10);
        root.right = new Node(15);
        root.right.left = new Node(14);
        root.right.right = new Node(17);
        root.right.right.left = new Node(16);
        root.left.left = new Node(7);
        root.left.right = new Node(14);
        root.left.left.right = new Node(9);
        root.left.left.right.left = new Node(8);
        if(isValidBST(root))
           System.out.println("Valid");
        else
        	System.out.println("Not Valid");
        
	}
	// Time Complexity = O(n)
	// Space Complexity = O(1)
	private static boolean isValidBST(Node root)
	{
		return checkValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private static boolean checkValidBST(Node root,Integer minValue,Integer maxValue)
	{
		if(root == null)
			 return true;
		if(root.Data <minValue || root.Data > maxValue)
			return false;
		
		return (checkValidBST(root.left, minValue,root.Data) && checkValidBST(root.right,root.Data, maxValue));
	}
}
