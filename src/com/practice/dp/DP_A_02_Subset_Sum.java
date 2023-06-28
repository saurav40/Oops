package com.practice.dp;

import java.util.Arrays;

public class DP_A_02_Subset_Sum {
	public static void main(String[] args) {
        int set[]={3, 34, 5, 12, 5, 2};
        int target = 9;
        
        //recursive 
        System.out.println(isSubsetRecur(set,target,set.length));
        //memoization 
        int dp[][] = new int[set.length+1][target+1];
        for(int i=0;i<=set.length;i++)
        	Arrays.fill(dp[i],-1);
        isSubsetMemo(set,target,set.length,dp);
        if(dp[set.length][target] == 1)
        	 System.out.println(true);
        else
        	System.out.println(false);
        
        //Tabulation
        System.out.println(isSubsetSumTabulation(set, target,set.length));
	}
	private static boolean isSubsetRecur(int[] set,int sum,int n)
	{
		if(sum==0)
			return true;
		if(n==0 && sum>0)
			return false;
		
		//take
		if(set[n-1]<=sum)
		{
			//include
			boolean include = isSubsetRecur(set, sum-set[n-1], n-1);
			//notInclude 
			boolean notInclude = isSubsetRecur(set, sum, n-1);
			
			return include || notInclude;
		}
		else // not take
			return isSubsetRecur(set, sum, n-1);
			
	}
	private static int isSubsetMemo(int []set,int sum,int n,int[][] dp)
	{
		if(sum==0)
			return 1;
		if(n==0 && sum>0)
		{
			return 0;
		}
		if(dp[n][sum]!=-1)
			return dp[n][sum];
		//take
		if(set[n-1] <= sum)
		{
			int include = isSubsetMemo(set, sum-set[n-1], n-1, dp);
			int notInclud = isSubsetMemo(set, sum,n-1, dp);
			if(include !=0 || notInclud !=0)
				dp[n][sum] = 1;
			else
				dp[n][sum]=0;
		}
		else
			dp[n][sum]=isSubsetMemo(set, sum, n-1, dp);
		return dp[n][sum];
	}
	private static boolean isSubsetSumTabulation(int []set,int sum,int n)
	{
		int dp[][] = new int[n+1][sum+1];
		
		for(int i=0;i<=n;i++)
		{
			dp[i][0]=1;
		}
		
		for(int i=1;i<=n;i++)
		 for(int j=1;j<=sum;j++)
		 {
			 //take
			 if(set[i-1] <= j)
			 {
				 int include = dp[i-1][j-set[i-1]];
				 int notInclud = dp[i-1][j];
				 if(include!=0 || notInclud!=0)
					 dp[i][j] = 1;
				 else
					 dp[i][j] = 0;
			 }
			 else
				 dp[i][j] = dp[i-1][j];
		 } 
		if(dp[n][sum] == 1)
			return true;
		return false;
	}
	
	
}
