package com.timberliu.algorithm.leetcode.bfs_dfs.no0785_2_isGraphBipartite;

/**
 * 785. 判断二分图
 *
 * 染色法
 *   深度优先搜索
 *
 *   相邻两个节点标记为同一种颜色，即不是二分图
 *
 * 图相关题目经常会遇到'染色法'或者'标记法'
 *
 * @author liujie
 * @date 2021/9/15
 */

public class Solution1 {

	// 0 未染色 1 红色 2 绿色
	private int[] color;
	private boolean bipartite;

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		bipartite = true;
		color = new int[n];
		for (int i = 0; i < n && bipartite; i++) {
			if (color[i] == 0) {
				dfs(graph, i, 1);
			}
		}
		return bipartite;
	}

	private void dfs(int[][] graph, int i, int c) {
		color[i] = c;
		int anotherColor = c == 1 ? 2 : 1;
		for (int v : graph[i]) {
			if (color[v] == 0) {
				dfs(graph, v, anotherColor);
				if (!bipartite) {
					return;
				}
			} else if (color[v] != anotherColor) {
				bipartite = false;
				return;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/is-graph-bipartite/ -----");
		/**
		 *  0 -- 1
		 *  |    |
		 *  3 -- 2
		 */
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
		System.out.println(solution1.isBipartite(graph1));

		System.out.println("----- 2 -----");
		int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
		System.out.println(solution1.isBipartite(graph2));

	}

}
