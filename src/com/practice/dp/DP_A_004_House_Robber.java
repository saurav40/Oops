package com.practice.dp;

import java.util.Arrays;

public class DP_A_004_House_Robber {
	public static void main(String[] args) {
		  int nums[] = {2,4,1,5,7,3};
		  System.out.println(maxLootR(nums.length-1,nums));
	       // memoization
	        int dp[] = new int[nums.length];
	        Arrays.fill(dp,-1);
	         System.out.println(maxLootM(nums.length-1,nums,dp));
	       System.out.println(maxLootTab(nums));
	       System.out.println(maxLootSpaceOpt(nums));
	}

	static int maxLootSpaceOpt(int[] nums) {
		int n = nums.length;

		if (n == 1)
			return nums[0];

		int prev = nums[0];
		int curr = Math.max(nums[1], prev);

		for (int i = 2; i < n; i++) {
			int tmp = curr;
			curr = Math.max(nums[i] + prev, curr);
			prev = tmp;
		}
		return curr;
	}

	static int maxLootTab(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];

		if (n == 1)
			return nums[0];

		dp[0] = nums[0];
		dp[1] = Math.max(nums[1], dp[0]);

		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[n - 1];
	}

	static int maxLootM(int n, int nums[], int[] dp) {
		if (n == 0) {
			return nums[n];
		} else if (n == 1)
			return Math.max(nums[n], nums[n - 1]);

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = Math.max(nums[n] + maxLootM(n - 2, nums, dp), maxLootM(n - 1, nums, dp));
	}

	static int maxLootR(int n, int nums[]) {
		if (n == 0) {
			return nums[n];
		} else if (n == 1)
			return Math.max(nums[n], nums[n - 1]);

		return Math.max(nums[n] + maxLootR(n - 2, nums), maxLootR(n - 1, nums));
	}
}
