package com.practice.dp;

import java.util.Arrays;
import java.util.Comparator;

public class DP_E_04_Longest_Chain_String_Subset {
	public static void main(String[] args) {
        String []word1 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        String []word2 = {"a","abc"};
        String []word3 = {"a","ab","ba","bca","cba","cbda"};
        System.out.println(longestChain(word1.length, word1));
        System.out.println(longestChain(word2.length, word2));
        System.out.println(longestChain(word3.length, word3));
        
	}

	public static int longestChain(int N, String words[]) {
		// code here
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		Arrays.sort(words, Comparator.comparingInt(String::length));
		int maxLength = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (compare(words[i], words[j]) && 1 + dp[j] > dp[i]) {
					dp[i] = 1 + dp[j];
				}
			}
			if (dp[i] > maxLength) {
				maxLength = dp[i];
			}
		}
		return maxLength;
	}

	private static boolean compare(String A, String B) {
		int n = A.length();
		int m = B.length();

		if (n - m != 1)
			return false;

		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (A.charAt(i) == B.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}

		}
		if (i - j == 0 || i - j == 1)
			return true;
		return false;
	}

}
