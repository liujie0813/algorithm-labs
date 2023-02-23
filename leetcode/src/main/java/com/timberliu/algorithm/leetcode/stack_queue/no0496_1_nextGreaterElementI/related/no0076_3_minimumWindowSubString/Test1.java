package com.timberliu.algorithm.leetcode.stack_queue.no0496_1_nextGreaterElementI.related.no0076_3_minimumWindowSubString;

/**
 * @author liujie
 * @date 2022/4/26
 */

public class Test1 {

	public String minWindow(String s, String t) {
		// 所需字符个数（当前窗口）
		int[] need = new int[128];
		for (int i = 0; i < t.length(); i++) {
			need[t.charAt(i)]++;
		}
		// l、r 维护窗口
		int l = 0, r = 0;
		// count：当前窗口包含 所需字符的个数
		int minLen = Integer.MAX_VALUE, count = 0;
		// minLen 对应的 start
		int minStart = 0;
		for (; r < s.length(); r++) {
			// 如果是所需字符，count++
			if (need[s.charAt(r)] > 0) {
				count++;
			}
			need[s.charAt(r)]--;
			// 满足 t 的长度了
			if (count == t.length()) {
				// need 小于 0，表示该字符多余了，可以左移
				while (l <= r && need[s.charAt(l)] < 0) {
					need[s.charAt(l)]++;
					l++;
				}
				// 窗口小于最小长度，则更新
				if (r - l + 1 < minLen) {
					minLen = r - l + 1;
					minStart = l;
				}
				// 窗口右移一位，继续判断
				need[s.charAt(l)]++;
				l++;
				count--;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	public static void main(String[] args) {
		Test1 test1 = new Test1();
		String s = test1.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(s);
	}

}
