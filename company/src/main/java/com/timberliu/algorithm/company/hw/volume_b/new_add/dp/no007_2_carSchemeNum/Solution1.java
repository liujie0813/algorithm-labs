package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no007_2_carSchemeNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 代表团坐车
 *
 *  dp[i][j] 考虑前 i 个代表团，在容量为 j 的情况下的方案数
 *
 *   选择第 i 个代表团：
 *      dp[i][j] = dp[i - 1][j - arr[i]]
 *   不选择第 i 个代表团
 *      dp[i][j] = dp[i - 1][j]
 *
 *   初始化： 两种
 *    1. 0 个代表团，容量为 0 时，方案数为 1
 *    2. 考虑第一个代表团，容量为 0 或 arr[0] 时，方案数为 1
 *
 * @author liujie
 * @date 2023/5/24
 */

public class Solution1 {

	public static int schemeNum(int[] arr, int capacity) {
		int[][] dp = new int[arr.length + 1][capacity + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (j < arr[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		return dp[arr.length][capacity];
	}

	public static int schemeNum1(int[] arr, int capacity) {
		int[][] dp = new int[arr.length][capacity + 1];
		dp[0][0] = 1;
		dp[0][arr[0]] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (j < arr[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]];
				}
			}
		}
		return dp[arr.length - 1][capacity];
	}

	/**
	 * 5,4,2,3,2,4,9
	 * 10
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] arr = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();
		int capacity = scanner.nextInt();

		int res = schemeNum1(arr, capacity);
		System.out.println(res);
	}

}
