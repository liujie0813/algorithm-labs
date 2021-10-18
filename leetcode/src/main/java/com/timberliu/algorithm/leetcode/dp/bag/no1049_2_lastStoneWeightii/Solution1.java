package com.timberliu.algorithm.leetcode.dp.bag.no1049_2_lastStoneWeightii;

/**
 * 1049. 最后一块石头的重量 II
 *
 *  问题转换为：为原来的 stones 数组中的数字添加 +/- 符号，所形成的的计算表达式
 *
 *  再转：从 stones 数组中选择，凑成总和不超过 sum/2 的最大价值
 *								   恰好 sum-target/2
 *
 *  状态定义：dp[i][j] 考虑前 i 个数，凑成总和不超过 j 的最大价值
 *
 *  状态转移方程：dp[i][j] = max(dp[i-1][j], dp[i-1][j - k] + k)
 *
 *
 * @author liujie
 * @date 2021/10/18
 */

public class Solution1 {

	public int lastStoneWeightII(int[] stones) {
		int n = stones.length;
		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}
		int t = sum / 2;
		int[] dp = new int[t + 1];
		for (int i = 1; i <= n; i++) {
			int u = stones[i - 1];
			for (int j = t; j >= u; j--) {
				dp[j] = Math.max(dp[j], dp[j - u] + u);
			}
		}
		return Math.abs((sum - dp[t]) - dp[t]);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/last-stone-weight-ii/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.lastStoneWeightII(new int[]{2,7,4,1,8,1}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.lastStoneWeightII(new int[]{31,26,33,21,40}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.lastStoneWeightII(new int[]{1,2}));

	}

}
