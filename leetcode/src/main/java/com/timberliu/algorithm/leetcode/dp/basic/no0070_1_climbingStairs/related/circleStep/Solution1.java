package com.timberliu.algorithm.leetcode.dp.basic.no0070_1_climbingStairs.related.circleStep;

/**
 * 圆环会原点
 *
 * 0-9 共 10 个点，走 k 步回到原点的走法
 *
 *  dp[i][j] 表示走 i 步走到 j 的走法
 *
 *  dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]
 *
 * @author Timber
 * @date 2024/4/30
 */


public class Solution1 {

    // n个点，走k步
    public int circleStep(int n, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + n) % n] + dp[i - 1][(j + 1) % n];
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {

    }

}
