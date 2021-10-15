package com.timberliu.algorithm.leetcode.dp.bag.no0494_2_targetSum;

/**
 * 494. 目标和
 *
 *  令所有值的绝对值总和为 sum，负值的绝对值总和为 m, 有 (s - m) - m = target， m = (sum - target) / 2
 *
 *  问题转换：只使用 + 运算符，凑出 m 的方案数
 *
 *  状态定义：f[i][j]：考虑前 i 个数，凑出总和恰好为 j 的方案数
 *
 *  初始值：f[0][0] = 1
 *
 *  状态转移方程：f[i][j] = f[i - 1][j] + f[i - 1][j - nums[i - 1]]
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution2 {

	public static int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		// 确保 (sum - target) 能够被 2 整除
		if (sum < target || (sum - target) % 2 != 0) {
			return 0;
		}
		//
		int m = (sum - target) / 2;
		int[] dp = new int[m + 1];
		dp[0] = 1;
		// 数（物品）
		for (int i = 1; i <= n; i++) {
			int x = nums[i - 1];
			// 计算结果
			for (int j = m; j >= x; j--) {
				dp[j] += dp[j - x];
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/target-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));

		System.out.println("----- 2 -----");
		System.out.println(findTargetSumWays(new int[]{1}, 1));

	}

}
