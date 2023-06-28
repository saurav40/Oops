package com.practice.dp;

import java.util.Arrays;

public class DP_C_07_Longest_Repeatining_Subsequnce_in_string {
  public static void main(String[] args) {
	String str = "AABEBCDD";
	 int n=str.length();
     System.out.println(lcsR(str,str,n,n));
    //Memoization
      int [][] dp = new int[n+1][n+1];
      for(int i=0;i<=n;i++)
    	  Arrays.fill(dp[i],-1);
    System.out.println(lcsM(str,str,n,n,dp));
    //Tabulation
     System.out.println(lcsT(str,str,n,n));
}
  static int lcsR(String s1,String s2,int n,int m)
	{
		if(n==0 || m==0)
		{
			return 0;
		}

		
		if(s1.charAt(n-1) == s2.charAt(m-1) && m!=n)
		{
			return 1+lcsR(s1,s2,n-1,m-1);
		}
		else
			return Math.max(lcsR(s1,s2,n-1,m),lcsR(s1,s2,n,m-1));
	}
	static int lcsM(String s1,String s2,int n,int m,int [][] dp)
	{
		if(n==0 || m==0)
		{
			return 0;
		}
		if(dp[n][m] != -1)
			return dp[n][m];
		
		if(s1.charAt(n-1) == s2.charAt(m-1) && n!=m)
		{
			return dp[n][m]=1+lcsM(s1,s2,n-1,m-1,dp);
		}
		else
			return dp[n][m] = Math.max(lcsM(s1,s2,n-1,m,dp),lcsM(s1,s2,n,m-1,dp));
	}
	static int lcsT(String s1,String s2,int n,int m)
	{
		int [][] dp = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
			dp[i][0] =0;
		for(int j=0;j<=m;j++)
			dp[0][j] = 0;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j)
				{
				   dp[i][j]=1+dp[i-1][j-1];
				}
				else
				   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp[n][m];
	}
}
