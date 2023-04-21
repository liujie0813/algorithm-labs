package com.timberliu.algorithm.company.hw.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 74. 删除重复数字后的最大数字
 *
 * @author liujie
 * @date 2023/4/21
 */

public class no074_2_maxNumAfterDeleteElement {

	public static int maxNum(String str) {
		int[] unused = new int[10];
		for (int i = 0; i < str.length(); i++) {
			unused[str.charAt(i) - '0']++;
		}
		int[] used = new int[10];

		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if (stack.isEmpty() || num <= stack.peek()) {
				stack.push(num);
				used[num]++;
				unused[num]--;
			} else {

			}

		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

	}

}
