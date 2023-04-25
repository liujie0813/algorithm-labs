package com.timberliu.algorithm.company.hw.dfs_bfs.no039_1_maxSingleEntranceArea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 39. 查找单入口空闲区域
 *
 *  DFS 遍历
 *   缓存入口，每次遍历完后判断入口数量，如果为 1，更新 max 和入口下标
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static int[][] directions = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};

	public static String maxSingleEntranceArea(String[][] arr, int m, int n) {
		boolean[][] visited = new boolean[m][n];
		int max = 0;
		int[] res = new int[2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ("O".equals(arr[i][j]) && !visited[i][j]) {
					List<int[]> entrances = new ArrayList<>();
					int[] areaNum = new int[1];
					dfs(arr, i, j, visited, areaNum, entrances);

					if (entrances.size() == 1) {
						if (areaNum[0] > max) {
							max = areaNum[0];
							res = entrances.get(0);
						} else if (areaNum[0] == max) {
							res[0] = res[1] = -1;
						}
					}
				}
			}
		}
		if (max == 0) {
			return "NULL";
		}
		if (res[0] == -1) {
			return max + "";
		}
		return res[0] + " " + res[1] + " " + max;
	}

	private static void dfs(String[][] arr, int x, int y, boolean[][] visited,
								  int[] curAreaSum, List<int[]> curEntrance) {
		curAreaSum[0]++;
		visited[x][y] = true;
		if (x == 0 || x == arr.length - 1 || y == 0 || y == arr[0].length - 1) {
			curEntrance.add(new int[]{x, y});
		}
		for (int[] direction : directions) {
			int newX = x + direction[0];
			int newY = y + direction[1];
			if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length && !visited[newX][newY] && "O".equals(arr[newX][newY])) {
				dfs(arr, newX, newY, visited, curAreaSum, curEntrance);
			}
		}
	}

	/**
	 * 5 4
	 * X X X X
	 * X O O O
	 * X X X X
	 * X O O O
	 * X X X X
	 */
	/*
	 * 5 4
	 * X X X X
	 * X O O O
	 * X O O O
	 * X O O X
	 * X X X X
	 */
	/*
	 * 4 5
	 * X X X X X
	 * O O O O X
	 * X O O O X
	 * X O X X O
	 */
	/*
	 * 4 5
	 * X X X X X
	 * X O O O X
	 * X O O O X
	 * X O X X O
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		String[][] arr = new String[m][n];
		for (int i = 0; i < m; i++) {
			arr[i] = scanner.nextLine().split(" ");
		}

		String res = maxSingleEntranceArea(arr, m, n);
		System.out.println(res);
	}

}
