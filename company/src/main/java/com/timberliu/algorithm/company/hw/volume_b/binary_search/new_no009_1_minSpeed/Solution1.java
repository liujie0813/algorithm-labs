package com.timberliu.algorithm.company.hw.volume_b.binary_search.new_no009_1_minSpeed;

import java.util.Scanner;

/**
 * 9. 食堂供餐
 *
 * @author liujie
 * @date 2023/5/25
 */

public class Solution1 {

	public static int minSpeed(int[] arr, int m) {
		int max = 0;
		for (int val : arr) {
			max = Math.max(max, val);
		}
		int left = 0;
		int right = max;
		int res = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(arr, m, mid)) {
				res = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}

	private static boolean check(int[] arr, int m, int speed) {
		int cur = m;
		for (int p : arr) {
			if (cur < p) {
				return false;
			}
			cur -= p;
			cur += speed;
		}
		return true;
	}

	/**
	 * 3
	 * 14
	 * 10 4 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = minSpeed(arr, m);
		System.out.println(res);
	}

}
