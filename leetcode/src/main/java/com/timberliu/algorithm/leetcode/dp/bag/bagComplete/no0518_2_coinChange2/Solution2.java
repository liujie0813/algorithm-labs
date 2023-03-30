package com.timberliu.algorithm.leetcode.dp.bag.bagComplete.no0518_2_coinChange2;

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
 *  dp[0] = 1：表示凑合总金额为 0 的硬币组合数为 1
 *     还有一种情况：如果正好选了 coins[i]，也就是 j-coins[i] = 0 的情况，
 *     			表示第 i 个硬币刚好能选，此时 dp[0] = 1 表示只选 coins[i]
 *
 *  完全背包在求最大价值时，两个 for 循环的先后顺序是无所谓的
 *  在求方案数，有区别（coins[0] = 1, coins[1] = 5）
 *  1. 外层循环遍历物品，内层循环遍历容量，求的是组合数
 *		只有 [1, 5]
 *  2. 外层循环遍历容量，内层循环遍历物品，求的是排列数
 *      有 [1, 5], [5, 1]
 *
 * @author Timber
 * @date 2021/10/14
 */
public class Solution2 {

	public int change(int amount, int[] coins) {
		int n = coins.length;
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			int val = coins[i];
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
