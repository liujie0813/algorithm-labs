package com.timberliu.algorithm.company.hw.sliding_window.no085_newWordNum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 85. 新词挖掘
 *
 *  滑动窗口
 *
 *   相比于 leetcode76（寻找覆盖子串），这里可以理解为寻找异位词
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution1 {

	public static int findNewWords(String originStr, String findStr) {
		Map<Character, Integer> findMap = new HashMap<>();
		for (int i = 0; i < findStr.length(); i++) {
			findMap.put(findStr.charAt(i), findMap.getOrDefault(findStr.charAt(i), 0) + 1);
		}

		Map<Character, Integer> curMap = new HashMap<>();
		int left = 0;
		int validCnt = 0;
		int res = 0;
		for (int i = 0; i < originStr.length(); i++) {
			char ch = originStr.charAt(i);
			// 如果当前字符不是需要的
			if (!findMap.containsKey(ch)) {
				// 清空滑动窗口
				left = i + 1;
				validCnt = 0;
				curMap = new HashMap<>();
				continue;
			}

			// 统计字符出现次数
			curMap.put(ch, curMap.getOrDefault(ch, 0) + 1);
			// 该字符出现次数 达到要求
			if (curMap.get(ch).equals(findMap.get(ch))) {
				validCnt++;
			}
			if (validCnt == findMap.size()) {
				res++;
			}

			// 移动左边界
			if (i - left + 1 == findStr.length()) {
				char leftCh = originStr.charAt(left);
				if (findMap.containsKey(leftCh) && findMap.get(leftCh).equals(curMap.get(leftCh))) {
					validCnt--;
				}
				curMap.put(leftCh, curMap.getOrDefault(leftCh, 0) - 1);
				left++;
			}
		}
		return res;
	}

	/*
	 * qweebaewqd
	 * qwe
	 */
	/**
	 * abab
	 * ab
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String originStr = scanner.nextLine();
		String findStr = scanner.nextLine();
		int res = findNewWords(originStr, findStr);
		System.out.println(res);

	}

}
