package com.timberliu.algorithm.company.hw.logic.no062_1_longestDistance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 62. 相同数字的积木游戏
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static int longestDistance(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = -1;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				res = Math.max(res, i - map.get(arr[i]));
			} else {
				map.put(arr[i], i);
			}
		}
		return res;
	}

	/*
	 * 5
	 * 1 2 3 1 4
	 */
	/**
	 * 2
	 * 1 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int res = longestDistance(arr);
		System.out.println(res);
	}

}
