package com.timberliu.algorithm.leetcode.string.no0151_2_reverseWordsInAString;

/**
 * 151. 翻转字符串里的单词
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(n)
 *
 *   原理？
 *     1. [left, right) 表示实际字符串
 *     2. 从后往前遍历字符串，先去除尾部空字符
 *     3. 再从后往前继续遍历字符串，遇到空字符串，将 [left + 1, right - left - 1) 添加到 res
 *
 * Created by liujie on 2021/3/2
 */

public class Solution1 {

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] chars = s.toCharArray();
        int end = s.length() - 1;
        // 删除后置空格
        while (end >= 0 && Character.isSpaceChar(chars[end])) {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        int right = end + 1;
        int left = end;
        // 从后往前遍历，遇到空格，将单词添加到 res
        while (left >= 0) {
            if (Character.isSpaceChar(chars[left])) {
                // 连续空格时，不能添加
                if (left != right - 1) {
                    sb.append(chars, left + 1, right - left - 1).append(" ");
                }
                right = left;
            }
            left--;
        }
        // 无前置空格
        if (left != right - 1) {
            return sb.append(chars, left + 1, right - left - 1).toString();
        }
        // 有前置空格（去掉最后一个空格）
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
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
