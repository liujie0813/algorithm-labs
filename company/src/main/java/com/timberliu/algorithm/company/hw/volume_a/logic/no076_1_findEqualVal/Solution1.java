package com.timberliu.algorithm.company.hw.volume_a.logic.no076_1_findEqualVal;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 76. 找等值元素
 *
 *  100 * 100 * 100
 *
 * @author liujie
 * @date 2023/4/21
 */

public class Solution1 {

	public static int[][] findEqualVal(int[][] arr, int m, int n) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				List<int[]> list = map.computeIfAbsent(arr[i][j], (val) -> new ArrayList<>());
				list.add(new int[]{i, j});
			}
		}

		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int min = Integer.MAX_VALUE;
				List<int[]> indexs = map.get(arr[i][j]);
				for (int[] index : indexs) {
					if (i == index[0] && j == index[1]) {
						continue;
					}
					min = Math.min(min, Math.abs(i - index[0]) + Math.abs(j - index[1]));
				}
				res[i][j] = min == Integer.MAX_VALUE ? -1 : min;
			}
		}
		return res;
	}

	/**
	 * 3
	 * 5
	 * 0 3 5 4 2
	 * 2 5 7 8 3
	 * 2 5 4 2 4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		int[][] res = findEqualVal(arr, m, n);
		PrintUtils.printIntArrayV2(res);

	}

}
