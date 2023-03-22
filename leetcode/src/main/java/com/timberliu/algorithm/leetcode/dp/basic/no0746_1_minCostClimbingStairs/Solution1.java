package com.timberliu.algorithm.leetcode.dp.basic.no0746_1_minCostClimbingStairs;

/**
 * 746. 使用最小花费爬楼梯
 *   cost[i]：从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶
 *     可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯
 *     计算并返回达到楼梯顶部的最低花费
 *
 *   dp[i]：表示到第 i 个台阶所需要的最低费用
 *
 *   dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
 *
 *   dp[0] = dp[1] = 0
 *
 */
public class Solution1 {

	/**
	 * 第一步没有花费，最后一步有花费
	 *
	 * cost[i] 表示从当前楼梯向上所需支付的费用
	 */
    public static int minCostClimbingStairs(int[] cost) {
    	int res = 0;
		int first = 0, second = 0;
		// 走到楼梯顶部（包括最后一级楼梯）
		for (int i = 2; i <= cost.length; i++) {
			res = Math.min(first + cost[i - 2], second + cost[i - 1]);
			first = second;
			second = res;
		}
		return res;
    }

	/**
	 * 第一步有花费，最后一步没有花费
	 *
	 * cost[i] 表示走上当前楼梯所需支付的费用
	 */
	public static int minCostClimbingStairs1(int[] cost) {
		int res = 0;
		int first = cost[0], second = cost[1];
		for (int i = 2; i < cost.length; i++) {
			res = Math.min(first, second) + cost[i];
			first = second;
			second = res;
		}
		return Math.min(first, second);
	}

    public static void main(String[] args) {
		int res1 = minCostClimbingStairs(new int[]{10, 15, 20});
		System.out.println(res1);

		int res2 = minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
		System.out.println(res2);

		int res3 = minCostClimbingStairs1(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
		System.out.println(res3);
	}

}