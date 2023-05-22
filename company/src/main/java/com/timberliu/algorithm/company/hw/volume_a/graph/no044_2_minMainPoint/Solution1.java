package com.timberliu.algorithm.company.hw.volume_a.graph.no044_2_minMainPoint;

import java.util.Scanner;

/**
 * 44. 计算快递业务主站点
 *
 * @author liujie
 * @date 2023/4/24
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
			while (x != node[x]) {
				x = node[x];
			}
			return x;
		}
		public void union(int x, int y) {
			int p = find(x);
			int q = find(y);
			if (p != q) {
				node[p] = q;
				count--;
			}
		}
	}

	public static int minMainPoint(int[][] arr) {
		int n = arr.length;
		UnionFind unionFind = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i][j] == 1) {
					unionFind.union(i, j);
				}
			}
		}
		return unionFind.count;
	}

	/*
	 * 4
	 * 1 1 1 1
	 * 1 1 1 0
	 * 1 1 1 0
	 * 1 0 0 1
	 */
	/**
	 * 4
	 * 1 1 0 0
	 * 1 1 0 0
	 * 0 0 1 0
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
		int res = minMainPoint(arr);
		System.out.println(res);
	}

}
