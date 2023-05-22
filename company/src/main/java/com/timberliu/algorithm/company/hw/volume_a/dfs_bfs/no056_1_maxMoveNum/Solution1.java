package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no056_1_maxMoveNum;

import java.util.Scanner;

/**
 * 56. 机器人
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution1 {

	public static int[][] changes = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};

	public static int maxMoveNum(int[][] arr, int m, int n) {
		boolean[][] visited = new boolean[m][n];
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					int[] num = new int[1];
					dfs(arr, i, j, visited, num);
					res = Math.max(res, num[0]);
				}
			}
		}
		return res;
	}

	private static void dfs(int[][] arr, int x, int y, boolean[][] visited, int[] num) {
		visited[x][y] = true;
		num[0]++;
		for (int[] change : changes) {
			int newX = x + change[0];
			int newY = y + change[1];
			if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length &&
					!visited[newX][newY] && Math.abs(arr[x][y] - arr[newX][newY]) <= 1) {
				dfs(arr, newX, newY, visited, num);
			}
		}
	}

	/*
	 * 2 3
	 * 1 3 5
	 * 4 1 3
	 */
	/**
	 * 4 4
	 * 1 2 5 2
	 * 2 4 4 5
	 * 3 5 7 1
	 * 4 6 2 4
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

		int res = maxMoveNum(arr, m, n);
		System.out.println(res);
	}

}
