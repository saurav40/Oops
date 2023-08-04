package com.practice.dp;

public class DP_A_005_House_robber_II {
	public static void main(String[] args) {
       System.out.println(rob(new int[] {4,1,2,7,5,3,1}));
	}

	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return Math.max(nums[0], nums[1]);
		int LootA = maxLootT(0, n - 2, nums);
		int lootB = maxLootT(1, n - 1, nums);
		return Math.max(LootA, lootB);
	}

	static int maxLootT(int start, int end, int[] nums) {
		int dp[] = new int[(end - start) + 1];
		dp[0] = nums[start];
		dp[1] = Math.max(dp[0], nums[start + 1]);

		int k = 2;
		for (int i = start + 2; i <= end; i++) {
			dp[k] = Math.max(nums[i] + dp[k - 2], dp[k - 1]);
			k++;
		}
		return dp[dp.length - 1];
	}

	static int maxLoot(int start, int end, int[] nums) {

		int prev = nums[start];
		int curr = Math.max(prev, nums[start + 1]);

		for (int i = start + 2; i <= end; i++) {
			int tmp = curr;
			curr = Math.max(nums[i] + prev, curr);
			prev = tmp;
		}
		return curr;
	}
}
