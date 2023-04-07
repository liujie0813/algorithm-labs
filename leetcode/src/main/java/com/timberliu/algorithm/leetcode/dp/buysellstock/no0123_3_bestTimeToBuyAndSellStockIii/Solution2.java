package com.timberliu.algorithm.leetcode.dp.buysellstock.no0123_3_bestTimeToBuyAndSellStockIii;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

/**
 * 123. 买卖股票的最佳时机
 *
 *  至多买卖两次
 *
 *  dp[i][j][k]：表示前 i 天，买入了 j 次，状态为 j 时所剩的最大现金
 *
 *  k = 0：持有股票
 *  k = 1：不持有股票
 *
 *  推导：
 *   dp[i][0][0]：买入 0 次，持股
 *   dp[i][0][1]：买入 0 次，不持股
 *   dp[i][1][0]：买入 1 次，持股；
 *      - 当天买入（第一次买入）：-prices[i]
 *      - 之前已经买入，沿用：dp[i-1][1][0]
 *   dp[i][1][0]：买入 1 次，不持股；
 *      - 当天卖出：dp[i-1][1][0] + prices[i]
 *      - 之前已经卖出，沿用：dp[i-1][1][1]
 *   dp[i][2][0]：买入 2 次，持股
 *      - 当天买入：dp[i-1][1][1] - prices[i]
 *      - 之前已经买入，沿用：dp[i-1][2][0]
 *   dp[i][2][1]：买入 2 次，不持股
 *      - 当天卖出：dp[i-1][2][0] + prices[i]
 *      - 之前已经卖出，沿用：dp[i-1][2][1]
 *
 *  初始化：
 *   dp[i][1][1] = -prices[i]
 *
 */

public class Solution2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        // 买入一次，持股
        dp[0][1][0] = -prices[0];
        dp[0][2][0] = Integer.MIN_VALUE;

        PrintUtils.printIntArray(dp[0]);
        for (int i = 1; i < n; i++) {
            // 买入一次，持股
            dp[i][1][0] = Math.max(dp[i - 1][1][0], -prices[i]);
            // 买入一次，不持股（已卖出）
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] + prices[i]);
            // 买入两次，持股
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] - prices[i]);
            // 买入两次，不持股（已卖出）
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][2][0] + prices[i]);
            PrintUtils.printIntArray(dp[i]);
        }
        return Math.max(dp[n - 1][1][1], dp[n - 1][2][1]);
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        System.out.println("----- 1 -----");
        System.out.println(solution1.maxProfit(new int[]{3,3,5,0,0,3,1,4}));

        System.out.println("----- 2 -----");
        System.out.println(solution1.maxProfit(new int[]{1,2,3,4,5}));

        System.out.println("----- 3 -----");
        System.out.println(solution1.maxProfit(new int[]{7,6,4,3,1}));

    }

}