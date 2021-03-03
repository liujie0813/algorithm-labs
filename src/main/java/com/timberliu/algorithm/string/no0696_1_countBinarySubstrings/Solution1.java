package com.timberliu.algorithm.string.no0696_1_countBinarySubstrings;

/**
 * 计数二进制子串
 *
 *   1. 计算连续的 0 或 1 的数量
 *   2. 两个 count 的较小者 就是 连续的 0 和 1 子串，这两个子串所能组成的（所求子串）的数量
 *
 * Created by liujie on 2021/3/1
 */

public class Solution1 {

    public static int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int i = 0;
        int lastCount = 0;
        int res = 0;
        while (i < s.length()){
            int count = 0;
            char ch = s.charAt(i);
            while (i < s.length() && ch == s.charAt(i)) {
                count++;
                i++;
            }
            res += Math.min(lastCount, count);
            lastCount = count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/count-binary-substrings/ -----");
        System.out.println("----- 1 -----");
        System.out.println(countBinarySubstrings("00110011"));

        System.out.println("----- 2 -----");
        System.out.println(countBinarySubstrings("001001"));

        System.out.println("----- 3 -----");
        System.out.println(countBinarySubstrings("10101"));

        System.out.println("----- 4 -----");
        System.out.println(countBinarySubstrings("01"));

        System.out.println("----- 5 -----");
        System.out.println(countBinarySubstrings("0"));

        System.out.println("----- 6 -----");
        System.out.println(countBinarySubstrings("1010001"));

    }
}
