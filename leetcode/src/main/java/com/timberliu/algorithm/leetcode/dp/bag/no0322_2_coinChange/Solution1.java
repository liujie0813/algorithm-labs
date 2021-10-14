package com.timberliu.algorithm.leetcode.dp.bag.no0322_2_coinChange;

/**
 * 322. 零钱兑换
 *
 *  状态定义：f[i][j] 考虑前 i 个硬币，凑成总和为 j 所需要的最少硬币数量
 *
 *  状态转移方程：f[i][j] = min(f[i - 1][j - k*t] + k), 0 <= k*t <= j
 *
 * Created by liujie on 2021/7/29
 */

public class Solution1 {

    static int INF = Integer.MAX_VALUE;

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = INF;
        }

        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];

                for (int k = 1; k * val <= j; k++) {
                     if (dp[i - 1][j - k * val] != INF) {
                         dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * val] + k);
                     }
                }
            }
        }
        return dp[n][amount] == INF ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/coin-change/ -----");
        System.out.println("----- 1 -----");
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));

        System.out.println("----- 2 -----");
        System.out.println(coinChange(new int[]{2}, 3));

    }
}
