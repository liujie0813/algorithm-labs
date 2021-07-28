package com.timberliu.algorithm.leetcode.binary_search.no0069_1_sqrtx.related.no0050_2_powxN;

/**
 * 50. Pow(x, n)
 *
 *   递归解法
 *     1. 如果 n 为 0，直接返回 1
 *     2. 递归得到 n / 2 的结果 tmp
 *     3. 如果 n 为 偶数，tmp^2 即可；否则 tmp^2 再乘以 x
 *
 * Created by liujie on 2021/3/23
 */

public class Solution1 {

    public static double myPow(double x, int n) {
        return n < 0 ? 1 / quickMul(x, -n) : quickMul(x, n);
    }

    private static double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double tmp = quickMul(x, n / 2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/powx-n/ -----");
        System.out.println("----- 1 -----");
        System.out.println(myPow(2.00000, 10));

        System.out.println("----- 2 -----");
        System.out.println(myPow(2.10000, 3));

        System.out.println("----- 3 -----");
        System.out.println(myPow(2.00000, -3));

        System.out.println("----- 4 -----");
        System.out.println(myPow(8.84372, -5));
    }
}
