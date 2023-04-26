package com.timberliu.algorithm.company.hw.sliding_window.no028_1_firstIndexCoverSubArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 28. 最左侧冗余覆盖子串
 *
 * @author liujie
 * @date 2023/4/26
 */

public class Solution2 {

	public static int firstIndexCoverSubArray(String s1, String s2, int k) {
		// 统计 s1 字符个数
		Map<Integer, Integer> need = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			int val = s1.charAt(i) - 'a';
			need.put(val, need.getOrDefault(val, 0) + 1);
		}
		// 统计窗口内字符个数
		Map<Integer, Integer> window = new HashMap<>();
		int valid = 0;
		int left = 0;
		for (int right = 0; right < s2.length(); right++) {
			// 当前右边界
			int cur = s2.charAt(right) - 'a';
			if (need.containsKey(cur)) {
				window.put(cur, window.getOrDefault(cur, 0) + 1);
				if (window.get(cur).equals(need.get(cur))) {
					valid++;
				}
			}
			// 所需字符达到要求
			if (valid == need.size()) {
				return left;
			}
			// 窗口右移（移动左边界）
			if (right >= s1.length() + k - 1) {
				int prev = s2.charAt(left) - 'a';
				if (need.containsKey(prev)) {
					if (window.get(prev).equals(need.get(prev))) {
						valid--;
					}
					window.put(prev, window.getOrDefault(prev, 0) - 1);
				}
				left++;
			}
		}
		return -1;
	}

	/*
	 * ab
	 * aabcd
	 * 1
	 */
	/**
	 * abc
	 * dfs
	 * 10
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		int k = Integer.parseInt(scanner.nextLine());
		int res = firstIndexCoverSubArray(s1, s2, k);
		System.out.println(res);
	}

}
