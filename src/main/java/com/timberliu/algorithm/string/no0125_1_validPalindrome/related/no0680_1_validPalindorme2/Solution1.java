package com.timberliu.algorithm.string.no0125_1_validPalindrome.related.no0680_1_validPalindorme2;

/**
 * 验证回文字符串
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     1. 双指针遍历
 *     2. 如果遇到不相等的字符，则分两种情况：删除 left 或 right 分别判断
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return doValidPalindrome(s, left, right - 1) || doValidPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    private static boolean doValidPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/valid-palindrome-ii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(validPalindrome("aba"));

        System.out.println("----- 1 -----");
        System.out.println(validPalindrome("abca"));
    }
}
