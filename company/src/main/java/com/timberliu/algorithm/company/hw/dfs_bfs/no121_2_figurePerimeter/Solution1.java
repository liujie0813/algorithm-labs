package com.timberliu.algorithm.company.hw.dfs_bfs.no121_2_figurePerimeter;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.Scanner;

/**
 * 121. 相同数字组成图片的周长
 *
 * @author liujie
 * @date 2023/5/4
 */

public class Solution1 {

	public static int[] figurePerimeter(int[][] matrix, int[] target) {
		int[] res = new int[target.length];
		for (int i = 0; i < target.length; i++) {
			int targetVal = target[i];
			int perimeter = 0;
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix[j].length; k++) {
					if (matrix[j][k] == targetVal) {
						if (j == 0 || matrix[j - 1][k] != targetVal) {
							perimeter++;
						}
						if (j == matrix.length - 1 || matrix[j + 1][k] != targetVal) {
							perimeter++;
						}
						if (k == 0 || matrix[j][k - 1] != targetVal) {
							perimeter++;
						}
						if (k == matrix[j].length - 1 || matrix[j][k + 1] != targetVal) {
							perimeter++;
						}
					}
				}
			}
			res[i] = perimeter;
		}
		return res;
	}

	/**
	 * 2
	 * 1 1 3 2 2 2 3 2 4 3 2 3 3 3 4 4 1 4 2 4 3 4 4 5 2 5 3
	 * 2 3 7 3 8 4 5 4 6 4 7 4 8 5 4 5 5 5 6 5 7 5 8 6 4 6 5 6 6 6 7 6 8 7 4 7 5 7 6 7 7 7 8
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int[][] matrix = new int[64][64];
		int[] target = new int[n];
		for (int i = 0; i < n; i++) {
			String[] splits = scanner.nextLine().split(" ");
			int val = Integer.parseInt(splits[0]);
			target[i] = val;
			for (int j = 1; j < splits.length; j += 2) {
				int row = Integer.parseInt(splits[j]);
				int col = Integer.parseInt(splits[j + 1]);
				matrix[row][col] = val;
			}
		}

		int[] res = figurePerimeter(matrix, target);
		PrintUtils.printIntArrayV2(res);
	}

}
