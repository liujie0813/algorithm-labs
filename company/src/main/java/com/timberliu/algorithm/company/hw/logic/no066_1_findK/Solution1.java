package com.timberliu.algorithm.company.hw.logic.no066_1_findK;

import java.util.Scanner;

/**
 * 66. 简单的像素曝光
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static int findK(int[] arr) {
		double minDiff = Integer.MAX_VALUE;
		int res = 0;
		for (int k = -127; k <= 128; k++) {
			double sum = 0;
			for (int val : arr) {
				int newVal = val + k;
				sum += Math.min(255, Math.max(0, newVal));
			}
			double diff = Math.abs(sum / arr.length - 128);
			if (diff < minDiff) {
				minDiff = diff;
				res = k;
			} else if (diff - minDiff <= 0.00001) {
				res = Math.min(res, k);
			}
		}
		return res;
	}

	/*
	 * 0 0 0 0
	 */
	/**
	 * 129 130 129 130
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int res = findK(arr);
		System.out.println(res);
	}

}
