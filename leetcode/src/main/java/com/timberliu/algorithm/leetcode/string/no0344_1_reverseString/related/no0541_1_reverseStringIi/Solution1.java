package com.timberliu.algorithm.leetcode.string.no0344_1_reverseString.related.no0541_1_reverseStringIi;

/**
 * 541. 反转字符串 II
 *
 *
 * Created by liujie on 2023/2/27
 */

public class Solution1 {

    public static String reverseStr(String s, int k) {
		char[] chars = s.toCharArray();
		for (int r = 0; r < s.length(); r += 2 * k) {
			if (r + k <= s.length()) {
				reverseChars(chars, r, r + k - 1);
			} else {
				reverseChars(chars, r, s.length() - 1);
			}
		}
		return new String(chars);
	}

	private static void reverseChars(char[] chars, int left, int right) {
    	while (left <= right) {
    		char ch = chars[left];
    		chars[left++] = chars[right];
    		chars[right--] = ch;
		}
	}

    public static void main(String[] args) {
		String res1 = reverseStr("abcdefgh", 3);
		System.out.println(res1);

		String res2 = reverseStr("abcdefghi", 3);
		System.out.println(res2);

		String res3 = reverseStr("abcdefghij", 3);
		System.out.println(res3);
	}

}