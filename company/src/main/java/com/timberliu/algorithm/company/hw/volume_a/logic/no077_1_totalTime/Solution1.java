package com.timberliu.algorithm.company.hw.volume_a.logic.no077_1_totalTime;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author liujie
 * @date 2023/4/21
 */

public class Solution1 {

	private static String totalTime(int taskA, int taskB, int num) {
		LinkedHashSet<Integer> res = new LinkedHashSet<>();
		int max = Math.max(taskA, taskB);
		int min = Math.min(taskA, taskB);
		for (int i = 0; i <= num; i++) {
			res.add(max * i + min * (num - i));
		}
		return res.toString();
	}

	/*
	 * 2,4,4
	 */
	/**
	 * 1,2,3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(",");
		int taskA = Integer.parseInt(strs[0]);
		int taskB = Integer.parseInt(strs[1]);
		int num = Integer.parseInt(strs[2]);
		if (num == 0) {
			System.out.println("[]");
			return;
		}
		String res = totalTime(taskA, taskB, num);
		System.out.println(res);

	}

}
