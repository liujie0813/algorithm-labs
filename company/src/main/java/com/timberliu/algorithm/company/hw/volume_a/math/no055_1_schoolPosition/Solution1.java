package com.timberliu.algorithm.company.hw.volume_a.math.no055_1_schoolPosition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 55. 新学校选址
 *
 *  中位数原理
 *
 *  学校建在中位数点时，距离两边的距离和最短
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution1 {

	public static int schoolPosition(int[] arr) {
		Arrays.sort(arr);
		if (arr.length % 2 == 0) {
			return arr[(arr.length - 1) / 2];
		} else {
			return arr[arr.length / 2];
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = schoolPosition(arr);
		System.out.println(res);
	}

}
