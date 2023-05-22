package com.timberliu.algorithm.company.hw.volume_a.sliding_window.no008_1_mostColorCarNum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 8. 最多颜色的车辆
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static int maxColorCarNum(int[] arr, int m) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int cur = arr[i];
			map.put(cur, map.getOrDefault(cur, 0) + 1);
			// 每次新增的字符可能突破最大值
			res = Math.max(res, map.get(cur));
			if (i >= m - 1) {
				int prev = arr[i - m + 1];
				map.put(prev, map.get(prev) - 1);
			}
		}
		return res;
	}

	/*
	 * 0 2 2 2 4 2
	 * 3
	 */
	/**
	 *
	 * 0 1 2 1
	 * 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int m = scanner.nextInt();
		int res = maxColorCarNum(arr, m);
		System.out.println(res);
	}

}
