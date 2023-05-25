package com.timberliu.algorithm.company.hw.volume_b.dfs_bfs.new_no010_1_maxValOfMineHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 10. 寻找最大价值的矿堆
 *
 * @author liujie
 * @date 2023/5/25
 */

public class Solution1 {

	private static int[][] directions = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};

	public static int maxValOfMineHeap(List<int[]> matrix) {
		int n = matrix.size(), m = matrix.get(0).length;
		int res = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					int val = dfs(matrix, i, j, visited);
					res = Math.max(res, val);
				}
			}
		}
		return res;
	}

	private static int dfs(List<int[]> matrix, int curX, int curY, boolean[][] visited) {
		int res = matrix.get(curX)[curY];
		visited[curX][curY] = true;
		for (int[] direction : directions) {
			int newX = curX + direction[0];
			int newY = curY + direction[1];
			if (newX >= 0 && newX < matrix.size() && newY >= 0 && newY < matrix.get(0).length
					&& !visited[newX][newY] && matrix.get(newX)[newY] != 0) {
				res += dfs(matrix, newX, newY, visited);
			}
		}
		return res;
	}

	/*
	 * 22220
	 * 00000
	 * 00000
	 * 11111
	 */
	/*
	 * 22220
	 * 00020
	 * 00010
	 * 01111
	 */
	/**
	 * 20000
	 * 00120
	 * 00000
	 * 00111
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<int[]> matrix = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.isEmpty()) {
				break;
			}
			int[] arr = new int[line.length()];
			for (int i = 0; i < line.length(); i++) {
				arr[i] = line.charAt(i) - '0';
			}
			matrix.add(arr);
		}

		int res = maxValOfMineHeap(matrix);
		System.out.println(res);
	}

}
