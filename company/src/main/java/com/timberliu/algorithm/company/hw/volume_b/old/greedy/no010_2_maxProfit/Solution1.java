package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no010_2_maxProfit;

import java.util.Scanner;

/**
 * 10. 最大股票收益
 *
 * @author liujie
 * @date 2023/6/2
 */

public class Solution1 {

	// 2 21 28 6 56
	public static int maxProfit(int[] arr) {
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				res += arr[i] - arr[i - 1];
			}
		}
		return res;
	}

	/**
	 * 2Y 3S 4S 6Y 8S
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			int num = Integer.parseInt(splits[i].substring(0, splits[i].length() - 1));
			String str = splits[i].substring(splits[i].length() - 1);
			if ("Y".equals(str)) {
				arr[i] = num;
			} else {
				arr[i] = 7 * num;
			}
		}
		int res = maxProfit(arr);
		System.out.println(res);
	}

}
