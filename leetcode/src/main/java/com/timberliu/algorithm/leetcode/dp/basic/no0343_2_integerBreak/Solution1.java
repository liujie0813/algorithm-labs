package com.timberliu.algorithm.leetcode.dp.basic.no0343_2_integerBreak;

/**
 * 343. 整数拆分
 *   将 n 拆分为 k 个正整数的和（k >= 2），并使这些整数的乘积最大化
 *   2 <= n <= 58
 *
 *   dp[i]：表示把数字 i 至少拆分为两个正整数，可以得到的最大乘积
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
            // 拆分的数最大 i/2，继续遍历就重复了
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }
        return dp[n];
    }

    /**
     * dp[i] = max( dp[i], dp[j] * dp[i-j] )
     */
    public static int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        // 特殊处理，不符合 dp至少拆分为两个正整数 的语义
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            // j <= i/2 等价于 j <= i-j
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    /**
     * dp[i] = max( dp[i], j * dp[i-j] )
     */
    public static int integerBreak3(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        // 特殊处理，不符合 dp 的语义
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 59; i < 170; i++) {
            int res1 = integerBreak(59);
            int res2 = integerBreak3(59);
            System.out.println(res1 + "\t" + res2 + "\t" + (res1 == res2));
        }
    }

}