package com.timberliu.algorithm.company.hw.math.no024_1_middlePosOfArray;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 24. 计算数组的中心位置
 *
 *  大数相乘
 *
 * @author Timber
 * @date 2023/4/26
 */
public class Solution1 {

	public static int middlePosOfArray(int[] arr) {
		BigInteger fact = BigInteger.valueOf(1);
		for (int val : arr) {
			fact = fact.multiply(BigInteger.valueOf(val));
		}

		BigInteger left = BigInteger.valueOf(1);
		BigInteger right = fact.divide(BigInteger.valueOf(arr[0]));
		for (int i = 0; i < arr.length - 1; i++) {
			if (left.compareTo(right) == 0) {
				return i;
			}
			left = left.multiply(BigInteger.valueOf(arr[i]));
			right = right.divide(BigInteger.valueOf(arr[i + 1]));
		}
		return -1;
	}

	/**
	 * 2 5 3 6 5 6
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().split(" ");
		int[] arr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		int res = middlePosOfArray(arr);
		System.out.println(res);
	}

}
