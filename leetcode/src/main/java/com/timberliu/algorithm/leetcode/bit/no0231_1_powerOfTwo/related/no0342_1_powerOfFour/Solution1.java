package com.timberliu.algorithm.leetcode.bit.no0231_1_powerOfTwo.related.no0342_1_powerOfFour;

/**
 * 342. 4的幂
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution1 {

	public boolean isPowerOfFour(int n) {
		if (n <= 0) {
			return false;
		}
		int a = (int) Math.sqrt(n);
		return a * a == n && (a & -a) == a;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/power-of-four/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.isPowerOfFour(16));

		System.out.println("----- 2 -----");
		System.out.println(solution1.isPowerOfFour(5));

		System.out.println("----- 3 -----");
		System.out.println(solution1.isPowerOfFour(1));

	}
}
