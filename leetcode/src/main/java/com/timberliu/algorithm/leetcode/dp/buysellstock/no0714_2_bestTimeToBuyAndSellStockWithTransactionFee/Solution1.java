package com.timberliu.algorithm.leetcode.dp.buysellstock.no0714_2_bestTimeToBuyAndSellStockWithTransactionFee;

/**
 * 714. 买卖股票的最佳时机-手续费
 *
 *  定义：
 *    dp[i][0]: 表示第 i 天持有股票，所得最多现金
 *    dp[i][1]: 表示第 i 天不持有股票，所得最多现金
 *
 *  推导：
 *   第 i 天持有股票
 *    - 前一天已经持有 dp[i - 1][0]
 *    - 前一天未持有，今天买入 dp[i - 1][1] - prices[i] - fee
 *
 *   第 i 天不持有股票
 *    - 前一天不持有 dp[i - 1][1]
 *    - 前一天持有，今天卖出 dp[i - 1][0] + prices[i]
 *
 *  初始化：
 *   dp[0][0] = -prices[i] - fee
 *
 */

public class Solution1 {

    public int maxProfit(int[] prices, int fee) {
		int[][] dp = new int[prices.length][2];
		dp[0][0] = -prices[0] - fee;
		dp[0][1] = 0;
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
		}
		return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxProfit(new int[]{1,3,7,5,10,3}, 3));

	}

}