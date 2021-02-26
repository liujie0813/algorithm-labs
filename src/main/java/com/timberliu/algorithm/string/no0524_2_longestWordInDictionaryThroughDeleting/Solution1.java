package com.timberliu.algorithm.string.no0524_2_longestWordInDictionaryThroughDeleting;

import java.util.Arrays;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 *   时间复杂度：O(m*n)
 *   空间复杂度：O(1)
 *
 *   原理？
 *     1. 遍历字典，如果某个字符串是给定的子串，则：
 *         1. 如果长度大于最大子串，或者长度相等/但字典序排序小于它的字符串，进行更新
 *     2. 判断子串
 *         1. i 指向给定字符串，j 指向字典中的字符串
 *         2. 如果两个字符，则同时增加 i 和 j，否则只增加 i
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static String findLongestWord(String s, List<String> dictionary) {
        String maxStr = "";
        for (String s1 : dictionary) {
            if (isSubSequence(s, s1)) {
                if (s1.length() > maxStr.length() || (s1.length() == maxStr.length() && s1.compareTo(maxStr) < 0)) {
                    maxStr = s1;
                }
            }
        }
        return maxStr;
    }

    private static boolean isSubSequence(String sequence, String sub) {
        int j = 0;
        for (int i = 0; i < sequence.length() && j < sub.length(); i++) {
            if (sequence.charAt(i) == sub.charAt(j)) {
                j++;
            }
        }
        return j == sub.length();
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
