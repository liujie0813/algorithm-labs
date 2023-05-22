package com.timberliu.algorithm.company.hw.volume_a.math.no064_2_diffNum;

import java.util.Scanner;

/**
 * 64. 二进制差异数
 *
 *  n 为 O(n^5)：暴力运算，双层循环+位运算，会超时
 *
 *  由于要求差异值大于相似值，二进制表示，最高位的 1 位数不同时，才满足
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static int diffNum(int[] arr) {
		int[] highBit = new int[32];
		for (int val : arr) {
			String bin = Integer.toBinaryString(val);
			highBit[bin.length()]++;
		}

		int res = 0;
		for (int i = 0; i < highBit.length; i++) {
			for (int j = i + 1; j < highBit.length; j++) {
				res += highBit[i] * highBit[j];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = diffNum(arr);
		System.out.println(res);
	}

}
