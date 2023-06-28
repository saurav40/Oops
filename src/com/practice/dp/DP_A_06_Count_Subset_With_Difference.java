package com.practice.dp;

import java.util.Arrays;

public class DP_A_06_Count_Subset_With_Difference {
   public static void main(String[] args) {
	int [] arr = {1,2,5,6,6,7,8,3};
	int diff = 2;
	/*
	 * s1-s2 = diff
	 * s1+s2 = sum(arr)
	 * 
	 *  2s1=diff+sum(arr)
	 *  s1 = (diff+sum(arr))/2;
	 *  
	 */
	int sum=0;
	for(int i=0;i<arr.length;i++)
		sum+=arr[i];
	
	if((diff+sum)%2==0)
	{
		int target = (diff+sum)/2;
		System.out.println(isSubsetRecursion(arr, arr.length, target));
		
		/*
		 *  Memoization 
		 *  
		 */
		int[][] dp = new int[arr.length+1][target+1];
		for(int i=0;i<=arr.length;i++)
			Arrays.fill(dp[i],-1);
		System.out.println(isSubsetMemo(arr, arr.length, target, dp));
		
		System.out.println(isSubsetTabulation(arr,target,arr.length));
	}
	else
		System.out.println(0);
  }
   private static int isSubsetRecursion(int set[],int n,int sum)
   {
	    if(sum==0)
	    	 return 1;
	    if(n==0 && sum>0)
	    	return 0;
	    //pick
	    if(set[n-1]<=sum)
	    {
	    	
	    	int include = isSubsetRecursion(set,n-1, sum-set[n-1]);
	    	int notInclude = isSubsetRecursion(set,n-1, sum);
	    	/*
	    	 *  n==1 means we made sum==0 , we got a path return 1
	    	 *  n==0 no path found & sum>0,we didn't get a path return 0
	    	 */
	    	return include+notInclude;
	    }
	    else
	    	return isSubsetRecursion(set, n-1, sum);
   }
   private static int isSubsetMemo(int set[],int n,int sum,int dp[][])
   {
	   if(sum==0)
	    	 return 1;
	    if(n==0 && sum>0)
	    	return 0;
	    //pick
	    if(set[n-1]<=sum)
	    {
	    	
	    	int include = isSubsetMemo(set,n-1, sum-set[n-1],dp);
	    	int notInclude = isSubsetMemo(set,n-1, sum,dp);
	    	/*
	    	 *  n==1 means we made sum==0 , we got a path return 1
	    	 *  n==0 no path found & sum>0,we didn't get a path return 0
	    	 */
	    	dp[n][sum]=include+notInclude;
	    }
	    else
	    	dp[n][sum]=isSubsetMemo(set, n-1, sum,dp);
	    
	    return dp[n][sum];
   }
   private static int isSubsetTabulation(int [] set,int sum,int n)
   {
	   int dp[][] = new int[n+1][sum+1];
	   for(int i=0;i<=n;i++)
	   {
		   dp[i][0] = 1;
	   }
	   
	   for(int i=1;i<=n;i++)
	   {
		   for(int j=1;j<=sum;j++)
		   {
			   if(set[i-1]<=j)
			   {
				   dp[i][j] = dp[i-1][j-set[i-1]] + dp[i-1][j];
			   }
			   else
				   dp[i][j] = dp[i-1][j];
		   }
	   }
	   return dp[n][sum];
   }
}
