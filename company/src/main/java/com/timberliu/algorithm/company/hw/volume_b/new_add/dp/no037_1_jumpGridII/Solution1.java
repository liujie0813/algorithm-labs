package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no037_1_jumpGridII;

import java.util.Arrays;
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

        int[] arr1 = new int[n - 1];
        System.arraycopy(arr, 0, arr1, 0, n - 1);
        int first = doJumpGrid(arr1);

        int[] arr2 = new int[n - 1];
        System.arraycopy(arr, 1, arr2, 0, n - 1);
        int second = doJumpGrid(arr2);
        return Math.max(first, second);
    }

    public static int doJumpGrid(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        if (n >= 1) {
            dp[0] = arr[0];
        }
        if (n >= 2) {
            dp[1] = Math.max(arr[0], arr[1]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[n - 1];
    }

    /*
     * 2 3 2
     */
    /**
     * 1 2 3 1
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
