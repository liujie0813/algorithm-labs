package com.timberliu.algorithm.company.hw.graph.no059_1_minClickTimes;

import java.util.Scanner;

/**
 * 59. 开心消消乐
 *
 *  岛屿数量
 *
 * @author Timber
 * @date 2023/4/23
 */
public class Solution1 {

	public static class UnionFind {
		int[] node;
		int count;
		public UnionFind(int n) {
			this.node = new int[n];
			this.count = n;
			for (int i = 0; i < n; i++) {
				this.node[i] = i;
			}
		}
		public int find(int x) {
			while (this.node[x] != x) {
				x = this.node[x];
			}
			return x;
		}
		public void union(int x, int y) {
			int p = find(x);
			int q = find(y);
			if (p != q) {
				this.node[p] = q;
				this.count--;
			}
		}
	}

	public static int[][] changes = {
			{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
	};

	public static int minClickTimes(int[][] arr, int m, int n) {
		UnionFind unionFind = new UnionFind(m * n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					// 0 看做孤岛，但不计数
					unionFind.count--;
					continue;
				}

				for (int[] change : changes) {
					int newI = i + change[0];
					int newJ = j + change[1];
					if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && arr[newI][newJ] == 1) {
						unionFind.union(i * n + j, newI * n + newJ);
					}
				}
			}
		}
		return unionFind.count;
	}

	/**
	 * 4 4
	 * 1 1 0 0
	 * 0 0 0 1
	 * 0 0 1 1
	 * 1 1 1 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		int res = minClickTimes(arr, m, n);
		System.out.println(res);

	}

}
