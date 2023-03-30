package com.timberliu.algorithm.leetcode.dp.bag.bagComplete.no0279_2_perfectSquares;

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
 *  一维优化  f[j] = min(f[j], f[j - t] + 1)
 *
 *  时间复杂度：O(n * √n)
 *  空间复杂度：O(n)
 *
 * @author Timber
 * @date 2021/10/14
 */
public class Solution2 {

	int INF = -1;

	public int numSquares(int n) {
		List<Integer> list = new ArrayList<>();
		int idx = 1;
		while (idx * idx <= n) {
			list.add(idx * idx);
			idx++;
		}

		int len = list.size();
		int[] dp = new int[n + 1];
		// 第一个数
		for (int j = 0; j <= n; j++) {
			Integer t = list.get(0);
			int k = j / t;
			// 只有容量为 第一个数的 整数倍 时才能凑出
			if (k * t == j) {
				dp[j] = k;
			} else {
				dp[j] = INF;
			}
		}

		// 其他数
		for (int i = 1; i < len; i++) {
			Integer t = list.get(i);
			for (int j = t; j <= n; j++) {
				// 不选第 i 个数
//				dp[j] = dp[j];
				// 选第 i 个数
				if (dp[j - t] != INF) {
					dp[j] = Math.min(dp[j], dp[j - t] + 1);
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/perfect-squares/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		System.out.println(solution1.numSquares(12));

		System.out.println("----- 2 -----");
		System.out.println(solution1.numSquares(13));

	}

}
