package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no057_2_melonProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MELON 的难题
 *
 *  dp[i][j]：考虑前 i 块石头，重量限制为 j 的情况下，最少数量
 *
 *  dp[i][j] = min(dp[i-1][j], dp[i-1][j - arr[i]] + 1)
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static int melonProblem(int n, int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0) {
            return -1;
        }
        int INF = n * 2;

        int target = sum / 2;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int v = arr[i];
            for (int j = target; j >= v; j--) {
                dp[j] = Math.min(dp[j], dp[j - v] + 1);
            }
        }
        return dp[target] == INF ? -1 : dp[target];
    }

    /*
     * 4
     * 1 1 2 2
     */
    /**
     * 10
     * 1 1 1 1 1 9 8 3 7 10
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int res = melonProblem(n, arr);
        System.out.println(res);
    }

}
