package com.practice.dp;
/*
 *   Approach : we will follow LCS Print & we will include non-common character in ans
 *   
 *   when s1.charAt(i-1) == s2.charAt(j-1)
 *             ans.add(s1.charAt(i-1)
 *    else when no match
 *          if(we move Up we add S1.charAt(i-1)) at condition if(dp[i][j-1] <dp[i-1][j]) i--;
 *          if(we move left we add s2.charAt(j-1) at else condtion of above condtion
 *    
 *    at the end of the iteration any elment left in s1 & s2 the we add it in our answer
 *        when i !=0 
 *    and 
 *        when j != 0
 *       
 * 
 */
public class DP_C_06_Print_Shortest_Common_SuperSequence {
  public static void main(String[] args) {
	String a = "AGGTAB";
	String b = "GXTXAYB";
	System.out.println(scsTab(a,b,a.length(),b.length()));
 }
  static String scsTab(String s1,String s2,int n,int m)
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
    int index = (n+m)-dp[n][m];
	 char ans [] = new char[index];
     int i = n;
     int j = m;
     index--;
     while(i>0 && j >0)
     {
         if(s1.charAt(i-1) == s2.charAt(j-1))
         {
             ans[index] = s1.charAt(i-1);
             index--;
             i--;
             j--;
         }
         else 
         {
             if(dp[i][j-1] < dp[i-1][j])
             {
                 ans[index--] = s1.charAt(i-1);
                 i--;
             }
             else
             {
                 ans[index--] = s2.charAt(j-1);
                 j--;
             }
         }
     }
     while(i>0)
     {
         ans[index--] = s1.charAt(i-1);
         i--;
     }
     while(j>0)
     {
         ans[index--] = s2.charAt(j-1);
         j--;
     }
	return new String(ans);
  }
}
