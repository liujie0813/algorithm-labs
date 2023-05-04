package com.timberliu.algorithm.company.hw.logic.no009_1_minAdjustCount;

import java.util.Scanner;

/**
 * 9. 最小调整顺序次数
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static int minAdjustCount(String[] strs) {
		int queueSize = 0;
		boolean orderly = true;
		int res = 0;
		for (String op : strs) {
			if (op.startsWith("head add")) {
				if (queueSize > 0 && orderly) {
					orderly = false;
				}
				queueSize++;
			} else if (op.startsWith("tail add")) {
				queueSize++;
			} else if (op.startsWith("remove")) {
				if (queueSize == 0) {
					continue;
				}
				if (!orderly) {
					res++;
					orderly = true;
				}
				queueSize--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] strs = new String[2 * n];
		for (int i = 0; i < 2 * n; i++) {
			strs[i] = scanner.nextLine();
		}
		int res = minAdjustCount(strs);
		System.out.println(res);
	}

}
