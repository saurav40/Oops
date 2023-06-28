package com.practice.dp;

import java.util.Arrays;

public class DP_B_01_Unbounded_KnapSack {
	public static void main(String[] args) {
        int N = 4;
        int W = 8;
        int val[] ={1, 4, 5, 7};
        int wt[] = {1, 3, 4, 5};
        //o/p -> 11
        System.out.println(knapSack(N,W,val,wt));
        System.out.println(knapSackTabulation(N, W, val, wt));
        
	}
	static int knapSack(int N,int W,int[] val,int []wt)
	{
		int dp[][] = new int[N+1][W+1];
        for(int i=0;i<=N;i++)
            Arrays.fill(dp[i],-1);
        return knapSackMemo(N,W,val,wt,dp);
	}
	static int knapSackMemo(int N,int W,int [] val,int wt[],int dp[][])
    {
        if(N==0 || W==0)
           return 0;
        
        if(dp[N][W] != -1)
           return dp[N][W];
        //take 
        if(wt[N-1]<=W)
        {
            // Include but allowed to reuse the same element
            int include = val[N-1]+knapSackMemo(N,W-wt[N-1],val,wt,dp);
            //not Include means go to other elements
            int notInclude = knapSackMemo(N-1,W,val,wt,dp);
            dp[N][W]= Math.max(include,notInclude);
        }
        else //not take
          dp[N][W]=knapSackMemo(N-1,W,val,wt,dp);
          
     return dp[N][W];
    }
	static int knapSackTabulation(int N,int W,int[] val,int [] wt)
	{
		int dp[][] = new int[N+1][W+1];
		 for(int i=0;i<=N;i++)
			   dp[i][0]=0;
		   for(int j=0;j<=W;j++)
			   dp[0][j]=0;
		for(int i=1;i<=N;i++)
			for(int j=1;j<=W;j++)
			{
				//take 
		        if(wt[i-1]<=j)
		        {
		            // Include but allowed to reuse the same element
		            int include = val[i-1]+dp[i][j-wt[i-1]];
		            //not Include means go to other elements
		            int notInclude = dp[i-1][j];
		            dp[i][j]= Math.max(include,notInclude);
		        }
		        else //not take
		          dp[i][j]=dp[i-1][j]; 
			}
		return dp[N][W];
	}
	
}
