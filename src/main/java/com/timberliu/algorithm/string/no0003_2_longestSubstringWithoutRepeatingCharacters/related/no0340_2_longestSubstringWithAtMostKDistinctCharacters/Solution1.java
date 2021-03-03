package com.timberliu.algorithm.string.no0003_2_longestSubstringWithoutRepeatingCharacters.related.no0340_2_longestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. 至多包含 K 个不同字符的最长子串
 *
 * Created by liujie on 2021/3/1
 */

public class Solution1 {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.isEmpty()) {
            return 0;
        }
        if (k < 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>(2);
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch) && map.size() == k) {
                int minRight = Integer.MAX_VALUE;
                for (Integer val : map.values()) {
                    if (val < minRight) {
                        minRight = val;
                    }
                }
                start = minRight + 1;
                map.remove(s.charAt(minRight));
            }
            map.put(ch, i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/ -----");
        System.out.println("----- 1 -----");
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));

        System.out.println("----- 2 -----");
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));

    }
}
