package com.practice.dp;

public class DP_F_01_Partition_DP_Matrix_Chain_Multiplication {
	public static void main(String[] args) {
      System.out.println(matrixMultiplication(5,new int[] {10,20,30,40,50}));
      System.out.println(matrixMultiplication(5, new int[] {40, 20, 30, 10, 30}));
	}
	 static int matrixMultiplication(int N, int arr[])
	    {
	        // code here
	        //tabulation
	        return MCMT(arr,N);
	        //Memoization
	        // int dp[][] = new int[N][N];
	        // for(int i=0;i<N;i++)
	        //   Arrays.fill(dp[i],-1);
	        // return MCMM(1,N-1,arr,dp);
	        //return MCMR(1,N-1,arr);
	        
	    }
	    static int MCMT(int arr[],int N)
	    {
	        int dp[][] = new int[N][N];
	        //base case i==j then 0
	        for(int i=0;i<N;i++)
	             dp[i][i]=0;
	        for(int i=N-1;i>=1;i--)
	        {
	            for(int j=i+1;j<N;j++)
	            {
	                int min = (int)(1e9);
	                for(int k=i;k<=j-1;k++)
	               {
	                 int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k]+ dp[k+1][j];
	                 min = Math.min(min,steps);
	               }
	              dp[i][j]=min;
	            }
	        }
	        return dp[1][N-1];
	    }
	    static int MCMM(int i,int j,int arr[],int [][] dp)
	    {
	        if(i==j)
	           return 0;
	        if(dp[i][j] !=-1)
	           return dp[i][j];
	        int min = (int)1e9; 
	        for(int k=i;k<=j-1;k++)
	        {
	            int steps = arr[i-1]*arr[k]*arr[j] + MCMM(i,k,arr,dp) + MCMM(k+1,j,arr,dp);
	            min = Math.min(min,steps);
	        }
	        return dp[i][j]=min;
	    }
	    static int MCMR(int i,int j,int arr[])
	    {
	        if(i==j)
	           return 0;
	        int min = (int)1e9; 
	        for(int k=i;k<=j-1;k++)
	        {
	            int steps = arr[i-1]*arr[k]*arr[j] + MCMR(i,k,arr) + MCMR(k+1,j,arr);
	            min = Math.min(min,steps);
	        }
	        return min;
	    }
}
