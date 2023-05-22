package com.timberliu.algorithm.company.hw.volume_a.back_track.no110_2_maxTriangleNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 110. 组成直角三角形个数
 *
 *  t 100
 *  n 20
 *
 *  100 * 20^3
 *
 *  回溯 - 全组合
 *   使用 used 记录哪些线段已经使用过
 *
 * @author liujie
 * @date 2023/4/13
 */

public class Solution1 {

	public static int maxTriangleNum(int[] arr) {
		Arrays.sort(arr);
		// 3 4 5 5 6 7 12 13
		return dfs(arr, 0, new boolean[arr.length]);
	}

	private static int dfs(int[] arr, int index, boolean[] used) {
		int res = 0;
		for (int i = index; i < arr.length - 2; i++) {
			if (used[i]) {
				continue;
			}
			for (int j = i + 1; j < arr.length - 1; j++) {
				if (used[j]) {
					continue;
				}
				for (int k = j + 1; k < arr.length; k++) {
					if (used[k]) {
						continue;
					}

					if (arr[i] * arr[i] + arr[j] * arr[j] == arr[k] * arr[k]) {
						used[i] = used[j] = used[k] = true;
						res = Math.max(res, dfs(arr, i + 1, used) + 1);
						used[i] = used[j] = used[k] = false;
					}
				}
			}
		}
		return res;
	}

	/**
	 * 7 3 4 5 6 5 12 13
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scanner.nextInt();
			}

			int res = maxTriangleNum(arr);
			System.out.println(res);
		}
	}

}
