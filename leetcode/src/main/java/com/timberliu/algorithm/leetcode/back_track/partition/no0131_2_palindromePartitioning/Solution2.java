package com.timberliu.algorithm.leetcode.back_track.partition.no0131_2_palindromePartitioning;

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
public class Solution2 {

	public List<List<String>> partition(String s) {

		List<List<String>> res = new ArrayList<>();
		// 以 begin 位开始作为回文串的分割起点
		dfs(s, 0, new ArrayList<>(), res);
		return res;
	}

	private void dfs(String s, int begin, List<String> cur, List<List<String>> res) {
		if (begin == s.length()) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = begin; i < s.length(); i++) {
			if (isPalindrome(s, begin, i)) {
				cur.add(s.substring(begin, i + 1));
				dfs(s, i + 1, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str, int left, int right) {
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/palindrome-partitioning/ -----");
		Solution2 solution1 = new Solution2();
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
