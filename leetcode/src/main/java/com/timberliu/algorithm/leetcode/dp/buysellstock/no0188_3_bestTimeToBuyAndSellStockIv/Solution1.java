package com.timberliu.algorithm.leetcode.dp.buysellstock.no0188_3_bestTimeToBuyAndSellStockIv;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

/**
 * 188. 买卖股票的最佳时机
 *
 *  最多 k 笔交易
 *
 */

public class Solution1 {

    public int maxProfit(int k, int[] prices) {
    	int n = prices.length;
		int[][] dp = new int[n][2 * k + 1];
		dp[0][1] = -prices[0];
		for (int i = 2; i <= k; i++) {
			dp[0][2 * i - 1] = Integer.MIN_VALUE;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][2 * j - 1] = Math.max(dp[i - 1][2 * j - 2] - prices[i], dp[i - 1][2 * j - 1]);
				dp[i][2 * j] = Math.max(dp[i - 1][2 * j - 1] + prices[i], dp[i - 1][2 * j]);
			}
		}
		int res = 0;
		for (int i = 1; i <= k; i++) {
			res = Math.max(dp[n - 1][2 * i], res);
		}
		return res;
    }

    public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxProfit(2, new int[]{2,4,1}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxProfit(3, new int[]{3,2,6,5,0,3}));

	}

}