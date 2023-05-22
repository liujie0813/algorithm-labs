package com.timberliu.algorithm.company.hw.volume_a.logic.no052_1_concatNewspaper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 52. 匿名信
 *
 *  n = 10^4，双重 for 循环会超时
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static boolean concatNewspapere(String[] newspaper, String[] letter) {
		Map<String, Integer> cntMap = new HashMap<>();
		for (String str : newspaper) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String newStr = new String(chars);
			cntMap.put(newStr, cntMap.getOrDefault(newStr, 0) + 1);
		}

		for (String find : letter) {
			char[] chars = find.toCharArray();
			Arrays.sort(chars);
			String newFind = new String(chars);
			Integer cnt = cntMap.getOrDefault(newFind, 0);
			if (cnt <= 0) {
				return false;
			} else {
				cntMap.put(newFind, cnt - 1);
			}
		}
		return true;
	}

	/*
	 * ab bcd ef
	 * cbd fe
	 */
	/**
	 * ab bcd ef
	 * cd ef
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] newspaper = scanner.nextLine().split(" ");
		String[] letter = scanner.nextLine().split(" ");
		boolean res = concatNewspapere(newspaper, letter);
		System.out.println(res);
	}

}
