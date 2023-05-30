package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no021_1_goldBoxIII;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 21. 阿里巴巴找黄金宝箱 III
 *
 * @author liujie
 * @date 2023/5/30
 */

public class Solution1 {

	public static int goldBoxIII(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				Integer index = map.get(arr[i]);
				if (i - index <= k) {
					return index;
				}
			} else {
				map.put(arr[i], i);
			}
		}
		return -1;
	}

	/*
	 * 6,3,1,6
	 * 3
	 */
	/**
	 * 5,6,7,5,6,7
	 * 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}
		int k = scanner.nextInt();
		int res = goldBoxIII(arr, k);
		System.out.println(res);
	}

}
