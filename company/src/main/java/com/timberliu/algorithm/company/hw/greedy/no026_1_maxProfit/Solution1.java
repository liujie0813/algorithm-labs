package com.timberliu.algorithm.company.hw.greedy.no026_1_maxProfit;

import java.util.Scanner;

/**
 * 26. 最大利润
 *
 *  商品可以反复买卖
 *
 * @author Timber
 * @date 2023/4/26
 */
public class Solution1 {

	public static int maxProfit(int[][] arr, int[] holds) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int max = 0;
			for (int j = 1; j < arr[0].length; j++) {
				max += Math.max(0, arr[i][j] - arr[i][j - 1]);
			}
			res += max * holds[i];
		}
		return res;
	}

	/*
	 * 3
	 * 3
	 * 4 5 6
	 * 1 2 3
	 * 4 3 2
	 * 1 5 3
	 */
	/**
	 * 1
	 * 1
	 * 1
	 * 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int productNum = scanner.nextInt();
		int days = scanner.nextInt();
		int[] holds = new int[productNum];
		for (int i = 0; i < productNum; i++) {
			holds[i] = scanner.nextInt();
		}
		int[][] arr = new int[productNum][days];
		for (int i = 0; i < productNum; i++) {
			for (int j = 0; j < days; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		int res = maxProfit(arr, holds);
		System.out.println(res);
	}

}
