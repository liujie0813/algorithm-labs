package com.timberliu.algorithm.leetcode.matrix.no0048_2_rotateImage;

/**
 * 48. 旋转图像
 *
 *   顺时针选择 90
 *
 *      1 2 3
 *      4 5 6
 *      7 8 9
 *    1. 先上下翻转
 *      7 8 9
 *      4 5 6
 *      1 2 3
 *    2. 再对角线翻转
 *      7 4 1
 *      8 5 2
 *      9 6 3
 *
 * @author liujie
 * @date 2021/8/22
 */

public class Solution2 {

    public void rotate(int[][] matrix) {
        flipUpDown(matrix);
        diagnoal(matrix);
    }

    private void flipUpDown(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
    }

    private void flipLeftRight(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
    }

    private void diagnoal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void backDiagnoal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/rotate-image/ -----");
        Solution2 solution2 = new Solution2();
        System.out.println("----- 1 -----");
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution2.rotate(matrix1);
        System.out.println();

        System.out.println("----- 2 -----");
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution2.rotate(matrix2);
        System.out.println();

        System.out.println("----- 3 -----");
        /*
         *  1 2 3        3 2 1        7 4 1
         *  4 5 6 ->     6 5 4  ->    8 5 2
         *  7 8 9        9 8 7        9 6 3
         */
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution2.flipLeftRight(matrix3);
        solution2.backDiagnoal(matrix1);
        System.out.println();

    }

}
