package com.timberliu.algorithm.leetcode.dp.sequence.sub_sequence_two.no1143_2_longestCommonSubSequence;

/**
 * 1143. 最长公共子序列
 *
 *  状态定义：f[i][j] 考虑 text1 中以 i 为结尾的字符串、text2 中以 j 结尾的字符串，公共子序列的最大长度
 *
 *  状态转移方程：
 *    1. text1[i] == text[j] 必然使用 text1[i]
 *       f[i][j] = f[i - 1][j - 1] + 1
 *    2. text1[i] != text[j] 使用 text1[i] 或者 text1[j]
 *       f[i][j] = max(f[i - 1][j],  f[i][j - 1])
 *
 * @author Timber
 * @date 2021/10/25
 */
public class Solution1 {

	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length(), m = text2.length();
		text1 = " " + text1;
		text2 = " " + text2;
		char[] s1 = text1.toCharArray();
		char[] s2 = text2.toCharArray();
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
					dp[i][j] = dp[i - 1][j - 1]+ 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n][m] - 1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/longest-common-subsequence/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.longestCommonSubsequence("abcde", "ace"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.longestCommonSubsequence("abc", "abc"));

		System.out.println("----- 3 -----");
		System.out.println(solution1.longestCommonSubsequence("abc", "def"));

	}

}
