package com.timberliu.algorithm.leetcode.dp.bag.no0518_2_coinChange2;

/**
 * 518. 零钱兑换 II
 *
 *  状态定义：f[i][j] 考虑前 i 件物品，凑成总和为 j 的方案数量
 *
 *
 *
 * @author Timber
 * @date 2021/10/14
 */
public class Solution1 {

	public int change(int amount, int[] coins) {
		int n = coins.length;
		int[][] dp = new int[n + 1][amount + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= n; i++) {
			int val = coins[i - 1];
			for (int j = 0; j <= amount; j++) {
				dp[i][j] = dp[i - 1][j];
				for (int k = 1; k * val <= j; k++) {
					dp[i][j] += dp[i - 1][j - k * val];
				}
			}
		}
		return dp[n][amount];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/coin-change-2/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.change(5, new int[]{1, 2, 5}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.change(3, new int[]{2}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.change(10, new int[]{10}));


	}

}
