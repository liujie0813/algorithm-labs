package com.timberliu.algorithm.company.hw.volume_a.logic.no113_1_longestPalindromeSubString;

import java.util.*;

/**
 * 113. 最长回文子串
 *
 *  构造最长回文子串
 *
 * @author liujie
 * @date 2023/4/12
 */

public class Solution1 {

	public static String longestPalindromeSubString(String input) {
		// 统计字符出现次数
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		List<Character> evenList = new ArrayList<>();
		List<Character> oddList = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Character ch = entry.getKey();
			Integer cnt = entry.getValue();
			// 奇数次的字符（多的那一次也可能放中间）
			if (cnt % 2 == 1) {
				oddList.add(ch);
				cnt--;
			}
			// 偶数次的字符
			for (int i = 0; i < cnt / 2; i++) {
				evenList.add(ch);
			}
		}
		// 字典序排序
		evenList.sort(Comparator.naturalOrder());
		StringBuilder leftStr = new StringBuilder();
		for (Character ch : evenList) {
			leftStr.append(ch);
		}
		// 中间的也按字典序取最小的
		String midStr = "";
		if (!oddList.isEmpty()) {
			oddList.sort(Comparator.naturalOrder());
			midStr = oddList.get(0) + "";
		}
		// 反转左边
		String rightStr = reverse(leftStr);
		return leftStr + midStr + rightStr;
	}

	private static String reverse(StringBuilder str) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		for (int i = 0; i < n; i++) {
			sb.append(str.charAt(n - 1 - i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		String res = longestPalindromeSubString(input);
		System.out.println(res);
	}

}
