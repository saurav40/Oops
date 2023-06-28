package com.practice.dp;

import java.util.ArrayList;
import java.util.TreeSet;

public class DP_E_02_Print_Longest_Increasing_Subsequence {
	public static void main(String[] args) {
		int arr[] = {2,5,7,8,9,3,1,19,8,101};
		ArrayList<Integer> res1 = printLIS(arr,arr.length);
		for(int x : res1)
			System.out.print(x+" ");
		System.out.println();
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0;i<arr.length;i++)
			set.add(arr[i]);
		int [] arr2 = new int [set.size()];
		int idx = 0;
		for(int ele : set)
			   arr2[idx++]=ele;
		ArrayList<Integer> res = printLCS(arr,arr2,arr.length,arr2.length);
		for(int x : res)
			System.out.print(x+" ");
	}
	static ArrayList<Integer> printLCS(int[] a1,int[] a2,int n,int m)
	{
		ArrayList<Integer> res = new ArrayList<>();
		int dp[][] = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(a1[i-1] == a2[j-1])
				{
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		int i = n;
		int j = m;
		while(i>0 && j>0)
		{
			if(a1[i-1] == a2[j-1])
			{
				res.add(0,a1[i-1]);
				i--;
				j--;
			}
			else if(dp[i][j-1] > dp[i-1][j])
			{
				j--;
			}
			else
				i--;
				
		}
		return res;
	}
	static ArrayList<Integer> printLIS(int arr[],int n)
	{
		int dp[] = new int[n];
		int hash[] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			dp[i] = 1;
			hash[i] = i;
		}
		
		int max=0;
		int lastIndex = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i] > arr[j] && 1+dp[j] > dp[i])
				{
					dp[i] = 1+dp[j];
					hash[i] = j;
				}
			}
			if(dp[i] > max)
			{
				max = dp[i];
				lastIndex = i;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(0,arr[lastIndex]);
		
		while(hash[lastIndex] != lastIndex)
		{
			lastIndex = hash[lastIndex];
			ans.add(0,arr[lastIndex]);
		}
		return ans;
	}
}
