package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class DP_E_01_Longest_Increasing_Subsequence {
	public static void main(String[] args) {
      int arr[] = {2,5,7,8,9,3,1,19,8,101};
      //System.out.println(lisR(0,-1,arr,arr.length));
      //memoization
      int n=arr.length;
      int dp[][] = new int[n+1][n+1];
      for(int i=0;i<=n;i++)
    	  Arrays.fill(dp[i], -1);
      
       System.out.println(lisM(0, -1, arr, n, dp));
       
       //Tabulation
       System.out.println(lisT(arr, n));
       
       //space Optiomized to O(n^2) to O(2n)
       System.out.println(lisSpace(arr, n));
       
       //space Optimzed to O(n) 
       System.out.println(lisSpcace1D(arr, n));
       
       //Time o(n^2) to o(nlogn)
       System.out.println(lisUsingBinarySearch(arr, n));
	}
	
	static int lisR(int idx,int prev,int arr[],int n)
	{
		//base
		if(idx == n)
			 return 0;
		//Take
		if(prev == -1 || arr[idx]>arr[prev])
		{
			int pick = 1 + lisR(idx+1,idx,arr,n);
			int notPick = 0 + lisR(idx+1,prev,arr,n);
			return Math.max(pick, notPick);
		}
		else //Not take
			return 0 + lisR(idx+1,prev,arr,n);
		
	}
	static int lisM(int idx,int prev,int arr[],int n,int [][] dp)
	{
		if(idx == n)
			  return 0;
		
		if(dp[prev+1][idx] != -1)
			return dp[prev+1][idx];
		
		//Take
		if(prev == -1 || arr[idx]>arr[prev])
		{
					int pick = 1 + lisR(idx+1,idx,arr,n);
					int notPick = 0 + lisR(idx+1,prev,arr,n);
					return dp[prev+1][idx]=Math.max(pick, notPick);
		}
				else //Not take
					return dp[prev+1][idx]=0 + lisR(idx+1,prev,arr,n); 
		
	}
	static int lisT(int [] arr,int n)
	{
		int dp[][] = new int[n+1][n+1];
		
		 //base case idx == n ->0
	       //in above dp array all elments are by default set to zero then we don't need
	       //think for base case
	       // idx -> n-1 to 0 
	       // prev -> idx-1 to -1
		//prev = inx -1,
		
		for(int idx=n-1;idx>=0;idx--)
		{
			for(int prev=idx-1;prev>=-1;prev--)
			{
				//Take
				if(prev == -1 || arr[idx]>arr[prev])
				{
							int pick = 1 + dp[idx+1][idx+1];
							int notPick = 0 + dp[idx+1][prev+1];
							dp[idx][prev+1]=Math.max(pick, notPick);
				}
				else //Not take
			       dp[idx][prev+1]=0 + dp[idx+1][prev+1];
			}
		}
		return dp[0][0];
	}
	static int lisSpace(int arr[],int n)
	{
		int next[] = new int[n+1];
		int curr[] = new int[n+1];
		
		 //base case idx == n ->0
	       //in above dp array all elments are by default set to zero then we don't need
	       //think for base case
	       // idx -> n-1 to 0 
	       // prev -> idx-1 to -1
		//prev = inx -1,
		
		for(int idx=n-1;idx>=0;idx--)
		{
			for(int prev=idx-1;prev>=-1;prev--)
			{
				//Take
				if(prev == -1 || arr[idx]>arr[prev])
				{
							int pick = 1 + next[idx+1];
							int notPick = 0 + next[prev+1];
							curr[prev+1]=Math.max(pick, notPick);
				}
						else //Not take
							 curr[prev+1]=0 + next[prev];
			}
			for(int k=0;k<=n;k++)
			{
				next[k] = curr[k];
			}
		}
		return next[0];
	}
	static int lisSpcace1D(int arr[],int n)
	{
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
		int max=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i])
				{
					dp[i] = Math.max(dp[i], 1+dp[j]);
				}
				if(dp[i] > max)
					max = dp[i];
			}
		}
		return max;
	}
	/*
	 *  Time 0(NLogN) space size of Lis()
	 */
	static int lisUsingBinarySearch(int arr[],int n)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        int len =1;
        for(int i=1;i<n;i++)
        {
            if(arr[i] > ans.get(ans.size()-1))
            {
                ans.add(arr[i]);
                len++;
               //System.out.println(ans);
            }
            else
            {
                //serach for elment arr[i] in ans using Binary Search 
                // if element found then replace the elment of ans(pos) to arr[i]
                //or not found return index of first greatest element
                int index = binarySearchLowerBound(ans,ans.size(),arr[i]);
                ans.add(index,arr[i]);
                ans.remove(index+1);
              //  System.out.println(ans);
            }
        }
       
       return len;
    }
    static int binarySearchLowerBound(ArrayList<Integer> a,int n,int t)
    {
        int low=0;
        int high = n-1;
        //int mid = 0;
        int ans = n;
        while(low <= high)
        {
            int mid = (low+high)/2;
            //System.out.println(a.get(mid)+" ");
            if(a.get(mid) >= t)
            {
                high = mid-1; 
                ans = mid;
            }
            else
                 low=mid+1;
        }
        
       
      return ans;
    }
}
