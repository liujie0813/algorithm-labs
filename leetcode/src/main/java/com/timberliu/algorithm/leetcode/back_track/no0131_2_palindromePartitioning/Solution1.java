package com.timberliu.algorithm.leetcode.back_track.no0131_2_palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 *   预处理 f[i][j] 表示 i 到 j 是否为回文串
 *
 *   f[i][j] = f[i + 1][j - 1] && s[i] == s[j]
 *
 * @author Timber
 * @date 2021/11/2
 */
public class Solution1 {

	public List<List<String>> partition(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		boolean[][] dp = new boolean[n][n];
		// 右端点 j 一直往右移动
		for (int j = 0; j < n; j++) {
			// 左端点在 j 左边，一直往左移动
			for (int i = j; i >= 0; i--) {
				if (i == j) {
					dp[i][j] = true;
				} else {
					// 长度为 2，满足 s[i] == s[j]
					if (j - i == 1) {
						dp[i][j] = chars[i] == chars[j];
					} else {
						dp[i][j] = chars[i] == chars[j] && dp[i + 1][j - 1];
					}
				}
			}
		}
		List<List<String>> res = new ArrayList<>();
		// 以 begin 位开始作为回文串的分割起点
		dfs(s, 0, new ArrayList<>(), res, dp);
		return res;
	}

	private void dfs(String s, int begin, List<String> cur, List<List<String>> res, boolean[][] dp) {
		if (begin == s.length()) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = begin; i < s.length(); i++) {
			if (dp[begin][i]) {
				cur.add(s.substring(begin, i + 1));
				dfs(s, i + 1, cur, res, dp);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/palindrome-partitioning/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		List<List<String>> res1 = solution1.partition("aab");
		for (List<String> res : res1) {
			for (String a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<List<String>> res2 = solution1.partition("a");
		for (List<String> res : res2) {
			for (String a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

	}

}
