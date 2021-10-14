package com.timberliu.algorithm.leetcode.dp.bag.no0279_2_perfectSquares;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 *
 *  问题转换为：给定若干个数字，每个数字可以选择多次，求凑出目标值 n 所需要用到的 最少数字个数
 *
 *  状态定义：f[i][j] 考虑前 i 个数字，凑出数字总和为 j 所需要用到的最少数字数量
 *
 *  状态转移方程：f[i][j] = min(f[i - 1][j - k*t] + k), 0 <= k*t <= j
 *
 *  时间复杂度：有 O(n * √n) 个状态，每个状态遍历 n 次，整体复杂度为 O(n^2 * √n)
 *  空间复杂度：O(n * √n)
 *
 * @author Timber
 * @date 2021/10/14
 */
public class Solution1 {

	int INF = -1;

	public int numSquares(int n) {
		List<Integer> list = new ArrayList<>();
		int idx = 1;
		while (idx * idx <= n) {
			list.add(idx * idx);
			idx++;
		}

		int len = list.size();
		int[][] dp = new int[len][n + 1];
		// 第一个数
		for (int j = 0; j <= n; j++) {
			Integer t = list.get(0);
			int k = j / t;
			// 只有容量为 第一个数的 整数倍 时才能凑出
			if (k * t == j) {
				dp[0][j] = k;
			} else {
				dp[0][j] = INF;
			}
		}

		// 其他数
		for (int i = 1; i < len; i++) {
			Integer t = list.get(i);
			for (int j = 0; j <= n; j++) {
				// 不选第 i 个数
				dp[i][j] = dp[i - 1][j];
				// 选第 i 个数，选 k 次
				for (int k = 1; k * t <= j; k++) {
					// 能够选 k 个 t 的前提是：j - k * t 也能够被凑出
					if (dp[i - 1][j - k * t] != INF) {
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * t] + k);
					}
				}
			}
		}

		return dp[len - 1][n];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/perfect-squares/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.numSquares(12));

		System.out.println("----- 2 -----");
		System.out.println(solution1.numSquares(13));

	}

}
