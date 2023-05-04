package com.timberliu.algorithm.company.hw.back_track.no013_2_filterString;

import java.util.*;

/**
 * 13. 过滤组合字符串
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {{
		put('0', Arrays.asList('a', 'b', 'c'));
		put('1', Arrays.asList('d', 'e', 'f'));
		put('2', Arrays.asList('g', 'h', 'i'));
		put('3', Arrays.asList('j', 'k', 'l'));
		put('4', Arrays.asList('m', 'n', 'o'));
		put('5', Arrays.asList('p', 'q', 'r'));
		put('6', Arrays.asList('s', 't'));
		put('7', Arrays.asList('u', 'v'));
		put('8', Arrays.asList('w', 'x'));
		put('9', Arrays.asList('y', 'z'));
	}};

	public static List<String> filterString(String str1, String str2) {
		List<LinkedHashSet<Character>> allStrs = new LinkedList<>();
		backtrack(str1, 0, new LinkedHashSet<>(), allStrs);

		Iterator<LinkedHashSet<Character>> iter = allStrs.iterator();
		while (iter.hasNext()) {
			LinkedHashSet<Character> set = iter.next();
			boolean all = true;
			for (int i = 0; i < str2.length(); i++) {
				if (!set.contains(str2.charAt(i))) {
					all = false;
					break;
				}
			}
			if (all) {
				iter.remove();
			}
		}
		List<String> res = new ArrayList<>();
		for (LinkedHashSet<Character> set : allStrs) {
			StringBuilder sb = new StringBuilder();
			for (Character ch : set) {
				sb.append(ch);
			}
			res.add(sb.toString());
		}
		return res;
	}

	private static void backtrack(String str, int index, LinkedHashSet<Character> set, List<LinkedHashSet<Character>> res) {
		if (index == str.length()) {
			res.add(new LinkedHashSet<>(set));
			return;
		}
		for (Character ch : map.get(str.charAt(index))) {
			set.add(ch);
			backtrack(str, index + 1, set, res);
			set.remove(ch);
		}
	}

	/**
	 * 78
	 * ux
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		List<String> res = filterString(str1, str2);
		for (String val : res) {
			System.out.print(val + " ");
		}
	}

}
