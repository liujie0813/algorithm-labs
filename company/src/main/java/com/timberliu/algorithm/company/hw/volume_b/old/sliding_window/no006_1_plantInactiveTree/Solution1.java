package com.timberliu.algorithm.company.hw.volume_b.old.sliding_window.no006_1_plantInactiveTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 6. 补种未成活的胡杨树
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution1 {

	public static int maxContinuousTree(int n, int[] arr, int k) {
		int left = 1, right = arr[0] - 1;
		int max = 0;
		List<Integer> supplied = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (k <= 0 && !supplied.isEmpty()) {
				left = supplied.get(0) + 1;
				supplied.remove(0);
				k++;
			}
			if (k > 0) {
				if (i + 1 < arr.length) {
					right = arr[i + 1] - 1;
				} else {
					right = n;
				}
				supplied.add(arr[i]);
				k--;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

	public static int maxContinuousTree1(int n, int[] arr, int k) {
		int max = 0;
		for (int i = 0; i <= arr.length - k; i++) {
			int left = 1;
			int right = n;
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
		int res = maxContinuousTree1(n, arr, k);
		System.out.println(res);
	}

}
