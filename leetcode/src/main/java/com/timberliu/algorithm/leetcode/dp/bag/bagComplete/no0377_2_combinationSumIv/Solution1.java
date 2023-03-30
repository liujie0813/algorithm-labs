package com.timberliu.algorithm.leetcode.dp.bag.bagComplete.no0377_2_combinationSumIv;

/**
 * 377. 组合总和 IV
 *
 *  给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 *  题目描述是求组合，但又说顺序不同算两个组合，其实就是求排列
 *
 *  正整数个数没有限制，所以是一个完全背包问题
 *
 *  如果要把排列都列出来，只能使用回溯。但本题求的是排列个数。
 *
 */

public class Solution1 {

    public int combinationSum4(int[] nums, int target) {
    	int[] dp = new int[target + 1];
    	dp[0] = 1;
		for (int i = 0; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i >= nums[j]) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
    }

    public static void main(String[] args) {

    }

}