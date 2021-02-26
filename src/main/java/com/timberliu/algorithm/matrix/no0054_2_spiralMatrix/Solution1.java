package com.timberliu.algorithm.matrix.no0054_2_spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 *   按层模拟
 *     时间复杂度：O(mn)
 *     空间复杂度：O(1)
 *
 *   原理？
 *     1. 定义：最上层 top = 0，最底层 bottom = a.length - 1, 最左边 left = 0，最右边 right = a[0].length - 1
 *     2. 依次打印四条边：
 *        1. 从 top, left 到 top, right                 top+1
 *        2. 从 top, right 到 bottom, right             right-1
 *        3. 从 bottom, right 到 bottom, left           bottom-1
 *        4. 从 bottom, left 到 top, left               left+1
 *           每次打印完一条边，需要调整范围，判断是否超出边界
 *        再次打印向内一层，，，
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int col = right; col >= left; col--) {
                res.add(matrix[bottom][col]);
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int row = bottom; row >= top; row--) {
                res.add(matrix[row][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/spiral-matrix/ -----");
        System.out.println("----- 1 -----");
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers1 = spiralOrder(matrix1);
        System.out.println(integers1);

        System.out.println("----- 2 -----");
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers2 = spiralOrder(matrix2);
        System.out.println(integers2);

        System.out.println("----- 2 -----");
        int[][] matrix3 = {{1,2,3},{4,5,6,},{7,8,9},{10,11,12}};
        List<Integer> integers3 = spiralOrder(matrix3);
        System.out.println(integers3);

        System.out.println("----- 2 -----");
        int[][] matrix4 = {{1},{2},{3}};
        List<Integer> integers4 = spiralOrder(matrix4);
        System.out.println(integers4);
    }
}
