package com.practice.dp;

public class DP_C_02_Longest_common_substring {
	public static void main(String[] args) {
       String s1 = "acdbklmnp";
       String s2 = "defklmnp";
       System.out.println(lcs(s1,s2,s1.length(),s2.length()));
       } 
	static int lcs(String s1,String s2,int n,int m)
	{
		int dp[][] = new int[n+1][m+1];
		int max = 0;
		for(int i=1;i<=n;i++)
			for(int  j=1;j<=m;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					 dp[i][j] = dp[i-1][j-1]+1;
					 
					 max = Math.max(max,dp[i][j]);
				}
				else 
					dp[i][j] =0;
			}
		return max;
	}
}
