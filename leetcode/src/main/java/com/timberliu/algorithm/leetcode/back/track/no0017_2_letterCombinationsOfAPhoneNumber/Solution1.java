package com.timberliu.algorithm.leetcode.back.track.no0017_2_letterCombinationsOfAPhoneNumber;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 *
 *  时间复杂度：O(4^n)
 *  空间复杂度：O(4^n)
 *
 * @author Timber
 * @date 2021/11/1
 */
public class Solution1 {

	private Map<Character, List<Character>> map = new HashMap<>();

	{
		map.put('2', Arrays.asList('a', 'b', 'c'));
		map.put('3', Arrays.asList('d', 'e', 'f'));
		map.put('4', Arrays.asList('g', 'h', 'i'));
		map.put('5', Arrays.asList('j', 'k', 'l'));
		map.put('6', Arrays.asList('m', 'n', 'o'));
		map.put('7', Arrays.asList('p', 'q', 'r', 's'));
		map.put('8', Arrays.asList('t', 'u', 'v'));
		map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0) {
			return res;
		}
		dfs(digits, new StringBuilder(), 0, res);
		return res;
	}

	private void dfs(String digits, StringBuilder cur, int i, List<String> res) {
		if (i >= digits.length()) {
			res.add(cur.toString());
			return;
		}
		for (Character c : map.get(digits.charAt(i))) {
			cur.append(c);
			dfs(digits, cur, i + 1, res);
			cur.deleteCharAt(cur.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		List<String> res1 = solution1.letterCombinations("23");
		for (String s : res1) {
			System.out.print(s + ", ");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<String> res2 = solution1.letterCombinations("");
		for (String s : res2) {
			System.out.print(s + ", ");
		}
		System.out.println();

		System.out.println("----- 3 -----");
		List<String> res3 = solution1.letterCombinations("2");
		for (String s : res3) {
			System.out.print(s + ", ");
		}
		System.out.println();

	}

}
