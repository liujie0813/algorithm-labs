package com.timberliu.algorithm.string.no0008_2_stringToIntegerAtoi;

import com.sun.imageio.plugins.common.I18N;

/**
 * 8. 字符串转换整数 (atoi)
 *
 *    时间复杂度：O(n)
 *    空间复杂读：O(1)
 *
 *    原理？
 *      1. 首先循环跳过所有前置空字符
 *      2. 判断下一个字符是否是 +/-，得出正负
 *      3. 遍历剩余字符，必须是数字，否则直接结束
 *         1. 判断结果是否可能会溢出，如果是直接返回最大最小值
 *         2. 否则叠加
 *
 * Created by liujie on 2021/3/3
 */

public class Solution1 {

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        boolean negative = false;
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            negative = s.charAt(index) == '-';
            index++;
        }
        int res = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int val = Character.getNumericValue(s.charAt(index));
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (
                    (negative && val > 8) || (val > 7)))) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + val;
            index++;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/string-to-integer-atoi/ -----");
        System.out.println("----- 1 -----");
        System.out.println(myAtoi("42"));

        System.out.println("----- 2 -----");
        System.out.println(myAtoi("   -42"));

        System.out.println("----- 3 -----");
        System.out.println(myAtoi("4193 with words"));

        System.out.println("----- 4 -----");
        System.out.println(myAtoi("words and 987"));

        System.out.println("----- 5 -----");
        System.out.println(myAtoi("-91283472332"));

        System.out.println("----- 6 -----");
        System.out.println(myAtoi("2147483648"));

        System.out.println("----- 7 -----");
        System.out.println(myAtoi(""));

        System.out.println("----- 8 -----");
        System.out.println(myAtoi("  "));

    }
}
