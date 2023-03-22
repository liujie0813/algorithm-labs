package com.timberliu.algorithm.leetcode.dp.path.no0062_2_uniquePaths;

/**
 * 62. 不同路径
 *
 *  dp[i][j]：从 (0,0) 到 (i, j) 有 dp[i][j] 条不同的路径
 *
 *  dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 *
 * @author Timber
 * @date 2021/10/12
 */
public class Solution1 {

	public static int uniquePaths(int m, int n) {
		int[][] arr = new int[m][n];
		arr[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && j > 0) {
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
				} else if (i > 0) {
					arr[i][j] = arr[i - 1][j];
				} else if (j > 0) {
					arr[i][j] = arr[i][j - 1];
				}
			}
		}
		return arr[m - 1][n - 1];
	}

	public static int uniquePaths1(int m, int n) {
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			arr[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			arr[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		return arr[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/unique-paths/ -----");
		System.out.println("----- 1 -----");
		System.out.println(uniquePaths(3, 7));

		System.out.println("----- 2 -----");
		System.out.println(uniquePaths(3, 2));

		System.out.println("----- 3 -----");
		System.out.println(uniquePaths(7, 3));

		System.out.println("----- 3 -----");
		System.out.println(uniquePaths1(3, 3));

	}

}
