package com.timberliu.algorithm.leetcode.graph.bfs.no1162_2_asFarFromLandAsPossible;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1162. 地图分析
 *
 * @author liujie
 * @date 2021/9/18
 */

public class Solution1 {

	private int[][] diff = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private int n;
	private int m;

	public int maxDistance(int[][] grid) {
		n = grid.length;
		m = grid[0].length;
		int res = -1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					int maxDistance = doMaxDistance(grid, i, j);
					res = Math.max(res, maxDistance);
				}
			}
		}
		return res;
	}

	private int doMaxDistance(int[][] grid, int x, int y) {
		Deque<Integer> queue = new LinkedList<>();
		queue.offer(x * m + y);

		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;

		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			while (size-- > 0) {
				Integer prev = queue.poll();
				int prevX = prev / m;
				int prevY = prev % m;
				for (int[] ints : diff) {
					int nextX = prevX + ints[0];
					int nextY = prevY + ints[1];
					if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
						continue;
					}
					if (grid[nextX][nextY] == 1) {
						return level;
					}
					if (visited[nextX][nextY]) {
						continue;
					}
					visited[nextX][nextY] = true;
					queue.offer(nextX * m + nextY);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/as-far-from-land-as-possible/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.maxDistance(new int[][]{
				{1,0,1},{0,0,0},{1,0,1}
		}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.maxDistance(new int[][]{
				{1,0,0},{0,0,0},{0,0,0}
		}));

	}

}
