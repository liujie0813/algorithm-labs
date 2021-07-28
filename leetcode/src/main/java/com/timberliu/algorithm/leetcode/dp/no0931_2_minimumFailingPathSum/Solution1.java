package com.timberliu.algorithm.leetcode.dp.no0931_2_minimumFailingPathSum;

/**
 * 931. 下降路径最小和
 *
 * Created by liujie on 2021/7/29
 */

public class Solution1 {

    public static int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            dp[row - 1][i] = matrix[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                int min = dp[i + 1][j];
                if (j != 0) {
                    min = Math.min(dp[i + 1][j - 1], min);
                }
                if (j != col - 1) {
                    min = Math.min(dp[i + 1][j + 1], min);
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int res = dp[0][0];
        for (int i = 1; i < col; i++) {
            res = Math.min(res, dp[0][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/minimum-falling-path-sum/ -----");
        int[][] martix = {{2, 1, 3},
                          {6, 5, 4},
                          {7, 8, 9}};
        System.out.println(minFallingPathSum(martix));

        int[][] martix1 = {{-19, 57},
                           {-40, -5}};
        System.out.println(minFallingPathSum(martix1));

        int[][] martix2 = {{-48}};
        System.out.println(minFallingPathSum(martix2));

    }
}
