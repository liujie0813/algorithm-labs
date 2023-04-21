package com.timberliu.algorithm.company.hw.prefix_sum.no083_areaNum;

import java.util.Scanner;

/**
 * 83. 荒地建设基站
 *
 *  模拟
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution1 {

	public static int areaNum(int[][] arr, int n, int m, int side, int minVal) {
		int curVal = 0;
		int res = 0;
		for (int i = 0; i < side - 1; i++) {
			for (int j = 0; j < side - 1; j++) {
				curVal += arr[i][j];
			}
		}
		for (int i = side - 1; i < n; i++) {
			for (int j = 0; j < side - 1; j++) {
				curVal += arr[i][j];
			}
			int tmp = curVal;
			for (int j = side - 1; j < m; j++) {
				for (int k = 0; k < side; k++) {
					curVal += arr[i - k][j];
				}
				if (curVal >= minVal) {
					res++;
				}
				for (int k = 0; k < side; k++) {
					curVal -= arr[i - k][j - side + 1];
				}
			}
			for (int j = 0; j < side - 1; j++) {
				tmp -= arr[i - side + 1][j];
			}
			curVal = tmp;
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
