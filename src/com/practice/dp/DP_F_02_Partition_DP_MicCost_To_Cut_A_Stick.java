package com.practice.dp;

import java.util.Arrays;

public class DP_F_02_Partition_DP_MicCost_To_Cut_A_Stick {
	public static void main(String[] args) {
		System.out.println(minCost(7, new int[] { 3, 1, 5, 4 }));
	}

	private static int minCost(int n, int cuts[]) {
		int m = cuts.length;
		int cuts2[] = new int[m + 2];
		Arrays.sort(cuts);
		int k = 1;
		cuts2[0] = 0;
		cuts2[m + 1] = n;
		for (int i = 0; i < m; i++)
			cuts2[k++] = cuts[i];
		//return minCostR(1, m, cuts2);
		//memoization
		
		//int dp[][] = new int[m+3][m+3];
		//for(int i=0;i<=m+2;i++)
			//Arrays.fill(dp[i], -1);
		//return minCostMemo(1, m, cuts2, dp);
		return minCostTabu(cuts2, m+2);
	}

	private static int minCostR(int i, int j, int[] cuts) {
		if (i > j)
			return 0;
		
		int mini = (int)1e9;
		for(int k=i;k<=j;k++)
		{
			int cost = cuts[j+1]-cuts[i-1]+ minCostR(i,k-1,cuts)+minCostR(k+1,j,cuts);
			mini = Math.min(mini, cost);
		}
		return mini;
	}
   private static int minCostMemo(int i,int j,int cuts[],int dp[][])
   {
	   if(i>j)
		   return 0;
	  
	   if(dp[i][j] != -1)
		   return dp[i][j];
	   
	   int mini = Integer.MAX_VALUE;
	   
	   for(int k=i;k<=j;k++)
	   {
		   int cost = cuts[j+1]-cuts[i-1] + minCostMemo(i,k-1,cuts,dp) + minCostMemo(k+1,j,cuts,dp);
		   mini = Math.min(mini, cost);
	   }
	   return dp[i][j] = mini;
   }
   private static int minCostTabu(int cuts[],int n)
   {
	   int dp[][] = new int[n+1][n+1];
	   int m = n-2;
	   // Base Case : By Default all values are zero, It confirmed the base case
	   for(int i=m;i>=1;i--)
	   {
		   for(int j=1;j<=m;j++)
		   {
			   if(i>j)
				   continue;
			   
			   int mini = Integer.MAX_VALUE;
			   
			   for(int k=i;k<=j;k++)
			   {
				   int cost = cuts[j+1]-cuts[i-1] + dp[i][k-1] + dp[k+1][j];
				   mini = Math.min(mini, cost);
			   }
			   dp[i][j] = mini;
			   
		   }
			   
	   }
	   return dp[1][m];
   }
}
