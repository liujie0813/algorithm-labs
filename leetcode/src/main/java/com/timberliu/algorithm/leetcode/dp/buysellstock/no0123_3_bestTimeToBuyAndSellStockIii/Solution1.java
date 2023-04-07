package com.timberliu.algorithm.leetcode.dp.buysellstock.no0123_3_bestTimeToBuyAndSellStockIii;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

/**
 * 123. 买卖股票的最佳时机
 *
 *  至多买卖两次
 *
 *  有5种状态：
 *  - 没有持有
 *  - 第一次持有股票
 *  - 第一次不持有股票
 *  - 第二次持有股票
 *  - 第二次不持有股票
 *
 *  dp[i][j]：表示第 i 天状态 j 所剩的最大现金
 *
 *  推导：
 *   dp[i][1] 由两个操作：
 *   - 第 i 天买入股票了，则 dp[i][1] = dp[i-1][0] - prices[i]
 *   - 第 i 天没有操作，沿用前一天的状态，则 dp[i][1] = dp[i-1][1]
 *   dp[i][1] = max(dp[i-1][0]-prices[i], dp[i-1][1])
 *
 *   dp[i][2] 由两个操作：
 *   - 第 i 天卖出股票，则 dp[i][2] = dp[i-1][1] + prices[i]
 *   - 第 i 天没有操作，沿用前一天的状态，则 dp[i][2] = dp[i-1][2]
 *   dp[i][2] = max(dp[i-1][1]+prices[i], dp[i-1][2])
 *
 *   dp[i][3] = max(dp[i-1][2]-prices[i], dp[i-1][3])
 *   dp[i][4] = max(dp[i-1][3]+prices[i], dp[i-1][4])
 *
 *  初始化：
 *   dp[0][1] = -prices[0]
 *   dp[0][3] = MIN_VALUE：第1天不能进行第2次买卖
 *
 */

public class Solution1 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][3] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);

            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return Math.max(dp[n - 1][2], dp[n - 1][4]);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println("----- 1 -----");
        System.out.println(solution1.maxProfit(new int[]{3,3,5,0,0,3,1,4}));

        System.out.println("----- 2 -----");
        System.out.println(solution1.maxProfit(new int[]{1,2,3,4,5}));

        System.out.println("----- 3 -----");
        System.out.println(solution1.maxProfit(new int[]{7,6,4,3,1}));

    }

}