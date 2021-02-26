package com.timberliu.algorithm.matrix.no0073_2_setMatrixZeroes;

import java.util.Arrays;

/**
 * 矩阵置零
 *
 *  时间复杂度：O(n)
 *  空间复杂度：O(1)
 *
 *  原理？
 *    1. 首先遍历原始矩阵，用首行、首列，标记该行或者该列是否有零
 *       用一个 boolean 变量标记首列是否有零
 *
 *    2. 第二次遍历，判断包含零的行或列，全置为零
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length, col = matrix[0].length;
        boolean firstColHasZero = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
            }
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColHasZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/set-matrix-zeroes/ -----");
        System.out.println("----- 1 -----");
        int[][] martix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(martix1);
        for (int[] ints : martix1) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("----- 2 -----");
        int[][] martix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(martix2);
        for (int[] ints : martix2) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("----- 3 -----");
        int[][] martix3 = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        setZeroes(martix3);
        for (int[] ints : martix3) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
