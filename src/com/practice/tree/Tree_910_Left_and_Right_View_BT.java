package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_910_Left_and_Right_View_BT {
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
       //Left View 
       ArrayList<Integer> leftView = leftView(root);
       ArrayList<Integer> rightView = rightView(root);
       for(int x:leftView)
    	   System.out.print(x+" ");
       System.out.println();
       for(int y:rightView)
    	   System.out.print(y+" ");
	}
	private static ArrayList<Integer> leftView(Node root)
	{
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Node> q = new LinkedList<>(); 
		q.add(root);
		while(!q.isEmpty())
		{
			int len = q.size();
			for(int i=1;i<=len;i++)
			{
				Node tmp = q.peek();
				q.remove();
				if(i==1)
					result.add(tmp.Data);
				if(tmp.left != null)
					 q.add(tmp.left);
				if(tmp.right != null)
					 q.add(tmp.right);
			}
		}
		return result;
	}
	private static ArrayList<Integer> rightView(Node root)
	{
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Node> q = new LinkedList<>(); 
		q.add(root);
		while(!q.isEmpty())
		{
			int len = q.size();
			for(int i=1;i<=len;i++)
			{
				Node tmp = q.peek();
				q.remove();
				if(i==len)
					result.add(tmp.Data);
				if(tmp.left != null)
					 q.add(tmp.left);
				if(tmp.right != null)
					 q.add(tmp.right);
			}
		}
		return result;
	}
}
