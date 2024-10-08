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

    /**
     * 循环条件为 left<right
     * 区分划分为 left=mid 和 right=mid-1
     * 为了避免只有两个元素时死循环，mid=(left+right+1)/2
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if ((long) mid * mid <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static double mySqrt2(int x) {
        double left = 0.0, right = x;
        double res = 0;
        while (left <= right) {
            double mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                res = mid;
                left = mid + 0.01;
            } else {
                right = mid - 0.01;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sqrtx/ -----");
        System.out.println("----- 1 -----");
        System.out.println(mySqrt1(4));

        System.out.println("----- 2 -----");
        System.out.println(mySqrt1(8));

        System.out.println("----- 3 -----");
        System.out.println(mySqrt2(2147395599));
    }
}
