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
 *   一维空间优化？可以优化空间，但不能降低时间复杂度
 *       如果像【完全背包】只保留【容量维度】，且【从小到大】遍历容量，
 *       在转移 f[i] 时无法直接知道所依赖的 f[j - weight[i]] 使用了多少件物品 i
 *
 * @author Timber
 * @date 2021/10/14
 */
public class Solution2 {

	public static int maxValue(int num, int capacity, int[] limit, int[] weight, int[] value) {
		int[] dp = new int[capacity + 1];

		for (int i = 0; i < num; i++) {
			for (int c = capacity; c >= 0; c--) {
				for (int k = 0; k <= limit[i] && c >= k * weight[i]; k++) {
					dp[c] = Math.max(dp[c], dp[c - k * weight[i]] + k * value[i]);
				}
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {

	}

}
