package com.timberliu.algorithm.leetcode.string.no0005_2_longestPalindromicSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 5. 最长回文子串
 *
 * dp[i][j]：区间 [i, j] 是否为回文子串
 *
 * dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
 *
 * @author liujie
 * @date 2022/2/24
 */

public class Solution1 {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		int max = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (i + 1 >= j || dp[i + 1][j - 1]) {
						dp[i][j] = true;
						max = Math.max(max, j - i + 1);
					}
				}
			}
		}
		return max;
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
