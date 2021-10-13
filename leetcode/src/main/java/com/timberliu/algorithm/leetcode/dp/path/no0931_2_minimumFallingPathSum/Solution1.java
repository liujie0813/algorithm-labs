package com.timberliu.algorithm.leetcode.dp.path.no0931_2_minimumFallingPathSum;

/**
 * 931. 下降路径最小和
 *
 *   不修改原数组
 *   从上往下，会出现覆盖情况，需要 O(n^2) 空间
 *
 * @author liujie
 * @date 2021/10/13
 */

public class Solution1 {

	public static int minFallingPathSum(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] aux = new int[m][n];
		for (int i = 0; i < n; i++) {
			aux[0][i] = matrix[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int min = aux[i - 1][j];
				if (j > 0) {
					min = Math.min(aux[i - 1][j - 1], min);
				}
				if (j < n - 1) {
					min = Math.min(aux[i - 1][j + 1], min);
				}
				aux[i][j] = min + matrix[i][j];
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i : aux[m - 1]) {
			res = Math.min(i, res);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/minimum-falling-path-sum/ -----");
		System.out.println("----- 1 -----");
		System.out.println(minFallingPathSum(new int[][]{
				{2, 1, 3},
				{6, 5, 4},
				{7, 8, 9}
		}));

		System.out.println("----- 2 -----");
		System.out.println(minFallingPathSum(new int[][]{
				{-19, 57},
				{-40, 5},
		}));

		System.out.println("----- 3 -----");
		System.out.println(minFallingPathSum(new int[][]{
				{-48},
		}));

		System.out.println("----- 4 -----");
		System.out.println(minFallingPathSum(new int[][]{
				{-84, -36, 2},
				{87, -79, 10},
				{42, 10, 63}
		}));

		System.out.println("----- 5 -----");
		System.out.println(minFallingPathSum(new int[][]{
				{-19, 57},
				{-40, -5}
		}));

	}

}
