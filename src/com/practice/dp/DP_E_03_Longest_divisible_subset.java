package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_E_03_Longest_divisible_subset {
	public static void main(String[] args) {
      List<Integer> res1 = longestDivisibleSubset(new int[] {-3,2,0,4});
      List<Integer> res2 = longestDivisibleSubset(new int[] {1,4,5,7,8,16});
      List<Integer> res3 = longestDivisibleSubset(new int[] {8,17,13,19,10,3,20,5});
      List<Integer> res4 = longestDivisibleSubset(new int[] {1,2,4,8});
      for(int x : res1)
      {
    	  System.out.print(x+" ");
      }
      System.out.println();
      for(int x : res2)
      {
    	  System.out.print(x+" ");
      }
      System.out.println();
      for(int x : res3)
      {
    	  System.out.print(x+" ");
      }
      System.out.println();
      for(int x : res4)
      {
    	  System.out.print(x+" ");
      }
      System.out.println();
      
	} 
	static List<Integer> longestDivisibleSubset(int arr[])
	{
		int n = arr.length;
		if(n==0)
			return new ArrayList<>();
		int dp[] = new int[n];
		int track[] = new int[n];
		for(int i=0;i<n;i++)
		{
			dp[i] = 1;
			track[i] = i;
		}
		int maxLength = 0;
		int lastIndex = 0;
		Arrays.sort(arr);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j] != 0 && arr[i]%arr[j] == 0 && 1+dp[j] > dp[i])
				{
					dp[i] = 1+dp[j];
					track[i] = j;
				}
			}
			if(dp[i] > maxLength)
			{
				maxLength = dp[i];
				lastIndex = i;
			}
		}
		
		List<Integer>  ans = new ArrayList<>();
		ans.add(0,arr[lastIndex]);
		
		while(track[lastIndex] != lastIndex)
		{
			lastIndex = track[lastIndex];
			ans.add(0,arr[lastIndex]);
		}
		return ans;
	}
}
