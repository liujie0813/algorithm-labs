package com.timberliu.algorithm.company.hw.exercise.no02.no127_2_buildBlock;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 127. 叠积木
 *
 *  要看每一层能够放几个积木
 *    如果可以放多个，则用回溯
 *    如果放一个或两个，则用贪心
 *
 * @author liujie
 * @date 2023/6/15
 */

public class Solution1 {

	public static int buildBlock(int[] arr) {
		Arrays.sort(arr);
		int sum = 0;
		for (int a : arr) {
			sum += a;
		}
		int level = arr.length;
		while (level > 1) {
			if (sum % level != 0) {
				continue;
			}
			boolean[] res = new boolean[1];
			backtrack(arr, 0,sum / level, new int[level], res);
			if (res[0]) {
				return level;
			}
			level--;
		}
		return -1;
	}

	private static void backtrack(int[] arr, int cur, int len, int[] bucket, boolean[] res) {
		if (cur == arr.length) {
			res[0] = true;
			return;
		}
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] + arr[cur] > len) {
				continue;
			}
			bucket[i] += arr[cur];
			backtrack(arr, cur + 1, len, bucket, res);
			bucket[i] -= arr[cur];
		}
	}

	/*
	 * 3 6 3 3 3
	 */
	/**
	 * 9 9 9 5 3 2 2 2 2 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		int res = buildBlock(arr);
		System.out.println(res);
	}

}
