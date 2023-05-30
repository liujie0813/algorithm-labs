package com.timberliu.algorithm.company.hw.volume_b.new_add.dfs_bfs.no995_2_polluteDays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 污染水域
 *
 * @author liujie
 * @date 2023/5/26
 */

public class Solution1 {

	private static int[][] directions = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1}
	};

	public static int polluteDays(int[][] arr, int n) {
		Deque<int[]> deque = new LinkedList<>();
		int need = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					need++;
				} else {
					deque.offer(new int[]{i, j});
				}
			}
		}
		if (need == 0) {
			return -1;
		}
		int level = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				int[] poll = deque.poll();
				for (int[] direction : directions) {
					int newX = direction[0] + poll[0];
					int newY = direction[1] + poll[1];
					if (newX >= 0 && newX < n && newY >= 0 && newY < n && arr[newX][newY] == 0) {
						arr[newX][newY] = 1;
						need--;
						deque.offer(new int[]{newX, newY});
					}
				}
			}
			level++;
		}
		if (need == 0) {
			return level - 1;
		}
		return -1;
	}

	/*
	 * 1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0
	 *
	 * 1,0,0,1
	 * 0,0,0,0
	 * 0,0,0,0
	 * 1,0,0,0
	 */
	/*
	 * 1,0,1,0,0,0,1,0,1
	 */
	/**
	 * 0,0,0,0
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int n = (int) Math.sqrt(splits.length);
		int[][] arr = new int[n][n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(splits[index++]);
			}
		}

		int res = polluteDays(arr, n);
		System.out.println(res);
	}

}
