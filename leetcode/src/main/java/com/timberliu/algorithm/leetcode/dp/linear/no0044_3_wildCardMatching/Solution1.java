package com.timberliu.algorithm.leetcode.dp.linear.no0044_3_wildCardMatching;

/**
 * 44. 通配符匹配
 *
 *  状态：f[i][j] 考虑 s 中以 i 结尾，p 中以 j 结尾的子串是否匹配
 *
 *  状态方程：
 *      1. p[j] 为普通字符：前面的子串匹配且第 i 个字符和第 j 个字符匹配、
 *          f[i][j] = f[i-1][j-1] 且 s[j] = p[j]
 *      2. p[j] 为 '?'：前面的子串匹配且第 i 个字符可以是任意字符
 *          f[i][j] = f[i-1][j-1] 且 p[j] = '?'
 *      3. p[j] 为 '*': 匹配 s 中字符的个数
 *          1). 0个：
 *              f[i][j] = f[i][j-1]
 *          2). 1个：
 *              f[i][j] = f[i-1][j-1]
 *          3). 2个：
 *              f[i][j] = f[i-2][j-1]
 *
 *          表达式展开得
 *              f[i][j] = f[i][j-1] || f[i-1][j-1] || f[i-2][j-1] ...
 *
 *          将 i = i-1 代入表达式：
 *              f[i-1][j] = f[i-1][j-1] || f[i-2][j-1] || f[i-3][j-1] ...
 *
 *          最后得 f[i][j] = f[i][j-1] || f[i-1][j]
 *
 * @author Timber
 * @date 2021/10/18
 */
public class Solution1 {

	public boolean isMatch(String ss, String pp) {
		int n = ss.length(), m = pp.length();
		ss = " " + ss;
		pp = " " + pp;
		char[] s = ss.toCharArray();
		char[] p = pp.toCharArray();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i - 1 >= 0 && p[j] != '*') {
					dp[i][j] = dp[i - 1][j - 1] && (s[i] == p[j] || p[j] == '?');
				}
				// 对应 . 字符
				else if (p[j] == '*') {
					dp[i][j] = dp[i][j - 1] || (i - 1 >= 0 && dp[i - 1][j]);
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/wildcard-matching/ -----");
		Solution1 solution1 = new Solution1();
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
