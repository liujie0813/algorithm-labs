package com.timberliu.algorithm.company.hw.logic.no035_1_putBoxes;

import java.util.Scanner;

/**
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static String[] putBoxes(String str, int n) {
		StringBuilder[] sb = new StringBuilder[n];
		for (int i = 0; i < n; i++) {
			sb[i] = new StringBuilder();
		}
		int index = 0;
		while (index < str.length()) {
			for (int i = 0; i < n && index < str.length(); i++) {
				sb[i].append(str.charAt(index++));
			}
			for (int i = n - 1; i >= 0 && index < str.length(); i--) {
				sb[i].append(str.charAt(index++));
			}
		}
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			res[i] = sb[i].toString();
		}
		return res;
	}

	/**
	 * ABCDEFG 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		String[] res = putBoxes(strs[0], Integer.parseInt(strs[1]));
		for (String val : res) {
			System.out.println(val);
		}
	}

}
