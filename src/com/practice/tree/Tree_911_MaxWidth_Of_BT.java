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
		   System.out.println("Maximum Width Of Tree : "+maxWidth_of_BT(root));
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
