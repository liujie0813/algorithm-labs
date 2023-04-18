package com.timberliu.algorithm.company.hw.no099_1_minNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 99. 组合出合法最小数
 *
 * @author liujie
 * @date 2023/4/17
 */

public class Solution1 {

	public static String minNum(String[] strs) {
		Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));

		if (strs[0].charAt(0) == '0') {
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].charAt(0) != '0') {
					strs[0] = strs[i] + strs[0];
					strs[i] = "";
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str);
		}
		String res;
		if (sb.charAt(0) == '0') {
			res = sb.substring(1, sb.length());
		} else {
			res = sb.toString();
		}
		return "".equals(res) ? "0" : res;
	}

	/*
	 * 20 1
	 */
	/*
	 * 08 10 2
	 */
	/*
	 * 01 02
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] strs = line.split(" ");

		String res = minNum(strs);
		System.out.println(res);
	}

}
