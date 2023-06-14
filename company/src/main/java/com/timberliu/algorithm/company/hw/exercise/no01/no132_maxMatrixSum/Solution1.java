package com.timberliu.algorithm.company.hw.exercise.no01.no132_maxMatrixSum;

import java.util.Scanner;

/**
 *
 * dp[i][j]：考虑前 i 行前 j 列的所有子矩阵的最大和
 *
 *
 *
 * @author liujie
 * @date 2023/6/14
 */

public class Solution1 {

	public static int maxMatrixSum(int[][] matrix, int n, int m) {
		int[][] prefixSum = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
			}
		}

		int res = 0;
		for (int rightBottomI = 1; rightBottomI <= n; rightBottomI++) {
			for (int rightBottomJ = 1; rightBottomJ <= m; rightBottomJ++) {
				int max = 0;
				for (int leftTopI = 1; leftTopI <= rightBottomI; leftTopI++) {
					for (int leftTopJ = 1; leftTopJ <= rightBottomJ; leftTopJ++) {
						int val = prefixSum[rightBottomI][rightBottomJ]
								- prefixSum[leftTopI - 1][rightBottomJ]
								- prefixSum[rightBottomI][leftTopJ - 1]
								+ prefixSum[leftTopI - 1][leftTopJ - 1];
						max = Math.max(max,  val);
					}
				}
				res = Math.max(res, max);
			}
		}
		return res;
	}

	/**
	 * 3 4
	 * -3 5 -1 5
	 * 2 4 -2 4
	 * -1 3 -1 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}

		int res = maxMatrixSum(matrix, n, m);
		System.out.println(res);
	}

}
