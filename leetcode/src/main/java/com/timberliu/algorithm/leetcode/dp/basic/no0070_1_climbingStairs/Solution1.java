package com.timberliu.algorithm.leetcode.dp.basic.no0070_1_climbingStairs;

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
        int res = 3;
        for (int i = 3; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/climbing-stairs/ -----");
        System.out.println(climbStairs(2));

        System.out.println(climbStairs(3));
    }
}
