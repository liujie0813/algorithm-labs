package com.timberliu.algorithm.company.hw.volume_a.logic.no038_1_findClosestXNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 38. 预订酒店
 *
 * @author liujie
 * @date 2023/4/25
 */

public class Solution1 {

	public static int[] findClosestXNum(int[] arr, int k, int x) {
		int[][] prices = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			prices[i][0] = arr[i];
			prices[i][1] = Math.abs(arr[i] - x);
		}
		// 优先按照差价排序，差价相同再按价格排序
		Arrays.sort(prices, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		int[] res = new int[k];
		for (int i = 0; i < k && i < prices.length; i++) {
			res[i] = prices[i][0];
		}
		// 价格从低到高
		Arrays.sort(res);
		return res;
	}

	/*
	 * 10 5 6
	 * 1 10 2 9 3 8 4 7 5 6
	 */
	/**
	 * 6 3 1000
	 * 30 30 200 500 70 300
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int x = scanner.nextInt();
		scanner.nextLine();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int[] res = findClosestXNum(arr, k, x);
		for (int val : res) {
			System.out.print(val + " ");
		}
	}

}
