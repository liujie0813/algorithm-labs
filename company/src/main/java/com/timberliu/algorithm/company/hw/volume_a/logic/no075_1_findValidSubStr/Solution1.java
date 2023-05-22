package com.timberliu.algorithm.company.hw.volume_a.logic.no075_1_findValidSubStr;

import java.util.*;

/**
 * 75. 字符串解密
 * 
 * @author liujie
 * @date 2023/4/21
 */

public class Solution1 {

	public static String findValidSubStr(String str1, String str2) {
		List<String> subStrList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str1.length(); i++) {
			if ('g' <= str1.charAt(i) && str1.charAt(i) <= 'z') {
				sb.append(str1.charAt(i));
			} else if (sb.length() > 0) {
				subStrList.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		if (sb.length() > 0) {
			subStrList.add(sb.toString());
		}

		Set<Character> str2Set = new HashSet<>();
		for (int i = 0; i < str2.length(); i++) {
			str2Set.add(str2.charAt(i));
		}
		int str2Num = str2Set.size();

		String res = "";
		for (String subStr : subStrList) {
			Set<Character> subStrSet = new HashSet<>();
			for (int i = 0; i < subStr.length(); i++) {
				subStrSet.add(subStr.charAt(i));
			}
			int subStrNum = subStrSet.size();

			if (subStrNum <= str2Num) {
				if (subStrNum > res.length()) {
					res = subStr;
				} else if (subStrNum == res.length()) {
					res = subStr.compareTo(res) > 0 ? subStr : res;
				}
			}
		}
		return "".equals(res) ? "Not Found" : res;
	}

	/*
	 * abcmnq
	 * rt
	 */
	/*
	 * 123admyffc79ptaagghi2222smeersst88mnrt
	 * ssyyfgh
	 */
	/**
	 * 123admyffc79pt
	 * ssyy
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		String res = findValidSubStr(str1, str2);
		System.out.println(res);
	}
	
}
