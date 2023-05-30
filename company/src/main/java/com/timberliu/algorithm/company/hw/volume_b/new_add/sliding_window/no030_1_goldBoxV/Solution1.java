package com.timberliu.algorithm.company.hw.volume_b.new_add.sliding_window.no030_1_goldBoxV;

import java.util.Scanner;

/**
 * 阿里巴巴找黄金宝箱 V
 *
 * @author liujie
 * @date 2023/5/29
 */

public class Solution1 {

	public static int maxVal(int[] arr, int k) {
		int max = -1;
		int sum = 0;
		int left = 0, right = 0;
		while (right < arr.length) {
			sum += arr[right];
			if (right >= k - 1) {
				max = Math.max(max, sum);
				sum -= arr[left];
				left++;
			}
			right++;
		}
		return max;
	}

	/**
	 * 2,10,-3,-8,40,5
	 * 4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}
		int k = Integer.parseInt(scanner.nextLine());
		int res = maxVal(arr, k);
		System.out.println(res);
	}

}
