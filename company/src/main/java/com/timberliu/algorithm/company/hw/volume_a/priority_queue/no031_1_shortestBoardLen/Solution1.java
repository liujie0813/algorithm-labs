package com.timberliu.algorithm.company.hw.volume_a.priority_queue.no031_1_shortestBoardLen;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 31. 最短木板长度
 *
 * @author Timber
 * @date 2023/4/25
 */
public class Solution1 {

	public static int shortestBoardLen(int[] arr, int m) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int val : arr) {
			pq.offer(val);
		}
		for (int i = 0; i < m; i++) {
			Integer top = pq.poll();
			pq.offer(top + 1);
		}
		return pq.peek();
	}

	/*
	 * 5 3
	 * 4 5 3 5 5
	 */
	/**
	 * 5 2
	 * 4 5 3 5 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int res = shortestBoardLen(arr, m);
		System.out.println(res);
	}

}
