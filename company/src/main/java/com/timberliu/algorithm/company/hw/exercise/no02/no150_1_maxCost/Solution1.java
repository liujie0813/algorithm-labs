package com.timberliu.algorithm.company.hw.exercise.no02.no150_1_maxCost;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liujie
 * @date 2023/6/15
 */

public class Solution1 {

	public static int maxCost(int[] arr, int limit) {
		Arrays.sort(arr);
		int n = arr.length;
		for (int i = n - 1; i > 1; i--) {
			for (int j = i - 1; j > 0; j--) {
				for (int k = j - 1; k >= 0; k--) {
					if (arr[i] + arr[j] + arr[k] > limit) {
						continue;
					}
					return arr[i] + arr[j] + arr[k];
				}
			}
		}
		return -1;
	}

	/*
	 * 23, 26, 36, 27
	 * 78
	 */
	/**
	 * 23, 30, 40
	 * 26
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(", ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}
		int limit = Integer.parseInt(scanner.nextLine());

		int res = maxCost(arr, limit);
		System.out.println(res);
	}

}
