package com.timberliu.algorithm.leetcode.bfs_dfs.no0733_1_floodFill.related.no0827_3_makingALargeIsland;

/**
 * 827. 最大人工岛
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution1 {

	public static int largestIsland(int[][] grid) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					grid[i][j] = 1;

					grid[i][j] = 0;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/making-a-large-island/ -----");
		System.out.println("----- 1 -----");
		System.out.println(largestIsland(new int[][] {
				{1, 0},
				{0, 1}
		}));

		System.out.println("----- 2 -----");
		System.out.println(largestIsland(new int[][] {
				{1, 1},
				{1, 0}
		}));

		System.out.println("----- 3 -----");
		System.out.println(largestIsland(new int[][] {
				{1, 1},
				{1, 1}
		}));

	}
}
