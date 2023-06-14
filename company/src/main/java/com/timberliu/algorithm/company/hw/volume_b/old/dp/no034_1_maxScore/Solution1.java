package com.timberliu.algorithm.company.hw.volume_b.old.dp.no034_1_maxScore;

import java.util.Scanner;

/**
 * 34. 翻牌求最大分
 *
 * @author liujie
 * @date 2023/6/13
 */

public class Solution1 {

	public static int maxScore(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				dp[i] = Math.max(0, arr[i]);
			} else if (i < 3) {
				dp[i] = Math.max(0, dp[i - 1] + arr[i]);
			} else {
				dp[i] = Math.max(dp[i - 3], dp[i - 1] + arr[i]);
			}
		}
		return dp[arr.length - 1];
	}

	/**
	 * 1, -5, -6, 4, 7, 2, -2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(", ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		int res = maxScore(arr);
		System.out.println(res);
	}

}
