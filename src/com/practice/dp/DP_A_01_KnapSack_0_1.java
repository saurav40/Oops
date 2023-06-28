package com.practice.dp;

import java.util.Arrays;

public class DP_A_01_KnapSack_0_1 {
   int N;
   int []wt;
   int []values;
   int W;
   
   public DP_A_01_KnapSack_0_1(int N)
   {
	   this.N=N;
	   wt = new int[N];
	   values =new int[N];
   }
   void setKnapSack(int[] wt,int values[],int W)
   {
	   this.wt = wt;
	   this.values = values;
	   this.W =W;
   }
   int getKnapSack()
   {
	   //return knapSack_0_1(this.wt,this.values,this.W,this.N);
//	   int dp[][] = new int[this.N+1][this.W+1];
//	   for(int i=0;i<=this.N;i++)
//	   {
//		   Arrays.fill(dp[i], -1);
//	   }
//	   knapSackMemo(this.wt, this.values,this.W,this.N, dp);
//	   return dp[N][W];
	   System.out.println("optimized :"+kanpSackTabSpaceOptimazed(this.wt, this.values, this.W, this.N));
	   return knapSackTabu(wt, values, W, N);
   }
   
   //Recurrence or recursion
   private int knapSack_0_1(int[] wt,int values[],int W,int n)
   {
	     /*
	      *  if no elment left means all included i.e n==0 return 0
	      *  if bag is full means W is zero W==0 return 0;
	      * 
	      */
	   if(n==0 || W==0)
		   return 0;
	     //take 
	    
	     if(wt[n-1] <= W)
	     { 
	    	        //include 
	    	return  Math.max(values[n-1]+knapSack_0_1(wt, values, W-wt[n-1],n-1),
	    			//notInclude
	    			0+knapSack_0_1(wt, values, W, n-1));
	     }
	     else  //not take
	     {
	    	return knapSack_0_1(wt, values, W, n-1) ;
	     }
   }
   //Memoization
   private int knapSackMemo(int wt[],int val[],int w,int n,int[][]dp)
   {
	   if(n==0 || w==0)
		   return 0;
	   if(dp[n][w] != -1)
		   return dp[n][w];
	   
	   //take 
	   if(wt[n-1]<=w)
	   {
		   int include = val[n-1]+knapSackMemo(wt, val, w-wt[n-1], n-1, dp);
		   int notInclude = 0 + knapSackMemo(wt, val, w,n-1, dp);
		   dp[n][w] = Math.max(include, notInclude);
	   }
	   else//not take
		   dp[n][w] = 0 + knapSackMemo(wt, val, w, n-1, dp);
	   return dp[n][w];
   }
   //wrong function
   private int kanpSackTabSpaceOptimazed(int wt[],int val[],int w,int n)
   {
    // int dp[][] = new int[n+1][w+1];
	    int [] prev = new int[w+1];
	    int [] curr = new int[w+1];
	   //base case - initialization
	   // if n/i == 0 then no profit =0
	   // if w/j == 0 then no 

//	   for(int i=0;i<=n;i++)
//		   dp[i][0]=0;
	   for(int j=0;j<=w;j++)
		    prev[j] = 0;
	   
	   for(int i=1;i<=n;i++) {
		   for(int j=1;j<=w;j++)
		   {
			   //take
			   if(wt[i-1] <= j)
			   {
				   int include = val[i-1]+prev[j-wt[i-1]];
				   int notInclude = prev[j];
				   curr[j] = Math.max(include, notInclude);
			   }
			   else //not take
			   {
				   curr[j]= prev[j];
			   }
		   }
		   prev = curr;
	   }
	   return prev[w]; 
   }
   //Tabulation
   private int knapSackTabu(int wt[],int val[],int w,int n)
   {
	   int dp[][] = new int[n+1][w+1];
	   
	   //base case - initialization
	   // if n/i == 0 then no profit =0
	   // if w/j == 0 then no 
	   for(int i=0;i<=n;i++)
		   dp[i][0]=0;
	   for(int j=0;j<=w;j++)
		   dp[0][j]=0;
	   
	   for(int i=1;i<=n;i++)
		   for(int j=1;j<=W;j++)
		   {
			   //take
			   if(wt[i-1] <= j)
			   {
				   int include = val[i-1]+dp[i-1][j-wt[i-1]];
				   int notInclude = dp[i-1][j];
				   dp[i][j] = Math.max(include, notInclude);
			   }
			   else //not take
			   {
				   dp[i][j] = dp[i-1][j];
			   }
		   }
	   return dp[n][w];
		   
   }
  public static void main(String[] args) {
	 DP_A_01_KnapSack_0_1 case1= new DP_A_01_KnapSack_0_1(3);
	 int weight[] = {4,5,1};
	 int values[]= {1,2,3};
	 case1.setKnapSack(weight, values, 4);
	 
	 DP_A_01_KnapSack_0_1 case2= new DP_A_01_KnapSack_0_1(6);
	 int weight2[] = {2,4,6,5,8,9};
	 int values2[]= {4,3,4,5,1,2};
	 case2.setKnapSack(weight2, values2, 30);
	 
	 System.out.println(case1.getKnapSack());
	 System.out.println(case2.getKnapSack());
	 
	
  }
}
