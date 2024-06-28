package com.timberliu.algorithm.leetcode.string.no0076_3_minimumWindowSubString;

/**
 * 76. 最小覆盖子串
 *
 * Created by liujie on 2021/3/31
 */

public class Solution1 {

    public static String minWindow(String s, String t) {
        // 统计 t 中各个字符的个数，即表示各个字符所需要的个数
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // 窗口的左右指针
        int l = 0, r = 0;
        // count：当前子串长度
        int minLen = Integer.MAX_VALUE, start = 0, count = 0;
        // 遍历字符串 s
        while (r < s.length()) {
            // 当前字符在 t 中存在
            if (need[s.charAt(r)] > 0) {
                count++;
            }
            // 当前字符（在 t 中所需相应字符的数量减 1）
            need[s.charAt(r)]--;
            // 窗口包含所有字符
            if (count == t.length()) {
                // 尝试缩小左边界
                // 如果窗口中该字符出现次数大于 t 中出现次数，则可以左移
                while (l <= r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }
                // 如果小于 minLen，更新子串
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                // 窗口右移
                need[s.charAt(l)]++;
                l++;
                // 窗口右移，子串长度减 1
                count--;
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
