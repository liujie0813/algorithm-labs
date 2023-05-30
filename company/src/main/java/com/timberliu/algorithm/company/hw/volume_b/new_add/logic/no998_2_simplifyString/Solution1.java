package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no998_2_simplifyString;

import java.util.*;

/**
 * 字符串化繁为简
 *
 * @author liujie
 * @date 2023/5/24
 */

public class Solution1 {

	public static String simplifyString(String str) {
		// 要替换的字符串
		StringBuilder mainSb = new StringBuilder();
		// 每对括号内的等效字符串
		List<TreeSet<Character>> equalList = new ArrayList<>();

		TreeSet<Character> set = new TreeSet<>();
		boolean open = false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				open = true;
			} else if (ch == ')') {
				if (!set.isEmpty()) {
					equalList.add(set);
					set = new TreeSet<>();
				}
				open = false;
			} else {
				if (open) {
					set.add(ch);
				} else {
					mainSb.append(ch);
				}
			}
		}

		// 两两合并等效容器
		while (merge(equalList)) {}

		char[] res = mainSb.toString().toCharArray();
		for (TreeSet<Character> equals : equalList) {
			// 每个等效容器中的字符
			// 替换为字典序最小的那个
			Character ch = equals.first();
			for (int i = 0; i < res.length; i++) {
				if (equals.contains(res[i])) {
					res[i] = ch;
				}
			}
		}
		return res.length == 0 ? "0" : new String(res);
	}

	private static boolean merge(List<TreeSet<Character>> equalList) {
		for (int i = 0; i < equalList.size(); i++) {
			for (int j = i + 1; j < equalList.size(); j++) {
				if (canMerge(equalList.get(i), equalList.get(j))) {
					equalList.get(i).addAll(equalList.get(j));
					equalList.remove(j);
					return true;
				}
			}
		}
		return false;
	}

	private static boolean canMerge(TreeSet<Character> first, TreeSet<Character> second) {
		for (char lowerCase = 'a'; lowerCase <= 'z'; lowerCase++) {
			char upperCase = Character.toUpperCase(lowerCase);
			// 字符相等，或大小写
			if ((first.contains(lowerCase) || first.contains(upperCase)) &&
					(second.contains(lowerCase) || second.contains(upperCase))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		String res = simplifyString(line);
		System.out.println(res);
	}

}
