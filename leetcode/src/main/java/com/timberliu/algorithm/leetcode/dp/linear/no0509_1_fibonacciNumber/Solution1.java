package com.timberliu.algorithm.leetcode.dp.linear.no0509_1_fibonacciNumber;

/**
 *
 * 509. 斐波那契数
 *
 *  0 1 1 2 3 5 8
 *
 *  动态规则思路：
 *    1. 边界条件：f(0) = 1、f(1) = 1
 *    2. 递推关系（状态转移方程）：f(n) = f(n-1) + f(n-2)
 *    由于 f(n) 只与 f(n-1) 和 f(n-2) 有关，可以使用【滚动数组思想】把空间复杂度优化成 O(1)
 *
 * Created by liujie on 2021/7/28
 */

public class Solution1 {

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] tab = new int[n + 1];
        return fib1(tab, n);
    }

    private static int fib1(int[] tab, int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (tab[n] != 0) {
            return tab[n];
        }
        tab[n] = fib1(n - 1) + fib1(n - 2);
        return tab[n];
    }

    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] tab = new int[n + 1];
        tab[0] = 0;
        tab[1] = 1;
        for (int i = 2; i <= n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }

    public static int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int first = 0, second = 1, res = 1;
        for (int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/fibonacci-number/ -----");
        System.out.println(fib2(5));

    }
}
