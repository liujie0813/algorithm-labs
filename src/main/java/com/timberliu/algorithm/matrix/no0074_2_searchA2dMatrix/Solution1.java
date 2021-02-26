package com.timberliu.algorithm.matrix.no0074_2_searchA2dMatrix;

/**
 * 搜索二维矩阵
 *
 *
 *
 *   时间复杂度：O(logmn)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     将二维数组看作一维数组，使用二分查找
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            int rowMid = middle / matrix[0].length;
            int colMid = middle % matrix[0].length;
            if (matrix[rowMid][colMid] == target) {
                return true;
            } else if (matrix[rowMid][colMid] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/search-a-2d-matrix/ -----");
        System.out.println("----- 1 -----");
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b1 = searchMatrix(matrix1, 3);
        System.out.println(b1);

        System.out.println("----- 2 -----");
        int[][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b2 = searchMatrix(matrix2, 13);
        System.out.println(b2);

        System.out.println("----- 3 -----");
        int[][] matrix3 = {{1, 1}};
        boolean b3 = searchMatrix(matrix3, 2);
        System.out.println(b3);
    }

}
