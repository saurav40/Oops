package com.practice.dp;

public class DP_C_02_Longest_common_substring {
	static int max = 0;
	public static void main(String[] args) {
       String s1 = "acdbklmnp";
       String s2 = "defklmnp";
       System.out.println(lcs(s1,s2,s1.length(),s2.length()));
       System.out.println(lcsR(s1,s2,s1.length(),s2.length()));
       System.out.println(max);
       
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
	static int lcsR(String s1,String s2,int n,int m)
	{
		if(n == 0 || m == 0)
		{
			return 0;
		}
		
		lcsR(s1,s2,n,m-1);
		lcsR(s1,s2,n-1,m);
		if(s1.charAt(n-1) == s2.charAt(m-1))
		{
			int res = 1+lcsR(s1,s2,n-1,m-1);
			max = Math.max(max, res);
			return res;
		}
		else
			return 0;
	}
}
