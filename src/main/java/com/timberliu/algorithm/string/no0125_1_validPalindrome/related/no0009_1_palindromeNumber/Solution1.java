package com.timberliu.algorithm.string.no0125_1_validPalindrome.related.no0009_1_palindromeNumber;

/**
 * 回文数
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     12321
 *     1. 对数字反转一半
 *     2. 循环结束条件：x <= num
 *        x = num
 *        x = num/10
 *     3. 先 x % 10，得到最后一位数字，x/=10 为下次做准备
 *     4. 反转后的数字 num * 10 + x % 10
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return x == num || x == num / 10;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/palindrome-number/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isPalindrome(121));

        System.out.println("----- 2 -----");
        System.out.println(isPalindrome(-121));

        System.out.println("----- 3 -----");
        System.out.println(isPalindrome(10));
    }
}
