package com.timberliu.algorithm.company.hw.volume_a.sliding_window.no028_1_firstIndexCoverSubArray;

import java.util.Scanner;

/**
 * 28. 最左侧冗余覆盖子串
 *
 * @author liujie
 * @date 2023/4/26
 */

public class Solution1 {

	public static int firstIndexCoverSubArray(String s1, String s2, int k) {
		// 统计 s1 字符个数
		int[] need = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			need[s1.charAt(i) - 'a']++;
		}
		// 子串长度，需要的字符总数
		int count = s1.length();
		int left = 0;
		for (int right = 0; right < s2.length(); right++) {
			// 当前右边界
			int cur = s2.charAt(right) - 'a';
			need[cur]--;
			if (need[cur] >= 0) {
				count--;
			}
			// 所需字符达到要求
			if (count == 0) {
				return left;
			}
			// 窗口右移（移动左边界）
			if (right >= s1.length() + k - 1) {
				int prev = s2.charAt(left) - 'a';
				need[prev]++;
				if (need[prev] > 0) {
					count++;
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
