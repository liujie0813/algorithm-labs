package com.timberliu.algorithm.leetcode.dp.sequence.sub_string_palindrome.no0647_palindromicSubstrings;

/**
 * 647. 回文子串
 *
 * @author liujie
 * @date 2022/2/24
 */

public class Solution1 {

	public int countSubstrings(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		int res = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i <= 1 || dp[i + 1][j - 1]) {
						res++;
						dp[i][j] = true;
					}
				}
			}
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
