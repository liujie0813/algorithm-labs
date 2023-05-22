package com.timberliu.algorithm.company.hw.volume_a.dfs_bfs.no011_2_minCount;

import java.util.Scanner;

/**
 * 11. 羊、狼、农夫过河
 *
 * @author liujie
 * @date 2023/4/28
 */

public class Solution1 {

	public static int minCount(int sheep, int wolf, int capacity) {
		int[] res = {Integer.MAX_VALUE};
		dfs(sheep, wolf, 0, 0, capacity, 0, res);
		return res[0];
	}

	private static void dfs(int sheep, int wolf, int otherSheep, int otherWolf, int capacity, int curCnt, int[] res) {
		if (sheep == 0 && wolf == 0) {
			res[0] = Math.min(res[0], curCnt);
			return;
		}
		// 本岸 羊+狼 <= 船容量，可一次运过去
		if (sheep + wolf <= capacity) {
			res[0] = Math.min(res[0], curCnt + 1);
			return;
		}
		for (int i = 0; i <= sheep; i++) {
			for (int j = 0; j <= wolf; j++) {
				// 至少运 1 个
				if (i + j == 0) {
					continue;
				}
				// 船上的羊+狼 <= 船容量
				if (i + j > capacity) {
					break;
				}
				// 本岸羊 > 本岸狼
				if (sheep - i <= wolf - j && sheep - i != 0) {
					continue;
				}
				// 对岸羊 > 对岸狼
				if (otherSheep + i <= otherWolf + j && otherSheep + i != 0) {
					break;
				}
				dfs(sheep - i, wolf -j, otherSheep + i, otherWolf + j, capacity, curCnt + 1, res);
			}
		}
	}

	/*
	 * 5 3 3
	 */
	/**
	 * 3 3 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sheep = scanner.nextInt();
		int wolf = scanner.nextInt();
		int capacity = scanner.nextInt();
		int res = minCount(sheep, wolf, capacity);
		System.out.println(res);
	}

}
