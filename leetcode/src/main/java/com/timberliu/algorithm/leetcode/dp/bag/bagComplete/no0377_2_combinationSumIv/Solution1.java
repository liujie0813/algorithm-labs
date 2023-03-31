package com.timberliu.algorithm.leetcode.dp.bag.bagComplete.no0377_2_combinationSumIv;

/**
 * 377. 组合总和 IV
 *
 *  给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 *  题目描述是求组合，但又说顺序不同算两个组合，其实就是求排列
 *  正整数个数没有限制，所以是一个完全背包问题
 *  如果要把排列都列出来，只能使用回溯。但本题求的是排列个数。
 *
 *  对于组合问题，不能直接套用完全背包的定义
 *
 *  状态定义：dp[i][j] 表示组合长度为 i，凑成总和为 j 的组合个数
 *     由于组合的长度没有限制，所以最终答案为所有 dp[x][target] 的总和
 *
 *  dp[i][j] 推导：组合中最后一个数字可以选择 nums 中的任何一个数
 *    dp[i][j] = ∑ dp[i-1][j - nums[i]], j >= nums[i]，
 *               i从0到n-1
 *
 *  dp[0][0] = 1
 *
 */

public class Solution1 {

    public static int combinationSum4(int[] nums, int target) {
    	int len = target;
    	int[][] dp = new int[len + 1][target + 1];
    	dp[0][0] = 1;

    	int res = 0;
    	// 组合长度
		for (int i = 1; i <= len; i++) {
			// 凑成的总和
			for (int j = 0; j <= target; j++) {
				for (int num : nums) {
					if (j >= num) {
						dp[i][j] += dp[i - 1][j - num];
					}
				}
			}
			res += dp[i][target];
		}
		return res;
    }

    public static void main(String[] args) {
		int res = combinationSum4(new int[]{1, 2, 3}, 4);
		System.out.println(res);
	}

}