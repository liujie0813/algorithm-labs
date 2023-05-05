package com.timberliu.algorithm.company.hw.dfs_bfs.no123_2_minTime;

import java.util.*;

/**
 * @author liujie
 * @date 2023/5/4
 */

public class Solution2 {

	public static int[][] directions = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};

	public static int minTime(int[][] matrix, int n, int m) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int val = matrix[i][j];
				List<int[]> list = map.computeIfAbsent(val, (a) -> new ArrayList<>());
				list.add(new int[]{i, j});
			}
		}

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		int[] res = {Integer.MAX_VALUE};
		backtrack(matrix, n, m, 0, 0, 0, visited, map, false, res);
		return res[0];
	}

	private static void backtrack(int[][] matrix, int n, int m, int curX, int curY, int curTime, boolean[][] visited,
								  Map<Integer, List<int[]>> transferMap, boolean transfer, int[] res) {
		if (curX == n - 1 && curY == m - 1) {
			res[0] = Math.min(curTime, res[0]);
			return;
		}
		int curVal = matrix[curX][curY];
		List<int[]> transferList = transferMap.get(curVal);
		if (transferList.size() > 1 && !transfer) {
			for (int[] node : transferList) {
				int newX = node[0];
				int newY = node[1];
				if (curX != newX && curY != newY && !visited[newX][newY]) {
					visited[newX][newY] = true;
					backtrack(matrix, n, m, newX, newY, curTime, visited, transferMap, true, res);
					visited[newX][newY] = false;
				}
			}
		}
		for (int[] direction : directions) {
			int newX = curX + direction[0];
			int newY = curY + direction[1];
			if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
				visited[newX][newY] = true;
				int time = Math.abs(curVal - matrix[newX][newY]);
				backtrack(matrix, n, m, newX, newY, curTime + time, visited, transferMap, transfer, res);
				visited[newX][newY] = false;
			}
		}
	}

	/*
	 * 5 5
	 * 1  99 99 99 99
	 * 2  99 8  9  10
	 * 3  99 7  99 11
	 * 4  5  6  99 12
	 * 99 99 99 99 13
	 */
	/**
	 * 5 5
	 * 10 99 99 99 99
	 * 2  99 8  9  10
	 * 3  99 7  99 11
	 * 4  5  6  99 12
	 * 99 99 99 99 13
	 */
	public static void main(String[] args) {
		// 处理输入
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		int res = minTime(matrix, n, m);
		System.out.println(res);
	}

}
