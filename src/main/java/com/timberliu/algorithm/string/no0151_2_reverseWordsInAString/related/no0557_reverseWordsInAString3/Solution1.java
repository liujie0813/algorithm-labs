package com.timberliu.algorithm.string.no0151_2_reverseWordsInAString.related.no0557_reverseWordsInAString3;

/**
 * 557. 反转字符串中的单词 III
 *
 * Created by liujie on 2021/3/3
 */

public class Solution1 {

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' ') {
                swap(chars, left, i - 1);
                left = i + 1;
            }
        }
        swap(chars, left, s.length() - 1);
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int left, int right) {
        while (left <= right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(reverseWords("Let's take LeetCode contest"));

    }
}
