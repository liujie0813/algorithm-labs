package com.timberliu.algorithm.offer.string.no058_leftRotateString;

/**
 * 剑指 Offer 058 II. 坐旋转字符串
 *
 * @author liujie
 * @date 2023/3/1
 */

public class Solution1 {

	public static String reverseWords(String s, int n) {
		char[] chars = s.toCharArray();
		reverse(chars, 0, n - 1);
		reverse(chars, n, s.length() - 1);
		reverse(chars, 0, s.length() - 1);
		return new String(chars);
	}

    private static void reverse(char[] chars, int left, int right) {
		while (left <= right) {
			char tmp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = tmp;
		}
	}

    public static void main(String[] args) {
		String res = reverseWords("abcdefg", 2);
		System.out.println(res);
	}

}