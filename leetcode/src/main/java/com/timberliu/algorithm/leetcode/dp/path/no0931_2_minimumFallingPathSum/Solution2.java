package com.timberliu.algorithm.leetcode.dp.path.no0931_2_minimumFallingPathSum;

/**
 * 931. 下降路径最小和
 *
 *   从下往上，需要 O(n) 空间
 *
 * Created by liujie on 2021/7/29
 */

public class Solution2 {

    public static int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        for (int i = 0; i < col; i++) {
            dp[i] = matrix[row - 1][i];
        }
        // dp <7, 8, 9>
        int temp, last;
        for (int i = row - 2; i >= 0; i--) {
            last = dp[0];
            for (int j = 0; j < col; j++) {
                temp = dp[j];
                int min = Math.min(dp[j], last);
                if (j != col - 1) {
                    min = Math.min(min, dp[j + 1]);
                }
                dp[j] = matrix[i][j] + min;
                last = temp;
            }
        }
        int res = dp[0];
        for (int i = 1; i < col; i++) {
            res = Math.min(res, dp[i]);
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
