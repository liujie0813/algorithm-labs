package com.timberliu.algorithm.leetcode.binary_search.no0069_1_sqrtx;

/**
 * 69. x 的平方根
 *
 * Created by liujie on 2021/3/23
 */

public class Solution1 {

    public static int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sqrtx/ -----");
        System.out.println("----- 1 -----");
        System.out.println(mySqrt(4));

        System.out.println("----- 2 -----");
        System.out.println(mySqrt(8));

        System.out.println("----- 3 -----");
        System.out.println(mySqrt(2147395599));
    }
}
