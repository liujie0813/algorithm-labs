package com.timberliu.algorithm.leetcode.string.no0151_2_reverseWordsInAString;

/**
 * 151. 翻转字符串里的单词
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)（使用 char 数组，原地翻转）
 *
 *   原理？
 *    1. 移除前置、后置、中间多余空格
 *    2. 翻转整个字符串
 *    3. 翻转每个单词
 *
 * Created by liujie on 2021/3/2
 */

public class Solution3 {

    public static String reverseWords(String s) {
        char[] chars = removeSpace(s);
        reverseWord(chars, 0, chars.length - 1);
        reverseEachWord(chars);
        return new String(chars);
    }

    private static char[] removeSpace(String s) {
        int left = 0, right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(ch);
            }
            left++;
        }
        return sb.toString().toCharArray();
    }

    private static void reverseEachWord(char[] chars) {
        int left = 0, right = 1;
        while (left < chars.length) {
            while (right < chars.length && chars[right] != ' ') {
                right++;
            }
            reverseWord(chars, left, right - 1);
            left = right + 1;
            right = left + 1;
        }
    }

    private static void reverseWord(char[] chars, int left, int right) {
        while (left <= right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/reverse-words-in-a-string/ -----");
        System.out.println("----- 1 -----");
        System.out.println(reverseWords("the sky is blue"));

        System.out.println("----- 2 -----");
        System.out.println(reverseWords("  hello world!  "));

        System.out.println("----- 3 -----");
        System.out.println(reverseWords("a good   example"));

        System.out.println("----- 4 -----");
        System.out.println(reverseWords("  Bob    Loves  Alice   "));

        System.out.println("----- 5 -----");
        System.out.println(reverseWords("Alice does not even like bob"));

    }
}
