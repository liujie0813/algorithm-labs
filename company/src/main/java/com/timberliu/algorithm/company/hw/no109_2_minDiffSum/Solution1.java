package com.timberliu.algorithm.company.hw.no109_2_minDiffSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 109. 实力差距最小总和
 *
 *
 *
 * @author liujie
 * @date 2023/4/13
 */

public class Solution1 {

	public static int maxDiffSum(int[] arr, int maxDiff) {
		Arrays.sort(arr);
		int[] res = dfs(arr, 0, new boolean[arr.length], maxDiff);
		return res[0] == 0 ? -1 : res[1];
	}

	private static int[] dfs(int[] arr, int index, boolean[] used, int maxDiff) {
		// <队伍数，实力差距和>
		int[] res = {0, Integer.MAX_VALUE};
		for (int i = index; i < arr.length - 1; i++) {
			if (used[i]) {
				continue;
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (used[j]) {
					continue;
				}
				int diff = Math.abs(arr[i] - arr[j]);
				if (diff <= maxDiff) {
					used[i] = used[j] = true;
					int[] next = dfs(arr, i + 1, used, maxDiff);

					if (next[0] + 1 > res[0]) {
						res[0] = next[0] + 1;
						res[1] = next[1] + diff;
					}
					if (next[0] + 1 == res[0]) {
						res[1] = Math.min(res[1], next[1] + diff);
					}
					used[i] = used[j] = false;
				}
			}
		}
		if (res[0] == 0) {
			res[1] = 0;
		}
		return res;
	}

	/**
	 * eg:
	 *  6 30
	 *  81 87 47 59 81 18
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int maxDiff = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = maxDiffSum(arr, maxDiff);
		System.out.println(res);
	}

}
