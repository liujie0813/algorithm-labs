package com.timberliu.algorithm.company.hw.volume_a.stack_queue.no074_2_maxNumAfterDeleteElement;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 74. 删除重复数字后的最大数字
 *   每个数字最多出现两次
 *
 * @author liujie
 * @date 2023/4/21
 */

public class Solution1 {

	public static String maxNum(String str) {
		// 字符可用个数
		int[] unused = new int[10];
		for (int i = 0; i < str.length(); i++) {
			unused[str.charAt(i) - '0']++;
		}
		// 字符已经保留的个数
		int[] reserve = new int[10];

		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if (reserve[num] == 2) {
				// 如果已经保留 2 个了，删除当前遍历的字符，并且可用的个数--
				unused[num]--;
				continue;
			}

			while (!stack.isEmpty()) {
				Integer peek = stack.peek();
				// 如果已经保留的 + 可用的 > 2（不包括已删除的）
				if (peek < num && reserve[peek] + unused[peek] > 2) {
					stack.pop();
					reserve[peek]--;
				} else {
					break;
				}
			}

			stack.push(num);
			reserve[num]++;
			unused[num]--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		return sb.toString();
	}

	/*
	 * 5445795045
	 */
	/**
	 * 34533
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String res = maxNum(str);
		System.out.println(res);
	}

}
