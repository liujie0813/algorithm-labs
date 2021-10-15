package com.timberliu.algorithm.leetcode.dp.bag.no0474_2_onesAndZeroes;

/**
 * 474. 一和零
 *
 *  状态定义：f[k][i][j] 考虑前 i 件物品，在数字 1 容量不超过 i，数字 0 容量不超过 0 的条件下的最大价值
 *          （每个字符串的价值为 1）
 *
 *  状态转移方程：f[k][i][j] = max(f[k - 1][i][j], f[k - 1][i - cnt[k][0]][j - cnt[k][1]] + 1)
 *             cnt 数组记录的是字符串中出现的 0 1 数量
 *
 * @author liujie
 * @date 2021/10/15
 */

public class Solution1 {

	public static int findMaxForm(String[] strs, int m, int n) {
		int len = strs.length;
		int[][] cnt = new int[len][2];
		for (int i = 0; i < len; i++) {
			int zero = 0, one = 0;
			for (char c : strs[i].toCharArray()) {
				if (c == '0') {
					zero++;
				} else {
					one++;
				}
			}
			cnt[i] = new int[]{zero, one};
		}

		int[][][] dp = new int[len + 1][m + 1][n + 1];
		for (int k = 1; k <= len; k++) {
			int zero = cnt[k - 1][0], one = cnt[k - 1][1];
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					int no = dp[k - 1][i][j];
					int yes = (i >= zero && j >= one) ? dp[k - 1][i - zero][j - one] + 1 : 0;
					dp[k][i][j] = Math.max(no, yes);
				}
			}
		}
		return dp[len][m][n];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/ones-and-zeroes/ -----");
		System.out.println("----- 1 -----");
		System.out.println(findMaxForm(new String[]{
				"10", "0001", "11101", "1", "0"
		}, 5, 3));

		System.out.println("----- 2 -----");
		System.out.println(findMaxForm(new String[]{
				"10", "0", "1"
		}, 1, 1));

	}

}
