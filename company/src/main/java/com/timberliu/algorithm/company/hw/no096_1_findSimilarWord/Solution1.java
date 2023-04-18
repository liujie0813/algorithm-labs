package com.timberliu.algorithm.company.hw.no096_1_findSimilarWord;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 96. 寻找相似单词
 *
 *
 * @author liujie
 * @date 2023/4/18
 */

public class Solution1 {

	public static List<String> findSimilarWords(String[] strs, String find) {
		List<String> res = new ArrayList<>();
		char[] findChars = find.toCharArray();
		Arrays.sort(findChars);
		String findStr = String.valueOf(findChars);
		for (String str : strs) {
			char[] strChars = str.toCharArray();
			Arrays.sort(strChars);
			String sortStr = String.valueOf(strChars);
			if (findStr.equals(sortStr)) {
				res.add(str);
			}
		}
		res.sort(String::compareTo);
		return res;
	}

	/**
	 * 4
	 * abc
	 * dasd
	 * tad
	 * bca
	 * abc
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = scanner.nextLine();
		}
		String find = scanner.nextLine();
		List<String> res = findSimilarWords(strs, find);
		if (res.isEmpty()) {
			System.out.println("null");
		} else {
			PrintUtils.printListString(res);
		}
	}

}
