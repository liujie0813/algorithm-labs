package com.timberliu.algorithm.company.hw.dfs_bfs.no125_2_minMoveCount;

import java.util.Scanner;

/**
 * 125. 西天取经
 *
 * @author Timber
 * @date 2023/5/5
 */
public class Solution1 {

	private static int[][] directions = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};

	public static int minMoveCount(int[][] arr, int n, int m, int t) {
		boolean[][] visited = new boolean[n][m];
		int[] res = {Integer.MAX_VALUE};
		dfs(arr, n, m, t, 0, 0, 0, visited, 0, res);
		if (res[0] == Integer.MAX_VALUE) {
			return -1;
		}
		return res[0];
	}

	private static void dfs(int[][] arr, int n, int m, int t, int curX, int curY, int curMoveCnt, boolean[][] visited, int burstCnt, int[] res) {
		if (curX == n - 1 && curY == m - 1) {
			res[0] = Math.min(res[0], curMoveCnt);
			return;
		}
		int curHeight = arr[curX][curY];
		for (int[] direction : directions) {
			int newX = curX + direction[0];
			int newY = curY + direction[1];
			if (newX < 0 || newX > n - 1 || newY < 0 || newY > m - 1 || visited[newX][newY]) {
				continue;
			}
			int nextHeight = arr[newX][newY];
			if (Math.abs(curHeight - nextHeight) > t && burstCnt < 3) {
				visited[newX][newY] = true;
				dfs(arr, n, m, t, newX, newY, curMoveCnt + 1, visited, burstCnt - 1, res);
				visited[newX][newY] = false;
			} else if (Math.abs(curHeight - nextHeight) <= t) {
				visited[newX][newY] = true;
				dfs(arr, n, m, t, newX, newY, curMoveCnt + 1, visited, burstCnt, res);
				visited[newX][newY] = false;
			}
		}
	}

	/**
	 * 4 4 10
	 * 10 20 30 40
	 * 100 120 140 160
	 * 200 230 260 290
	 * 300 400 500 600
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int t = scanner.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		int res = minMoveCount(arr, n, m, t);
		System.out.println(res);
	}

}
