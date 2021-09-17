package com.timberliu.algorithm.leetcode.bfs_dfs.no0279_2_perfectSquares;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 279. 完全平方数
 *
 * 动态规划
 *    f(n) =
 *
 * @author liujie
 * @date 2021/9/16
 */

public class Solution1 {

	public static int numSquares(int n) {
		Deque<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		queue.offer(n);
		visited.add(n);

		int level = 0;
		while (!queue.isEmpty()) {
			level++;
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Integer head = queue.poll();
				for (int j = 1; j * j <= head; j++) {
					int tmp = head - j * j;
					if (tmp == 0) {
						// 完全平方数 的数量 等于 层级
						return level;
					}
					if (visited.contains(tmp)) {
						continue;
					}
					queue.offer(tmp);
					visited.add(tmp);
				}
			}
		}
		return level;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/perfect-squares/ -----");
		System.out.println("----- 1 -----");
		System.out.println(numSquares(12));

		System.out.println("----- 2 -----");
		/*
		 *               13
		 *           /   |   \
		 *        12     9    4
		 *      / | \  / | \
		 *     11 8 3    5 0
		 */
		System.out.println(numSquares(13));
	}
}
