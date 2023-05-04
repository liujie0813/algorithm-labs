package com.timberliu.algorithm.company.hw.dp.no119_1_minCostTime;

import java.util.Scanner;

/**
 * 119. 高速公路休息站充电规划
 *
 *  dp[i]：到达 i 位置花费的最短时间
 *
 *  推导：
 *   1. 考虑从 起点 到 当前位置之前 的每一个充电站都有可能充电
 *   dp[i] = min(dp[i], dp[j] + time[j] + 1), 0 <= j < i
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static int minCostTime(int[][] positions, int distance) {
		int n = positions.length;
		int[] dp = new int[n];

		for (int i = 1; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				if (positions[i][0] - positions[j][0] > 1000) {
					break;
				}
				int driveTime = (positions[i][0] - positions[j][0]) / 100;
				int waitChargeTime = j == 0 ? 0 : positions[j][1] + 1;
				dp[i] = Math.min(dp[i], dp[j] + waitChargeTime + driveTime);
			}
			if (dp[i] == Integer.MAX_VALUE) {
				return -1;
			}
		}
		return dp[n - 1];
	}

	/**
	 * 1500
	 * 4
	 * 300 2
	 * 600 1
	 * 1000 0
	 * 1200 0
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int distance = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[n + 2][2];
		arr[0][0] = arr[0][1] = 0;
		for (int i = 1; i <= n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}
		arr[n + 1][0] = distance;
		arr[n + 1][1] = 0;
		int res = minCostTime(arr, distance);
		System.out.println(res);
	}

}
