package com.timberliu.algorithm.company.hw.logic.no060_1_totalScore;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 60. 投篮大赛
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution1 {

	public static int totalScore(String[] inputs) {
		List<Integer> list = new LinkedList<>();
		for (String input : inputs) {
			if ("+".equals(input)) {
				if (list.size() < 2) {
					return -1;
				}
				Integer first = list.get(list.size() - 2);
				Integer second = list.get(list.size() - 1);
				list.add(first + second);
			} else if ("D".equals(input)) {
				if (list.size() < 1) {
					return -1;
				}
				Integer val = list.get(list.size() - 1);
				list.add(val * 2);
			} else if ("C".equals(input)) {
				if (list.size() < 1) {
					return -1;
				}
				list.remove(list.size() - 1);
			} else {
				list.add(Integer.parseInt(input));
			}
		}
		int sum = 0;
		for (Integer val : list) {
			sum += val;
		}
		return sum;
	}

	/**
	 * 5 2 C D +
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = scanner.nextLine().split(" ");
		int res = totalScore(inputs);
		System.out.println(res);
	}

}
