package com.practice.dp;

public class DP_C_04_Longest_Palindromic_Sequence {
 
   public static void main(String[] args) {
	   String s = "abchdjjdhcba";
	   System.out.println(lps(s));
  }
  static int lps(String s)
  {
	  String reverse = reverse(s);
	  
	  return lcsT(s,reverse,s.length(),reverse.length());
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
				if(s1.charAt(i-1) == s2.charAt(j-1))
				{
				   dp[i][j]=1+dp[i-1][j-1];
				}
				else
				   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp[n][m];
	}

  static String reverse(String s)
  {
	  String ans ="";
	  for(int i=s.length()-1;i>=0;i--)
	  {
		  ans+=s.charAt(i);
	  }
	  return ans;
  }
}
