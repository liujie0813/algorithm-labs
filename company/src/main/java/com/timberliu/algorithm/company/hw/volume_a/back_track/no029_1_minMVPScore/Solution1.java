package com.timberliu.algorithm.company.hw.volume_a.back_track.no029_1_minMVPScore;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 29. 星际篮球争霸赛
 *
 * @author liujie
 * @date 2023/4/26
 */

public class Solution1 {

	public static int minMVPScore(int[] arr, int n) {
		int sum = 0;
		for (int a : arr) {
			sum += a;
		}
		Arrays.sort(arr);
		// k 从大到小，找到的第一个可拆分的 k 即为最大的分组数，最小的子数组和
		for (int k = n; k > 0; k--) {
			// 不能拆分为 k 组
			if (sum % k != 0) {
				continue;
			}
			int[] bucket = new int[k];
			if (canSplit(arr, 0, k, bucket, sum / k)) {
				return sum / k;
			}
		}
		return sum;
	}

	private static boolean canSplit(int[] arr, int index, int k, int[] bucket, int target) {
		if (index == arr.length) {
			return true;
		}
		for (int i = 0; i < k; i++) {
			if (i > 0 && bucket[i] == bucket[i - 1]) {
				continue;
			}
			if (bucket[i] + arr[index] > target) {
				continue;
			}
			bucket[i] += arr[index];
			if (canSplit(arr, index + 1, k, bucket, target)) {
				return true;
			}
			bucket[i] -= arr[index];
		}
		return false;
	}

	/**
	 * 9
	 * 5 2 1 5 2 1 5 2 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int res = minMVPScore(arr, n);
		System.out.println(res);
	}

}
