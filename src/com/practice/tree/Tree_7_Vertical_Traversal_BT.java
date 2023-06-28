package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Tree_7_Vertical_Traversal_BT {
	public static void main(String[] args) {
         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(5);
         root.left.left = new Node(3);
         root.left.right = new Node(4);
         root.left.left.left = new Node(9);
         root.left.left.right = new Node(10);
         root.right.left = new Node(6);
         root.right.right = new Node(7);
         List<List<Integer>> res = verticalOrder(root);
         for(List<Integer> x : res)
         {
        	 for(int y : x)
        		 System.out.print(y+" ");
        	 System.out.println();
         }
         List<List<Integer>> res2=verticalOrder2(root);
         for(List<Integer> y : res2) {
        	 for(int x : y)
        	 {
        		 System.out.print(x+" ");
        	 }
        	 System.out.println();
         }
	}
	private static List<List<Integer>> verticalOrder(Node root)
	{
		TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(root,0,0));
		while(!q.isEmpty())
		{
			Node tmp = q.peek().node;
			int  vertical = q.peek().x;
			int  level = q.peek().y;
			q.remove();
			
			if(!mp.containsKey(vertical))
				 mp.put(vertical,new TreeMap<>());
			if(!mp.get(vertical).containsKey(level))
				mp.get(vertical).put(level,new PriorityQueue<>());
			
			mp.get(vertical).get(level).add(tmp.Data);
			if(tmp.left!=null)
				q.add(new Tuple(tmp.left,vertical-1,level+1));
			if(tmp.right!=null)
				q.add(new Tuple(tmp.right,vertical+1,level+1));		
				
		}
		
		List<List<Integer>> result = new ArrayList<>();
		
		for(TreeMap<Integer, PriorityQueue<Integer>> entry : mp.values())
		{
			result.add(new ArrayList<>());
			for(PriorityQueue<Integer> pq:entry.values())
			{
				while(!pq.isEmpty())
				{
					result.get(result.size()-1).add(pq.poll());
				}
			}
		}
		return result;
	}
	private static List<List<Integer>> verticalOrder2(Node root)
	{
		TreeMap<Integer,PriorityQueue<Integer>> mp = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		q.add(new Pair(root,0));
		
		while(!q.isEmpty())
		{
			Node tmp = q.peek().node;
			int h = q.peek().hd;
			q.remove();
			
			if(!mp.containsKey(h))
				mp.put(h,new PriorityQueue<>());
			mp.get(h).add(tmp.Data);
			
			if(tmp.left != null)
				 q.add(new Pair(tmp.left,h-1));
			if(tmp.right != null)
				q.add(new Pair(tmp.right,h+1));
		}
		System.out.println("_____________");
		for(int i=0;i<mp.size();i++)
			result.add(new ArrayList<>());
		int i=0;
		for(PriorityQueue<Integer> pq:mp.values())
		{
			while(!pq.isEmpty())
			{
				result.get(i).add(pq.poll());
			}
			i++;
			//System.out.println();
		}
		return result;
	}
}
