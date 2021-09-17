package com.timberliu.algorithm.leetcode.graph.bfs.no0847_3_shortestPathVisitingAllNodes;

import java.util.*;

/**
 * 847. 访问所有节点的最短路径
 *
 *  BFS + 状态压缩
 *
 *    如何判断重复状态？
 *    	1. 由于 n <= 12，用 int 的低 12 位分别表示已经访问过的节点集合
 *      2. 当前节点
 *
 *    常规时间复杂度为 O(n+m)，n 为节点数，m 为边数
 *       节点数：n
 *       边数：最坏情况下为完全图，m = O(n^2)
 *     由于引入 mask，可以看做 2^n 次广度优先搜索
 *     时间复杂度为 O(2^n * n^2)
 *
 *    空间复杂度：O(2^n * n)
 *       dist 数组
 *
 * @author liujie
 * @date 2021/9/17
 */

public class Solution1 {

	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		int mask = 1 << n;
		// x：当前图状态，哪些节点访问过，由于 n <= 12，位表示
		// y：当前节点
		// dist：距离
		int[][] dist = new int[mask][n];
		for (int i = 0; i < mask; i++) {
			// -1：未访问过 >= 0：距离
			Arrays.fill(dist[i], -1);
		}

		Deque<int[]> queue = new LinkedList<>();
		// 最短路径可能从任意一个节点出发
		for (int i = 0; i < n; i++) {
			dist[1 << i][i] = 0;
			queue.offer(new int[]{1 << i, i});
		}

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int prevState = node[0], v = node[1], len = dist[prevState][v];
			if (prevState == mask - 1) {
				return len;
			}
			for (int i : graph[v]) {
				int curState = prevState | 1 << i;
				if (dist[curState][i] == -1) {
					dist[curState][i] = len + 1;
					queue.offer(new int[]{curState, i});
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		/*
		 * 从 1 出发
		 *     0
		 *   / | \
		 *  1  2  3
		 */
		System.out.println(solution1.shortestPathLength(new int[][]{
				{1, 2, 3},
				{0},
				{0},
				{0},
		}));

		System.out.println("----- 2 -----");
		/*
		 * 从 0 或 3 出发
		 *  2 --- 1 --- 0
		 *  | \   |
		 *  |   \ |
		 *  3     4
		 */
		System.out.println(solution1.shortestPathLength(new int[][]{
				{1},
				{0, 2, 4},
				{1, 3, 4},
				{2},
				{1, 2},
		}));

	}

}
