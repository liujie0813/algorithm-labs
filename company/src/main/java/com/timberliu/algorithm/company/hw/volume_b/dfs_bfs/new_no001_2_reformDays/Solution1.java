package com.timberliu.algorithm.company.hw.volume_b.dfs_bfs.new_no001_2_reformDays;

import java.util.*;

/**
 * 1. 宜居星球改造计划
 *
 *  每个宜居区能同时向上下左右四个方向进行改造
 *  所以为多源 BFS，即开始时需要把所有宜居的区域都要加到队列中
 *
 *  图的多源 BFS
 *
 *  使用 need 变量统计所有需要改造的区域数
 *  在 BFS 遍历后，判断 need 是否为 0
 *
 * @author liujie
 * @date 2023/5/22
 */

public class Solution1 {

	private static int[][] directions = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1},
	};

	public static int reformDays(List<String[]> matrix) {
		int m = matrix.size(), n = matrix.get(0).length;

		int need = 0;
		Deque<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				String val = matrix.get(i)[j];
				if ("YES".equals(val)) {
					queue.offer(new int[]{i, j});
				} else if ("NO".equals(val)) {
					need++;
				}
			}
		}
		if (queue.isEmpty()) {
			return -1;
		}
		if (queue.size() == m * n) {
			return 0;
		}
		int level = 0;
		while (!queue.isEmpty() && need > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] pos = queue.poll();
				for (int[] direction : directions) {
					int newX = pos[0] + direction[0];
					int newY = pos[1] + direction[1];
					if (newX >= 0 && newX < m && newY >= 0 && newY < n && "NO".equals(matrix.get(newX)[newY])) {
						matrix.get(newX)[newY] = "YES";
						queue.offer(new int[]{newX, newY});
						need--;
					}
				}
			}
			level++;
		}
		if (need == 0) {
			return level;
		}
		return -1;
	}

	/*
	 * YES YES NO
	 * NO NO NO
	 * YES NO NO
	 */
	/*
	 * YES NO NO NO
	 * NO NO NO NO
	 * NO NO NO NO
	 * NO NO NO NO
	 */
	/**
	 * YES NO NO YES
	 * NO NO YES NO
	 * NO YES NA NA
	 * YES NO NA NO
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String[]> matrix = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.isEmpty()) {
				break;
			}
			matrix.add(line.split(" "));
		}

		int res = reformDays(matrix);
		System.out.println(res);
	}

}
