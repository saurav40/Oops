package com.practice.dp;

import java.util.Arrays;

public class DP_A_04_Count_Subset_With_Sum_Equal_X {
	public static void main(String[] args) {
      int input1[]= {0,2,4,3,5,6,-2,4,7,8,9}; 
      int x1 = 7;
      
      System.out.println(countSubsets(input1, x1));
	}
	private static int countSubsets(int[] set,int x)
	{
		int n=set.length;
		//recursive
		 //return isSubsetCount(set,x,n);
		
		
		//Memoized
		int dp[][] = new int[n+1][x+1];
		for(int i=0;i<=n;i++)
			Arrays.fill(dp[i],-1);
		//return isSubsetCountMemo(set, x, n, dp);
		
		//Tabulation
		int t[][] = new int[n+1][x+1];
		for(int i=0;i<=n;i++)
			t[i][0]=1;
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=x;j++)
			{
				//take
			   if(set[i-1]<=j)	
			   {
				   t[i][j] = t[i-1][j-set[i-1]]+t[i-1][j];
			   }
			   else
				   t[i][j] = t[i-1][j];
			}
		
		return t[n][x];
		
		
	}
	private static int isSubsetCount(int[] set,int sum,int n)
	{
		if(sum == 0)
			return 1;
		if(n==0 && sum>0)
			return 0;
		
		//take
		if(set[n-1]<=sum)
		{
			return isSubsetCount(set, sum-set[n-1], n-1)+isSubsetCount(set, sum, n-1);
		}
		else
			return isSubsetCount(set, sum, n-1);
	}
	private static int isSubsetCountMemo(int [] set,int sum,int n,int [][] dp)
	{
		if(sum==0)
			return 1;
		if(n==0 && sum>0)
			return 0;
		if(dp[n][sum] != -1)
			return dp[n][sum];
		
		if(set[n-1] <= sum)
		{
			dp[n][sum] = isSubsetCountMemo(set, sum-set[n-1], n-1, dp)+isSubsetCountMemo(set, sum, n-1, dp);
		}
		else
			dp[n][sum] = isSubsetCountMemo(set, sum, n-1, dp);
		return dp[n][sum];
	}
}
