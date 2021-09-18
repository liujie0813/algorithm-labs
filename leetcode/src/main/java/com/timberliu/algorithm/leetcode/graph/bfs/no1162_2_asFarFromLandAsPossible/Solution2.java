package com.timberliu.algorithm.leetcode.graph.bfs.no1162_2_asFarFromLandAsPossible;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1162. 地图分析
 *
 *  多源 dfs
 *
 *    从每个 陆地 区域出发，多个 陆地 区域同时向外扩散一圈
 *      每个 海洋 区域被首次覆盖时对应的圈数，就是 海洋 区域距离最近的 陆地 区域的距离
 *
 *    将所有陆地区域 先入队列即可
 *
 * @author liujie
 * @date 2021/9/18
 */

public class Solution2 {

	public int maxDistance(int[][] grid) {
		int[][] diff = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int n = grid.length;
		int m = grid[0].length;

		Deque<Integer> queue = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					queue.offer(i * m + j);
					map.put(i * m + j, 0);
				}
			}
		}

		int res = -1;
		while (!queue.isEmpty()) {
			Integer prev = queue.poll();
			int prevX = prev / m;
			int prevY = prev % m;
			int prevStep = map.get(prev);
			for (int[] ints : diff) {
				int nextX = prevX + ints[0];
				int nextY = prevY + ints[1];
				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}
				if (grid[nextX][nextY] != 0) {
					continue;
				}
				grid[nextX][nextY] = prevStep + 1;
				queue.add(nextX * m + nextY);
				map.put(nextX * m + nextY, prevStep + 1);
				res = Math.max(res, prevStep + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/as-far-from-land-as-possible/ -----");
		Solution2 solution1 = new Solution2();
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
