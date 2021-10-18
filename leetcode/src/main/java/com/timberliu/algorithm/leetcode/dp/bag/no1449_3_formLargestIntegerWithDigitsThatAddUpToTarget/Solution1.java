package com.timberliu.algorithm.leetcode.dp.bag.no1449_3_formLargestIntegerWithDigitsThatAddUpToTarget;

import java.util.Arrays;

/**
 * 1449. 数位成本和为目标值的最大数字
 *
 *  最大数值
 *    1. 长度较长数字越大
 *    2. 长度相等看高位
 *
 *  问题转换：考虑前 i 个数，各数位的成本和【恰好】为目标值的 最大数值长度
 *
 *  dp[0] = 1;
 *  dp[j] = max(dp[j], d[j - cost[i]] + 1)
 *
 *  构造答案
 *     尽可能让高位越大越好
 *
 *  完全背包 + 贪心
 *
 * @author liujie
 * @date 2021/10/18
 */

public class Solution1 {

	public String largestNumber(int[] cost, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		// 物品（数字从 1 到 9）
		for (int i = 1; i <= 9; i++) {
			int u = cost[i - 1];
			for (int j = u; j <= target; j++) {
				dp[j] = Math.max(dp[j], dp[j - u] + 1);
			}
		}
		if (dp[target] < 0) {
			return "0";
		}

		// 构造答案
		StringBuilder res = new StringBuilder();
		int t = target;
		// 尽可能让高位的数值大，从 9 到 1
		for (int i = 9; i >= 1; i--) {
			int u = cost[i - 1];
			while (t >= u && dp[t] == dp[t - u] + 1) {
				res.append(i);
				t -= u;
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.largestNumber(new int[]{4,3,2,5,6,7,2,5,5}, 9));

		System.out.println("----- 2 -----");
		System.out.println(solution1.largestNumber(new int[]{7,6,5,5,5,6,8,7,8}, 12));

		System.out.println("----- 3 -----");
		System.out.println(solution1.largestNumber(new int[]{2,4,6,2,4,6,4,4,4}, 5));

		System.out.println("----- 4 -----");
		System.out.println(solution1.largestNumber(new int[]{6,10,15,40,40,40,40,40,40}, 47));

	}

}
