package com.practice.dp;
/*
 *  Sub Problem of Subset sum
 *  input array is given : return true if u can partition this array into two subset with equal sum
 *  {1,5,5,11}
 *  (1,5,5} & {11} - ans : yes
 *  
 *  {1,4,5,11} 
 *   ans : no
 *   
 *   Logic
 *   
 *   for(i to n)
 *     sum+=set[i];
 *  
 *   if(sum%2==0)
 *   {
 *      //seacrch as sum/2 target in set usin isSubset function
 *      isSubset(set,sum/2,n);
 *   }
 * 
 */
public class DP_A_03_Equal_Sum_Partition {
     public static void main(String[] args) {
		int set1[] = {1,5,5,11};
		int set2[] = {1,4,5,10};
		
		int sum1=0,sum2 = 0;
		for(int i=0;i<set1.length;i++)
		    sum1+=set1[i];
		for(int i=0;i<set2.length;i++)
			sum2+=set2[i];
			
		if(sum1%2 == 0)
		{
			System.out.println(isSubsetSum(set1, sum1, set1.length));
		}
		if(sum2%2 == 0)
		{
			System.out.println(isSubsetSum(set2, sum2,set2.length));
		}
	}
     private static boolean isSubsetSum(int []set,int sum,int n)
     {
    	 boolean dp[][] = new boolean[n+1][sum+1];
    	 for(int i=0;i<=n;i++)
    	 {
    		 dp[i][0] = true;
    	 }
    	 
    	 for(int i=1;i<=n;i++)
    		 for(int j=1;j<=sum;j++)
    		 {
    			 //take
    			 if(set[i-1]<=j)
    			 {
    				 dp[i][j] = dp[i-1][j-set[i-1]] || dp[i-1][j];
    				            //include              //exclude
    			 }
    			 else // not take
    				 dp[i][j] = dp[i-1][j];
    		 }
    	 return dp[n][sum];
     }
}
