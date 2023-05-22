package com.timberliu.algorithm.company.hw.volume_b.binary_search.no003_1_minPlantIInterval;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3. 最佳植树距离
 *
 *
 * @author liujie
 * @date 2023/5/22
 */

public class Solution1 {

	public static int minPlantInterval(int[] arr, int cnt) {
		Arrays.sort(arr);
		// 间距至少为 1，最大为 最后一棵树-第一棵树
		int left = 1, right = arr[arr.length - 1] - arr[0];
		int res = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(arr, cnt, mid)) {
				res = mid;
				left = mid + 1;
			} else {
				right = mid -1;
			}
		}
		return res;
	}

	/**
	 *  res >= cnt，说明种 res 棵树时，间距满足 minDist，那么 cnt <= res（树变少，间距增大），肯定也满足最小间距
	 *  res < cnt，那么不满足
	 */
	private static boolean check(int[] arr, int cnt, int minDist) {
		int res = 1;
		int cur = arr[0];
		for (int i = 1; i < arr.length; i++) {
			// 两棵树之间的间距要大于 minDist
			if (arr[i] - cur >= minDist) {
				res++;
				cur = arr[i];
			}
		}
		return res >= cnt;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int cnt = scanner.nextInt();

		int res = minPlantInterval(arr, cnt);
		System.out.println(res);
	}

}
