package com.timberliu.algorithm.leetcode.stack_queue.no0496_1_nextGreaterElementI.related.no0438_2_findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * Created by liujie on 2021/3/31
 */

public class Solution2 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            int curR = s.charAt(r) - 'a';
            window[curR]++;
            // 维持窗口内各个字符的数量等于 need 中字符数量
            while (window[curR] > need[curR]) {
                int curL = s.charAt(l) - 'a';
                l++;
                window[curL]--;
            }
            if (r - l + 1 == p.length()) {
                res.add(l);
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findAnagrams("cbaebabacd", "abc"));

        System.out.println("----- 2 -----");
        System.out.println(findAnagrams("abab", "ab"));

        System.out.println("----- 3 -----");
        System.out.println(findAnagrams("op", "by"));

        System.out.println("----- 4 -----");
        System.out.println(findAnagrams("baa", "aa"));
    }
}
