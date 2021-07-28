package com.timberliu.algorithm.leetcode.dp.no0509_1_fibonacciNumber.related.no0070_1_climbingStairs;

/**
 * 70. 爬楼梯
 *
 * Created by liujie on 2021/8/5
 */

public class Solution1 {

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int third = 3;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/climbing-stairs/ -----");
        System.out.println(climbStairs(2));

        System.out.println(climbStairs(3));
    }
}
