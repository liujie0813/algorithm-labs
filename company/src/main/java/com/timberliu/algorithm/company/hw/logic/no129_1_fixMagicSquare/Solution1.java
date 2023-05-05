package com.timberliu.algorithm.company.hw.logic.no129_1_fixMagicSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 129. 幻方修复
 *
 * @author liujie
 * @date 2023/5/5
 */

public class Solution1 {

	public static int[][] fixMagicSquare(int[][] arr, int n) {
		int sum = 0;
		for (int[] subArr : arr) {
			for (int a : subArr) {
				sum += a;
			}
		}
		int target = sum / n;

		// 行和、列和
		// 不相等的行、列
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int rowSum = 0;
			int colSum = 0;
			for (int j = 0; j < n; j++) {
				rowSum += arr[i][j];
				colSum += arr[j][i];
			}
			if (rowSum != target) {
				rows.add(i);
			}
			if (colSum != target) {
				cols.add(i);
			}
		}

		if (rows.isEmpty()) {
			for (int i = 0; i < n; i++) {
				rows.add(i);
			}
		}
		if (cols.isEmpty()) {
			for (int i = 0; i < n; i++) {
				cols.add(i);
			}
		}

		// 相交的点，即可能出错的点
		List<int[]> positions = new ArrayList<>();
		for (Integer row : rows) {
			for (Integer col : cols) {
				positions.add(new int[]{row, col});
			}
		}

		for (int i = 0; i < positions.size(); i++) {
			for (int j = i + 1; j < positions.size(); j++) {
				int[] pos1 = positions.get(i);
				int[] pos2 = positions.get(j);
				int x1 = pos1[0], y1 = pos1[1];
				int x2 = pos2[0], y2 = pos2[1];

				int tmp = arr[x1][y1];
				arr[x1][y1] = arr[x2][y2];
				arr[x2][y2] = tmp;
				if (isValid(arr, pos1, pos2, target)) {
					return new int[][] {
							{pos1[0], pos1[1], arr[pos2[0]][pos2[1]]},
							{pos2[0], pos2[1], arr[pos1[0]][pos1[1]]}
					};
				}
				tmp = arr[x2][y2];
				arr[x2][y2] = arr[x1][y1];
				arr[x1][y1] = tmp;
			}
		}
		return null;
	}

	private static boolean isValid(int[][] arr, int[] pos1, int[] pos2, int target) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i][i];
		}
		if (sum != target) {
			return false;
		}

		sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i][n - i - 1];
		}
		if (sum != target) {
			return false;
		}

		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				sum += arr[i][j];
			}
			if (sum != target) {
				return false;
			}
		}

		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				sum += arr[j][i];
			}
			if (sum != target) {
				return false;
			}
		}

		return true;
	}

	/*
	 * 3
	 * 8 1 9
	 * 3 5 7
	 * 4 6 2
	 */
	/**
	 * 4
	 * 4 8 11 14
	 * 12 13 2 7
	 * 6 3 16 9
	 * 15 10 5 1
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

		int[][] res = fixMagicSquare(arr, n);
		for (int[] re : res) {
			System.out.println(re[0] + " " + re[1] + " " + re[2]);
		}
	}

}
