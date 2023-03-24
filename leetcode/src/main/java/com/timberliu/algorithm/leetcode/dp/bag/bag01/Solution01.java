package com.timberliu.algorithm.leetcode.dp.bag.bag01;

/**
 * 01 背包原型问题
 *
 * @author liujie
 * @date 2023/3/23
 */

public class Solution01 {

	public static int maxValue(int capacity, int[] weight, int[] value) {
		int n = weight.length;
		int[][] dp = new int[n][capacity + 1];
		for (int j = weight[0]; j <= capacity; j++) {
			dp[0][j] = value[0];
		}
		// 遍历物品
		for (int i = 1; i < n; i++) {
			// 遍历背包容量
			for (int j = 0; j <= capacity; j++) {
				if (j < weight[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
				}
			}
		}
		return dp[n-1][capacity];
	}

	public static int maxValue1(int capacity, int[] weight, int[] value) {
		int n = weight.length;
		int[] dp = new int[capacity + 1];
		// 遍历物品
		for (int i = 0; i < n; i++) {
			// 需要倒序遍历
			for (int j = capacity; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {
		int res1 = maxValue(4, new int[]{1, 3, 4}, new int[]{10, 15, 20});
		System.out.println(res1);

		int res2 = maxValue1(4, new int[]{1, 3, 4}, new int[]{10, 15, 20});
		System.out.println(res2);
	}

}
