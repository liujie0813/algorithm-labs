package com.timberliu.algorithm.leetcode.dp.basic.no0343_2_integerBreak;

/**
 * 343. 整数拆分
 *   将 n 拆分为 k 个正整数的和（k >= 2），并使这些整数的乘积最大化
 *   2 <= n <= 58
 *
 *   dp[i]：表示拆分数字 i，可以得到的最大乘积
 *
 *   从 1 遍历到 j，有两个渠道得到 dp[i]
 *   - 拆成两个数：j * (i - j)
 *   - 拆分两个以上：j * dp[i - j]
 *
 *   dp[i] = max(dp[i], j*(i-j), j*dp[i-j])
 *            j有多个取值，dp[i] 取对应的最大值
 *
 *   dp[0] 和 dp[1] 没有意义，从 dp[2] 开始初始化就好
 *   dp[2] = 1
 *
 *   dp[i] 依赖于 dp[i-j]，从前往后遍历
 *
 *   拆分成 k 个数，k>=2，那么拆分的数最大等于 i/2
 */

public class Solution1 {

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            // 拆分的数最大不超过 i/2
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res1 = integerBreak(10);
        System.out.println(res1);


    }

}