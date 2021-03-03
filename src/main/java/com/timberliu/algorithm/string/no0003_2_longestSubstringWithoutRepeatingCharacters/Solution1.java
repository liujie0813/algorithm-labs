package com.timberliu.algorithm.string.no0003_2_longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 *   滑动窗口法
 *     时间复杂度：O(n)
 *     空间复杂度：O(n)
 *
 *   原理？
 *     1. 使用 [start, i] 标识当前的最长子串
 *     2. 使用 Map 存储 (字符 -> 当前字符之前出现的最后一个位置)
 *     2. 遍历字符串
 *        1. 如果该字符没有出现过，则将其加入 map 中，并更新最大子串长度
 *        2. 如果该字符出现过，则将当前子串的 start 更新为 (该字符之前出现的最后一个位置 + 1, start 中的较大者)
 *               选择较大值的原因：  a b c b a
 *               a). 第二次出现 b 时将 start 更新 2，继续遍历第二次出现 a，start 更新为 (2, 0+1) 较大者
 *           然后更新 map，该字符出现最后一个位置为 当前下标
 *        3. 通过 i - start + 1 判断最长子串
 *
 * Created by liujie on 2021/3/1
 */

public class Solution1 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
         return 0;
        }
        Map<Character, Integer> marked = new HashMap<>();
        // 当前子串 [start, i]
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (marked.containsKey(ch)) {
                start = Math.max(start, marked.get(ch) + 1);
            }
            marked.put(ch, i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/ -----");
        System.out.println("----- 1 -----");
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        System.out.println("----- 2 -----");
        System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println("----- 3 -----");
        System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println("----- 4 -----");
        System.out.println(lengthOfLongestSubstring("aab"));

    }
}
