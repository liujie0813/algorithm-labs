package com.timberliu.algorithm.basic.dp.bag_01;

/**
 * 01 背包
 *
 *   dp[i][c]: i 表示当前枚举到哪件物品，c 表示现在剩余的容量，val 表示最大价值
 *
 *   dp[i][c] = max(dp[i-1][c], dp[i-1][c-w[i]] + v[i])
 *    考虑第 i 件物品，剩余容量不超过 c 的条件（第 i 件物品选还是不选）
 *
 *    dp[i-1]：每个物品最多选择一次
 *
 * @author liujie
 * @date 2021/10/13
 */

public class Solution1 {

	public static int maxValue(int num, int capacity, int[] weight, int[] value) {
		int[][] dp = new int[num][capacity + 1];
		// 考虑第一件物品
		for (int c = 0; c <= capacity; c++) {
			// 剩余容量 大于 物品质量
			dp[0][c] = c >= weight[0] ? value[0]: 0;
		}
		// 再考虑其他物品
		for (int i = 1; i < num; i++) {
			for (int c = 0; c <= capacity; c++) {
				// 不选 i 物品
				int n = dp[i - 1][c];
				// 选 i 物品（剩余容量 大于 物品质量）
				int y = c >= weight[i] ? (dp[i - 1][c - weight[i]] + value[i]) : 0;
				dp[i][c] = Math.max(n, y);
			}
		}
		return dp[num - 1][capacity];
	}

	public static void main(String[] args) {
		System.out.println("----- 1 -----");
		System.out.println(maxValue(3, 4, new int[]{4, 2, 3}, new int[]{4, 2, 3}));

		System.out.println("----- 2 -----");
		System.out.println(maxValue(3, 5, new int[]{4, 2, 3}, new int[]{4, 2, 3}));

	}

}
