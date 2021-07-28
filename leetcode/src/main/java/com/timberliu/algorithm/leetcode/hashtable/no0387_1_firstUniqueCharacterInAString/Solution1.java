package com.timberliu.algorithm.leetcode.hashtable.no0387_1_firstUniqueCharacterInAString;

import java.util.Arrays;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * Created by liujie on 2021/4/26
 */

public class Solution1 {

    public static int firstUniqChar(String s) {
        int[] map = new int[26];
        // 遍历字符串，统计频次
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        // 再次遍历字符串，找到第一个出现一次的字符
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/first-unique-character-in-a-string/ -----");
        System.out.println("----- 1 -----");
        System.out.println(firstUniqChar("leetcode"));

        System.out.println("----- 2 -----");
        System.out.println(firstUniqChar("loveleetcode"));

    }
}
