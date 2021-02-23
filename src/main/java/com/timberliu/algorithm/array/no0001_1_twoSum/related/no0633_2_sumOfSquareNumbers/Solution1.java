package com.timberliu.algorithm.array.no0001_1_twoSum.related.no0633_2_sumOfSquareNumbers;

/**
 * 平方数之和
 *
 *   使用 sqrt 函数
 *     时间复杂度：O(√c）
 *     空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/23
 */

public class Solution1 {

    public static boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);

        while (left <= right) {
            double tmp = left * left + right * right;
            System.out.println(left + "-" + right);
            if (tmp == c) {
                return true;
            }

            if (tmp < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sum-of-square-numbers/ ------");
        System.out.println("----- 1 -----");
        boolean a = judgeSquareSum(5);
        System.out.println(a);

        System.out.println("----- 2 -----");
        boolean b = judgeSquareSum(3);
        System.out.println(b);

        System.out.println("----- 3 -----");
        boolean c = judgeSquareSum(4);
        System.out.println(c);

    }
}
