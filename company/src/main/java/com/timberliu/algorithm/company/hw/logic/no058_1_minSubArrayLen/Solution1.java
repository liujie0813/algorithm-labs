package com.timberliu.algorithm.company.hw.logic.no058_1_minSubArrayLen;

import java.util.*;

/**
 * 58. 通信误码
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution1 {

	public static int minSubArrayLen(int[] arr) {
		// 误码，出现的下标
		Map<Integer, List<Integer>> map = new HashMap<>();
		// 最大次数
		int maxCnt = 0;
		for (int i = 0; i < arr.length; i++) {
			List<Integer> list = map.computeIfAbsent(arr[i], (a) -> new ArrayList<>());
			list.add(i);
			maxCnt = Math.max(maxCnt, list.size());
		}

		int res = Integer.MAX_VALUE;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() == maxCnt) {
				// 最后一次出现的位置 - 第一次出现的位置 + 1
				res = Math.min(res, list.get(list.size() - 1) - list.get(0) + 1);
			}
		}
		return res;
	}

	/**
	 * 7
	 * 1 2 2 4 2 1 1
	 */
	/*
	 * 5
	 * 1 2 2 4 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = minSubArrayLen(arr);
		System.out.println(res);
	}

}
