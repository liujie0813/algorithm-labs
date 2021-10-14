package com.timberliu.algorithm.basic.dp.bounded_knapsack;

/**
 * 多重背包
 *
 *  在 0-1 背包问题的基础上，增加了每件物品可以选择【有限次数】的特点
 *
 *  状态定义：dp[i][j] 考虑前 i 件物品，且所选物品总体积不超过 j 时获得的最大价值
 *
 *  状态转移方程：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - k * v[i]] + k * w[i]), 0 < k <= s[i], 0 < k * v[i] <= j
 *            与完全背包一致，只是多了 0 < k <= s[i] 的条件
 *
 *
 * @author Timber
 * @date 2021/10/14
 */
public class Solution1 {

	public static int maxValue(int num, int capacity, int[] limit, int[] weight, int[] value) {
		int[][] dp = new int[num][capacity + 1];
		for (int c = 0; c <= capacity; c++) {
			int maxK = Math.min(c / weight[0], limit[0]);
			dp[0][c] = maxK * value[0];
		}

		for (int i = 1; i < num; i++) {
			for (int c = 0; c <= capacity; c++) {
				int no = dp[i - 1][c];
				int yes = 0;
				for (int k = 1; k <= limit[i] && c >= k * weight[i]; k++) {
					yes = Math.max(yes, dp[i - 1][c - k * weight[i]] + k * value[i]);
				}
				dp[i][c] = Math.max(no, yes);
			}
		}
		return dp[num - 1][capacity];
	}

	public static void main(String[] args) {

	}

}
