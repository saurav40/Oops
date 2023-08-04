package com.practice.dp;

import java.util.Arrays;

public class DP_F_05_Partition_DP_Palindrome_Partition {
	public static void main(String[] args) {
	   //System.out.println(isPalindrome("aba"));
       System.out.println(palindromePartitionR(0, 4,"aabb")-1);
       String s = "aabbaa";
       int n=s.length();
       int dp[] = new int[n];
       Arrays.fill(dp, -1);
       System.out.println(palindromePartitionM(0, n, s, dp)-1);
       System.out.println(palindromePartitionT("aabbcdc"));
	}
	static int palindromePartitionT(String s)
	{
		int n= s.length();
		int dp[] = new int[n+1];
		
		for(int i=n-1;i>=0;i--)
		{
			String temp = "";
	    	int min = Integer.MAX_VALUE;
	    	for(int k=i;k<n;k++)
	    	{
	    		temp += s.charAt(k);
	    		if(isPalindrome(temp))
	    		{
	    			//System.out.println("hey");
	    			int cost=1+dp[k+1];  
	    			min = Math.min(min, cost);
	    		}
	    		
	    	}
	        dp[i]=min;
		}
		return dp[0]-1;
		
	}
	static int palindromePartitionM(int i,int n,String s,int dp[])
	{
		if(i>=n)
    		return 0;
		if(dp[i]!=-1)
			return dp[i];
    	String temp = "";
    	int min = Integer.MAX_VALUE;
    	for(int k=i;k<n;k++)
    	{
    		temp += s.charAt(k);
    		if(isPalindrome(temp))
    		{
    			//System.out.println("hey");
    			int cost=1+palindromePartitionM(k+1,n, s,dp);  
    			min = Math.min(min, cost);
    		}
    		
    	}
    	return dp[i]=min;

	}
    static int palindromePartitionR(int i,int n,String s)
    {
    	if(i>=n)
    		return 0;
    	String temp = "";
    	int min = Integer.MAX_VALUE;
    	for(int k=i;k<n;k++)
    	{
    		temp += s.charAt(k);
    		if(isPalindrome(temp))
    		{
    			//System.out.println("hey");
    			int cost=1+palindromePartitionR(k+1,n, s);  
    			min = Math.min(min, cost);
    		}
    		
    	}
    	return min;
    }
    static boolean isPalindrome(String s)
    {
    	int i=0;
    	int j=s.length()-1;
    	while(i<j)
    	{
    		if(s.charAt(i)!=s.charAt(j))
    			return false;
    		i++;
    		j--;
    	}
    	return true;
    }
}
