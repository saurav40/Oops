package com.practice.dp;

public class DP_E_09_Number_of_Longest_Increasing_Subsequence {
	public static void main(String[] args) {
       System.out.println(findNumberOfLIS(new int[] {1,5,4,3,2,6,7,8,10,9}));
       System.out.println(findNumberOfLIS(new int[] {1,3,5,4,7}));
       System.out.println(findNumberOfLIS(new int[] {1,3,1}));
	}

	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;

		int dp[] = new int[n];
		int count[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			count[i] = 1;
		}

		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
					count[i] = count[j];
					dp[i] = 1 + dp[j];
				} else if (nums[i] > nums[j] && 1 + dp[j] == dp[i]) {
					count[i] += count[j];
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == maxLen) {
				ans += count[i];
			}
		}
		return ans;
	}
}
