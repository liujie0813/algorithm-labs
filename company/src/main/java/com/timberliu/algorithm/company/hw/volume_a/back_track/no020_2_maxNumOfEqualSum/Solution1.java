package com.timberliu.algorithm.company.hw.volume_a.back_track.no020_2_maxNumOfEqualSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 20. 最大平分数组
 *
 * @author liujie
 * @date 2023/4/27
 */

public class Solution1 {

	public static int maxNumOfEqualSum(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		Arrays.sort(arr);
		for (int i = arr.length; i >= 1; i--) {
			if (sum % i != 0) {
				continue;
			}
			int[] bucket = new int[i];
			if (canSplit(arr, 0, bucket, sum / i)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean canSplit(int[] arr, int index, int[] bucket, int target) {
		if (index == arr.length) {
			return true;
		}
		for (int i = 0; i < bucket.length; i++) {
			if (i > 0 && bucket[i] == bucket[i - 1]) {
				continue;
			}
			if (bucket[i] + arr[index] > target) {
				continue;
			}
			bucket[i] += arr[index];
			if (canSplit(arr, index + 1, bucket, target)) {
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
		int res = maxNumOfEqualSum(arr);
		System.out.println(res);
	}

}
