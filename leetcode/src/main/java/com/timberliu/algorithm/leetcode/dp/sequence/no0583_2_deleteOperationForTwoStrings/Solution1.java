package com.timberliu.algorithm.leetcode.dp.sequence.no0583_2_deleteOperationForTwoStrings;

/**
 * 583. 两个字符串的删除操作
 *
 *   等价于求两字符的【最长公共子序列】，若两者长度分别为 n 和 m，而最长公共子序列长度为 max，则 n + m - 2 * max 为答案
 *
 *
 * @author Timber
 * @date 2021/10/25
 */
public class Solution1 {

	public int minDistance(String word1, String word2) {
		int n = word1.length(), m = word2.length();
		word1 = " " + word1;
		word2 = " " + word2;
		char[] s1 = word1.toCharArray();
		char[] s2 = word2.toCharArray();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j <= m; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1[i] == s2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int max = dp[n][m] - 1;
		return n + m - 2 * max;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/delete-operation-for-two-strings/ -----");
		System.out.println("----- 1 -----");


	}

}
