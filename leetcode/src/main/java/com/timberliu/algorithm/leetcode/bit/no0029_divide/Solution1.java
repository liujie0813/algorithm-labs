package com.timberliu.algorithm.leetcode.bit.no0029_divide;

/**
 * 29. 两数相除
 *
 * @user liujie
 * @date 2023/8/15
 */
public class Solution1 {

    public int divide(int dividend, int divisor) {
        long x = dividend, y = divisor;
        boolean negative = (x > 0 && y < 0) || (x < 0 && y > 0);
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }

        long left = 0, right = x;
        while (left < right) {
            // >> 向下取整，+1 防止死循环，eg: [0,1]
            long mid = (left + right + 1) >> 1;
            if (mul(mid, y) <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        long res = negative ? -right : right;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    private long mul(long a, long k) {
        long res = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                res += a;
            }
            k >>= 1;
            a += a;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int divide = solution1.divide(7, 3);
        System.out.println(divide);
    }

}
