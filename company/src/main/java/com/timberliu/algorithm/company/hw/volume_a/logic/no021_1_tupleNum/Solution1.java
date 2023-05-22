package com.timberliu.algorithm.company.hw.volume_a.logic.no021_1_tupleNum;

import java.util.Scanner;

/**
 * 21. 二元组个数
 *
 * @author liujie
 * @date 2023/4/27
 */

public class Solution1 {

	public static int tupleNum(int[] arr1, int[] arr2) {
		int res = 0;
		for (int val1 : arr1) {
			for (int val2 : arr2) {
				if (val1 == val2) {
					res++;
				}
			}
		}
		return res;
	}

	/**
	 * 4
	 * 1 1 2 2
	 * 3
	 * 2 2 4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int[] arr1 = new int[m];
		int n = scanner.nextInt();
		int[] arr2 = new int[n];
		int res = tupleNum(arr1, arr2);
		System.out.println(res);
	}

}
