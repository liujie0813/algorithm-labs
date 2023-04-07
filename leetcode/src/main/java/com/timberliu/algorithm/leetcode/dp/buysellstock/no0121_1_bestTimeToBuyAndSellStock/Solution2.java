package com.timberliu.algorithm.leetcode.dp.buysellstock.no0121_1_bestTimeToBuyAndSellStock;

/**
 * 121. 买卖股票的最佳时机
 *
 *  买卖一次
 *
 *  定义：
 *    dp[i][0]: 表示第 i 天持有股票，所得最多现金
 *    dp[i][1]: 表示第 i 天不持有股票，所得最多现金
 *
 *  推导：
 *    如果第 i 天持有股票：
 *      - 第 i-1 天已经持有股票，保持现状，结果就是昨天持有股票所得的最多现金 dp[i] = dp[i - 1][0]
 *      - 第 i 天买入股票，结果就是今天买入股票后，所得的最多现金 dp[i] = -prices[i]
 *    	dp[i][0] = max(dp[i - 1][0], -prices[i])
 *
 *    如果第 i-1 天不持有股票：
 *      - 第 i-1 天已经不持有股票，保持现状，结果就是昨天不持有股票所得的最多现金 dp[i] = dp[i - 1][1]
 *      - 第 i 天买入股票，结果就是今天卖出股票后，所得的最多现金 dp[i] = prices[i] + dp[i - 1][0]
 *      dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0])
 *
 *  初始化
 *    dp[0][0] = -prices[0]
 *    dp[0][1] = 0
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution2 {

	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];
		dp[0][0] = -prices[0];
		dp[1][0] = 0;
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
		}
		return dp[prices.length - 1][1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxProfit(new int[]{7,1,5,3,6,4}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxProfit(new int[]{7,6,4,3,1}));
	}

}
