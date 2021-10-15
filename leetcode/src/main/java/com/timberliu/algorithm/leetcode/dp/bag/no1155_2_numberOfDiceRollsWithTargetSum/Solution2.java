package com.timberliu.algorithm.leetcode.dp.bag.no1155_2_numberOfDiceRollsWithTargetSum;

/**
 * 1155. 掷骰子的N种方法
 *
 *  分组背包
 *  将筛子看做物品组，每个从物品组中必须选择一个物品
 *
 *  状态定义：f[i][j] 考虑前 i 个筛子，总点数恰好为 j 的方案数
 *
 *  状态转义方程：f[i][j] = sum(f[i - 1][j - k[i]])
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution2 {

	static int mod = 1000000007;

	public static int numRollsToTarget(int d, int f, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		// 筛子（物品组）
		for (int i = 1; i <= d; i++) {
			// 总点数（最大价值）
			for (int j = target; j >= 0; j--) {
				// 点数（物品 体积）
				int sum = 0;
				for (int k = 1; k <= f; k++) {
					if (j >= k) {
						sum = (sum + dp[j - k]) % mod;
					}
				}
				dp[j] = sum;
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(numRollsToTarget(1, 6, 3));

		System.out.println("----- 2 -----");
		System.out.println(numRollsToTarget(2, 6, 7));

		System.out.println("----- 3 -----");
		System.out.println(numRollsToTarget(2, 5, 10));

		System.out.println("----- 4 -----");
		System.out.println(numRollsToTarget(1, 2, 3));

		System.out.println("----- 5 -----");
		System.out.println(numRollsToTarget(30, 30, 500));

	}

}
