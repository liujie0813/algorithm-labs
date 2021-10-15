package com.timberliu.algorithm.leetcode.dp.bag.no0879_3_profitableSchemes;

/**
 * 879. 盈利计划
 *
 *  状态定义：f[i][j][k] 考虑前 i 件工作，在使用人数不超过 j, 产生至少 k 利润的条件下的方案数
 *
 *  状态转移方程：
 *     1. 不选  f[i-1][j][k]
 *     2. 选   f[i-1][j - group[i-1]][max(0, k - profit[i-1])]
 *        a. 任务 满足人数要求 j >= group[i - 1]
 *        b. k - profit[i-1] 可能会出现负值？
 *           根据状态定义做等价替换；将【利润至少为负值】这个状态映射到 f[i][j][0]
 *           由于所有的任务利润都为 非负数，所以不可能出现利润为负的情况，此时【利润至少为负数 k】的方案数完全等价于【利润至少为 0】的方案数
 *
 *  有效起始值：f[0][x][0] = 1
 *           不存在任何 任务时，不管人数多少，所得利润必然为 0
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution2 {

	static int mod = 1000000007;

	public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		int m = group.length;
		int[][] dp = new int[n + 1][minProfit + 1];
		for (int j = 0; j <= n; j++) {
			dp[j][0] = 1;
		}

		// 任务
		for (int i = 1; i <= m; i++) {
			int g = group[i - 1], p = profit[i - 1];
			// 人数
			for (int j = n; j >= g; j--) {
				// 利润
				for (int k = minProfit; k >= 0; k--) {
					dp[j][k] = (dp[j][k] + dp[j - g][Math.max(0, k - p)]) % mod;
				}
			}
		}
		return dp[n][minProfit];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/profitable-schemes/ -----");
		System.out.println("----- 1 -----");
		System.out.println(profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));

		System.out.println("----- 2 -----");
		System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));

	}

}
