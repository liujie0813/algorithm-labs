package com.timberliu.algorithm.company.hw.volume_b.new_add.math.no028_1_dataClassify;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 28. 数据分类
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution1 {

	public static int dataClassify(int[] arr, int c, int b) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int first = arr[i] & 0xff;
			int second = (arr[i] >> 8) & 0xff;
			int third = (arr[i] >> 16) & 0xff;
			int forth = (arr[i] >> 24) & 0xff;
			int val = first + second + third + forth;
			int modVal = val % b;
			if (modVal < c) {
				map.put(modVal, map.getOrDefault(modVal, 0) + 1);
			}
		}
		int max = 0;
		for (Integer value : map.values()) {
			max = Math.max(max, value);
		}
		return max;
	}

	/*
	 * 3 4 256 257 258 259 260 261 262 263 264 265
	 */
	/**
	 * 1 4 256 257 258 259 260 261 262 263 264 265
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int c = scanner.nextInt();
		int b = scanner.nextInt();
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = scanner.nextInt();
		}
		int res = dataClassify(arr, c, b);
		System.out.println(res);
	}

}
