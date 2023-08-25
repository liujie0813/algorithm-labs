package com.timberliu.algorithm.company.hw.volume_b.old.dp.no024_2_taskPlan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 24. 高效的任务规划
 *
 * 每次只能配置一台             配置的总时间是不变的
 * 但配置完成的机器可以同时运行
 *
 * 优先配置运行时间较长的机器
 *
 *
 *
 * @author Timber
 * @date 2023/6/3
 */
public class Solution1 {

	public static int minTaskTime(int[][] arr) {
		Arrays.sort(arr, (a, b) -> b[1] - a[1]);

		int configEnd = 0;
		int res = 0;
		for (int[] ints : arr) {
			int configCost = ints[0];
			int runCost = ints[1];
			configEnd += configCost;
			// configEnd + runCost 当前机器运行结束的时间
			res = Math.max(res, configEnd + runCost);
		}
		return res;
	}

	/**
	 * 3
	 * 2
	 * 1 1
	 * 2 2
	 * 3
	 * 1 1
	 * 2 2
	 * 3 3
	 * 3
	 * 1 1
	 * 1 1
	 * 1 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int[] res = new int[m];
		for (int i = 0; i < m; i++) {
			int n = scanner.nextInt();
			int[][] arr = new int[n][2];
			for (int j = 0; j < n; j++) {
				arr[j][0] = scanner.nextInt();
				arr[j][1] = scanner.nextInt();
			}
			int val = minTaskTime(arr);
			res[i] = val;
		}
		for (int val : res) {
			System.out.println(val);
		}
	}

}
