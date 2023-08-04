package com.practice.dp;

import java.util.Arrays;

/*
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class DP_A_002_Climibing_Stairs {
	public static void main(String[] args) {
      System.out.println(climbStairsR(5));
      int n=45;
      int dp[]=new int[n];
      Arrays.fill(dp,-1);
      System.out.println(climbStairsM(n,dp));
      System.out.println(climbStairsT(20));
      System.out.println(climbStairsSpace(12));
	}
	static int climbStairsSpace(int n)
	 {
		 if(n<=2)
		    return n;

		 int prev=1;
		 int curr=2;
		 for(int i=2;i<n;i++)
		 {
			  int temp = curr;
			  curr=curr+prev;
				prev = temp;
		 }
		 return curr;

	 }
	static int climbStairsT(int n)
	 {
		 if(n<=2)
		    return n;
		 int dp[]=new int[n];

		 dp[0]=1;
		 dp[1]=2;
		 for(int i=2;i<n;i++)
		 {
			 dp[i]=dp[i-1]+dp[i-2];
		 }
		 return dp[n-1];

	 }
	static int climbStairsM(int n,int []dp)
	{
		if(n<=2)
			return n;
		if(dp[n-1] != -1)
			return dp[n-1];
		return dp[n-1]=climbStairsM(n-1,dp)+climbStairsM(n-2,dp);
	}
	static int climbStairsR(int n)
	{
		if(n<=2)
			return n;
		return climbStairsR(n-1)+climbStairsR(n-2);
	}
}
