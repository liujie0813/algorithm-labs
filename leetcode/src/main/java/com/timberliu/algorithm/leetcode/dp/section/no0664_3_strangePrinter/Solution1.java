package com.timberliu.algorithm.leetcode.dp.section.no0664_3_strangePrinter;

/**
 * 664. 奇怪的打印机
 *
 *  区间 DP [枚举长度 + 枚举左端点 + 枚举右端点] 三重循环
 *
 *   状态定义：f[l][r] 打印 [l, r] 这一段目标结果所消耗的最小打印次数
 *
 *   如何转移：
 *      1. 只打印 l 位置，f[l][r] = f[l + 1][r] + 1
 *      2. 不只打印 l 位置，而是打印 [l, k]，需要确保 s[l] == s[k]
 *           f[l][r] = f[l][k - 1] + f[k + 1][r]，l < k <= r
 *
 *    只需要确保 s[l] == s[k]
 *     打印 s[l] 时可以一同打印 s[k]，因此本身 s[k] 并不独立消耗打印次数
 *
 * @author Timber
 * @date 2021/10/26
 */
public class Solution1 {

	public int strangePrinter(String s) {
		int n = s.length();
		int[][] dp = new int[n + 1][n + 1];
		// 枚举长度
		for (int len = 1; len <= n; len++) {
			// 枚举左端点
			for (int l = 0; l + len - 1 < n; l++) {
				int r = l + len - 1;
				dp[l][r] = dp[l + 1][r] + 1;
				// 枚举右端点
				for (int k = l + 1; k <= r; k++) {
					if (s.charAt(l) == s.charAt(k)) {
						dp[l][r] = Math.min(dp[l][r], dp[l][k - 1] + dp[k + 1][r]);
					}
				}
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/strange-printer/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.strangePrinter("aaabbb"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.strangePrinter("aba"));

	}

}
