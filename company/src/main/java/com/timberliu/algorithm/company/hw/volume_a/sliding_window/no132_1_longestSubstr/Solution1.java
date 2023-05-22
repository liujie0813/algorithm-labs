package com.timberliu.algorithm.company.hw.volume_a.sliding_window.no132_1_longestSubstr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 132. 寻找符合要求的最长子串
 *
 * @author liujie
 * @date 2023/5/5
 */

public class Solution1 {

	public static int longestSubstr(String str, char exclude) {
		int[] cnt = new int[128];
		int res = 0;
		int left = 0, right = 0;
		while (right < str.length()) {
			char ch = str.charAt(right);
			if (ch == exclude) {
				right++;
				left = right;
				Arrays.fill(cnt, 0);
			} else {
				cnt[ch]++;
				while (cnt[ch] > 2) {
					cnt[str.charAt(left)]--;
					left++;
				}
				res = Math.max(res, right - left + 1);
				right++;
			}
		}
		return res;
	}

	/**
	 * D
	 * ABACA123D
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String filter = scanner.nextLine();
		String str = scanner.nextLine();
		int res = longestSubstr(str, filter.charAt(0));
		System.out.println(res);
	}

}
