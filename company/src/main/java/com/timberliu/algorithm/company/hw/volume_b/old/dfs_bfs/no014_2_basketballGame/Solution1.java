package com.timberliu.algorithm.company.hw.volume_b.old.dfs_bfs.no014_2_basketballGame;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 14. 篮球比赛
 *
 * @author liujie
 * @date 2023/6/2
 */

public class Solution1 {

	public static int basketballGame(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}

		Arrays.sort(arr);

		int[] res = {Integer.MAX_VALUE};
		dfs(arr, 0, 0, 0, sum, res);
		return res[0];
	}

	private static void dfs(int[] arr, int start, int cnt, int curSum, int total, int[] res) {
		if (cnt == 5) {
			res[0] = Math.min(res[0], Math.abs(total - 2 * curSum));
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			dfs(arr, i + 1, cnt + 1, arr[i] + curSum, total, res);
		}
	}

	/*
	 * 10 9 8 7 6 5 4 3 2 1
	 */
	/**
	 * 10 9 5 5 5 5 5 5 2 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		int[] arr = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}

		int res = basketballGame(arr);
		System.out.println(res);
	}

}
