package com.timberliu.algorithm.leetcode.dp.path.no0064_2_minimumPathSum;

/**
 * 64. 最小路径和
 *
 * @author Timber
 * @date 2021/10/12
 */
public class Solution1 {

	public static int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && j > 0) {
					dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
				} else if (i > 0) {
					// 第一列
					dp[j] = dp[0] + grid[i][j];
				} else if (j > 0) {
					// 第一行
					dp[j] = dp[j - 1] + grid[i][j];
				}
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/minimum-path-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(minPathSum(new int[][]{
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		}));

		System.out.println("----- 2 -----");
		System.out.println(minPathSum(new int[][]{
				{1, 2, 3},
				{4, 5, 6}
		}));

	}

}
