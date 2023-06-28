package com.practice.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Tree_913_Construct_BT_from_PostOrder_and_Inorder {
	public static void main(String[] args) {
       int[] in = {8,4,9,2,5,1,6,3,7};
       int[] post = {8,9,4,5,2,6,7,3,1};
       Node root = constructBT(in, post);
       inorder(root);
       System.out.println();
       postorder(root);
       
	}
	private static Node constructBT(int[] inorder,int[] postorder)
	{
		Map<Integer, Integer> mp = new HashMap<>();
		for(int i=0;i<inorder.length;i++)
		{
		   mp.put(inorder[i],i);
		}
		Node root = helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,mp);
		
		return root;
	}
	private static Node helper(int[] in,int inStart,int inEnd,int[] post,int postStart,int postEnd,
			Map<Integer,Integer> mp)
	{
		if(inStart > inEnd || postStart > postEnd)return null;
		
		Node root = new Node(post[postEnd]);
		
		int inRoot = mp.get(post[postEnd]);
		int inLeft = inRoot-inStart;
		
		root.left = helper(in, inStart, inRoot-1, post, postStart,postStart+inLeft-1, mp);
		root.right = helper(in,inRoot+1,inEnd,post,postStart+inLeft,postEnd-1,mp);
		return root;
	}
	private static void inorder(Node root)
	{
		Node curr = root;
		Stack<Node> st = new Stack<>();
		while(true)
		{
			if(curr!=null)
			{
				st.push(curr);
				curr=curr.left;
			}
			else
			{
				if(st.isEmpty())break;
				curr=st.peek();
				System.out.print(curr.Data+" ");
				st.pop();
				curr = curr.right;
			}
		}
	}
	private static void postorder(Node root)
	{
		if(root == null)
			return;
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		st1.add(root);
		while(!st1.isEmpty())
		{
			Node tmp = st1.pop();
			st2.add(tmp);
			
			if(tmp.left != null)
				st1.add(tmp.left);
			if(tmp.right != null)
				st1.add(tmp.right);
		}
		while(!st2.isEmpty())
		{
			System.out.print(st2.pop().Data+" ");
		}
	}
}
