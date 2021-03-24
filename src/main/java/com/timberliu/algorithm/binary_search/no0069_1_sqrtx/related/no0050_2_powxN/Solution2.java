package com.timberliu.algorithm.binary_search.no0069_1_sqrtx.related.no0050_2_powxN;

/**
 * 50. Pow(x, n)
 *
 *   迭代解法
 *
 *     x^64  x^32  x^16  x^8  x^4  x^2  x    == x^77
 *     1     0     0     1    1    0    1    = 77
 *
 *     只需要把二进制的位为 1 的乘起来
 *
 * Created by liujie on 2021/3/23
 */
public class Solution2 {

    public static double myPow(double x, int n) {
        return n < 0 ? 1 / quickMul(x, -n) : quickMul(x, n);
    }

    private static double quickMul(double x, int n) {
        double res = 1;
        double tmp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                // 位为 1 时，乘到结果里
                res *= tmp;
            }
            // 每次迭代
            tmp *= tmp;
            // 计算二进制最后一位，每次除以 2
            n /= 2;
        }
        return res;
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
