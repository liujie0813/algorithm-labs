package com.timberliu.algorithm.leetcode.dp.linear.no0115_3_distinctSubSequences;

/**
 * 115. 不同的子序列
 *
 *  状态定义：f[i][j] 考虑 s 中前 i 个字符，t 中前 j 个字符的匹配个数
 *      字符串匹配，通用的状态定义
 *
 *   两类决策：
 *     1. s[i] 不参与匹配：让 s 中前 i-1 个字符匹配 t 中前 j 个字符
 *          f[i][j] = f[i - 1][j]
 *     2. s[i] 参与匹配：让 s 中前 i-1 个字符匹配 t 中前 j-1 个字符，同时满足 s[i] = s[j]
 *          f[i][j] = f[i - 1][j - 1]
 *
 *
 * @author Timber
 * @date 2021/10/18
 */
public class Solution1 {

	public int numDistinct(String ss, String tt) {
		// 往两个字符串的头部追加 空字符，以此构造出可以滚动下去的初始化值
		int n = ss.length(), m = tt.length();
		ss = " " + ss;
		tt = " " + tt;
		char[] s = ss.toCharArray(), t = tt.toCharArray();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j];
				if (s[i] == t[j]) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/distinct-subsequences/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.numDistinct("rabbbit", "rabbit"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.numDistinct("babgbag", "bag"));

	}

}