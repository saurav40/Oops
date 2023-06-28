package com.practice.dp;

import java.util.Arrays;

public class DP_B_02_Rod_Cutting_Problem {
	/*
	 * 1.Rod Cutting
	 * 
	 * Given a rod of length n inches and an array of prices that includes prices of
	 * all pieces of size smaller than n. Determine the maximum value obtainable by
	 * cutting up the rod and selling the pieces.
	 * 
	 * Input:length 1 2 3 4 5 6 7 8 --->Assumed Lenth Array 
	 * Price={1, 5, 8, 9, 10,
	 * 17, 17, 20} 
	 * maX_Length=size(arr)=8 -->calculated
	 * find maximum profit
	 */
	public static void main(String[] args) {
         int price[] = {1,5,8,9,10,17,17,20};
        
         System.out.println(rodCuttingMaxProfit(price));
        
	}
	static int rodCuttingMaxProfit(int [] price)
	{
		int n = price.length;
		int []length = new int[n];
		for(int i=0;i<n;i++)
		{
			length[i]=i+1;
		}
		int maxLength = n;
		//recursion
		//return recursion(price, length, n, maxLength);
		
		//Memoization
		int [][] dp = new int[n+1][maxLength+1];
		for(int i=0;i<=n;i++)
			Arrays.fill(dp[i],-1);
		//return memoization(price, length, n, maxLength, dp);
		
		//Tabulation
		return tabulation(price, n, length,n);
		
	}
	static int recursion(int price[],int [] length,int n,int L)
	{
		if(L==0)
			return 0;
		if(n==0 && L>=0)
			return 0;
		
		//take
		if(length[n-1] <= L)
		{
			//include
			int include = price[n-1]+recursion(price, length, n, L-length[n-1]);
			//notInclude
			int notInclude = recursion(price, length, n-1,L);
			return Math.max(include, notInclude);
			
		}
		else //no take
			return recursion(price, length, n-1, L);	
	}
	static int memoization(int price[],int [] length,int n,int L,int[][]dp)
	{
		 if(L==0)
			 return 0;
		 if(n==0)
			 return 0;
		 
		 if(dp[n][L]!=-1)
			 return dp[n][L];
		 
		//take
			if(length[n-1] <= L)
			{
				//include
				int include = price[n-1]+memoization(price, length, n, L-length[n-1],dp);
				//notInclude
				int notInclude = memoization(price, length, n-1,L,dp);
				return dp[n][L]=Math.max(include, notInclude);
				
			}
			else //no take
				return dp[n][L]=memoization(price, length, n-1, L,dp);
	}
	static int tabulation(int price[],int n,int [] length,int L)
	{
		int dp[][] = new int[n+1][L+1];
		for(int i=0;i<=n;i++)
		{
			//L==0 return 0
			dp[i][0] = 0;
		}
		for(int j=0;j<=L;j++)
		{
			//n==0 return 0
			dp[0][j] =0;
		}
		for(int i=1;i<=n;i++)
			for(int j=1;j<=L;j++)
			{
				if(length[i-1] <= j)
				{
					//include
					int include = price[i-1]+dp[i][j-length[i-1]];
							//memoization(price, length, n, L-length[n-1],dp);
					//notInclude
					int notInclude =dp[i-1][j]; 
							//memoization(price, length, n-1,L,dp);
					dp[i][j]=Math.max(include, notInclude);
					
				}
				else //no take
				    dp[i][j]=dp[i-1][j];
					//memoization(price, length, n-1, L,dp);

			}
		
		return dp[n][L];
	}
}
