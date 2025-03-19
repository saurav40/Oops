package com.practice.dp;

import java.util.Arrays;

public class DP_A_001_Fibnacci {
	public static void main(String[] args) {
       System.out.println(fibnacciR(5));
       int n=45;
       int dp[]=new int[n+1];
       Arrays.fill(dp, -1);
       System.out.println(fibnacciM(n, dp));
       System.out.println(fibnacciT(n));
       System.out.println(fibanaciiTwoPointer(n));
	}
	static int fibanaciiTwoPointer(int n)
	{
		if(n<=1)
			return n;
		int prev = 0;
		int next = 1;
		for(int i=2;i<=n;i++)
		{
			int curr = prev + next;
			prev = next;
			next = curr;
		}
		return next;
	}
	static int fibnacciT(int n)
	{
		if(n<1)
			return n;
		int dp[] = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];		
	}
	static int fibnacciM(int n,int dp[])
	{
		 if(n<=1)
			 return n;
		 if(dp[n]!=-1)
			 return dp[n];
		
		 return dp[n]=fibnacciM(n-1,dp)+fibnacciM(n-2,dp);
	}
    static int fibnacciR(int n)
	{
	
		 if(n<=1)
			 return n;
		
		 return fibnacciR(n-1)+fibnacciR(n-2);
	}
}

