package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no071_1_signalVal;

import java.util.Scanner;

/**
 * 71. 计算网络信号
 *
 *  DFS
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution2 {

	public static int[][] changes = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};

	public static int signalVal(int[][] arr, int m, int n, int foundX, int foundY) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > 0) {
					dfs(arr, m, n, i, j);
					break;
				}
			}
		}
		return arr[foundX][foundY];
	}

	private static void dfs(int[][] arr, int m, int n, int curX, int curY) {
		int signal = arr[curX][curY];
		if (signal <= 1) {
			return;
		}
		for (int[] change : changes) {
			int nextX = curX + change[0];
			int nextY = curY + change[1];
			// 如果没有到边界，且为空旷位置（也是没有传播过的）
			if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && arr[nextX][nextY] == 0) {
				// 所有能传播到的位置，写上信号值（下个位置，信号递减）
				arr[nextX][nextY] = signal - 1;
				dfs(arr, m, n, nextX, nextY);
			}
		}
	}

	/*
	 * 6 5
	 * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
	 * 1 4
	 */
	/**
	 * 6 5
	 * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
	 * 2 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		int foundX = scanner.nextInt();
		int foundY = scanner.nextInt();
		int res = signalVal(arr, m, n, foundX, foundY);
		System.out.println(res);
	}

}
