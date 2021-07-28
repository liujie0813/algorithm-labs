package com.timberliu.algorithm.leetcode.stack_queue.no0496_1_nextGreaterElementI.related.no0438_2_findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * Created by liujie on 2021/3/31
 */

public class Solution1 {

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
        int valid = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            // 统计窗口各个字符
            window[c - 'a']++;
            // 如果当前字符是所需字符，且达到所需次数，则更改 valid
            if (need[c - 'a'] > 0 && window[c - 'a'] == need[c - 'a']) {
                valid += window[c - 'a'];
            }
            if (r - l + 1 == p.length()) {
                // 窗口大小和 valid 刚好等于 p.length
                if (valid == p.length()) {
                    res.add(l);
                }
                char c1 = s.charAt(l);
                // 窗口右移
                if (need[c1 - 'a'] > 0 && window[c1 - 'a'] == need[c1 - 'a']) {
                    valid -= window[c1 - 'a'];
                }
                window[c1 - 'a']--;
                l++;
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
