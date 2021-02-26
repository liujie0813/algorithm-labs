package com.timberliu.algorithm.string.no0125_1_validPalindrome.related.no0409_1_longestPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int res = 0;
        boolean hasOdd = false;
        for (Integer count : countMap.values()) {
            res += count;
            if (count % 2 == 1) {
                res -= 1;
                hasOdd = true;
            }
        }
        return res + (hasOdd ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/longest-palindrome/ -----");
        System.out.println("----- 1 -----");
        System.out.println(longestPalindrome("abccccdd"));


    }
}
