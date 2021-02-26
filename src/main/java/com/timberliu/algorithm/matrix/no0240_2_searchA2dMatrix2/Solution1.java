package com.timberliu.algorithm.matrix.no0240_2_searchA2dMatrix2;

/**
 * 搜索二维矩阵
 *
 *   1. 每行的元素从左到右升序排列
 *   2. 每列的元素从上到下升序排列
 *
 *   时间复杂度：O(m+n)
 *   空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0, j = column - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/search-a-2d-matrix/ -----");
        System.out.println("----- 1 -----");
        int[][] matrix1 = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        boolean b1 = searchMatrix(matrix1, 5);
        System.out.println(b1);

        System.out.println("----- 2 -----");
        int[][] matrix2 = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        boolean b2 = searchMatrix(matrix2, 20);
        System.out.println(b2);

        System.out.println("----- 3 -----");
        int[][] matrix3 = {{1, 1}};
        boolean b3 = searchMatrix(matrix3, 2);
        System.out.println(b3);
    }

}
