package com.timberliu.algorithm.leetcode.dp.linear.no0010_3_regularExpressionMatching;

/**
 * 10. 正则表达式匹配
 *
 *  动态规划
 *   状态：f[i][j] 考虑 s 中以 i 为结尾，p 中以 j 结尾的子串是否匹配
 *
 *   状态转移：
 *      1. p[j] 为普通字符：前面的子串匹配且 s 中第 i 个字符和 p 中第 j 个字符匹配
 *            f[i][j] = f[i - 1][j - 1] && s[i] = p[j]
 *      2. p[j] 为 '.'：前面的子串匹配，s 中第 i 个字符可以是任意字符
 *            f[i][j] = f[i - 1][j - 1] && p[j] == '.'
 *      3. p[j] 为 '*'：判断 p[j - 1] 的字符 a，根据 a* 实际匹配 s 中 a 的个数
 *          1). 0个：跳过 p 中的 a*
 *             f[i][j] = f[i][j - 2]
 *          2). 1个：
 *             f[i][j] = f[i - 1][j - 2] && (s[i] = p[j - 1] || p[j - 1] == '.')
 *          3). 2个：
 *             f[i][j] = f[i - 2][j - 2] && ((s[i] = p[j - 1] && s[i - 1] = p[j - 1]) || p[j - 1] == '.')
 *
 *          表达式展开得
 *             f[i][j] = f[i][j-2] || (f[i-1][j-2] && s[i] 匹配 p[j-1]) || (f[i-2][j-2] && s[i]和s[i-1] 匹配 p[j-1]) ...
 *
 *          将 i = i-1 代入表达式：
 *             f[i-1][j] = f[i-1][j-2] || (f[i-2][j-2] && s[i-1] 匹配 p[j-1]) || (f[i-3][j-2] && s[i]/s[i-1]/s[i-2] 匹配 p[j-1])
 *
 *			每个 Item 相差 s[i] 匹配 p[j-1]
 *		       f[i][j] = f[i][j-2] || (f[i-1][j] && s[i] 匹配 p[j-1])
 *             也就是 f[i][j] = f[i][j-2] || (f[i-1][j] && (s[i] = p[j - 1] || p[j - 1] == '.'))
 *
 *
 * @author liujie
 * @date 2021/10/18
 */

public class Solution2 {

	public static boolean isMatch(String ss, String pp) {
		int n = ss.length(), m = pp.length();
		char[] s = ss.toCharArray();
		char[] p = pp.toCharArray();

		// n+1，m+1 处理空字符串的情况
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;
		// 处理 f[0][j] 可以匹配的情况，只有 * 可以
		for (int i = 2; i <= m; i++) {
			if (p[i - 1] == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 普通字符和 .
				if (p[j - 1] != '*') {
					dp[i][j] = dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
				}
				// 对应 * 字符
				else {
					dp[i][j] = (j - 2 >= 0 && dp[i][j - 2]) || (dp[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.'));
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/regular-expression-matching/ -----");
		System.out.println("----- 1 -----");
		System.out.println(isMatch("aa", "a"));

		System.out.println("----- 2 -----");
		System.out.println(isMatch("aa", "a*"));

		System.out.println("----- 3 -----");
		System.out.println(isMatch("ab", ".*"));

		System.out.println("----- 4 -----");
		System.out.println(isMatch("aab", "c*a*b*"));

		System.out.println("----- 5 -----");
		System.out.println(isMatch("mississippi", "mis*is*p*."));

		System.out.println("----- 5 -----");
		System.out.println(isMatch("mississippi", "mis*is*p*."));

		System.out.println("----- 6 -----");
		System.out.println(isMatch("", ".*"));
	}

}
