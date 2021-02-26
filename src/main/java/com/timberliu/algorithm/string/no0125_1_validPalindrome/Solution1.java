package com.timberliu.algorithm.string.no0125_1_validPalindrome;

/**
 * 验证回文串
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     1. 双指针向内遍历即可
 *     2. Character.isLetterOrDigit  判断是否是字母或数字
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/valid-palindrome/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println("----- 2 -----");
        System.out.println(isPalindrome("race a car"));

        System.out.println("----- 3 -----");
        System.out.println(isPalindrome("OP"));
    }

}
