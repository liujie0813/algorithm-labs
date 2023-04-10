package com.timberliu.algorithm.leetcode.dp.sequence.sub_string_palindrome.no0005_2_longestPalindromicSubstring;

/**
 * 5. 最长回文子串
 *
 *  dp[i][j]：区间 [i, j] 范围内的最长回文子串
 *
 *  推导：
 *   如果 s[i] = s[j]，dp[i][j] = dp[i + 1][j - 1] + 2;
 *   如果 s[i] != s[j]，加入 s[i] 或者加入 s[j]，dp[i][j] = max(dp[i][j-1], dp[i+1][j])
 *
 *  初始化：
 *   dp[i][j] = 1, i = j
 *
 *  遍历顺序：dp[i][j] 依赖于左下角，i 要从下往上
 *
 * @author liujie
 * @date 2022/2/24
 */

public class Solution1 {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/longest-palindromic-substring/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.lengthOfLongestSubstring("babad"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.lengthOfLongestSubstring("cbbd"));

	}

}
