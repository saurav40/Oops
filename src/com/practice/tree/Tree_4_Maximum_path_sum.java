package com.practice.tree;

public class Tree_4_Maximum_path_sum {
	public static void main(String[] args) {
      Node root = new Node(-10);
      root.left = new Node(9);
      root.right = new Node(20);
      root.right.left = new Node(15);
      root.right.right = new Node(7);
      System.out.println("Maxmimum Sum : "+maxPathSum(root));
	}
	private static int maxPathSum(Node root)
	{
		int[] maxSum = {0};
		height(root, maxSum);
		return maxSum[0];
	}
	private static int height(Node root,int[] maxSum)
	{
		if(root == null)
			return 0;
		int lsum = height(root.left,maxSum);
		//to handle negative
		    lsum=Math.max(0, lsum);
		int rsum = height(root.right,maxSum);
		    rsum = Math.max(0, rsum);
		
		 maxSum[0]=Math.max(maxSum[0],root.Data+lsum+rsum);
		 
		 return root.Data + Math.max(lsum, rsum);
	
	}
}
