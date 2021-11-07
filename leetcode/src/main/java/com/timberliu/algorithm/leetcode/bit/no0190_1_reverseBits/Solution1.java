package com.timberliu.algorithm.leetcode.bit.no0190_1_reverseBits;

/**
 * 190. 颠倒二进制位
 *
 * @author Timber
 * @date 2021/11/4
 */
public class Solution1 {

	public static int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int t = (n >> i) & 1;
			if (t != 0) {
				res |= (1 << (31 - i));
			}
		}
		return res;
	}

	public static int reverseBits1(int n) {
		int res = 0;
		int cnt = 32;
		while (cnt-- > 0) {
			res <<= 1;
			res += (n & 1);
			n >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/reverse-bits/ -----");
		System.out.println("----- 1 -----");
		System.out.println(reverseBits(964176192));

		System.out.println("----- 2 -----");
		System.out.println(reverseBits1(-3));

	}

}
