package com.timberliu.algorithm.company.hw.exercise.no04.no096_1_weAreATeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Timber
 * @date 2023/6/18
 */
public class Solution1 {

	public static List<String> weAreATeam(int[][] arr, int n) {
		List<String> res = new ArrayList<>();
		UnionFind unionFind = new UnionFind(n);
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i][0];
			int b = arr[i][1];
			int c = arr[i][2];
			if ((c != 0 && c != 1) || (a < 1 || a > n) || (b < 1 || b > n)) {
				res.add("da pian zi");
				continue;
			}
			if (c == 0) {
				unionFind.union(a, b);
			} else if (c == 1) {
				if (unionFind.isConnected(a, b)) {
					res.add("we are a team");
				} else {
					res.add("we are not a team");
				}
			}
		}
		return res;
	}

	public static class UnionFind {
		private int[] node;
		private int count;
		public UnionFind(int n) {
			node = new int[n + 1];
			count = n;
			for (int i = 0; i <= n; i++) {
				node[i] = i;
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
				node[first] = second;
				count--;
			}
		}
		public boolean isConnected(int p, int q) {
			int first = find(p);
			int second = find(q);
			return first == second;
		}
	}

	/**
	 * 5 7
	 * 1 2 0
	 * 4 5 0
	 * 2 3 0
	 * 1 2 1
	 * 2 3 1
	 * 4 5 1
	 * 1 5 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		if ((n < 1 || n > 100000) || (m < 1 || m > 100000)) {
			System.out.println("Null");
			return;
		}
		int[][] arr = new int[m][3];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
			arr[i][2] = scanner.nextInt();
		}

		List<String> res = weAreATeam(arr, n);
		for (String val : res) {
			System.out.println(val);
		}
	}

}
