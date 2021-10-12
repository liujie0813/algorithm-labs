package com.timberliu.algorithm.leetcode.dp.path.no0062_2_uniquePaths;

import java.util.Arrays;

/**
 * @author Timber
 * @date 2021/10/12
 */
public class Solution2 {

	public static int uniquePaths(int m, int n) {
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				arr[j] += arr[j - 1];
			}
		}
		return arr[n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/unique-paths/ -----");
		System.out.println("----- 1 -----");
		System.out.println(uniquePaths(3, 7));

		System.out.println("----- 2 -----");
		System.out.println(uniquePaths(3, 2));

		System.out.println("----- 3 -----");
		System.out.println(uniquePaths(7, 3));

		System.out.println("----- 3 -----");
		System.out.println(uniquePaths(3, 3));

	}

}
