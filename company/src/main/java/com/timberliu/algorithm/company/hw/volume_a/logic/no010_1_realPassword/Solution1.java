package com.timberliu.algorithm.company.hw.volume_a.logic.no010_1_realPassword;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 10. 真正的密码
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static String realPassword(String[] strs) {
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

	/**
	 * h he hel hell hello w wo wor worl world
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		String res = realPassword(strs);
		System.out.println(res);
	}

}
