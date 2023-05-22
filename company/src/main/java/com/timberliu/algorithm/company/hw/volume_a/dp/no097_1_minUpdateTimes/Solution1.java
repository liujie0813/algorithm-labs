package com.timberliu.algorithm.company.hw.volume_a.dp.no097_1_minUpdateTimes;

import java.util.Scanner;

/**
 * 97. 严格递增字符串
 *
 * 最小修改次数
 *
 *  dp[i][0]：第 i 个字符是 0 的变换次数
 *  dp[i][1]：第 i 个字符是 1 的变动次数
 *
 *  推导：
 *   1、如果 s[i] == 'A'，则只有当 s[i-1] 为 A 时，才可以保持单调性
 *    dp[i][0] = dp[i-1][0] + II(s[i] = 'B')
 *
 *   2、如果 s[i] == 'B'，则当 s[i] 为 A 或 B 时，都可以保持单调性
 *    dp[i][1] = min(dp[i-1][0], dp[i-1][1]) + II(s[i] = 'A')
 *
 *  初始化：
 *   dp[0][0] = 0
 *   dp[1][0] = 0
 *
 * @author liujie
 * @date 2023/4/17
 */

public class Solution1 {

	public static int minUpdateTimes(String str) {
		int n = str.length();
		int[][] dp = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + (str.charAt(i - 1) == 'B' ? 1 : 0);
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (str.charAt(i - 1) == 'A' ? 1 : 0);
		}
		return Math.min(dp[n][0], dp[n][1]);
	}

	public static int minUpdateTimes1(String str) {
		int n = str.length();
		int dp0 = 0, dp1 = 0;
		for (int i = 1; i <= n; i++) {
			dp1 = Math.min(dp0, dp1) + (str.charAt(i - 1) == 'A' ? 1 : 0);
			dp0 = dp0 + (str.charAt(i - 1) == 'B' ? 1 : 0);
		}
		return Math.min(dp0, dp1);
	}

	/**
	 * AAABAAABBBBABB
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int times = minUpdateTimes(str);
		System.out.println(times);

		int times1 = minUpdateTimes1(str);
		System.out.println(times1);
	}

}
