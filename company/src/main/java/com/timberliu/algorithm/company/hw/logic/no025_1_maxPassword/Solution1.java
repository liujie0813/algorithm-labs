package com.timberliu.algorithm.company.hw.logic.no025_1_maxPassword;

import java.util.*;

/**
 * @author Timber
 * @date 2023/4/26
 */
public class Solution1 {

	public static String maxPassword(String[] strs) {
		Set<String> set = new HashSet<>();
		for (String str : strs) {
			set.add(str);
		}
		String res = "";
		for (String str : strs) {
			boolean flag = true;
			for (int i = 1; i < str.length(); i++) {
				if (!set.contains(str.substring(0, i))) {
					flag = false;
					break;
				}
			}
			if (flag) {
				if (str.length() > res.length()) {
					res = str;
				} else if (str.length() == res.length() && str.compareTo(res) > 0) {
					res = str;
				}
			}
		}
		return res;
	}

	/*
	 * h he hel hell hello
	 */
	/**
	 * b ereddred bw bww bwwl bwwlm bwwln
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");

		String res = maxPassword(strs);
		System.out.println(res);
	}

}
