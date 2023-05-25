package com.timberliu.algorithm.company.hw.volume_b.logic.new_no997_1_pathIsNormal;

import java.util.*;

/**
 * 报文通路
 *
 * @author liujie
 * @date 2023/5/25
 */

public class Soltion1 {

	public static boolean pathIsNormal(int[][] arr) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] val : arr) {
			Set<Integer> set = map.computeIfAbsent(val[0], (k) -> new HashSet<>());
			set.add(val[1]);
		}

		for (int[] val : arr) {
			if (!map.get(val[1]).contains(val[0])) {
				return false;
			}
		}
		return true;
	}

	/*
	 * 5
	 * 1 2
	 * 2 3
	 * 3 2
	 * 1 2
	 * 2 1
	 */
	/**
	 * 3
	 * 1 3
	 * 3 2
	 * 2 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}

		boolean res = pathIsNormal(arr);
		System.out.println(res);
	}

}
