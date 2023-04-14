package com.timberliu.algorithm.company.hw.no104_1_maxLogLimit;

import java.util.Scanner;

/**
 * 104. 日志限流
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution1 {

	public static int maxLogLimit(int[] arr, int total) {
		int right = Integer.MIN_VALUE;
		int sum = 0;
		for (int a : arr) {
			right = Math.max(right, a);
			sum += a;
		}
		if (sum < total) {
			return -1;
		}

		int left = total / arr.length;
		int res = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int val = can(arr, mid);
			if (val == total) {
				return mid;
			} else if (val < total) {
				res = Math.max(res, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}

	private static int can(int[] arr, int limit) {
		int res = 0;
		for (int a : arr) {
			res += Math.min(a, limit);
		}
		return res;
	}

	/**
	 * 6
	 * 3 3 8 7 10 15
	 * 40
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int total = scanner.nextInt();

		int res = maxLogLimit(arr, total);
		System.out.println(res);
	}

}
