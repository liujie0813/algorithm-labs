package com.timberliu.algorithm.company.hw.volume_a.dp.no050_1_findRepeatCode;

import java.util.Scanner;

/**
 * 50. 找出重复代码
 *
 *  dp[i][j]：考虑 first 前 i 个字符，second 前 j 个字符，最长公共子串
 *
 *   first[i - 1] == second[j - 1]
 *    dp[i][j] = dp[i - 1][j - 1] + 1
 *
 *   dp[0][0] = 0
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static String findRepeatCode(String first, String second) {
		int m = first.length(), n = second.length();
		int[][] dp = new int[m + 1][n + 1];

		int maxLen = 0, start = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				if (dp[i][j] > maxLen) {
					maxLen = dp[i][j];
					start = i - maxLen;
				}
			}
		}
		return first.substring(start, start + maxLen);
	}

	/**
	 * private_void_method
	 * public_void_method
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String first = scanner.nextLine();
		String second = scanner.nextLine();
		String res = findRepeatCode(first, second);
		System.out.println(res);
	}

}
