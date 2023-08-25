package com.timberliu.algorithm.company.hw.volume_b.old.sliding_window.no006_1_plantInactiveTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 6. 补种未成活的胡杨树
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution2 {

	/**
	 * @param total 总种植数量
	 * @param arr 未成活胡杨编号数组
	 * @param k 最多可补种数量
	 *
	 * @return 最多的连续胡杨树
	 */
	public static int maxContinuousTree(int total, int[] arr, int k) {
		int max = 0;
		for (int i = 0; i <= arr.length - k; i++) {
			int left = 1, right = total;
			if (i > 0) {
				left = arr[i - 1] + 1;
			}
			if (i + k < arr.length) {
				right = arr[i + k] - 1;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

	/*
	 * 5
	 * 2
	 * 2 4
	 * 1
	 */
	/**
	 * 10
	 * 3
	 * 2 4 7
	 * 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = scanner.nextInt();
		}
		int k = scanner.nextInt();
		int res = maxContinuousTree(n, arr, k);
		System.out.println(res);
	}

}
