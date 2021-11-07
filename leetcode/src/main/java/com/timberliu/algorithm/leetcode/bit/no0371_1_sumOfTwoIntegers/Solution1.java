package com.timberliu.algorithm.leetcode.bit.no0371_1_sumOfTwoIntegers;

/**
 * 371. 两整数之和
 *
 * @author Timber
 * @date 2021/11/7
 */
public class Solution1 {

	public int getSum(int a, int b) {
		int res = 0, t = 0;
		// 从低位到高位
		for (int i = 0; i < 32; i++) {
			int u1 = (a >> i) & 1;
			int u2 = (b >> i) & 1;
			if (u1 == 1 && u2 == 1) {
				// 进位为 1，当前位取决于  前一位的进位
				res |= (t << i);
				t = 1;
			} else if (u1 == 1 || u2 == 1) {
				// 前一位的进位为 1，当前有一位为 1，则当前位为 0，进位为 1
				// 前一位的进位为 0，当前有一位为 1，则当前位为 1，进位为 0
				// 进位不变，当前位取决于  前一位的进位（与 1 异或）
				res |= ((1 ^ t) << i);
			} else {
				// 进位为 0，当前位取决于  前一位的进位
				res |= (t << i);
				t = 0;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/sum-of-two-integers/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.getSum(1, 2));

		System.out.println("----- 2 -----");
		System.out.println(solution1.getSum(2, 3));

	}

}
