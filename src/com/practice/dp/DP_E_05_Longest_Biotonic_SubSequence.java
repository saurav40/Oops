package com.practice.dp;

import java.util.Arrays;

public class DP_E_05_Longest_Biotonic_SubSequence {
	public static void main(String[] args) {
      System.out.println(LongestBitonicSequence(new int[] {9,29,6}));
      System.out.println(LongestBitonicSequence(new int[] {3,7,3,8,9,0}));
      /*
              1 1 1 1 1 1
        dp1 : 1 2 1 3 4 1
        dp2 : 3 3 2 2 2 1
              4 5 3 5 6 1
    biotonic: 3 4 2 4 5 1
             max = 5 
             ans = 5          
      */
	}

	public static int LongestBitonicSequence(int[] nums) {
		// Code here
		// Approach : pre-req: LIS 0(n)
		// step 1 : find lis from 0 to n : dp1
		// step 2 : find lis from n to 0 : dp2
		// step 3 : find biotonic from dp1 & dp2

		int n = nums.length;

		int dp1[] = new int[n];
		int dp2[] = new int[n];
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);

		// Lis from left to right
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && 1 + dp1[j] > dp1[i]) {
					dp1[i] = 1 + dp1[j];
				}
			}
		}

		// Lis from right to left
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (nums[i] > nums[j] && 1 + dp2[j] > dp2[i]) {
					dp2[i] = 1 + dp2[j];
				}
			}
		}

		// Biotonic -Max(increasing,decreasing,increasing then decresaing)
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, (dp1[i] + dp2[i] - 1));
		}
		return max;
	}
}
