package com.timberliu.algorithm.company.hw.volume_b.logic.new_no012_1_mockMsgQueue;

import java.util.*;

/**
 * 12. 模拟消息队列
 *
 * @author liujie
 * @date 2023/5/29
 */

public class Solution1 {

	public static String mockMsgQueue(int[][] producers, int[][] consumers) {
		Arrays.sort(producers, Comparator.comparingInt(a -> a[0]));
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < consumers.length; i++) {
			res.add(new ArrayList<>());
		}

		for (int[] producer : producers) {
			int produceTime = producer[0];
			int produceContent = producer[1];
			// 优先级由高到低
			for (int j = consumers.length - 1; j >= 0; j--) {
				int start = consumers[j][0];
				int end = consumers[j][1];
				if (start <= produceTime && produceTime < end) {
					res.get(j).add(produceContent);
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (List<Integer> list : res) {
			if (list.isEmpty()) {
				sb.append("-1");
			} else {
				for (Integer a : list) {
					sb.append(a).append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/*
	 * 2 22 1 11 4 44 5 55 3 33
	 * 1 7 2 3
	 */
	/**
	 * 5 64 11 64 9 97
	 * 9 11 4 9
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] first = scanner.nextLine().split(" ");
		int n = first.length / 2;
		int[][] producer = new int[n][2];
		int index = 0;
		for (int i = 0; i < n; i++) {
			producer[i][0] = Integer.parseInt(first[index++]);
			producer[i][1] = Integer.parseInt(first[index++]);
		}
		String[] second = scanner.nextLine().split(" ");
		int m = second.length / 2;
		int[][] consumer = new int[m][2];
		int index1 = 0;
		for (int i = 0; i < m; i++) {
			consumer[i][0] = Integer.parseInt(second[index1++]);
			consumer[i][1] = Integer.parseInt(second[index1++]);
		}
		String res = mockMsgQueue(producer, consumer);
		System.out.println(res);
	}

}
