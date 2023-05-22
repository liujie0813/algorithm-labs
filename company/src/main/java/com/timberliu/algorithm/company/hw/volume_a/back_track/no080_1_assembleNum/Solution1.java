package com.timberliu.algorithm.company.hw.volume_a.back_track.no080_1_assembleNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 80. 组装新的数组
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution1 {

	public static int assembleNum(int[] arr, int total) {
		int min = Integer.MAX_VALUE;
		for (int val : arr) {
			min = Math.min(min, val);
		}
		Arrays.sort(arr);
		return dfs(arr, 0, 0, min, total);
	}

	private static int dfs(int[] arr, int index, int curSum, int min, int total) {
		if (total - min < curSum && curSum <= total) {
			return 1;
		}
		int res = 0;
		for (int i = index; i < arr.length; i++) {
			if (curSum + arr[i] > total) {
				break;
			}
			res += dfs(arr, i, curSum + arr[i], min, total);
		}
		return res;
	}

	/**
	 * 2 3
	 * 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int total = scanner.nextInt();

		int res = assembleNum(arr, total);
		System.out.println(res);
	}

}
