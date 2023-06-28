package com.practice.dp;

public class DP_C_08_Longest_Repeating_SubSequence {
	public static void main(String[] args) {
		 String str = "AABEBCDD";
		 int n=str.length();
		 System.out.println(lcsT(str,str,n,n));
	}
	static String lcsT(String s1,String s2,int n,int m)
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
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		int index = dp[n][m];
		char [] ans = new char[index];
		int i=n;
		int j=m;
		index--;
		while(i>0 && j>0)
		{
			if(s1.charAt(i-1) == s2.charAt(j-1) && dp[i][j] == 1+dp[i-1][j-1])
			{
				ans[index] = s1.charAt(i-1);
				index--;
				i--;
				j--;
			}
			else if(dp[i][j-1]>dp[i-1][j])
			{
				 j--;
			}
			else
			  i--;
		}
		
		return new String(ans);
	}
}
