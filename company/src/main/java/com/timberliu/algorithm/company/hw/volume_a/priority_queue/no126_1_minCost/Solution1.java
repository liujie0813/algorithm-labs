package com.timberliu.algorithm.company.hw.volume_a.priority_queue.no126_1_minCost;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 126. 购买水果最便宜的方案
 *
 * @author liujie
 * @date 2023/5/5
 */

public class Solution1 {

	public static int minCost(int[][] arr, int m, int n) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				if (a[2] == b[2]) {
					return a[1] - b[1];
				}
				return a[2] - b[2];
			}
			return a[0] - b[0];
		});
		for (int i = 0; i < m; i++) {
			pq.offer(arr[i]);
		}

		int res = 0;
		for (int i = 1; i <= n; i++) {
			while (!pq.isEmpty() && pq.peek()[1] < i) {
				pq.poll();
			}
			while (!pq.isEmpty() && pq.peek()[0] < i) {
				int[] poll = pq.poll();
				poll[0] = i;
				pq.offer(poll);
			}
			res += pq.peek()[2];
		}
		return res;
	}

	/**
	 * 4
	 * 6
	 * 2 3 10
	 * 2 4 20
	 * 1 3 15
	 * 1 4 25
	 * 3 4 8
	 * 1 4 16
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] arr = new int[m][3];
		for (int i = 0; i < m; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
			arr[i][2] = scanner.nextInt();
		}

		int res = minCost(arr, m, n);
		System.out.println(res);
	}

}
