package com.practice.dp;

import java.util.Arrays;

public class DP_B_04_Coin_Change_Min_no_of_coins {
   public static void main(String[] args) {
	    int sum = 4;
		int coins[] = {1,2,3};
		//int coins[] = {15};// o/p=>-1
	
		//Recursion
		int rans = minCoinsR(coins, sum, coins.length);
		if(rans >= Integer.MAX_VALUE-1)
			System.out.println(-1);
		else
			System.out.println(minCoinsR(coins,sum,coins.length));
		
		//Memoization
		int dp[][] = new int[coins.length+1][sum+1];
		for(int i=0;i<=coins.length;i++)
			 Arrays.fill(dp[i],-1);
		int mans = minCoinsMemo(coins, sum,coins.length,dp);
		
		if(mans >= Integer.MAX_VALUE-1)
			System.out.println(-1);
		else
			System.out.println(mans);
		
		System.out.println(minCoinsTab(coins, sum, coins.length));
		System.out.println(minCoinsTabSpaceOptimized(coins, sum, coins.length));
  }
  static int minCoinsTabSpaceOptimized(int coins[],int sum,int n)
  {
	  //int dp[][] = new int[n+1][sum+1];
      int [] prev = new int[sum+1];
      int [] curr = new int[sum+1];
      for(int j=0;j<=sum;j++)
      {
          if(j%coins[0] == 0)
          {
              prev[j] = j/coins[0];
          }
          else
             prev[j] = Integer.MAX_VALUE-1;
      }
      
      for(int i=1;i<=n;i++) {
       for(int j=1;j<=sum;j++)
       {
           if(coins[i-1]<=j)
           {
               int include = 1 + curr[j-coins[i-1]];
               int exclude = 0 + prev[j];
               curr[j] = Math.min(include,exclude);
           }
           else
              curr[j] = prev[j];
       
       }
       prev = curr;
      }
       if(prev[sum] >= Integer.MAX_VALUE-1)
          return -1;
      return prev[sum];
  }
   static int minCoinsTab(int coins[],int sum,int n)
   {
       int dp[][] = new int[n+1][sum+1];
       
       for(int j=0;j<=sum;j++)
       {
           if(j%coins[0] == 0)
           {
               dp[0][j] = j/coins[0];
           }
           else
              dp[0][j] = Integer.MAX_VALUE-1;
       }
       
       for(int i=1;i<=n;i++)
        for(int j=1;j<=sum;j++)
        {
            if(coins[i-1]<=j)
            {
                int include = 1 + dp[i][j-coins[i-1]];
                int exclude = 0 + dp[i-1][j];
                dp[i][j] = Math.min(include,exclude);
            }
            else
               dp[i][j] = dp[i-1][j];
        }
        if(dp[n][sum] >= Integer.MAX_VALUE-1)
           return -1;
       return dp[n][sum];
   }
  static int minCoinsMemo(int coins[],int sum,int n,int dp[][])
  {
	  if(n==0)
	  {
		  if(sum%coins[n] == 0)
			  return sum/coins[n];
		  else
			  return Integer.MAX_VALUE-1;
	  }
	  
	  if(dp[n][sum] != -1)
		  return dp[n][sum];
		  
	  //take
	 // int take = Integer.MAX_VALUE;
	  if(coins[n-1]<=sum)
	  {
		    int include = 1 + minCoinsMemo(coins, sum-coins[n-1], n,dp);
		    int notInclude = 0 + minCoinsMemo(coins,sum,n-1,dp);
		    dp[n][sum]= Math.min(include, notInclude);
	  }
	  else//not take
	    dp[n][sum]=minCoinsMemo(coins,sum,n-1,dp);
	  return dp[n][sum];
  }
  static int minCoinsR(int coins[],int sum,int n)
  {
	  /*
	   *   suppose target/sum == 7 && n==0 means a[0] = 6 
	   *   then can we achive 7 by using coins 6 : answer is no return INT_MAX because this is not a minums answer
	   *   if sum == 7 && n== 0,and a[0] ==7 can we achive now : yes
	   *   if(n==0)
	   *   {
	   *      if(sum%coins[n] == 0) return sum/coins[n];
	   *      else return Integer.MAX_VALUE -1;
	   *      
	   *   }
	   *   Integer.MAX_VALUE -1 to prevent overflow
	   */
	  if(n==0)
	  {
		  if(sum%coins[n] == 0)
			  return sum/coins[n];
		  else
			  return Integer.MAX_VALUE-1;
	  }
	  
	  //take
	 // int take = Integer.MAX_VALUE;
	  if(coins[n-1]<=sum)
	  {
		    int include = 1 + minCoinsR(coins, sum-coins[n-1], n);
		    int notInclude = 0 + minCoinsR(coins,sum,n-1);
		    return Math.min(include, notInclude);
	  }
	  else//not take
	    return minCoinsR(coins,sum,n-1);
  }
 
}
