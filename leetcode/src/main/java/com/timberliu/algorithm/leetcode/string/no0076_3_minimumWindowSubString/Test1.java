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

public class Test1 {

	public String minWindow(String s, String t) {
		Map<Character, Integer> need = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();

		// 统计 t 中字符所需个数
		for (int i = 0; i < t.length(); i++) {
			need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
		}
		// 最小子串的 start、minLen
		int start = 0, minLen = Integer.MAX_VALUE;
		// 当前窗口的 left, right
		int left = 0, right = 0;
		// 满足所需次数的字母个数
		int count = 0;
		while (right < s.length()) {
			char rightCh = s.charAt(right);
			if (need.containsKey(rightCh)) {
				// 统计当前窗口字母出现次数
				window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);
				// 该字母满足所需次数
				if (need.get(rightCh).equals(window.get(rightCh))) {
					count++;
				}
			}
			while (count == need.size()) {
				if (right - left + 1 < minLen) {
					start = left;
					minLen = right - left + 1;
				}
				char leftCh = s.charAt(left);
				if (need.containsKey(leftCh)) {
					if (need.get(leftCh).equals(window.get(leftCh))) {
						// 该字母不再满足所需次数
						count--;
					}
					window.put(leftCh, window.getOrDefault(leftCh, 0) - 1);
				}
				left++;
			}
			right++;
		}
		return minLen != Integer.MAX_VALUE ? s.substring(start, start + minLen) : "";
	}

	public static void main(String[] args) {
		Test1 test1 = new Test1();
		String s = test1.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(s);
	}

}
