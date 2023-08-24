import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = {0,2,4,3,5,-2,6,4,7,8,9};
		/*
		 *   (0,7),(2,5),(2,-2,7),(4,3)(4,5,-2),(3,-2,6),(5,-2,4),(-2,4,7),(7)
		 */
		int sum = 7;
		int ans = allSets(arr,arr.length,sum);
		System.out.println(ans);
	}
	private static int allSets(int[] arr, int n, int sum) {
		if (sum == 0)
			return 1;
		if (n == 0 && sum > 0)
			return 0;
		// takeable
		if (arr[n - 1] <= sum) {
			int take = allSets(arr, n - 1, sum - arr[n - 1]);
			int notTake = allSets(arr, n - 1, sum);
			return take + notTake;
		} else
			return allSets(arr, n - 1, sum);
	}

	private static int printAll(int[] arr, int sum) {
		int n = arr.length;
		int[][] dp = new int[n + 1][sum];
		for(int i=0;i<=n;i++)
			Arrays.fill(dp[i], 0);
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <sum; j++) {
				if (arr[i - 1] <= j && j - arr[i-1]>0 && j - arr[i-1] <=sum) { 
					 System.out.println(j-arr[i-1]);
					
					int take = dp[i - 1][j - arr[i-1]];
					int notTake = dp[i - 1][j];
					dp[i][j] = take + notTake;
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][sum];
	}
}
