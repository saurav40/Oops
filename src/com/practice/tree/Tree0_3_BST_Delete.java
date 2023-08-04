package com.practice.tree;

public class Tree0_3_BST_Delete {
	public static void main(String[] args) {
		  Node root = new Node(8);
		  root.left = new Node(5);
		  root.right = new Node(12);
		  root.right.left = new Node(10);
		  root.right.right = new Node(13);
		  root.left.left = new Node(2);
		  root.left.right = new Node(7);
		  root.left.left.left = new Node(1);
		  root.left.left.right = new Node(3);
		  root.left.left.right.right = new Node(4);
		  root.left.right.left = new Node(6);
		  root.left.right.right = new Node(8);
		  inorder(root);
		  root = deleteBST(root,5);
		  System.out.println();
		  inorder(root);
		  }
	private static Node deleteBST(Node root,int value)
	{
		if(root == null)
			return root;
		if(root.Data == value)
		{
			return helper(root);
		}
		
		Node dummy = root;
		while(root!=null)
		{
			if(root.Data > value)
			{
			    if(root.left != null && root.left.Data == value)
			    {
			    	root.left = helper(root.left);
			    	break;
			    } 
			    else
			    {
			    	root = root.left;
			    }
			    
			}
			else if(root.Data < value)
			{
				if(root.right != null && root.right.Data == value)
				{
					root.right = helper(root.right);
					break;
				}
				else
					root = root.right;
			}
			
		}
		return dummy;
	}
	private static Node helper(Node root)
	{
		if(root.left == null)
		{
			return root.right;
		}
		else if(root.right == null)
		{
			return root.left;
		}
		else
		{
			Node rightChild = root.right;
			Node leftRight = findLeftRight(root.left);
			leftRight.right = rightChild;
			return root.left;
		}
	}
	private static Node findLeftRight(Node root)
	{
		if(root.right == null)
			return root;
		return findLeftRight(root.right);
	}
	private static void inorder(Node root)
	
	{
		if(root  == null)
			return;
		inorder(root.left);
		System.out.print(root.Data+" ");
		inorder(root.right);
	}
}
