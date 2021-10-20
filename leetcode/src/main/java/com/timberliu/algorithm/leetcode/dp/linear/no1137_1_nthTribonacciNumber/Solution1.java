package com.timberliu.algorithm.leetcode.dp.linear.no1137_1_nthTribonacciNumber;

/**
 * 1137. 第 N 个泰波那契数
 *
 * @author Timber
 * @date 2021/10/20
 */
public class Solution1 {

	public int tribonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n <= 2) {
			return 1;
		}
		int first = 0, second = 1, third = 1, res = 0;
		for (int i = 3; i <= n; i++) {
			res = first + second + third;
			first = second;
			second = third;
			third = res;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/n-th-tribonacci-number/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.tribonacci(4));

		System.out.println("----- 2 -----");
		System.out.println(solution1.tribonacci(25));

	}

}
