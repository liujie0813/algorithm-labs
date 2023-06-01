package com.timberliu.algorithm.company.hw.volume_b.old.bit.no003_1_distributeApple;

import java.util.Scanner;

/**
 * 3. 分苹果
 *
 *  不进位的二进制积分 == 异或
 *
 * @author liujie
 * @date 2023/6/1
 */

public class Solution1 {

	/**
	 * 3 5 6
	 *
	 * 3
	 * 5^6 = 3
	 */
	public static int distribute(int[] arr) {
		int aWeight = 0;
		int bWeight = 0;
		int min = Integer.MAX_VALUE;
		for (int val : arr) {
			aWeight ^= val;
			bWeight += val;
			min = Math.min(min, val);
		}
		if (aWeight == 0) {
			return bWeight - min;
		} else {
			return -1;
		}
	}

	/**
	 * 3
	 * 3 5 6
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		int res = distribute(arr);
		System.out.println(res);
	}

}
