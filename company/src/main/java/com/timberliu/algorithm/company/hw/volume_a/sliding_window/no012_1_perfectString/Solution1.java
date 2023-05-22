package com.timberliu.algorithm.company.hw.volume_a.sliding_window.no012_1_perfectString;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 12. 完美走位
 *
 *  求最小覆盖子串（包含多余次数的字符）
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static int perfectString(String str) {
		// 出现次数
		Map<Character, Integer> cntMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
		}

		int avg = str.length() / 4;
		// 总多余次数
		int total = 0;
		// 各字符 -> 多余次数
		for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
			if (entry.getValue() > avg) {
				cntMap.put(entry.getKey(), entry.getValue() - avg);
				total += entry.getValue();
			} else {
				cntMap.put(entry.getKey(), 0);
			}
		}
		if (total == 0) {
			return 0;
		}

		int res = Integer.MAX_VALUE;
		int left = 0, right = 0;
		while (right < str.length()) {
			char ch = str.charAt(right);
			if (cntMap.containsKey(ch) && cntMap.get(ch) > 0) {
				total--;
			}
			cntMap.put(ch, cntMap.get(ch) - 1);

			while (total == 0) {
				res = Math.min(res, right - left + 1);
				char leftCh = str.charAt(left);
				if (cntMap.containsKey(leftCh) && cntMap.get(leftCh) >= 0) {
					total++;
				}
				cntMap.put(leftCh, cntMap.get(leftCh) + 1);
				left++;
			}
			right++;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int res = perfectString(str);
		System.out.println(res);
	}

}
