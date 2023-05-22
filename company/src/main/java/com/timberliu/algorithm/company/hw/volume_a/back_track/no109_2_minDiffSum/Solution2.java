package com.timberliu.algorithm.company.hw.volume_a.back_track.no109_2_minDiffSum;

import java.util.Scanner;

/**
 * 109. 实力差距最小总和
 *
 *  dp1[i]：考虑 [0, i] 的数，最多的匹配个数
 *  dp2[j]：考虑 [0, i] 的数，最小的实力差距总和
 *
 *  推导：
 *    如果 abs(arr[i]-arr[i-1]) <= maxDiff，  dp1[i] = max(dp1[i-2] + 1, dp1[i-1])
 *                                           dp2[i] = max(dp2[i-2] + diff, dp2[i - 1])
 *    如果 abs(arr[i]-arr[i-1]) > maxDiff,    dp1[i] = dp1[i-1]
 *                                           dp2[i] = dp2[i-1]
 *
 *  初始化：
 *    dp1[0] = 0
 *
 * @author liujie
 * @date 2023/4/13
 */

public class Solution2 {

	public static int maxDiffSum(int[] arr, int maxDiff) {
		int n = arr.length;
		int[] dp1 = new int[n + 1];
		int[] dp2 = new int[n + 1];
		for (int i = 2; i < n + 1; i++) {
			int diff = arr[i - 1] - arr[i - 2];
			int diffNum = 0;
			if (diff <= maxDiff) {
				diffNum = 1;
			}

			// 先看匹配个数，取匹配个数多的 对应的最小实力差距和
			if (dp1[i - 2] + diffNum > dp1[i - 1]) {
				dp1[i] = dp1[i - 2] + diffNum;
				dp2[i] = dp2[i - 2] + diff;
			} else if (dp1[i - 2] + diffNum < dp1[i - 1]) {
				dp1[i] = dp1[i - 1];
				dp2[i] = dp2[i - 1];
			} else {
				// 匹配个数一样，取较小的 最小实力差距和
				dp1[i] = dp1[i - 1];
				if (diffNum == 1) {
					dp2[i] = Math.min(dp2[i - 1], dp2[i - 2] + diff);
				} else {
					dp2[i] = Math.min(dp2[i - 1], dp2[i - 2]);
				}
			}
		}
		if (dp1[n] == 0) {
			return -1;
		}
		return dp2[n];
	}

	/**
	 * eg:
	 *  6 30
	 *  81 87 47 59 81 18
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int maxDiff = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = maxDiffSum(arr, maxDiff);
		System.out.println(res);
	}

}
