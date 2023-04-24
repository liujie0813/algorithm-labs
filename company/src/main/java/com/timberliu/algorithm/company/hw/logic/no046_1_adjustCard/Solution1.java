package com.timberliu.algorithm.company.hw.logic.no046_1_adjustCard;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 46. 梳理扑克牌
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static int[] adjustCard(int[] arr) {
		// <牌面，次数>
		Map<Integer, Integer> map = new HashMap<>();
		for (int val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		List<int[]> list = map.entrySet().stream().map((entry) -> new int[]{entry.getKey(), entry.getValue()}).sorted((a, b) -> {
			if (a[1] == b[1]) {
				// 次数相同的，按值比较，值大的在前
				return b[0] - a[0];
			}
			// 优先按次数比较，，次数大的在前
			return b[1] - a[1];
		}).collect(Collectors.toList());

		int[] res = new int[arr.length];
		int index = 0;
		// 单张牌
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < list.size(); i++) {
			int[] entry = list.get(i);
			int val = entry[0], cnt = entry[1];
			// 特殊情况
			// 3+3
			if (i > 0 && list.get(i - 1)[1] == 3 && cnt == 3) {
				pq.offer(val);
				cnt = 2;
				// 拆出一个单张，次数变为 2
				list.get(i - 1)[1] = 2;
			}
			// 单张
			if (cnt == 1 && !pq.isEmpty()) {
				while (!pq.isEmpty() && pq.peek() > val) {
					res[index++] = pq.poll();
				}
			}
			for (int j = 0; j < cnt; j++) {
				res[index++] = val;
			}
		}
		while (!pq.isEmpty()) {
			res[index++] = pq.poll();
		}
		return res;
	}

	/*
	 * 4 4 2 1 2 1 3 3 3 4
	 */
	/**
	 * 5 5 5 5 4 4 4 4 4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		int[] res = adjustCard(arr);
		PrintUtils.printIntArrayV2(res);
	}

}
