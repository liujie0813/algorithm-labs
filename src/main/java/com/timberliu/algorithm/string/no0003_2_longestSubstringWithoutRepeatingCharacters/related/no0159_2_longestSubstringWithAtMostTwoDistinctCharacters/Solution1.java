package com.timberliu.algorithm.string.no0003_2_longestSubstringWithoutRepeatingCharacters.related.no0159_2_longestSubstringWithAtMostTwoDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 159. 至多包含两个不同字符的最长子串
 *
 *    时间复杂度：O(n)
 *    空间复杂度：O(n)
 *
 *  原理？
 *    1. map 统计字符最后出现的位置
 *    2. 遍历字符串
 *       1. 如果 map 包含该字符，则更新 val；
 *       2. 如果 map 不包含该字符：
 *          1. 且 map kv 数小于 2，则添加
 *          2. map kv 数等于 2，则计算两个 kv 的 val 的较小者
 *             更新 start 为 min + 1
 *             从 map 中移除该位置对应的字符
 *
 *
 * Created by liujie on 2021/3/1
 */

public class Solution1 {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>(2);
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch) && map.size() == 2) {
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
        System.out.println("----- https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/ -----");
        System.out.println("----- 1 -----");
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));

        System.out.println("----- 2 -----");
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));

        System.out.println("----- 3 -----");
        System.out.println(lengthOfLongestSubstringTwoDistinct("ecba"));

        System.out.println("----- 3 -----");
        System.out.println(lengthOfLongestSubstringTwoDistinct("eeecba"));
    }
}
