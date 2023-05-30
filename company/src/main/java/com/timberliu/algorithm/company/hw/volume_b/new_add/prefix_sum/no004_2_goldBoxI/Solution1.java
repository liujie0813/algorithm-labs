package com.timberliu.algorithm.company.hw.volume_b.new_add.prefix_sum.no004_2_goldBoxI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4. 阿里巴巴找黄金宝箱
 *
 * @author liujie
 * @date 2023/5/23
 */

public class Solution1 {

	public static int firstBox(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		int left = 0, right = sum;
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				left += arr[i - 1];
			}
			right -= arr[i];
			if (left == right) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * 2,5,-1,8,6
	 */
	/*
	 * 8,9
	 */
	/**
	 * 11
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int[] arr = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
		int res = firstBox(arr);
		System.out.println(res);
	}

}
