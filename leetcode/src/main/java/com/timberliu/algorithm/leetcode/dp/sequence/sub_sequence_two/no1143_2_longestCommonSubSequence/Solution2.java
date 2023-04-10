package com.timberliu.algorithm.leetcode.dp.sequence.sub_sequence_two.no1143_2_longestCommonSubSequence;

/**
 * 1143. 最长公共子序列
 *
 *  状态定义：f[i][j] 考虑 text1 中前 i 个字符（以下标 i-1 结尾）、text2 中前 j 个字符（以下标 j-1 结尾），公共子序列的最大长度
 *
 *  状态转移方程：
 *    1. text1[i-1] == text[j-1]
 *       f[i][j] = f[i - 1][j - 1] + 1
 *    2. text1[i-1] != text[j-1]
 *       f[i][j] = max(f[i - 1][j],  f[i][j - 1])
 *
 *  与 718 不用的是，这里要求不是连续的了
 *   如果连续，text1[i-1] != text[j-1]，长度直接赋为 0
 *   如果不连续，text1[i-1] != text[j-1]，还需要看前面的序列
 *
 * @author Timber
 * @date 2021/10/25
 */
public class Solution2 {

	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length(), m = text2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1]+ 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/longest-common-subsequence/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.longestCommonSubsequence("abcde", "ace"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.longestCommonSubsequence("abc", "abc"));

		System.out.println("----- 3 -----");
		System.out.println(solution1.longestCommonSubsequence("abc", "def"));

	}

}
