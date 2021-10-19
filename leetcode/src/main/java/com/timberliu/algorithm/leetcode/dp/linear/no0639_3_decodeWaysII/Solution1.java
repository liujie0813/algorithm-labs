package com.timberliu.algorithm.leetcode.dp.linear.no0639_3_decodeWaysII;

/**
 * 639. 解码方法 II
 *
 *  状态定义：f[i] 考虑以 s[i] 为结尾的字符串，共有多少种解码方案
 *
 *  最终答案 f[n - 1]
 *  起始值 f[0] = s[0] == '*' ? 9 : (s[0] != '0' ? 1 : 0)
 *
 *  状态转移方程：
 *     f[i] 如何转移：
 *       1. s[i] 为 *：
 *          1). 单独作为一个 item：
 *              f[i] = f[i - 1] * 9
 *          2). 与上一个字符共同作为一个 item：对上一个字符 f[j] 讨论：
 *              a. 数字 1：如此有 11-19 共 9 种情况
 *                  f[i] = f[i - 2] * 9 （如果 f[i - 2] 取不到，使用 1）
 *              b. 数字 2：如此有 21-26 共 6 种情况
 *                  f[i] = f[i - 2] * 6
 *              c. 字符 *：如此有 11-19 和 21-26 共 15 种情况
 *                  f[i] = f[i - 2] * 15
 *       2. s[i] 为数字：
 *          1). 前一个字符 s[j] 为 *:
 *              a. 当前字符 s[i] 为 0：此时 s[i] 只能与 s[j] 组合，如此有 10 和 20 两种情况
 *                  f[i] = f[i - 2] * 2
 *              b. 当前字符 s[i] 为 1-9，这里 s[i] 就可以作为一个独立 item，即有 f[i] = f[i - 1]，另外对于数值大小：
 *                  A. s[i] 为数字 1-6，如此 s[j] 可以为 1 和 2，此时有 f[i] = f[i - 2] * 2
 *                  B. s[i] 为数字 7-9，如此 s[j] 可以为 1，此时有 f[i] = f[i - 2]
 *          2). 前一个字符 s[j] 为数字：
 *              a. s[i] 为 0：如此 s[j] 可以为 1 和 2，此时有 f[i] = f[i - 2]
 *              b. s[i] 为 1-9：这里 s[i] 就可以作为一个独立 item，即有 f[i] = f[i - 1]，另外对于数值大小：
 *                  A. f[j] 为数字 1：f[i] = f[i - 2]
 *                  B. f[i] 为数字 2，且 s[i] 为 1-6：f[i] = f[i - 2]
 *
 * @author Timber
 * @date 2021/10/19
 */
public class Solution1 {
	int mod = 1000000007;

	public int numDecodings(String ss) {
		char[] s = ss.toCharArray();
		int n = ss.length();
		long[] dp = new long[n];
		dp[0] = s[0] == '*' ? 9 : (s[0] != '0' ? 1 : 0);

		for (int i = 1; i < n; i++) {
			char cur = s[i], prev = s[i - 1];
			long valI2 = i - 2 >= 0 ? dp[i - 2] : 1;
			if (cur == '*') {
				// s[i] 单独作为一个 item
				dp[i] += dp[i - 1] * 9;
				// s[i] 与前一个字符共同作为一个 item
				if (prev == '*') {
					// 11-19、21-26
					dp[i] += valI2 * 15;
				} else {
					int u = prev - '0';
					if (u == 1) {
						// 11-19
						dp[i] += valI2 * 9;
					} else if (u == 2) {
						// 21-26
						dp[i] += valI2 * 6;
					}
				}
			} else {
				int t = cur - '0';
				if (prev == '*') {
					if (t == 0) {
						// 10、20
						dp[i] += valI2 * 2;
					} else {
						// s[i] 单独作为一个 item
						dp[i] += dp[i - 1];
						// s[i] 与前一个字符共同作为一个 item
						if (t <= 6) {
							// prev 为 1/2
							dp[i] += valI2 * 2;
						} else {
							// prev 为 1
							dp[i] += valI2;
						}
					}
				} else {
					int u = prev - '0';
					if (t == 0) {
						if (u == 1 || u == 2) {
							dp[i] += valI2;
						}
					} else {
						// s[i] 单独作为一个 item
						dp[i] += dp[i - 1];
						// s[i] 与前一个字符共同作为一个 item
						if (u == 1) {
							dp[i] += valI2;
						} else if (u == 2 && t <= 6){
							dp[i] += valI2;
						}
					}
				}
			}
			dp[i] %= mod;
		}
		return (int) dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/decode-ways-ii/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.numDecodings("*"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.numDecodings("1*"));

		System.out.println("----- 3 -----");
		System.out.println(solution1.numDecodings("2*"));

	}

}
