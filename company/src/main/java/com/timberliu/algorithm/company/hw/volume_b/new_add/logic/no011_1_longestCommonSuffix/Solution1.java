package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no011_1_longestCommonSuffix;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 11. 最长公共后缀
 *
 * @author liujie
 * @date 2023/5/31
 */

public class Solution1 {

	public static String longestCommonSuffix(List<String> strs) {
		String res = strs.get(0);
		for (int i = 1; i < strs.size(); i++) {
			String cur = strs.get(i);
			int first = res.length() - 1, second = cur.length() - 1;
			int len = 0;
			while (first - len >= 0 && second - len >= 0 && res.charAt(first - len) == cur.charAt(second - len)) {
				len++;
			}
			if (len == 0) {
				return "@Zero";
			}
			res = res.substring(first - len + 1);
		}
		return res;
	}

	/*
	 * ["abc","bbc","c"]
	 */
	/**
	 * ["aa","bb","cc"]
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] splits = line.substring(1, line.length() - 1).split(",");
		List<String> strs = Arrays.stream(splits).map(str -> str.substring(1, str.length() - 1)).collect(Collectors.toList());
		String res = longestCommonSuffix(strs);
		System.out.println(res);
	}

}
