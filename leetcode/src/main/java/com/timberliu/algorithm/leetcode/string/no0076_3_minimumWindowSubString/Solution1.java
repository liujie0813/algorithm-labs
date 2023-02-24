package com.timberliu.algorithm.leetcode.string.no0076_3_minimumWindowSubString;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * Created by liujie on 2021/3/31
 */

public class Solution1 {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 统计 t 中各个字符的个数
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 窗口的左右指针
        int l = 0, r = 0;
        int valid = 0;
        int minLen = Integer.MAX_VALUE, start = 0;
        // 遍历字符串 s
        while (r < s.length()) {
            char c = s.charAt(r);
            // 如果当前字符是所需要的
            if (need.containsKey(c)) {
                // 统计出现次数
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果某字符出现次数达到要求，则 valid++
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 校验 是否包含子串
            while (valid == t.length()) {
                // 如果小于 minLen，更新最小子串
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                // 尝试缩小左边界
                char c1 = s.charAt(l);
                if (need.containsKey(c1)) {
                    // 如果次数刚好相等，边界缩小后 valid--
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/minimum-window-substring/ -----");
        System.out.println("----- 1 -----");
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

        System.out.println("----- 2 -----");
        System.out.println(minWindow("a", "a"));

    }
}
