package com.timberliu.algorithm.company.hw.volume_a.back_track.no067_2_minDistance;

import java.util.Scanner;

/**
 * 67. 基站维护最短距离
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static int minDistance(int[][] arr) {
		int n = arr.length;
		boolean[] visited = new boolean[n];
		int[] res = new int[]{Integer.MAX_VALUE};
		backtrack(arr,0, 0, 0, visited, res);
		return res[0];
	}

	private static void backtrack(int[][] arr, int curSum, int index, int num, boolean[] visited, int[] res) {
		if (num == arr.length - 1) {
			// 访问 i-1 个时，最后访问 0 并返回
			res[0] = Math.min(res[0], curSum + arr[index][0]);
			return;
		}
		// 最后访问 0，这里 i 从 1 开始
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backtrack(arr, curSum + arr[index][i], i, num + 1, visited, res);
				visited[i] = false;
			}
		}
	}

	/*
	 * 3
	 * 0 2 1
	 * 1 0 2
	 * 2 1 0
	 */
	/**
	 * 3
	 * 0 1 2
	 * 5 0 8
	 * 12 15 0
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

		int res = minDistance(arr);
		System.out.println(res);
	}

}
