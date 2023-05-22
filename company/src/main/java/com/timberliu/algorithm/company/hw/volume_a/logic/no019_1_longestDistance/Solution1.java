package com.timberliu.algorithm.company.hw.volume_a.logic.no019_1_longestDistance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 19. 积木最远距离
 *
 * @author liujie
 * @date 2023/4/27
 */

public class Solution1 {

	public static int maxDistance(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = -1;
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				res = Math.max(res, i - map.get(arr[i]));
			}
		}
		return res;
	}

	/**
	 * 5
	 * 1
	 * 2
	 * 3
	 * 1
	 * 4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int res = maxDistance(arr);
		System.out.println(res);
	}

}
