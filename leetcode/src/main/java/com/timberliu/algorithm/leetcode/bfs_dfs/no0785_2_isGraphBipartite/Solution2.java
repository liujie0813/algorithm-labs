package com.timberliu.algorithm.leetcode.bfs_dfs.no0785_2_isGraphBipartite;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 785. 判断二分图
 *
 * 染色法
 *   广度优先搜索
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution2 {

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];

		for (int i = 0; i < n; i++) {
			if (color[i] != 0) {
				continue;
			}
			Deque<Integer> queue = new LinkedList<>();
			queue.offer(i);
			color[i] = 1;
			while (!queue.isEmpty()) {
				Integer top = queue.poll();
				int anotherColor = color[top] == 1 ? 2 : 1;
				for (int v : graph[top]) {
					if (color[v] == 0) {
						queue.offer(v);
						color[v] = anotherColor;
					} else if (color[v] != anotherColor) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/is-graph-bipartite/ -----");
		/**
		 *  0 -- 1
		 *  |    |
		 *  3 -- 2
		 */
		Solution2 solution2 = new Solution2();
		System.out.println("----- 1 -----");
		int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
		System.out.println(solution2.isBipartite(graph1));

		System.out.println("----- 2 -----");
		int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
		System.out.println(solution2.isBipartite(graph2));

	}

}
