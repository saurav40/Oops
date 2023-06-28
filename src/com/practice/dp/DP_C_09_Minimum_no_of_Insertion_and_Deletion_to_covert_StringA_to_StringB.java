package com.practice.dp;

public class DP_C_09_Minimum_no_of_Insertion_and_Deletion_to_covert_StringA_to_StringB {
	public static void main(String[] args) {
      String str1="GeeksForGeeks";
      String str2="Geeks";
      /*
       *  Find Min no of Insertion and Deletion required to coverte Str1 into Str2
       */
      int n = str1.length();
      int m = str2.length();
      int lcs = lcsTab(str1,str2,n,m);
      System.out.println(lcs);
      //min deletion required is
      int minDeltion = n-lcs;
      //min Insertion required is
      int minInsertion = m-lcs;
      System.out.println("total Opertion:" +(minDeltion+minInsertion));
      
	}
	static int lcsTab(String s1,String s2,int n,int m)
	{
		int dp[][] = new int [n+1][m+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[n][m];
	}
}
