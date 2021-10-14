package com.timberliu.algorithm.leetcode.dp.bag.no0322_2_coinChange;

/**
 * 322. 零钱兑换
 *
 *  状态定义：f[i][j] 考虑前 i 个硬币，凑成总和为 j 所需要的最少硬币数量
 *
 *  状态转移方程：f[i][j] = min(f[i - 1][j - k*t] + k), 0 <= k*t <= j
 *
 *  一维优化 f[j] = min(f[j], f[j - coin] + 1)
 *
 * Created by liujie on 2021/7/29
 */

public class Solution2 {

    static int INF = 0x3f3f3f3f;

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
        }

        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                 dp[j] = Math.min(dp[j], dp[j - val] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/coin-change/ -----");
        System.out.println("----- 1 -----");
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));

        System.out.println("----- 2 -----");
        System.out.println(coinChange(new int[]{2}, 3));

    }
}
