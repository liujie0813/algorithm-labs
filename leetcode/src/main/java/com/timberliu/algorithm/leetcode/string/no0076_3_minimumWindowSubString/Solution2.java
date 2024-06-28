package com.timberliu.algorithm.leetcode.string.no0076_3_minimumWindowSubString;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 *  滑动窗口（类比最小长度子数组）
 *  1. right 遍历右边界右移
 *    统计字符出现次数（求和）
 *  2. 达到条件，尝试左边界左移
 *    每个字符达到所需出现次数，满足 need 条件（和等于 target）
 *
 *    1. 尝试更新结果
 *      最小子串 start、minLen（minSum）
 *    2. 左边界左移
 *      字符出现次数排除（减和）
 *
 *    循环直到不满足条件
 *       不满足字符个数（和不等于 target）
 *
 * @author liujie
 * @date 2022/4/26
 */

public class Solution2 {

	public String minWindow(String s, String t) {
		Map<Character, Integer> need = new HashMap<>();
		// 统计 t 中字符所需个数
		for (int i = 0; i < t.length(); i++) {
			need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
		}
		// 最小子串的 start、minLen
		int start = 0, minLen = Integer.MAX_VALUE;
		// 当前窗口的 left, right
		int left = 0, right = 0;
		// 是所需字符的字符数
		int count = 0;
		while (right < s.length()) {
			char rightCh = s.charAt(right);
			// 当前字符所需次数大于 0
			if (need.getOrDefault(rightCh, 0) > 0) {
				count++;
			}
			// 当前字符所需次数--
			need.put(rightCh, need.getOrDefault(rightCh, 0) - 1);
			// t所需字符个数达到要求
			if (count == t.length()) {
				// 尝试缩小左边界
				// 字符不需要，或s中出现次数超过t中所需次数
				while (left <= right && need.get(s.charAt(left)) < 0) {
					left++;
				}
				if (right - left + 1 < minLen) {
					start = left;
					minLen = right - left + 1;
				}
				char leftCh = s.charAt(left);
				need.put(leftCh, need.getOrDefault(leftCh, 0) - 1);
				left++;
				count--;
			}
			right++;
		}
		return minLen != Integer.MAX_VALUE ? s.substring(start, start + minLen) : "";
	}

	public static void main(String[] args) {
		Solution2 test1 = new Solution2();
		String s = test1.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(s);
	}

}
