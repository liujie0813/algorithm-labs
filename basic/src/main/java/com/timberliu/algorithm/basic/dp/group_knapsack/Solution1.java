package com.timberliu.algorithm.basic.dp.group_knapsack;

/**
 * 分组背包
 *
 *  给定 num 个物品组，容量为 capacity 的背包，第 i 个物品组有 s[i] 件物品
 *    其中第 i 组的第 i 件物品的成本为 weight[i][j]，价值为 value[i][j]
 *
 *  同一组的物品最多只能选一个
 *
 *  状态定义：f[i][j] 考虑前 i 个物品组，背包容量不超过 j 的最大价值
 *
 *  状态转义方程：f[i][j] = max(f[i-1][j], f[i-1][j - weight[i][k]] + value[i][k]), 0 <= k < s[i]
 *
 *  时间复杂度：O(c * sum(s[i])
 *  空间复杂度：O(n * c)
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution1 {

	public int maxValue(int num, int capacity, int[] s, int[][] weight, int[][] value) {
		int[][] dp = new int[num + 1][capacity + 1];
		// 物品组
		for (int i = 1; i <= num; i++) {
			int[] weightI = weight[i - 1];
			int[] valueI = value[i - 1];
			int sI = s[i - 1];
			// 容量
			for (int c = 1; c <= capacity; c++) {
				dp[i][c] = dp[i - 1][c];
				// 物品组中任一 物品
				for (int k = 0; k < sI; k++) {
					if (c >= weightI[k]) {
						dp[i][c] = Math.max(dp[i][c], dp[i - 1][c - weightI[k]] + valueI[k]);
					}
				}
			}
		}
		return dp[num][capacity];
	}

	public static void main(String[] args) {

	}

}
