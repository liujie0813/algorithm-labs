package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no071_1_signalVal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 71. 计算网络信号
 *
 *  BFS
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution1 {

	public static int[][] changes = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};

	public static int signalVal(int[][] arr, int m, int n, int foundX, int foundY) {
		Deque<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > 0) {
					queue.add(new int[]{i, j});
					break;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] top = queue.poll();
			int x = top[0];
			int y = top[1];
			int nextSignal = arr[x][y] - 1;
			if (nextSignal == 0) {
				break;
			}
			for (int[] change : changes) {
				int nextX = x + change[0];
				int nextY = y + change[1];
				// 如果没有到边界，且为空旷位置（也是没有传播过的）
				if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && arr[nextX][nextY] == 0) {
					// 所有能传播到的位置，写上信号值
					arr[nextX][nextY] = nextSignal;
					queue.offer(new int[]{nextX, nextY});
				}
			}
		}

		return arr[foundX][foundY];
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
