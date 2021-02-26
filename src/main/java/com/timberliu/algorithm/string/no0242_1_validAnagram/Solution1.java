package com.timberliu.algorithm.string.no0242_1_validAnagram;

import java.util.HashMap;
import java.util.Map;

/**
 * 字母异位词
 *   等价于"两个字符串排序后相等"
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(n)
 *
 *   原理？
 *     使用 HashMap 存储字符出现的次数
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> numMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            numMap.put(c, numMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            numMap.put(c, numMap.getOrDefault(c, 0) - 1);
            if (numMap.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/valid-anagram/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isAnagram("anagram", "nagaram"));

        System.out.println("----- 2 -----");
        System.out.println(isAnagram("rat", "car"));

        System.out.println("----- 3 -----");
        System.out.println(isAnagram("", ""));

    }
}
