package com.practice.dp;

import java.util.Arrays;

public class DP_A_05_Min_Sum_Partation {
   public static void main(String[] args) {
	   int arr[] = {1,4,8,9,0,10};
	   int sum=0;
	   for(int i=0;i<arr.length;i++)
		   sum+=arr[i];
	  
	   System.out.println(minSumPartitionRecursion(arr, 0, sum, arr.length));
	   
	   /*
	    *  Memoization
	    */
	   int [][] dp = new int[arr.length+1][sum+1];
	   for(int i=0;i<=arr.length;i++)
	   {
		   Arrays.fill(dp[i], -1);
	   }
	   System.out.println();
	   System.out.println(minSubSetSumDifferenceMemo(arr, 0, sum,arr.length,dp));
	   System.out.println(minSubsetSumDiffTabulation(arr, arr.length, sum));
  }
  private static int minSumPartitionRecursion(int[] arr,int sum,int totalSum,int n)
  {
	  if(n==0)
		  return Math.abs(totalSum-2*sum);
	  
	  //pick
	  int pick = minSumPartitionRecursion(arr, sum+arr[n-1], totalSum, n-1);
	  //not pick
	  int notPick = minSumPartitionRecursion(arr, sum, totalSum, n-1);
	  
	  return Math.min(pick,notPick);
  }
  private static int minSubSetSumDifferenceMemo(int[] arr,int sum,int totalSum,int n,int dp[][])
  {
	  if(n==0)
		  return Math.abs(totalSum-2*sum);
	  if(dp[n][sum] !=-1)
		  return dp[n][sum];
	  //pick
	  int pick = minSubSetSumDifferenceMemo(arr, sum+arr[n-1], totalSum, n-1,dp);
	  //not pick
	  int notPick = minSubSetSumDifferenceMemo(arr, sum, totalSum, n-1,dp);
	  
	  return dp[n][sum]= Math.min(pick,notPick);
  }
  private static int minSubsetSumDiffTabulation(int []arr,int n,int totalSum)
  {
	  int dp[][] = new int[n+1][totalSum+1];
	  
	  
	  
	  return 0;
  }
}
