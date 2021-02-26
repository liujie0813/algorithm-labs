package com.timberliu.algorithm.matrix.no0766_1_toeplitzMatrix;

/**
 * 托普利茨矩阵
 *
 *  双层循环遍历：
 *    时间复杂度：O(n)
 *    空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/toeplitz-matrix/ -----");
        System.out.println("----- 1 -----");
        int[][] matrix1 = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean toeplitzMatrix1 = isToeplitzMatrix(matrix1);
        System.out.println(toeplitzMatrix1);

        System.out.println("----- 2 -----");
        int[][] matrix2 = {{1, 2},{2, 2}};
        boolean toeplitzMatrix2 = isToeplitzMatrix(matrix2);
        System.out.println(toeplitzMatrix2);
    }
}
