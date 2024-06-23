package com.timberliu.algorithm.leetcode.string.no0132_3_palindromePartitionII;

/**
 * 132. 分割回文串 II
 *
 *  最小分割次数
 *
 *  res[i] 表示以 i 为右端点的若干回文串的最小分割次数
 *         而 l 左端点可能有多个，所有方案中取最小的
 *
 * @author Timber
 * @date 2023/7/1
 */
public class Solution1 {

	public int minCut(String s) {
		int n = s.length();
		// dp[i][j] 判断区间是否为回文串
		boolean[][] dp = new boolean[n][n];
		for (int left = n - 1; left >= 0; left--) {
			for (int right = left; right < n; right++) {
				if (s.charAt(left) == s.charAt(right) && (left + 1 > right - 1 || dp[left + 1][right - 1])) {
					dp[left][right] = true;
				}
			}
		}

		int[] res = new int[n];
		for (int r = 0; r < n; r++) {
			// 0到r为回文串，分割次数为 0
			if (dp[0][r]) {
				res[r] = 0;
			} else {
				int min = Integer.MAX_VALUE;
				// [l, r] 为回文串，则从 l 分割
				for (int l = 1; l <= r; l++) {
					if (dp[l][r]) {
						min = Math.min(min, res[l - 1] + 1);
					}
				}
				res[r] = min;
			}
		}
		return res[n - 1];
	}

}
