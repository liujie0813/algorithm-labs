package com.timberliu.algorithm.leetcode.back_track.combination.no0017_2_letterCombinationsOfAPhoneNumber;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 *
 */

public class Solution2 {

	private static Map<Character, List<Character>> map = new HashMap<Character, List<Character>>(){{
		put('2', Arrays.asList('a', 'b', 'c'));
		put('3', Arrays.asList('d', 'e', 'f'));
		put('4', Arrays.asList('g', 'h', 'i'));
		put('5', Arrays.asList('j', 'k', 'l'));
		put('6', Arrays.asList('m', 'n', 'o'));
		put('7', Arrays.asList('p', 'q', 'r', 's'));
		put('8', Arrays.asList('t', 'u', 'v'));
		put('9', Arrays.asList('w', 'x', 'y', 'z'));
	}};

    public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		backtrack(digits, 0, new StringBuilder(), res);
		return res;
    }

    private static void backtrack(String digits, int curIndex, StringBuilder sb, List<String> res) {
    	if (curIndex == digits.length()) {
    		res.add(sb.toString());
    		return;
		}
		List<Character> characters = map.get(digits.charAt(curIndex));
		for (Character ch : characters) {
			sb.append(ch);
			backtrack(digits, curIndex + 1, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

    public static void main(String[] args) {
		List<String> res1 = letterCombinations("23");
		printListList(res1);

		List<String> res2 = letterCombinations("");
		printListList(res2);
	}

	private static void printListList(List<String> list) {
		for (String str : list) {
			System.out.print(str + ", ");
		}
		System.out.println();
	}

}