package com.timberliu.algorithm.leetcode.string.no0005_2_longestPalindromicSubstring.related.no0647_palindromicSubstrings;

/**
 * 647. 回文子串
 *
 * @author liujie
 * @date 2022/2/24
 */

public class Solution1 {

	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += palindrome(s, i, i);
			res += palindrome(s, i, i + 1);
		}
		return res;
	}

	private int palindrome(String str, int left, int right) {
		int res = 0;
		while (left >= 0 && right < str.length()) {
			if (str.charAt(left) != str.charAt(right)) {
				break;
			}
			left--;
			right++;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/palindromic-substrings/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.countSubstrings("abc"));

		System.out.println("----- 2 -----");
		System.out.println(solution1.countSubstrings("aaa"));

	}

}
