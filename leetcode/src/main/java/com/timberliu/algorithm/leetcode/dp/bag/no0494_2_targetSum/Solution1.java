package com.timberliu.algorithm.leetcode.dp.bag.no0494_2_targetSum;

/**
 * 494. 目标和
 *
 *  状态定义：f[i][j] 考虑前 i 个数，表达式的运算结果等于 target 的方案数
 *
 *  初始值：f[0][0] = 1 不考虑任何数，凑出结果为 0 的方案数为 1
 *
 *  状态转移方程：f[i][j] = f[i - 1][j - nums[i - 1]] + f[i - 1][j + nums[i - 1]]
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution1 {

	public static int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < target) {
			return 0;
		}
		// 第 2 维: [-sum, sum] -> [0, 2 * sum] 右偏移 s
		int[][] dp = new int[n + 1][2 * sum + 1];
		dp[0][sum] = 1;
		// 数（物品）
		for (int i = 1; i <= n; i++) {
			int x = nums[i - 1];
			// 计算结果
			for (int j = -sum; j <= sum; j++) {
				if ((j - x) + sum >= 0) {
					dp[i][j + sum] += dp[i - 1][(j - x) + sum];
				}
				if ((j + x) + sum <= 2 * sum) {
					dp[i][j + sum] += dp[i - 1][(j + x) + sum];
				}
			}
		}
		return dp[n][target + sum];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/target-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));

		System.out.println("----- 2 -----");
		System.out.println(findTargetSumWays(new int[]{1}, 1));

	}

}
