package com.practice.tree;

public class Tree_5_IsIdentical_BT {
	public static void main(String[] args) {
       Node root1 = new Node(1);
       Node root2 = new Node(1);
       root1.left = new Node(2);
       root2.left = new Node(2);
       root1.right =  new Node(3);
       root2.right =  new Node(3);
       root1.left.left =  new Node(4);
       root2.left.left = new Node(4);
       root1.left.right = new Node(5);
      root2.left.right = new Node(6);
       System.out.println(isIdenticalBT(root1, root2));
       
	}
	private static boolean isIdenticalBT(Node rootA,Node rootB)
	{
		if(rootA==null && rootB==null)
			return true;
		if(rootA!=null && rootB==null)return false;
		if(rootA==null && rootB!=null)return false;
		
		return rootA.Data == rootB.Data &&(isIdenticalBT(rootA.left, rootB.left) && isIdenticalBT(rootA.right, rootB.right));
			
	}
}
