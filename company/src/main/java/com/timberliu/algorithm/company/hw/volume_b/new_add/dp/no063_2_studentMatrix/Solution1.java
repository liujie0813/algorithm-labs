package com.timberliu.algorithm.company.hw.volume_b.new_add.dp.no063_2_studentMatrix;

import java.util.Scanner;

/**
 * 学生方阵
 *
 * dp[i][j][0]：水平方向
 * dp[i][j][1]：垂直方向
 * dp[i][j][2]：正对角线方向
 * dp[i][j][3]：反对角线方向
 *
 * @user liujie
 * @date 2023/8/31
 */
public class Solution1 {

    public static int maxContinuousLen(String[][] arr, int m, int n) {
        int[][][] dp = new int[m + 1][n + 2][4];

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ("M".equals(arr[i - 1][j - 1])) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                    dp[i][j][3] = dp[i - 1][j + 1][3] + 1;

                    res = Math.max(res, dp[i][j][0]);
                    res = Math.max(res, dp[i][j][1]);
                    res = Math.max(res, dp[i][j][2]);
                    res = Math.max(res, dp[i][j][3]);
                }
            }
        }
        return res;
    }

    /**
     * 3,4
     * F,M,M,F
     * F,M,M,F
     * F,F,F,M
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.next().split(",");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);

        String[][] arr = new String[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.next().split(",");
        }

        int res = maxContinuousLen(arr, m, n);
        System.out.println(res);
    }

}
