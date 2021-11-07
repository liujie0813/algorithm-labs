package com.timberliu.algorithm.leetcode.bit.no0191_1_numberOf1Bits;

/**
 * 191. 位1的个数
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution1 {

	public int hammingWeight(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += ((n >> i) & 1);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/number-of-1-bits/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.hammingWeight(11));

		System.out.println("----- 2 -----");
		System.out.println(solution1.hammingWeight(64));

		System.out.println("----- 3 -----");
		System.out.println(solution1.hammingWeight(-31));

	}

}
