package com.timberliu.algorithm.leetcode.bit.no0693_1_binaryNumberWithAlternatingBits;

/**
 * 693. 交替位二进制数
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution1 {

	public boolean hasAlternatingBits(int n) {
		int lastBit = n & 1;
		int index = 0;
		while (n != 0) {
			if (index % 2 == 0) {
				if ((n & 1) != lastBit) {
					return false;
				}
			} else {
				if ((n & 1) == lastBit) {
					return false;
				}
			}
			n >>= 1;
			index++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/binary-number-with-alternating-bits/ -----");
		Solution1 solution1 = new Solution1();
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
