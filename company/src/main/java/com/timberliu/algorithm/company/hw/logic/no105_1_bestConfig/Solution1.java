package com.timberliu.algorithm.company.hw.logic.no105_1_bestConfig;

import java.util.Scanner;

/**
 * 105. 最优芯片资源占用
 *
 *
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution1 {

	public static void bestConfig(int[][] arr, String sequence, int n, int m) {
		int[] index = new int[n];

		for (int i = 0; i < sequence.length(); i++) {
			int num = 0;
			if ('A' == sequence.charAt(i)) {
				num = 1;
			} else if ('B' == sequence.charAt(i)) {
				num = 2;
			} else if ('C' == sequence.charAt(i)) {
				num = 8;
			}

			for (int j = 0; j < n; j++) {
				if (m - index[j] >= num) {
					for (int k = 0; k < num; k++) {
						arr[j][k + index[j]] = 1;
					}
					index[j] += num;
					break;
				}
			}
		}
	}

	/**
	 * 8
	 * 2
	 * ACABA
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		String sequence = scanner.next();
		int[][] arr = new int[n][m];
		bestConfig(arr, sequence, n, m);
		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a);
			}
			System.out.println();
		}
	}

}
