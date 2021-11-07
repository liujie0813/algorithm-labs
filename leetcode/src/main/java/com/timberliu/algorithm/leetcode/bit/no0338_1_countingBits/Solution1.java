package com.timberliu.algorithm.leetcode.bit.no0338_1_countingBits;

/**
 * 338. 比特位计数
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution1 {

	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			// i & (i - 1) 去掉最右边的 1（如果有的话）
			res[i] = res[i & (i - 1)] + 1;
		}
		return res;
	}

	public int[] countBits1(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			// i >> 1 去掉最低位
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/counting-bits/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		int[] ints1 = solution1.countBits(2);
		for (int i : ints1) {
			System.out.print(i + ", ");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		int[] ints2 = solution1.countBits1(5);
		for (int i : ints2) {
			System.out.print(i + ", ");
		}
		System.out.println();

	}

}
