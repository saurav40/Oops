package com.practice.dp;

public class DP_C_05_Shortest_Common_SuperSequence {
	/*
	 *  Approach for given string a&b.
	 *  In worst case : the superSequnce can be a+b. that is not an answer 
	 *  we need shortest
	 *  We can find Longest Commong Sequence b/w a & b 
	 *  and then we return (n+m)-lcs(a,b,n,m);
	 *  example :
	 *      a : AGGTAB
	 *      b : GXTXAYB
	 *      
	 *      lcs(a,b)-> G T A B->4
	 *      6+7-4 = 9 i.e AGGXTXAYB
	 * 
	 */
  public static void main(String[] args) {
	 String a = "AGGTAB";
	 String b = "GXTXAYB";
	 
	 System.out.println(shortestCommongSuperSequence(a,b));
   }
  static int shortestCommongSuperSequence(String a,String b)
  {
	  int n = a.length();
	  int m = b.length();
	  return (n+m)-lcsTab(a,b,n,m);
  }
  static int lcsTab(String s1,String s2,int n,int m)
  {
	  int [][] dp = new int[n+1][m+1];
	  for(int i=1;i<=n;i++)
		  for(int j=1;j<=m;j++)
		  {
			  if(s1.charAt(i-1) == s2.charAt(j-1))
			  {
				  dp[i][j] = 1+ dp[i-1][j-1];
			  }
			  else
			  {
				  dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			  }
		  }
	 return dp[n][m];
	  
  }
}
