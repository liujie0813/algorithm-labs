package com.timberliu.algorithm.string.no0205_1_isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(n)
 *
 *   原理？
 *     1. 使用两个 map 存储 s 到 t、t 到 s 的映射
 *     2. 遍历字符串，判断当前 s 到 t、t 到 s 的映射 与之前出现过的映射是否相等
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || t2s.containsKey(y) && t2s.get(y) != x) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/isomorphic-strings/ -----");
        System.out.println("----- 1 -----");
        System.out.println(isIsomorphic("egg", "add"));

        System.out.println("----- 2 -----");
        System.out.println(isIsomorphic("foo", "bar"));

        System.out.println("----- 3 -----");
        System.out.println(isIsomorphic("paper", "title"));
    }

}
