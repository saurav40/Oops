package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree_9_Bottom_View_BT {
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
	      ArrayList<Integer> result = bottomView(root);
	      for(int x : result)
	    	  System.out.print(x+" ");
		}
	private static ArrayList<Integer> bottomView(Node root)
	{
		ArrayList<Integer> result = new ArrayList<>();
		//If u use normal HashMap order will be different so use TreeMap to resolve this
		Map<Integer,Integer> mp = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root,0));
		while(!q.isEmpty())
		{
           Node tmp = q.peek().node;
           int hd = q.peek().hd;
           q.remove();
           if(!mp.containsKey(hd))
        	   mp.put(hd,tmp.Data);
           else
        	   mp.put(hd,tmp.Data);
           if(tmp.left != null)
        	   q.add(new Pair(tmp.left,hd-1));
           if(tmp.right!=null)
        	   q.add(new Pair(tmp.right,hd+1));
		}
		
		for(Map.Entry<Integer,Integer> entry : mp.entrySet())
        {
	           result.add(entry.getValue());
        }
		return result;	
	}
}
