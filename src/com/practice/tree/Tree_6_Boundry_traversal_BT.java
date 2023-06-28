package com.practice.tree;

import java.util.ArrayList;

public class Tree_6_Boundry_traversal_BT {
	public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        root.right.right.left = new Node(10);
        root.right.right.left.left= new Node(11);
        root.right.right.left.right = new Node(12);
        
        ArrayList<Integer> out = boundaryAntiClockWise(root);
        for(int x : out)
        {
        	System.out.print(x+" ");
        }
        
      }
	private static boolean isLeaf(Node node)
	{
		if(node.left==null && node.right == null)return true;
		return false;
	}
	private static void addLeftBoundary(Node root,ArrayList<Integer> res)
	{
		Node curr = root.left;
		while(curr!=null) {
		if(!isLeaf(curr))
			res.add(curr.Data);
		if(curr.left!=null)curr=curr.left;
		else 
			curr = curr.right;
		}
	}
	private static void addLeaves(Node root,ArrayList<Integer> res)
	{ 
		if(root == null)
			  return;
		
		if(isLeaf(root))
		{
			res.add(root.Data);
			return;
		}
		addLeaves(root.left, res);
		addLeaves(root.right, res);
	}
	private static void addRightBoundary(Node root,ArrayList<Integer> res)
	{
		Node curr = root.right;
		ArrayList<Integer> tmp = new ArrayList<>();
		while(curr!=null)
		{
			if(!isLeaf(curr))
				tmp.add(curr.Data);
			if(curr.right !=null)
				curr=curr.right;
			else
				curr=curr.left;
		}
		int n=tmp.size();
        for(int i=n-1;i>=0;i--)
        {
        	res.add(tmp.get(i));
        }
	}
	private static ArrayList<Integer> boundaryAntiClockWise(Node root)
	{
		ArrayList<Integer> res = new ArrayList<>();
		if(isLeaf(root)==false)
			res.add(root.Data);
		addLeftBoundary(root,res);
		addLeaves(root,res);
		addRightBoundary(root,res);
			
	    return res;
	}
}
