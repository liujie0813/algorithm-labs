package com.timberliu.algorithm.leetcode.binary_search.no0069_1_sqrtx;

/**
 * x 的立方根
 *
 * Created by liujie on 2021/3/23
 */

public class Solution2 {

    // 立方根，二分法无限逼近
    public static double myCubit(double x) {
        double left = 0, right = x, res = -1;
        while (right - left > 0.00001) {
            double mid = (left + right) / 2;
            if (mid * mid * mid < x) {
                left = mid;
            } else if (mid * mid * mid > x) {
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/sqrtx/ -----");
        System.out.println("----- 1 -----");
        System.out.println(myCubit(4));

        System.out.println("----- 2 -----");
        System.out.println(myCubit(8));

        System.out.println("----- 3 -----");
        System.out.println(myCubit(2147395599));
    }
}
