package com.timberliu.algorithm.company.hw.graph.no101_1_maxReleaseNum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 101. Linux 发行版数量
 *
 *  n*n矩阵，求最大的连通分量的分量数
 *
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution1 {

	public static int maxReleaseNum(int[][] arr) {
		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(i)) {
				continue;
			}
			// 与 i 相连的所有分量
			Set<Integer> curVersionSet = new HashSet<>();
			dfs(arr, i, curVersionSet);
			// 最大的连通分量数
			res = Math.max(res, curVersionSet.size());
			// 加入到已遍历
			set.addAll(curVersionSet);
		}
		return res;
	}

	private static void dfs(int[][] arr, int i, Set<Integer> curVersionSet) {
		for (int j = 0; j < arr.length; j++) {
			if (curVersionSet.contains(j)) {
				continue;
			}
			if (i != j && arr[i][j] == 1) {
				curVersionSet.add(j);
				dfs(arr, j, curVersionSet);
			}
		}
	}

	/**
	 * 4
	 * 1 1 0 0
	 * 1 1 1 0
	 * 0 1 1 0
	 * 0 0 0 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		int res = maxReleaseNum(arr);
		System.out.println(res);
	}

}
