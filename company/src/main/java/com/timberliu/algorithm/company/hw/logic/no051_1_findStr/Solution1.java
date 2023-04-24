package com.timberliu.algorithm.company.hw.logic.no051_1_findStr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 51. 密室逃生游戏
 *
 *  1 <= n <= 10000
 *  1 <= k.length <= 26
 *  0 <= s.length <= 50
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static int findStr(String[] boxes, String key) {
		int[] keyCnt = new int[26];
		for (int i = 0; i < key.length(); i++) {
			keyCnt[key.charAt(i) - 'a']++;
		}

		for (int i = 0; i < boxes.length; i++) {
			int[] copyKeyCnt = Arrays.copyOf(keyCnt, keyCnt.length);
			int j = 0;
			for (; j < boxes[i].length(); j++) {
				if (!Character.isLetter(boxes[i].charAt(j))) {
					continue;
				}
				int index = Character.toLowerCase(boxes[i].charAt(j)) - 'a';
				if (copyKeyCnt[index] <= 0) {
					break;
				} else {
					copyKeyCnt[index]--;
				}
			}
			if (j != boxes[i].length()) {
				continue;
			}
			boolean equal = true;
			for (int val : copyKeyCnt) {
				if (val != 0) {
					equal = false;
				}
			}
			if (equal) {
				return i + 1;
			}
		}
		return -1;
	}

	/*
	 * abc
	 * sdf134 A2c4b
	 */
	/**
	 * abc
	 * sddf134 A2c4bd 523[]
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String key = scanner.nextLine();
		String[] boxes = scanner.nextLine().split(" ");
		int res = findStr(boxes, key);
		System.out.println(res);

	}

}
