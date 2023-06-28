package com.practice.dp;

public class DP_C_0911_Min_no_Insertion_to_make_String_Palindrome {
	public static void main(String[] args) {
		    String str = "agbcba";
	       System.out.println(minInsertion(str));
	}
	static int minInsertion(String str)
	{
		int n = str.length();
		String revStr = reverse(str);
		/*
		 *  if we insert same amount of elment that need to be deleted then we can make the String palindrome
		 */
		return n-lcsT(str,revStr,n,n);
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
	static String reverse(String str)
	{
	    String ans = "";
	    for(int i=str.length()-1;i>=0;i--)
	    {
	        ans+=str.charAt(i);
	    }
	    return ans;
	}
}
