package com.timberliu.algorithm.company.hw.volume_a.binary_search.no061_2_outBallNum;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.Scanner;

/**
 * 61. 开放日活动
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static int[] outBallNum(int[] arr, int n, int totalLimit) {
		int max = 0;
		long sum = 0;
		for (int val : arr) {
			sum += val;
			max = Math.max(max, val);
		}
		if (sum <= totalLimit) {
			return new int[0];
		}

		int left = totalLimit / n, right = max;
		int limit = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int capacity = capacity(arr, mid);
			if (capacity > totalLimit) {
				right = mid - 1;
			} else if (capacity < totalLimit) {
				limit = mid;
				left = mid + 1;
			} else {
				limit = mid;
				break;
			}
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = Math.max(arr[i] - limit, 0);
		}
		return res;
	}

	private static int capacity(int[] arr, int capacity) {
		int res = 0;
		for (int val : arr) {
			res += Math.min(val, capacity);
		}
		return res;
	}

	/*
	 * 14 7
	 * 2 3 2 5 5 1 4
	 */
	/*
	 * 3 3
	 * 1 2 3
	 */
	/**
	 * 6 2
	 * 3 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalLimit = scanner.nextInt();
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int[] res = outBallNum(arr, n, totalLimit);
		PrintUtils.printIntArray(res);
	}

}
