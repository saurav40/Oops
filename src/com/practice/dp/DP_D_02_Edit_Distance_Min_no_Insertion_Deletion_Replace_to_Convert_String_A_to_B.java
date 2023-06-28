package com.practice.dp;

public class DP_D_02_Edit_Distance_Min_no_Insertion_Deletion_Replace_to_Convert_String_A_to_B {
	public static void main(String[] args) {
      String A1 = "horse";
      String B1 = "ros";
      String A2 = "intention";
      String B2 ="execution";
      System.out.println(minDistance(A1, B1));
      System.out.println(minDistance(A2, B2));
	}
	 public static int minDistance(String word1, String word2) {
	      int n = word1.length();
	      int m = word2.length();
	      //return minDistanceR(word1,word2,n,m);  
	      //Memoization
	    //   int dp[][] = new int[n+1][m+1];
	    //   for(int i=0;i<=n;i++)
	    //      Arrays.fill(dp[i],-1);
	    //   return minDistanceM(word1,word2,n,m,dp); 
	    //Tabulation
	    //return minDistanceT(word1,word2,n,m);
	    return minDistaceSpaceOptimized(word1,word2,n,m);
	    }
	 private static int minDistaceSpaceOptimized(String s1,String s2,int n,int m)
	    {
	         int prev[] = new int[m+1];
	         int curr[] = new int[m+1];
	         for(int j=0;j<=m;j++)
	         {
	             prev[j]=j;
	         }
	         for(int i=1;i<=n;i++)
	        {
	            curr[0]=i;
	            for(int j=1;j<=m;j++)
	            {
	                if(s1.charAt(i-1) == s2.charAt(j-1))
	               {

	                   curr[j]=prev[j-1];
	               }
	               else
	               {
	                 //1. Insert  horse ros e != s then horses,ros s==s (n=n+1,m) ->1+Recur(n+1-1,m-1)=>Recur(n,m-1)
	                 int insert = curr[j-1];
	                 //2.Delete horse ros -> e!=s delete(e) then 1+(n-1,m);
	                 int delete= prev[j];
	                  //3.Repalce horse ros-> e!=s replace e->s then (horss,ros)->s==s,ans= 1 + recur(n-1,m-1)
	                 int replace = prev[j-1];
	                 curr[j]= 1+Math.min(insert,Math.min(delete,replace));
	               }
	            }
	            for(int k=0;k<=m;k++)
	            {
	                prev[k]=curr[k];
	            }
	        }
	        return prev[m];
	    }
	    private static int minDistanceT(String s1,String s2,int n,int m)
	    {
	       // System.out.println("88");
	        int dp[][] = new int[n+1][m+1];
	        
	        for(int i=0;i<=n;i++)
	        {
	            dp[i][0]=i;
	        }
	        for(int j=0;j<=m;j++)
	        {
	            dp[0][j] = j;
	        }
	        for(int i=1;i<=n;i++)
	        {
	            for(int j=1;j<=m;j++)
	            {
	                if(s1.charAt(i-1) == s2.charAt(j-1))
	               {

	                   dp[i][j]=dp[i-1][j-1];
	               }
	               else
	               {
	                 //1. Insert  horse ros e != s then horses,ros s==s (n=n+1,m) ->1+Recur(n+1-1,m-1)=>Recur(n,m-1)
	                 int insert = dp[i][j-1];
	                 //2.Delete horse ros -> e!=s delete(e) then 1+(n-1,m);
	                 int delete= dp[i-1][j];
	                  //3.Repalce horse ros-> e!=s replace e->s then (horss,ros)->s==s,ans= 1 + recur(n-1,m-1)
	                 int replace = dp[i-1][j-1];
	                 dp[i][j] = 1+Math.min(insert,Math.min(delete,replace));
	               }
	            }
	        }
	        return dp[n][m];
	    }
	    private static int minDistanceM(String s1,String s2,int n,int m,int dp[][])
	    {
	        if(m<=0)
	           return n;
	        if(n<=0)
	           return m;
	        if(dp[n][m] != -1)
	            return dp[n][m];
	        if(s1.charAt(n-1) == s2.charAt(m-1))
	        {
	            return dp[n][m]=minDistanceM(s1,s2,n-1,m-1,dp);
	        }
	        else
	           {
	               //1. Insert  horse ros e != s then horses,ros s==s (n=n+1,m) ->1+Recur(n+1-1,m-1)=>Recur(n,m-1)
	               int insert = 1 + minDistanceM(s1,s2,n,m-1,dp);
	               //2.Delete horse ros -> e!=s delete(e) then 1+(n-1,m);
	               int delete= 1 + minDistanceM(s1,s2,n-1,m,dp);
	               //3.Repalce horse ros-> e!=s replace e->s then (horss,ros)->s==s,ans= 1 + recur(n-1,m-1)
	               int replace = 1+minDistanceM(s1,s2,n-1,m-1,dp);
	               return dp[n][m] = Math.min(insert,Math.min(delete,replace));
	           }
	    }
	    private static int minDistanceR(String s1,String s2,int n,int m)
	    {
	        //Base case
	        /*
	            if s2 is empty but we have elment in s1 then we need to all elements from s1
	            so ans = leftElment in s1.

	            if s1 is empty and we have elment in s2 then we need to insert eqal elements in s1 to make s2.
	            ans = leftElement in s2;
	        */
	        if(m<=0)
	           return n;
	        if(n<=0)
	           return m;
	        if(s1.charAt(n-1) == s2.charAt(m-1))
	        {
	            return minDistanceR(s1,s2,n-1,m-1);
	        }
	        else
	           {
	               //1. Insert  horse ros e != s then horses,ros s==s (n=n+1,m) ->1+Recur(n+1-1,m-1)=>Recur(n,m-1)
	               int insert = 1 + minDistanceR(s1,s2,n,m-1);
	               //2.Delete horse ros -> e!=s delete(e) then 1+(n-1,m);
	               int delete= 1 + minDistanceR(s1,s2,n-1,m);
	               //3.Repalce horse ros-> e!=s replace e->s then (horss,ros)->s==s,ans= 1 + recur(n-1,m-1)
	               int replace = 1+minDistanceR(s1,s2,n-1,m-1);
	               return Math.min(insert,Math.min(delete,replace));
	           }
	    }
}


