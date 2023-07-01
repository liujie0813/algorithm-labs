package com.timberliu.algorithm.company.hw.exercise.no05.no149_1_splitClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Timber
 * @date 2023/6/23
 */
public class Solution1 {

	public static String splitClass(String[][] arr) {
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		boolean lastIsFirst = false;
		for (String[] str : arr) {
			int number = Integer.parseInt(str[0]);
			if ("Y".equals(str[1])) {
				if (lastIsFirst) {
					first.add(number);
				} else {
					second.add(number);
				}
			} else if ("N".equals(str[1])) {
				if (lastIsFirst) {
					second.add(number);
					lastIsFirst = false;
				} else {
					first.add(number);
					lastIsFirst = true;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for (Integer str : first) {
			res.append(str).append(" ");
		}
		res.append("\n");
		for (Integer str : second) {
			res.append(str).append(" ");
		}
		return res.toString();
	}

	/**
	 * 1/N 2/Y 3/N 4/Y 5/Y
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		String[][] arr = new String[splits.length][2];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = splits[i].split("/");
		}

		String res = splitClass(arr);
		System.out.println(res);
	}

}
