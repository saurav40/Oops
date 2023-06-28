package com.practice.dp;

import java.util.Arrays;

public class DP_B_03_Coin_Change_Max_no_of_ways {
	public static void main(String[] args) {
		int sum = 4;
		int coins[] = {1,2,3};
		
		// count how many subset of coins exists that sum is equal to 4;
		//1.recursion
	    System.out.println(coinChangeR(coins,sum,coins.length));
	    /*
	     * Memo
	     */
	    int[][] dp = new int[coins.length+1][sum+1];
	    for(int i=0;i<=coins.length;i++)
	        Arrays.fill(dp[i], -1);
	    System.out.println(coinChangeM(coins,sum,coins.length,dp));
	    System.out.println(coinChangeT(coins, sum));
	
	}
	 static int coinChangeT(int coins[],int sum)
	 {
		 int n = coins.length;
		 int dp[][] = new int[n+1][sum+1];
		 for(int i=0;i<=n;i++)
		 {
			 dp[i][0] =1;
		 }
		 for(int j=0;j<=sum;j++)
			 dp[0][j] = 0;
		 
		 for(int i=1;i<=n;i++)
			 for(int j=1;j<=sum;j++)
			 {
				 if(coins[i-1]<=j)
					{
						int include = dp[i][j-coins[i-1]];
						int notInclude = dp[i-1][j];
						//total no ways is
						dp[i][j] = include + notInclude;
					}
					else //no take
						 dp[i][j] = dp[i-1][j];
			 }
		 return dp[n][sum];
	 }
	 static int coinChangeM(int[] coins,int sum,int n,int [][] dp)
		{
			if(sum==0)
				return 1;
			if(n==0)
				return 0;
			if(dp[n][sum] != -1)
			    return dp[n][sum];
			//take
			if(coins[n-1]<=sum)
			{
				int include = coinChangeM(coins, sum-coins[n-1], n,dp);
				int notInclude = coinChangeM(coins, sum, n-1,dp);
				//total no ways is
				return dp[n][sum] = include + notInclude;
			}
			else //no take
				return dp[n][sum] = coinChangeM(coins, sum, n-1,dp);
		}
	static int coinChangeR(int[] coins,int sum,int n)
	{
		if(sum==0)
			return 1;
		if(n==0)
			return 0;
		
		//take
		if(coins[n-1]<=sum)
		{
			int include = coinChangeR(coins, sum-coins[n-1], n);
			int notInclude = coinChangeR(coins, sum, n-1);
			//total no ways is
			return include + notInclude;
		}
		else //no take
			return coinChangeR(coins, sum, n-1);
	}
	
}
