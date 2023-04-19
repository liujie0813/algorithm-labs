package com.timberliu.algorithm.company.hw.dp.no097_1_minUpdateTimes;

import java.util.Scanner;

/**
 * 97. 严格递增字符串
 *
 * 最小修改次数
 *
 *
 *
 * @author liujie
 * @date 2023/4/17
 */

public class Solution2 {

	public static int minUpdateTimes(String str) {
		int n = str.length();
		int[] prefixSum = new int[n + 1];
		// 1 的个数
		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + (str.charAt(i) - '0');
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			res = Math.min(res, prefixSum[i] + (n - i - (prefixSum[n] - prefixSum[i])));
		}
		return res;
	}

	/**
	 * AAABAAABBBBABB
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int times = minUpdateTimes(str);
		System.out.println(times);

	}

}
