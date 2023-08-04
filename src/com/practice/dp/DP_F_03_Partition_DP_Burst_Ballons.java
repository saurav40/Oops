package com.practice.dp;

import java.util.Arrays;

public class DP_F_03_Partition_DP_Burst_Ballons {
	public static void main(String[] args) {
       System.out.println(maxCoins(new int[] {3,1,4,5}));
	}
	/*
	 *  Partially understood the problem : just remembering the problem 
	 *  Need to revisit some reference to understand this solution
	 */
	static int maxCoins(int coins[])
	{
		int n=coins.length;
		int coinsArray[]= new int[n+2];
		int k = 1;
		for(int i=0;i<n;i++)
			coinsArray[k++] = coins[i];
		coinsArray[0] = 1;
		coinsArray[n+1] = 1;
		System.out.println(maxCoinsR(1,n,coinsArray));
		//memoization
		
		int dp[][] = new int[n+1][n+1];
		for(int i=0;i<=n;i++)
			Arrays.fill(dp[i],-1);
	
		System.out.println(maxCoinsM(1, n, coinsArray, dp));
		return maxCoinT(coinsArray, n);
	}
	static int maxCoinT(int coins[],int n)
	{
		int dp[][] = new int[n+2][n+2];
		//base case byDefault satisfied the condition
		for(int i=n;i>=1;i--)
			for(int j=1;j<=n;j++)
			{
			    if(i>j)
			    	continue;
				int maxCoin = Integer.MIN_VALUE;
				for(int k=i;k<=j;k++)
				{
					int cost = coins[i-1]*coins[k]*coins[j+1] + dp[i][k-1] + dp[k+1][j];
					maxCoin = Math.max(maxCoin, cost);
				}
				dp[i][j] = maxCoin;
			}
		return dp[1][n];
	}
	static int maxCoinsM(int i,int j,int [] coins,int [][] dp)
	{
		if(i>j)
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
	    int maxCoin = Integer.MIN_VALUE;
		for(int k=i;k<=j;k++)
		{
			int cost = coins[i-1]*coins[k]*coins[j+1] + maxCoinsM(i, k-1, coins, dp) + maxCoinsM(k+1, j, coins, dp);
			maxCoin = Math.max(maxCoin, cost);
		}
		return dp[i][j] = maxCoin;
	}
	static int maxCoinsR(int i,int j,int []coins)
	{
		 if(i>j)
			 return 0;
		 int maxCoin = Integer.MIN_VALUE;
		 for(int  k=i;k<=j;k++)
		 {
			 int cost = coins[i-1]*coins[k]*coins[j+1] + maxCoinsR(i, k-1, coins) + maxCoinsR(k+1, j, coins);
			 maxCoin = Math.max(maxCoin, cost);
		 }
		 return maxCoin;
	}
} 
