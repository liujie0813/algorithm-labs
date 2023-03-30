package com.timberliu.algorithm.leetcode.dp.bag.bagComplete;

/**
 * 完全背包原型问题
 *
 * @author liujie
 * @date 2023/3/29
 */

public class Solution1 {

	public static int maxValue(int capacity, int[] weight, int[] value) {
		int n = weight.length;
		int[][] dp = new int[n + 1][capacity + 1];
		for (int j = 0; j <= capacity; j++) {
			dp[0][j] = j / weight[0] * value[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= capacity; j++) {
				int tmp = 0;
				for (int k = 1; k * weight[i] <= j; k++) {
					tmp = Math.max(tmp, dp[i - 1][j - k * weight[i]] + k * value[i]);
				}
				dp[i][j] = Math.max(dp[i - 1][j], tmp);
			}
		}
		return dp[n - 1][capacity];
	}

	public static int maxValue1(int capacity, int[] weight, int[] value) {
		int n = weight.length;
		int[] dp = new int[capacity + 1];
		// 遍历物品
		for (int i = 0; i < n; i++) {
			for (int j = weight[i]; j <= capacity; j++) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {
		int res = maxValue(5, new int[]{1, 2}, new int[]{1, 2});
		System.out.println(res);
	}

}
