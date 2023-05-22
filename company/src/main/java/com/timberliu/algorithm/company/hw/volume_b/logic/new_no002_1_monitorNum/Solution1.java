package com.timberliu.algorithm.company.hw.volume_b.logic.new_no002_1_monitorNum;

import java.util.Scanner;

/**
 * 2. 需要打开多少监控器
 *
 * @author liujie
 * @date 2023/5/22
 */

public class Solution1 {

	private static int[][] directions = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};

	public static int minMonitorNum(int[][] arr, int m, int n) {
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 如果当前车停车了
				if (arr[i][j] == 1) {
					res++;
					continue;
				}
				// 如果上下左右任意一个方向停车了
				for (int[] direction : directions) {
					int newX = i + direction[0];
					int newY = j + direction[1];
					if (newX >= 0 && newX < m && newY >= 0 && newY < n && arr[newX][newY] == 1) {
						res++;
						break;
					}
				}
			}
		}
		return res;
	}

	/**
	 * 3 3
	 * 0 0 0
	 * 0 1 0
	 * 0 0 0
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

		int res = minMonitorNum(arr, m, n);
		System.out.println(res);
	}

}
