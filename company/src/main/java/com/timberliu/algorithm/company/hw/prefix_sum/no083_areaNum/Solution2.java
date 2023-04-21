package com.timberliu.algorithm.company.hw.prefix_sum.no083_areaNum;

import java.util.Scanner;

/**
 * 83. 荒地建设基站
 *
 *  二维前缀和
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution2 {

	public static int areaNum(int[][] arr, int n, int m, int side, int minVal) {
		// prefixSum[i][j] 表示以 [i-1][j-1] 为右下角的矩阵和
		int[][] prefixSum = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i - 1][j - 1];
			}
		}
		int res = 0;
		for (int i = side; i <= n; i++) {
			for (int j = side; j <= m; j++) {
				if (prefixSum[i][j] - prefixSum[i - side][j] - prefixSum[i][j - side] + prefixSum[i - side][j - side] >= minVal) {
					res++;
				}
			}
		}
		return res;
	}

	/*
	 * 2 5 1 6
	 * 1 3 4 5 8
	 * 2 3 6 7 1
	 */
	/**
	 * 2 5 2 6
	 * 1 3 4 5 8
	 * 2 3 6 7 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int areaLen = scanner.nextInt();
		int areaWidth = scanner.nextInt();
		int[][] arr = new int[areaLen][areaWidth];
		int len = scanner.nextInt();
		int minVal = scanner.nextInt();
		for (int i = 0; i < areaLen; i++) {
			for (int j = 0; j < areaWidth; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		int res = areaNum(arr, areaLen, areaWidth, len, minVal);
		System.out.println(res);
	}

}
