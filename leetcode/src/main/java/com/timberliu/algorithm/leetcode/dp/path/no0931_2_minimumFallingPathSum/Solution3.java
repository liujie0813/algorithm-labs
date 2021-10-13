package com.timberliu.algorithm.leetcode.dp.path.no0931_2_minimumFallingPathSum;

/**
 * 931. 下降路径最小和
 *
 *   从下往上，需要 O(n) 空间
 *      每一行保存 上一个和下一个 即可
 *
 * Created by liujie on 2021/7/29
 */

public class Solution3 {

    public static int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        for (int i = 0; i < col; i++) {
            dp[i] = matrix[0][i];
        }
        // dp <2, 1, 3>
        for (int i = 1; i < row; ++i) {
            int last = dp[0];
            for (int j = 0; j < col; j++) {
                int temp = dp[j];
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

        System.out.println("----- 4 -----");
        System.out.println(minFallingPathSum(new int[][]{
                {-84, -36, 2},
                {87, -79, 10},
                {42, 10, 63}
        }));

        System.out.println("----- 5 -----");
        System.out.println(minFallingPathSum(new int[][]{
                {-19, 57},
                {-40, -5}
        }));

    }
}
