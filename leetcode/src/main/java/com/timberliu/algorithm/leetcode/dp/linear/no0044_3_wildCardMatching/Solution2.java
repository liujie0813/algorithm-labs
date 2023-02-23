package com.timberliu.algorithm.leetcode.dp.linear.no0044_3_wildCardMatching;

/**
 * 44. 通配符匹配
 *
 * @author Timber
 * @date 2021/10/18
 */
public class Solution2 {

	public boolean isMatch(String ss, String pp) {
		int m = ss.length(), n = pp.length();
		char[] s = ss.toCharArray();
		char[] p = pp.toCharArray();

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			if (p[i - 1] == '*') {
				dp[0][i] = true;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p[j - 1] != '*') {
					dp[i][j] = dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?');
				} else {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/wildcard-matching/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.isMatch("aa", "a"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.isMatch("aa", "*"));

		System.out.println("----- 3 -----");
		System.out.println(solution1.isMatch("cb", "?a"));

		System.out.println("----- 4 -----");
		System.out.println(solution1.isMatch("adceb", "*a*b"));

		System.out.println("----- 5 -----");
		System.out.println(solution1.isMatch("acdcb", "a*c?b"));

	}

}
