package com.timberliu.algorithm.company.hw.no106_1_maxPoint;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 106. 工单调度策略
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution1 {

	public static int maxPoint(int[][] arr) {
		// 按截止时间从小到大排序
		// 截止时间相同的，按积分从大到小
		Arrays.sort(arr, Comparator.comparing(a -> a, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(b[1], a[1]);
			}
			return Integer.compare(a[0], b[0]);
		}));

		// 优先级队列，按积分从小到大
		// 要放弃就放弃积分小的
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
		int res = 0;
		int curTime = 0;
		for (int i = 0; i < arr.length; i++) {
			int endTime = arr[i][0];
			int point = arr[i][1];
			if (endTime >= curTime + 1) {
				// 截止时间内，处理该工单
				pq.offer(arr[i]);
				res += point;
				curTime++;
			} else if (!pq.isEmpty()){
				int[] peek = pq.peek();
				if (point > peek[1]) {
					// 积分更大
					// 将修复栈顶 peek 工单的1小时，用于修复 arr[i] 工单
					pq.offer(arr[i]);
					res += point - peek[1];
					pq.poll();
				}
			}
		}
		return res;
	}

	/*
	 * 3
	 * 1 1
	 * 2 10   截止时间靠后，但积分较大，可以放弃截止时间早的
	 * 2 20
	 */
	/**
	 * 7      对截止时间排序，先处理早的
	 * 1 6    截止时间相同，优先处理积分大的
	 * 1 7
	 * 3 2
	 * 3 1
	 * 2 4
	 * 2 5
	 * 6 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}

		int res = maxPoint(arr);
		System.out.println(res);
	}

}
