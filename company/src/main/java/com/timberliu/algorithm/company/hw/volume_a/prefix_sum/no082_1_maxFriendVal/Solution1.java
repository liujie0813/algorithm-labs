package com.timberliu.algorithm.company.hw.volume_a.prefix_sum.no082_1_maxFriendVal;

import java.util.Scanner;

/**
 * 82. 统计友好度最大值
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution1 {

	public static int maxFriendVal(int[] arr) {
		//      1 1 0 1 2 1 0
		// left 0 1 2 0 1 0 1 0

		//         1 1 0 1 2 1 0
		// right 2 1 0 1 0 1 0 0
		int[] leftPrefixSum = new int[arr.length + 1];
		for (int i = 1; i <= arr.length; i++) {
			if (arr[i - 1] == 1) {
				leftPrefixSum[i] = leftPrefixSum[i - 1] + 1;
			}
		}
		int[] rightPrefixSum = new int[arr.length + 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 1) {
				rightPrefixSum[i] = rightPrefixSum[i + 1] + 1;
			}
		}
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				res = Math.max(res, leftPrefixSum[i] + rightPrefixSum[i + 1]);
			}
		}
		return res;
	}

	/*
	 * 0 1 0
	 */
	/**
	 * 1 1 0 1 2 1 0
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		int[] arr = new int[line.length];
		for (int i = 0; i < line.length; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		int res = maxFriendVal(arr);
		System.out.println(res);
	}

}
