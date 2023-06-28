package com.practice.dp;

public class DP_C_0912_Pattern_Matching_Is_Subsequence {
	public static void main(String[] args) {
      String s ="abcedghk";
      String t ="cedgh";
      /*
       * is t is subsquence of s
       */
      if(t.length() == lcs(s,t,s.length(),t.length()))
    	  System.out.println("Yes");
      else
    	  System.out.println("No");
	}
	static int lcs(String s1,String s2,int n,int m)
	{
		int dp[][] = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		
		return dp[n][m];
	}
}
