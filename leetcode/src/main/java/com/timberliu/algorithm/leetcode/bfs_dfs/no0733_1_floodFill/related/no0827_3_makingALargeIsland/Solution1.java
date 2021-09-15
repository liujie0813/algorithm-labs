package com.timberliu.algorithm.leetcode.bfs_dfs.no0733_1_floodFill.related.no0827_3_makingALargeIsland;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 827. 最大人工岛
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution1 {

	private int[][] dirs = {
			{-1, 0},
			{1, 0},
			{0, 1},
			{0, -1}
	};

	private int[][] grid;
	private int n;
	private int m;

	public int largestIsland(int[][] grid) {
		this.grid = grid;
		this.n = grid.length;
		this.m = grid[0].length;
		int idx = 2;
		// area 表示当前格子连通了多少个 1
		int[] area = new int[m * n + 2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					area[idx] = dfs(i, j, idx);
					idx++;
				}
			}
		}
		int res = 0;
		for (int a : area) {
			res = Math.max(res, a);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != 0) {
					continue;
				}
				Set<Integer> visited = new HashSet<>();
				for (Integer p : getNeighbors(i, j)) {
					if (grid[p / m][p % m] > 1) {
						visited.add(grid[p / m][p % m]);
					}
				}
				int tmp = 1;
				for (Integer v : visited) {
					tmp += area[v];
				}
				res = Math.max(res, tmp);
			}
		}
		return res;
	}

	private int dfs(int i, int j, int idx) {
		int cnt = 1;
		grid[i][j] = idx;
		for (Integer p : getNeighbors(i, j)) {
			if (grid[p / m][p % m] == 1) {
				grid[p / m][p % m] = idx;
				cnt += dfs(p / m, p % m, idx);
			}
		}
		return cnt;
	}

	private List<Integer> getNeighbors(int x, int y) {
		List<Integer> res = new ArrayList<>();
		for (int[] dir : dirs) {
			int nextX = x + dir[0];
			int nextY = y + dir[1];
			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
				continue;
			}
			res.add(nextX * m + nextY);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/making-a-large-island/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.largestIsland(new int[][] {
				{1, 0},
				{0, 1}
		}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.largestIsland(new int[][] {
				{1, 1},
				{1, 0}
		}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.largestIsland(new int[][] {
				{1, 1},
				{1, 1}
		}));

	}
}
