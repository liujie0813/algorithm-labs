package com.timberliu.algorithm.leetcode.string.no0524_2_longestWordInDictionaryThroughDeleting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 *   时间复杂度：O(m*n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     1. 排序
 *       长度不同，按长度倒序
 *       长度相同，按字典序升序
 *     2. 遍历字典
 *        使用双指针检查删除某些字符后是否到 str 的末尾
 *        如果找到了，直接返回
 *
 * Created by liujie on 2021/2/26
 */

public class Solution2 {

    public static String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((str1, str2) -> {
            if (str1.length() != str2.length()) {
                return str2.length() - str1.length();
            } else {
                return str1.compareTo(str2);
            }
        });
        for (String str : dictionary) {
            int j = 0;
            for (int i = 0; i < s.length() && j < str.length(); i++) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
            }
            if (j == str.length()) {
                return str;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/ -----");
        System.out.println("----- 1 -----");
        List<String> dictionary1 = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord("abpcplea", dictionary1));

        System.out.println("----- 2 -----");
        List<String> dictionary2 = Arrays.asList("a", "b", "c");
        System.out.println(findLongestWord("abpcplea", dictionary2));

    }
}
