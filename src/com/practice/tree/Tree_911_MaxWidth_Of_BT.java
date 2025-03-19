package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_911_MaxWidth_Of_BT {
	public static void main(String[] args) {
		   Node root = new Node(1);
		   root.left = new Node(3);
		   root.right = new Node(2);
		   root.left.left = new Node(5);
		   root.left.right = new Node(3);
		   root.right.right = new Node(9);
		   //System.out.println("Maximum Width Of Tree : "+maxWidth_of_BT(root));
		   
		   Node root1 = new Node(1);
		   root1.left = new Node(2);
		   root1.left.left = new Node(4);
		   root1.left.left.left = new Node(5);
		   root1.left.left.left.left = new Node(6);
		   
		   root1.right = new Node(3);
		   root1.right.right =new Node(7);
		   root1.right.right.right = new Node(10);
		   System.out.println("Max width :"+ maxWidthOfBinaryTree(root1));
		   
	}
	private static int maxWidthOfBinaryTree(Node root) {
		if(root == null)
			return 0;
		
		int width = 0;
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()) {
			int minIndexNodeAtLevel = q.peek().hd;
			
			int size = q.size();
			int leftIndex =0;
			int rightIndex = 0;
			for(int i=1;i<=size;i++) {
				int parentIndex = q.peek().hd;
				Node node = q.peek().node;
				q.remove();
				
				if(i==1) {
					// Store left most index
					leftIndex = parentIndex;
				}
				
				if(i == size) {
					rightIndex = parentIndex;
				}
				
				//Base index to push child into queue(0,1,2 .......n) at each level
				int baseIndex = parentIndex - minIndexNodeAtLevel;
				
				if(node.left != null) {
					q.add(new Pair(node.left, 2*baseIndex+1));
				}
				
				if(node.right != null) {
					q.add(new Pair(node.right, 2*baseIndex+2));
				}
			}
			width = Math.max(width, rightIndex-leftIndex+1);
		}
		return width;
	}
	private static int maxWidth_of_BT(Node root)
	{
		if(root == null) return 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root,0));
		int width = 0;
		while(!q.isEmpty())
		{
			int minAtLevel = q.peek().hd;
			int len = q.size();
			int leftIndex=0,righIndex=0;
			for(int i=1;i<=len;i++)
			{
				int parentLevel = q.peek().hd;
				Node tmp = q.peek().node;
				q.remove();
				
				//left
				if(i==1)
					leftIndex = parentLevel;
				//right
				if(i==len)
					 righIndex = parentLevel;
			
				int index = parentLevel-minAtLevel;
				if(tmp.left != null)
					q.add(new Pair(tmp.left,2*index+1));
				if(tmp.right != null)
					q.add(new Pair(tmp.right,2*index+2));
			}
			width = Math.max(width, righIndex-leftIndex+1);
		}
		return width;
	}
	
}
