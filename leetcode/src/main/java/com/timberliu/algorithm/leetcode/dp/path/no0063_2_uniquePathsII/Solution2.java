package com.timberliu.algorithm.leetcode.dp.path.no0063_2_uniquePathsII;

/**
 * 63. 不同路径 II
 *
 *  有障碍物
 *
 * @author Timber
 * @date 2021/10/12
 */
public class Solution2 {

	public static int uniquePathsWithObstacles(int[][] arr) {
		if (arr[0][0] == 1) {
			return 0;
		}
		int m = arr.length, n = arr[0].length;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int j = 1; j < m && arr[0][j] == 0; j++) {
			dp[j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 遇到障碍物
				if (arr[i][j] == 1) {
					dp[j] = 0;
				} else if (j != 0) {
					dp[j] += dp[j - 1];
				}
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/unique-paths-ii/ -----");
		System.out.println("----- 1 -----");
		System.out.println(uniquePathsWithObstacles(new int[][] {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0},
		}));

		System.out.println("----- 2 -----");
		System.out.println(uniquePathsWithObstacles(new int[][] {
				{0, 1},
				{0, 0},
		}));

	}

}
