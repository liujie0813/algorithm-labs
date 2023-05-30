package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no017_1_sparseMatrix;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 17. 稀疏矩阵
 *
 * @author liujie
 * @date 2023/5/29
 */

public class Solution1 {

	public static int[] sparseMatrix(int[][] arr, int n, int m) {
		int[] zeroRowCnt = new int[n];
		int[] zeroColCnt = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					zeroRowCnt[i]++;
					zeroColCnt[j]++;
				}
			}
		}
		return new int[]{
			(int) Arrays.stream(zeroRowCnt).filter(a -> a >= n / 2).count(),
			(int) Arrays.stream(zeroColCnt).filter(a -> a >= n / 2).count(),
		};
	}

	/**
	 * 3 3
	 * 1 0 0
	 * 0 1 0
	 * 0 0 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		int[] res = sparseMatrix(arr, n, m);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

}
