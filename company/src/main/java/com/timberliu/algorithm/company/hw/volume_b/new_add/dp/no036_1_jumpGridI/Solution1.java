package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no036_1_jumpGridI;

import java.util.Scanner;

/**
 * 跳格子I
 *
 *  dp[i]：考虑前 i 个格子的最高分数
 *
 *  dp[i] = max(dp[i-1], dp[i-2] + arr[i])
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static int jumpGrid(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[n - 1];
    }

    /*
     * 1 2 3 1
     */
    /**
     * 2 7 9 3 1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int res = jumpGrid(arr);
        System.out.println(res);
    }

}
