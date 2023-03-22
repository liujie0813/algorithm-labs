package com.timberliu.algorithm.leetcode.dp.path.no0063_2_uniquePathsII;

/**
 * 63. 不同路径 II
 *
 *  有障碍物
 *
 * @author Timber
 * @date 2021/10/12
 */
public class Solution1 {

	public static int uniquePathsWithObstacles(int[][] arr) {
		if (arr[0][0] == 1) {
			return 0;
		}
		int m = arr.length, n = arr[0].length;
		arr[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((i > 0 || j > 0) && arr[i][j] == 1) {
					arr[i][j] = 0;
					continue;
				}
				if (i > 0 && j > 0) {
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
				} else if (i > 0) {
					arr[i][j] = arr[i - 1][j];
				} else if (j > 0){
					arr[i][j] = arr[i][j - 1];
				}
			}
		}
		return arr[m - 1][n - 1];
	}

	public static int uniquePathsWithObstacles1(int[][] arr) {
		if (arr[0][0] == 1) {
			return 0;
		}
		int m = arr.length, n = arr[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m && arr[i][0] == 0; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < m && arr[0][j] == 0; j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// 遇到障碍物，dp[i][j] 保持为 0 就好
				if (arr[i][j] != 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
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
