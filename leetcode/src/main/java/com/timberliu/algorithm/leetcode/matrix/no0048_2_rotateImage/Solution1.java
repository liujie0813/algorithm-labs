package com.timberliu.algorithm.leetcode.matrix.no0048_2_rotateImage;

import java.util.Arrays;

/**
 * 48. 旋转图像
 *
 *   1. 使用辅助数组
 *   2. 翻转
 *   3. 原地旋转
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution1 {

    public void rotate(int[][] matrix) {
        // 3 层 1；4 层 2；5 层 2
        for (int i = 0; i < matrix.length / 2; i++) {
            //
            for (int j = i; j < matrix.length - i - 1; j++) {
                rotateOne(matrix, i, j);
            }
        }
    }

    /*
     *   1 2 3
     *   4 5 6
     *   7 8 9
     *  一次旋转
     *     7 2 1
     *     4 5 6
     *     9 8 3
     */
    private void rotateOne(int[][] matrix, int row, int col) {
        int n = matrix.length - 1;
        int temp = matrix[row][col];
        matrix[row][col] = matrix[n - col][row];
        matrix[n - col][row] = matrix[n - row][n - col];
        matrix[n - row][n - col] = matrix[col][n - row];
        matrix[col][n - row] = temp;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/rotate-image/ -----");
        Solution1 solution1 = new Solution1();
        System.out.println("----- 1 -----");
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution1.rotate(matrix1);
        System.out.println(matrix1);

        System.out.println("----- 1 -----");
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution1.rotate(matrix2);
        System.out.println(matrix2);
        System.out.println();
    }
}
