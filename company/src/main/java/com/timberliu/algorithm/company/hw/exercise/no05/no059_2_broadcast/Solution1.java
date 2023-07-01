package com.timberliu.algorithm.company.hw.exercise.no05.no059_2_broadcast;

import java.util.Scanner;

/**
 * @author Timber
 * @date 2023/6/23
 */
public class Solution1 {

	public static int minInitialBroadcast(int[][] matrix, int n) {
		UnionFind unionFind = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					unionFind.union(i, j);
				}
			}
		}
		return unionFind.count;
	}

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
		public int find(int p) {
			while (p != node[p]) {
				p = node[p];
			}
			return p;
		}
		public void union(int p, int q) {
			int first = find(p);
			int second = find(q);
			if (first != second) {
				this.node[first] = second;
				this.count--;
			}
		}
	}

	/**
	 * 110,110,001
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int n = splits.length;
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = splits[i].charAt(j) - '0';
			}
		}

		int res = minInitialBroadcast(matrix, n);
		System.out.println(res);
	}

}
