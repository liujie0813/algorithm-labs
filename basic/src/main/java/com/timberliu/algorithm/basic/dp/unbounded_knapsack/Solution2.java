package com.timberliu.algorithm.basic.dp.unbounded_knapsack;

/**
 * 完全背包
 *
 *  在 0-1 背包问题的基础上，增加了每件物品可以选择多次的特点
 *
 *  状态定义：dp[i][j] 表示考虑前 i 件物品，放入一个容量为 j 的背包可以获得的最大价值
 *
 *  状态转移方程：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - k * v])
 *
 *    时间复杂度：有 num * capacity 个状态需要被转移，每次转移都需要枚举当前物品的件数，最多枚举 capacity 次
 *            整体复杂度为 O(n * c * c)
 *    空间复杂度：O(n * c)
 *
 * @author Timber
 * @date 2021/10/13
 */
public class Solution2 {

	public static int maxValue(int num, int capacity, int[] weight, int[] value) {
		int[] dp = new int[capacity + 1];

		for (int i = 0; i < num; i++) {
			for (int c = 0; c <= capacity; c++) {
				// 不考虑第 i 件物品
				int no = dp[c];
				// 考虑第 i 件物品
				int yes = c >= weight[i] ? dp[c - weight[i]] + value[i] : 0;
				dp[c] = Math.max(no, yes);
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {
		System.out.println("----- 1 -----");
		System.out.println(maxValue(2, 5, new int[]{1, 2}, new int[]{1, 2}));

	}

}
