package com.timberliu.algorithm.leetcode.dp.bag.no0518_2_coinChange2;

/**
 * 518. 零钱兑换 II
 *
 *  状态定义：f[i][j] 考虑前 i 件物品，凑成总和为 j 的方案数量
 *
 *  换元一维优化：
 *    1. 在二维解法的基础上，直接取消 物品 维度
 *    2. 确保 容量维度 的遍历顺序 从小到大（适用于完全背包问题）
 *    3. 将形如 f[j-1][j-k*val] 的式子更替为 f[j-val]
 *         形如 f[j-1][j-k*val]+k 的式子更替换为 f[j-val]+1
 *         形如 f[j-1][j-k*val]+w[i] 的式子更替换为 f[j-val]+w[i]
 *          同时解决数组越界问题（将物品维度的遍历修改为 从val开始）
 *
 * @author Timber
 * @date 2021/10/14
 */
public class Solution2 {

	public int change(int amount, int[] coins) {
		int n = coins.length;
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			int val = coins[i - 1];
			for (int j = val; j <= amount; j++) {
				dp[j] += dp[j - val];
			}
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/coin-change-2/ -----");
		Solution2 solution2 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution2.change(5, new int[]{1, 2, 5}));

		System.out.println("----- 2 -----");
		System.out.println(solution2.change(3, new int[]{2}));

		System.out.println("----- 3 -----");
		System.out.println(solution2.change(10, new int[]{10}));

	}


}
