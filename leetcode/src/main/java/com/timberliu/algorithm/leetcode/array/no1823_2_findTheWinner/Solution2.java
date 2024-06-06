package com.timberliu.algorithm.leetcode.array.no1823_2_findTheWinner;

/**
 * 1823. 找出游戏的获胜者
 *
 *  findTheWinner(n - 1, k) 剩余 n-1 个人继续游戏的最终幸存者编号
 *     剩余 n-1 是从 k+1 作为编号 1 重新开始
 *     把 n-1 个人的编号映射回 n 个人时的编号，即 +k
 *
 * @author liujie
 * @date 2024/6/5
 */

public class Solution2 {

	public int findTheWinner(int n, int k) {
		if (n == 1) {
			return 1;
		}
		int res = (findTheWinner(n - 1, k) + k) % n;
		return res == 0 ? n : res;
	}

	public static void main(String[] args) {
		Solution2 solution1 = new Solution2();
		int res1 = solution1.findTheWinner(5, 2);
		System.out.println(res1);

		int res2 = solution1.findTheWinner(6, 5);
		System.out.println(res2);
	}

}
