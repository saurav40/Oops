package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
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
	     levelOrder(root);
	}
	private static void levelOrder(Node root)
	{
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty())
		{
			int len = q.size();
			for(int i=0;i<len;i++)
			{
				Node tmp = q.poll();
				System.out.print(tmp.Data+" ");
				if(tmp.left!=null)
					q.add(tmp.left);
				if(tmp.right!=null)
					q.add(tmp.right);
			}
			System.out.println();
		}
		
	}
}
