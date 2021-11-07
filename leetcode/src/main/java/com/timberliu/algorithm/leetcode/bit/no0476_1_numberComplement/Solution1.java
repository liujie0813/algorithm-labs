package com.timberliu.algorithm.leetcode.bit.no0476_1_numberComplement;

/**
 * 476. 数字的补数
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution1 {

	public int findComplement(int num) {
		// 第一个 1 的位置
		int firstOne = -1;
		for (int i = 31; i >= 0; i--) {
			if (((num >> i) & 1) != 0) {
				firstOne = i;
				break;
			}
		}
		// 从低位到 firstOne 位，逐位取反
		int res = 0;
		for (int i = 0; i < firstOne; i++) {
			// 位置为 0，取反，求或
			if (((num >> i) & 1) == 0) {
				res |= (1 << i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/number-complement/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.findComplement(1));

		System.out.println("----- 5 -----");
		System.out.println(solution1.findComplement(5));

	}

}
