package com.timberliu.algorithm.leetcode.dp.no0322_2_coinChange;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * Created by liujie on 2021/7/29
 */

public class Solution1 {

    public static int coinChange(int[] coins, int amount) {
        if (amount < -1) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = coinChange(coins, amount - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, 1 + subRes);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        // 外层循环在遍历所有状态的所有取值
        for (int i = 1; i < amount + 1; i++) {
            // 内层循环在求所有选择的最小值
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/coin-change/ -----");
        System.out.println(coinChange1(new int[]{1, 2, 5}, 11));

        System.out.println(coinChange1(new int[]{2}, 3));

    }
}
