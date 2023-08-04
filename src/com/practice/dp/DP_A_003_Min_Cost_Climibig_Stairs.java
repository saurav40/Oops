package com.practice.dp;

import java.util.Arrays;

public class DP_A_003_Min_Cost_Climibig_Stairs {
	public static void main(String[] args) {
      int cost[] = {10,15,30};
       System.out.println(minCostR(cost.length, cost));
      int cost2[]={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
      System.out.println(minCostR(cost2.length, cost2));
      int n=cost2.length;
      int dp[]=new int[n+1];
      Arrays.fill(dp, -1);
      System.out.println(minCostM(n,cost2,dp));
      System.out.println(minCostT(cost2));
      }
	static int minCostT(int cost[])
	{
		int n = cost.length;
		int dp[] = new int[n];
		if(n==1)
			return cost[0];
		if(n==2)
			return Math.min(cost[0], cost[1]);
		dp[0]=cost[0];
		dp[1]=cost[1];
		
		for(int i=2;i<n;i++)
		{
			dp[i]=cost[i]+Math.min(dp[i-1], dp[i-2]);
		}
		return 0+Math.min(dp[n-1], dp[n-2]);
	}
	static int minCostM(int n,int cost[],int[] dp)
    {
        if(n<=1)
    		return cost[n];
    	if(dp[n]!=-1)
    	    return dp[n];
    	if(n==cost.length)
    	{
    		return dp[n]=0+Math.min(minCostM(n-1,cost,dp),minCostM(n-2,cost,dp));
    	}
    	else
    	 return dp[n]=cost[n]+Math.min(minCostM(n-1,cost,dp),minCostM(n-2,cost,dp));
    }
    static int minCostR(int n,int cost[])
    {
    	if(n<=1)
    		return cost[n];
    	if(n==cost.length)
    	{
    		return 0+Math.min(minCostR(n-1,cost),minCostR(n-2,cost));
    	}
    	else
    	 return cost[n]+Math.min(minCostR(n-1,cost),minCostR(n-2,cost));
    }
}
