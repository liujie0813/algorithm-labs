package com.timberliu.algorithm.leetcode.dp.path.no1289_3_minimumFallingPathSumii;

/**
 * 1289. 下降路径最小和  II
 *
 *   记录最小值和次小值
 *
 * @author liujie
 * @date 2021/10/13
 */

public class Solution1 {

	public static int minFallingPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] dp = new int[n];
		int lastFirst = -1, lastSecond = -1;
		for (int i = 0; i < n; i++) {
			int temp = grid[0][i];
			dp[i] = temp;

			if (temp < (lastFirst == -1 ? Integer.MAX_VALUE : grid[0][lastFirst])) {
				lastSecond = lastFirst;
				lastFirst = i;
			} else if (temp < (lastSecond == -1 ? Integer.MAX_VALUE : grid[0][lastSecond])) {
				lastSecond = i;
			}
		}

		for (int i = 1; i < m; i++) {
			// 上一行的最小值、次小值，否则会被覆盖
			int lastFirstVal = dp[lastFirst], lastSecondVal = dp[lastSecond];
			// 记录当前行的最小值、次小值下标
			int first = -1, second = -1;
			for (int j = 0; j < n; j++) {
				dp[j] = grid[i][j] + (j == lastFirst ? lastSecondVal : lastFirstVal);

				if (dp[j] < (first == -1 ? Integer.MAX_VALUE : dp[first])) {
					second = first;
					first = j;
				} else if (dp[j] < (second == -1 ? Integer.MAX_VALUE : dp[second])) {
					second = j;
				}
			}
			lastFirst = first;
			lastSecond = second;
		}
		int res = Integer.MAX_VALUE;
		for (int i : dp) {
			res = Math.min(res, i);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/minimum-falling-path-sum-ii/ -----");
		System.out.println("----- 1 -----");
		System.out.println(minFallingPathSum(new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		}));

		System.out.println("----- 2 -----");
		System.out.println(minFallingPathSum(new int[][]{
				{-73, 61,  43, -48, -36},
				{3,   30,  27, 57,  10},
				{96,  -76, 84, 59,  -15},
				{5,   -49, 76, 31,  -7},
				{97,  91,  61, -46,  6}
		}));


	}

}
