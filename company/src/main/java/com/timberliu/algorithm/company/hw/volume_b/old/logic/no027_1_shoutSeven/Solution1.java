package com.timberliu.algorithm.company.hw.volume_b.old.logic.no027_1_shoutSeven;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.Scanner;

/**
 * 27. 喊七的次数重排
 *
 * @author Timber
 * @date 2023/6/4
 */
public class Solution1 {

	public static int[] shoutSeven(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		int[] res = new int[arr.length];
		int index = 1;
		while (sum > 0) {
			if (index % 7 == 0 || index % 10 == 7) {
				res[(index - 1) % arr.length]++;
				sum--;
			}
			index++;
		}
		return res;
	}

	/*
	 * 0 1 0
	 */
	/**
	 * 0 0 0 2 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		int[] res = shoutSeven(arr);
		PrintUtils.printIntArrayV2(res);
	}

}
