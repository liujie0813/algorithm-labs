package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no098_1_minWaitTime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 98. 微服务的集成测试
 *
 *  依赖的服务可以同时启动
 *
 *
 *
 * @author liujie
 * @date 2023/4/17
 */

public class Solution1 {

	public static int minWaitTime(int[][] arr, int k) {
		int[] cache = new int[arr.length];
		Arrays.fill(cache, -1);
		return dfs(arr, k - 1, cache);
	}

	private static int dfs(int[][] arr, int index, int[] cache) {
		// 如果已经计算过，直接返回
		if (cache[index] != -1) {
			// 不同的服务依赖同一个服务
			return cache[index];
		}
		int max = 0;
		for (int i = 0; i < arr[0].length; i++) {
			if (i != index && arr[index][i] == 1) {
				// 服务可以同时启动，这里求最大值
				max = Math.max(max, dfs(arr, i, cache));
			}
		}
		cache[index] = arr[index][index] + max;
		return cache[index];
	}

	/*
	 * 3
	 * 5 0 0
	 * 1 5 0
	 * 0 1 5
	 * 3
	 */

	/*
	 * 4
	 * 2 0 0 1
	 * 0 3 0 0
	 * 0 1 1 0
	 * 0 1 1 1
	 * 1
	 */

	/**
	 * 6
	 * 6 0 0 0 0 0
	 * 1 1 0 0 0 0
	 * 0 0 5 1 0 1
	 * 0 0 0 2 0 0
	 * 0 1 1 0 3 1
	 * 0 0 0 0 0 3
	 * 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		int k = scanner.nextInt();

		int res = minWaitTime(arr, k);
		System.out.println(res);
	}

}
