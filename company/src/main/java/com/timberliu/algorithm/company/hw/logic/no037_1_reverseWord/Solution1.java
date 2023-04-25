package com.timberliu.algorithm.company.hw.logic.no037_1_reverseWord;

import java.util.Scanner;

/**
 * 37. 单词倒序
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static String reverseWord(String str) {
		int index = 0;
		char[] chars = str.toCharArray();
		while (index < str.length()) {
			int left = index;
			while (left < chars.length && !Character.isLetter(chars[left])) {
				left++;
			}
			int right = left;
			while (right < chars.length && Character.isLetter(chars[right])) {
				right++;
			}
			doReverse(chars, left, right - 1);
			index = right;
		}
		return new String(chars);
	}

	private static void doReverse(char[] chars, int left, int right) {
		while (left < right) {
			char ch = chars[left];
			chars[left] = chars[right];
			chars[right] = ch;
			left++;
			right--;
		}
	}

	/*
	 * My name is Bob.
	 */
	/**
	 * how are you ? I am fine.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String res = reverseWord(str);
		System.out.println(res);
	}

}
