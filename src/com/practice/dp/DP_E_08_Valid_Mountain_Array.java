package com.practice.dp;

public class DP_E_08_Valid_Mountain_Array {
	public static void main(String[] args) {
       System.out.println(validMountainArray(new int[] {1,3,1}));
       System.out.println(validMountainArray(new int[] {3,5,5}));
       System.out.println(validMountainArray(new int[] {0,3,2,1}));
       System.out.println(validMountainArray(new int[] {2}));
	}
	public static boolean validMountainArray(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return false;
		int dp1[] = new int[n];
		int dp2[] = new int[n];
		// Arrays.fill(dp1,1);
		// Arrays.fill(dp2,1);

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
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (dp1[i] > 0 && dp2[i] > 0) {
				if (dp1[i] + dp2[i] > max) {
					max = dp1[i] + dp2[i];
					// index = i;
				}
			}
			// max = Math.max(max, (dp1[i] + dp2[i]));
		}

		return max + 1 == n;
	}
}
