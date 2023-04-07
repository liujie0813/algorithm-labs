package com.timberliu.algorithm.leetcode.dp.buysellstock.no0309_2_bestTimeToBuyAndSellStockWithCooldown;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

/**
 * 309. 买卖股票的最佳时机-含冷冻期
 *
 *  可以买卖多次
 *
 *  定义：
 *    dp[i][0]：持有股票
 *    dp[i][1]：不持有股票（不是今天卖出股票）
 *    dp[i][2]：不持有股票（今天卖出股票）
 *
 *  推导：
 *    第 i 天持有股票
 *      - 前一天就是持有股票状态
 *      - 前一天是不持有股票（不是今天卖出），今天买入
 *      dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i])
 *    第 i 天不持有股票（不是今天卖出）
 *      - 前一天是不持有股票（不是今天卖出）
 *      - 前一天是不持有股票（今天卖出）
 *      dp[i][1] = max(dp[i - 1][1], dp[i - 1][2])
 *    第 i 天不持有股票（今天卖出）
 *      dp[i][2] = dp[i - 1][0] + prices[i]
 *
 *  初始化：
 *    dp[0][0] = -prices[0]
 *
 */

public class Solution1 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = Integer.MIN_VALUE;
        PrintUtils.printIntArray(dp[0]);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            PrintUtils.printIntArray(dp[i]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println("----- 1 -----");
        System.out.println(solution1.maxProfit(new int[]{1,2,3,0,2}));

        System.out.println("----- 2 -----");
        System.out.println(solution1.maxProfit(new int[]{3,2,6,5,0,3}));

    }

}