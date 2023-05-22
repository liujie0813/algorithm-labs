package com.timberliu.algorithm.company.hw.volume_a.logic.no036_1_findNthChar;

import java.util.Scanner;

/**
 * 36. 对称美学
 *
 *  注意溢出
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static String[] findNthChar(long[][] arr) {
		String[] res = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = doFind(arr[i][0], arr[i][1]);
		}
		return res;
	}

	private static String doFind(long n, double k) {
		if (n == 1 && k == 0) {
			return "red";
		}
		double half = 1L << (n - 2);
		if (k < half) {
			// 前半部分
			String res = doFind(n - 1, k);
			return "red".equals(res) ? "blue" : "red";
		} else {
			// 后半部分
			return doFind(n - 1, k - half);
		}
	}

	/*
	 * 5
	 * 1 0
	 * 2 1
	 * 3 2
	 * 4 6
	 * 5 8
	 */
	/**
	 * 1
	 * 64 73709551616
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[][] arr = new long[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextLong();
			arr[i][1] = scanner.nextLong();
		}

		String[] res = findNthChar(arr);
		for (String val : res) {
			System.out.println(val);
		}
	}

}
