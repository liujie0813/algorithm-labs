package com.timberliu.algorithm.leetcode.graph.bfs.no0909_2_snakesAndLadders;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 909. 蛇梯棋
 *
 * @author liujie
 * @date 2021/9/18
 */

public class Solution1 {

	private int[] diff = {1, 2, 3, 4, 5, 6};
	private int n, m;

	public int snakesAndLadders(int[][] board) {
		n = board.length;
		m = board[0].length;
		int end = n * m - 1;

		boolean[] visited = new boolean[n * m];

		Deque<Integer> queue = new LinkedList<>();
		// 从 0~n-1
		queue.offer(0);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			while (size-- > 0) {
				int prev = queue.poll();
				for (int i : diff) {
					int next = prev + i;
					if (next > end) {
						continue;
					}
					// 计算坐标
					int nextX = n - 1 - next / m;
					int nextY = (next / m % 2) == 0 ? next % m : m - 1 - next % m;
					// 判断梯子或蛇
					if (board[nextX][nextY] != -1) {
						// 如果是 则传送
						next = board[nextX][nextY] - 1;
					}
					if (next == end) {
						return level;
					}
					if (visited[next]) {
						continue;
					}
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/snakes-and-ladders/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.snakesAndLadders(new int[][]{
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}
		}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.snakesAndLadders(new int[][]{
				{-1,-1,-1},
				{-1,9,8},
				{-1,8,9}
		}));

	}

}
