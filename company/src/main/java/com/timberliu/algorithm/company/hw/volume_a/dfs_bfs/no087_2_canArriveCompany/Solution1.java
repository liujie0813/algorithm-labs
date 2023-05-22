package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no087_2_canArriveCompany;

import java.util.Scanner;

/**
 * 87. 上班之路
 *
 *  一般上下左右遍历
 *   1. 创建一个 direction 数组 <上下左右>
 *   2. 位置变动，判断边界，dfs
 *
 *
 * @author liujie
 * @date 2023/4/19
 */

public class Solution1 {

	private static int[][] changes = new int[][]{
			{-1, 0, 1},
			{1, 0, 2},
			{0, -1, 3},
			{0, 1, 4}
	};

	public static boolean canArriveCompany(char[][] arr, int n, int m, int turnCnt, int cleanCnt) {
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'S') {
					return canArrive(arr, n, m, visited, 0, i, j, turnCnt, cleanCnt);
				}
			}
		}
		return false;
	}

	private static boolean canArrive(char[][] arr, int n, int m, boolean[][] visited, int lastDirection, int x, int y, int turnCnt, int cleanCnt) {
		if (arr[x][y] == 'T') {
			return true;
		}
		visited[x][y] = true;

		for (int[] change : changes) {
			int newX = x + change[0];
			int newY = y + change[1];
			int direction = change[2];

			int tc = turnCnt;
			int cc = cleanCnt;
			if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
				if (lastDirection != 0 && lastDirection != direction) {
					if (turnCnt <= 0) {
						continue;
					}
					tc--;
				}
				if ('*' == arr[newX][newY]) {
					if (cleanCnt <= 0) {
						continue;
					}
					cc--;
				}
				if (canArrive(arr, n, m, visited, direction, newX, newY, tc, cc)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * 1 0
	 * 3 5
	 * ..S..
	 * ****.
	 * T....
	 */
	/**
	 * 1 1
	 * 3 5
	 * ..S..
	 * ****.
	 * T....
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int turnCnt = scanner.nextInt();
		int cleanCnt = scanner.nextInt();
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			arr[i] = line.toCharArray();
		}

		boolean res = canArriveCompany(arr, n, m, turnCnt, cleanCnt);
		System.out.println(res);
	}

}
