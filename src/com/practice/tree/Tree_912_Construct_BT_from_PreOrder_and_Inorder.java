package com.practice.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Tree_912_Construct_BT_from_PreOrder_and_Inorder {
	public static void main(String[] args) {
        int [] inOrder = {9,3,15,20,7};
        int [] preOrder = {3,9,20,15,7};
        
        Node root = constructBT(inOrder,preOrder);
        inorder(root);
        System.out.println();
        preOrder(root);
	}
	private static Node constructBT(int[] inOrder,int [] preOrder)
	{
		Map<Integer,Integer> mp = new HashMap();
		for(int i =0;i<inOrder.length;i++)
			mp.put(inOrder[i],i);
		Node root = helper(inOrder,0,inOrder.length-1,preOrder,0,preOrder.length-1,mp);
		return root;
	}
	private static Node helper(int[] in,int inStart,int inEnd,int [] pre,int preStart,int preEnd,Map<Integer,Integer> mp)
	{
		if(inStart > inEnd || preStart > preEnd)
			return null;
		Node root = new Node(pre[preStart]);
		
		int inRoot = mp.get(pre[preStart]);
		int inLeft = inRoot-inStart;
		
		root.left = helper(in,inStart,inRoot-1,pre,preStart+1,preStart+inLeft,mp);
		root.right = helper(in,inRoot+1,inEnd,pre,preStart+inLeft+1,preEnd,mp);
		return root;
	}
	private static void inorder(Node root)
	{
		Stack<Node> st = new Stack<>();
		Node curr = root;
		while(true)
		{
			if(curr != null)
			{
				st.push(curr);
				curr = curr.left;
			}
			else
			{
				if(st.isEmpty())break;
				curr = st.pop();
				System.out.print(curr.Data+" ");
				curr = curr.right;
			}
		}
	}
	private static void preOrder(Node root)
	{
		Stack<Node> st = new Stack<>();
		st.add(root);
		
		while(!st.isEmpty())
		{
			Node tmp = st.pop();
			System.out.print(tmp.Data+" ");
			if(tmp.right != null)
			{
				st.push(tmp.right);
			}
			if(tmp.left != null)
			{
				st.push(tmp.left);
			}
		}
	}
}
