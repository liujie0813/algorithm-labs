package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no015_1_originMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 15. 报文重排序
 *
 * @author liujie
 * @date 2023/5/25
 */

public class Solutioon1 {

	public static String originMessage(String[] arr, int n) {
		Map<Integer, String> map = new HashMap<>();
		for (String str : arr) {
			int i = 0;
			for (; i < str.length(); i++) {
				if (Character.isDigit(str.charAt(i))) {
					break;
				}
			}
			String s = str.substring(0, i);
			int order = Integer.parseInt(str.substring(i));
			map.put(order, s);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(map.get(i));
			if (i < n) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/*
	 * 4
	 * rolling3 stone4 like1 a2
	 */
	/**
	 * 8
	 * gifts6 and7 exchange1 all2 precious5 things8 kinds3 of4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] strs = scanner.nextLine().split(" ");

		String res = originMessage(strs, n);
		System.out.println(res);
	}

}
