package com.timberliu.algorithm.company.hw.volume_b.old.string.no009_1_incrementSequence;

import java.util.Scanner;

/**
 * 9. 非严格连续递增子序列
 *
 * @author liujie
 * @date 2023/6/2
 */

public class Solution1 {

	public static int incrementSequence(String str) {
		int cnt = Character.isDigit(str.charAt(0)) ? 1 : 0;
		int res = 0;
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
				cnt = 0;
			} else {
				char last = str.charAt(i - 1);
				if (ch >= last) {
					cnt++;
					res = Math.max(res, cnt);
				} else {
					cnt = 1;
				}
			}
		}
		return res;
	}

	/**
	 * abc2234019A334bc
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int res = incrementSequence(str);
		System.out.println(res);
	}

}
