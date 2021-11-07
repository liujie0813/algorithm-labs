package com.timberliu.algorithm.leetcode.bit.no0231_1_powerOfTwo;

/**
 * 231. 2 的幂
 *
 * @author Timber
 * @date 2021/11/5
 */
public class Solution1 {

	public static boolean isPowerOfTwo(int n) {
		return n >= 0 && (n & n - 1) == 0;
	}

	public static boolean isPowerOfTwo1(int n) {
		return n >= 0 && (n & -n) == n;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/power-of-two/ -----");
		System.out.println("----- 1 -----");
		System.out.println(isPowerOfTwo1(1));

		System.out.println("----- 2 -----");
		System.out.println(isPowerOfTwo1(4));

		System.out.println("----- 3 -----");
		System.out.println(isPowerOfTwo1(6));

	}

}
