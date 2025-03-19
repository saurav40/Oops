package com.practice.dp;

import java.util.Arrays;
/**
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 */
public class DP_E_Others_01_LeetCode_1395 {
	public int numTeams(int[] rating) {
        int n = rating.length;
        int dp[] = new int[n];
        int cnt = 0;
        /**
           Apply LIS - Look for smaller than current
         */
         for (int i=0; i < n;i++)
         {
            for(int j=i;j>=0;j--)
            {
                if(rating[i] > rating[j])
                {
                    //Store result in i
                    dp[i] ++;
                    cnt = cnt + dp[j];
                }
            }
         }

         Arrays.fill(dp,0);
        /**
           Look for Greater than the current one
         */
         for(int i=0;i<n;i++)
         {
            for(int j=i;j>=0;j--)
            {
               if(rating[i] < rating[j])
               {
                 dp[i]++;
                 cnt = cnt + dp[j];
               }
            }
         }
         return cnt;
    }
	public static void main(String[] args) {
		DP_E_Others_01_LeetCode_1395 obj = new DP_E_Others_01_LeetCode_1395();
		int [] input = {4,3,2,1};
		System.out.println(obj.numTeams(input));
	}

}
