package com.practice.dp;

public class DP_D_01_Distinct_Subsequence {
	public static void main(String[] args) {
       String s1 = "babgbag";
       String s2 = "bag";
       System.out.println(numDistinct(s1, s2));
	}
	 public static int numDistinct(String s, String t) {
	        int n = s.length();
	        int m = t.length();
	      //Recursion
	      // return distinctSubsequencesR(s,t,n,m);
	      //Memoization
	    //   int dp[][] = new int[n+1][m+1];
	    //   for(int i=0;i<=n;i++)
	    //      Arrays.fill(dp[i],-1);
	    //   return distinctSubsequencesM(s,t,n,m,dp);
	    //Tabulation 
	     // return distinctSubsequencesT(s,t,n,m);
	    // return distinctSubsequencesSpaceOptimzation(s,t,n,m);
	    return distinct1DArrayOptimization(s,t,n,m);
	    }
	 private static int distinct1DArrayOptimization(String s1,String s2,int n,int m)
	    {
	        int[] prev = new int[m+1];
	        prev[0] = 1;

	        for(int i=1;i<=n;i++){
	          for(int j=m;j>=1;j--)
	          {
	              if(s1.charAt(i-1) == s2.charAt(j-1))
	              {
	                  prev[j] = prev[j-1] + prev[j];
	              }
	          }
	       }
	     return prev[m];
	    }
	    private static int distinctSubsequencesSpaceOptimzation(String s1,String s2,int n,int m)
	    {
	        int[] prev = new int[m+1];
	        int[] curr = new int[m+1];
	        prev[0] = 1;
	        curr[0] = 1;
	        for(int i=1;i<=n;i++){
	          for(int j=1;j<=m;j++)
	          {
	              if(s1.charAt(i-1) == s2.charAt(j-1))
	              {
	                  curr[j] = prev[j-1] + prev[j];
	              }
	              else 
	                 curr[j] = prev[j];
	          }
	          //prev = curr;
	          for(int k=0;k<=m;k++)
	          {
	              prev[k]=curr[k];
	          }
	       }
	     return prev[m];
	    }
	    private static  int distinctSubsequencesT(String s1,String s2,int n,int m)
	    {
	        int dp[][] = new int[n+1][m+1];
	        for(int i=0;i<=n;i++)
	             dp[i][0]=1;
	        for(int j=1;j<=m;j++)
	            dp[0][j]=0;
	        for(int i=1;i<=n;i++)
	          for(int j=1;j<=m;j++)
	          {
	              if(s1.charAt(i-1) == s2.charAt(j-1))
	              {
	                  dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
	              }
	              else 
	                 dp[i][j] = dp[i-1][j];
	          }
	          return dp[n][m];
	    }
	    private static int distinctSubsequencesM(String s1,String s2,int n,int m,int [][]dp)
	    {
	        if(m==0)
	           return 1;
	        if(n==0)
	            return 0;
	        if(dp[n][m] != -1)
	          return dp[n][m];
	        if(s1.charAt(n-1) == s2.charAt(m-1))
	        {
	            int includeChar = distinctSubsequencesM(s1,s2,n-1,m-1,dp);
	            int notIncludeChar = distinctSubsequencesM(s1,s2,n-1,m,dp);
	            return dp[n][m] = includeChar+notIncludeChar;
	        }
	        else 
	           return dp[n][m] = distinctSubsequencesM(s1,s2,n-1,m,dp);
	    }
	    private static int distinctSubsequencesR(String s1,String s2,int n,int m)
	    {
	        if(m==0)
	           return 1;
	        if(n==0)
	            return 0;
	        
	        if(s1.charAt(n-1) == s2.charAt(m-1))
	        {
	            int includeChar = distinctSubsequencesR(s1,s2,n-1,m-1);
	            int notIncludeChar = distinctSubsequencesR(s1,s2,n-1,m);
	            return  includeChar+notIncludeChar;
	        }
	        else 
	           return  distinctSubsequencesR(s1,s2,n-1,m);
	    }
}
