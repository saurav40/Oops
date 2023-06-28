package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_917_Cousin_of_node_BT {
	public static void main(String[] args) {
		 Node root = new Node(1);
		 root.left = new Node(2);
		 root.right = new Node(3);
		 root.left.left = new Node(4);
		 root.left.right = new Node(5);
		 root.right.left = new Node(6);
		 root.right.right = new Node(7);
		 root.left.left.left = new Node(8);
		 root.left.left.right = new Node(9);
		 root.left.right.left = new Node(10);
		 root.left.right.right = new Node(11);
		 root.right.left.left = new Node(12);
		 root.right.left.right = new Node(13);
		 root.right.right.left = new Node(14);
		 root.right.right.right = new Node(15);
		 int level = getLevel(root,0,root.right.right.right);
	     ArrayList<Integer> result = getCousins(root, level, root.right.right.right);
	     for(int x:result)
	    	 System.out.print(x+" ");
	//	 System.out.println(level);	 
	}
	private static ArrayList<Integer> getCousins(Node root,int level,Node node)
	{
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root,0));
		while(!q.isEmpty())
		{
			Node tmp =q.peek().node;
			int depth = q.peek().hd;
			q.remove();
			if(level-1 == depth)
			{
				if(tmp.left !=null && tmp.right != null &&(tmp.left.Data == node.Data || tmp.right.Data == node.Data))
					continue;
				if(tmp.left != null && tmp.left.Data != node.Data)
					 q.add(new Pair(tmp.left,depth+1));
				if(tmp.right != null && tmp.right.Data !=node.Data)
					q.add(new Pair(tmp.right,depth+1));
			}
			else if(depth < level-1)
			{ 
				if(tmp.left != null)
					q.add(new Pair(tmp.left,depth+1));
				if(tmp.right != null)
					q.add(new Pair(tmp.right,depth+1));
			}
			else
				if(level == depth)
				{
					result.add(tmp.Data);
					while(!q.isEmpty())
					{
						Node tmp2 = q.peek().node;
						q.remove();
						
						result.add(tmp2.Data);
					}
				}
			
		}
		
		return result;
	}
	private static int getLevel(Node root,int level,Node node)
	{
		if(root == null)
			return 0;
		if(root == node)
			return level;
		
		int lLevel = getLevel(root.left, level+1, node);
		int rLevel = getLevel(root.right,level+1,node);
	    
		return Math.max(lLevel, rLevel);
	}
}
