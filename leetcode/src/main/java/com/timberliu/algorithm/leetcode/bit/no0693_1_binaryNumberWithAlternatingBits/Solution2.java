package com.timberliu.algorithm.leetcode.bit.no0693_1_binaryNumberWithAlternatingBits;

/**
 * 693. 交替位二进制数
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution2 {

	public boolean hasAlternatingBits(int n) {
		int num = n ^ (n >> 1);
		return (num & (num + 1)) == 0;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/binary-number-with-alternating-bits/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.hasAlternatingBits(5));

		System.out.println("----- 2 -----");
		System.out.println(solution1.hasAlternatingBits(7));

		System.out.println("----- 3 -----");
		System.out.println(solution1.hasAlternatingBits(11));

		System.out.println("----- 4 -----");
		System.out.println(solution1.hasAlternatingBits(10));

		System.out.println("----- 5 -----");
		System.out.println(solution1.hasAlternatingBits(3));

	}

}
