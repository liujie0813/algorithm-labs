package com.timberliu.algorithm.leetcode.string.no0005_2_longestPalindromicSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 5. 最长回文子串
 *
 * @author liujie
 * @date 2022/2/24
 */

public class Solution1 {

	public int lengthOfLongestSubstring(String s) {
		// [start, end]
		// <字符，该字符出现的最后位置>
		Map<Character, Integer> marked = new HashMap<>();
		int start = 0;
		int maxLen = 0;
		for (int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);
			// 如果字符出现过，则跳过
			if (marked.containsKey(ch)) {
				start = Math.max(start, marked.get(ch) + 1);
			}
			marked.put(ch, end);
			// 更新最大长度
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/longest-palindromic-substring/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.lengthOfLongestSubstring("babad"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.lengthOfLongestSubstring("cbbd"));

	}

}
