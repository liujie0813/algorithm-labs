package com.timberliu.algorithm.company.hw.binary_search.no079_1_minAbility;

import java.util.Scanner;

/**
 * 79. 农场施肥
 *
 * @author Timber
 * @date 2023/4/20
 */
public class Solution1 {

	public static int minAbility(int[] fields, int n) {
		int min = 0, max = 0;
		for (int field : fields) {
			min = Math.min(min, field);
			max = Math.max(max, field);
		}

		int res = -1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (canComplete(fields, mid, n)) {
				res = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return res;
	}

	private static boolean canComplete(int[] fields, int ability, int n) {
		int res = 0;
		for (int field : fields) {
			res += Math.ceil((double) field / ability);
		}
		return res <= n;
	}

	/*
	 * 3 1
	 * 2 3 4
	 */
	/**
	 * 5 7
	 * 5 7 9 15 10
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[] fields = new int[m];
		for (int i = 0; i < m; i++) {
			fields[i] = scanner.nextInt();
		}

		int res = minAbility(fields, n);
		System.out.println(res);

	}

}
