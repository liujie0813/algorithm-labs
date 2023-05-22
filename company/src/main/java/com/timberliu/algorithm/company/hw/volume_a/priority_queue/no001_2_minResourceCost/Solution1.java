package com.timberliu.algorithm.company.hw.volume_a.priority_queue.no001_2_minResourceCost;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 最大化控制资源成本
 *
 *   任务的开始时间、结束时间、并行度（占用机器数）
 *   求最少的机器数
 *
 *   eg：[2, 3, 1]
 *       [6, 9, 2]
 *       [0, 5, 1]
 *
 *   思路：
 *   1. 扫描线做法，先按照左边界进行排序
 *   2. 遍历排序后的task
 *   	使用优先级队列存储前面的 task（右边界小的在前）
 *      如果区间没有交集，就可以剔除该task
 *
 * @author liujie
 * @date 2023/3/21
 */

public class Solution1 {

	public static Integer minResourceCost(int[][] tasks) {
		Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		int res = 0;
		int curCost = 0;
		for (int[] task : tasks) {
			while (!pq.isEmpty()) {
				// 当前task的左边界 小于 前面task的右边界（区间有重叠）
				if (task[0] < pq.peek()[0]) {
					break;
				}
				int[] poll = pq.poll();
				curCost -= poll[1];
			}
			pq.offer(new int[]{task[1], task[2]});
			curCost += task[2];

			res = Math.max(res, curCost);
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] task = new int[n][3];
		for (int i = 0; i < n; i++) {
			task[i][0] = scanner.nextInt();
			task[i][1] = scanner.nextInt();
			task[i][2] = scanner.nextInt();
		}

		Integer res = minResourceCost(task);
		System.out.println(res);
	}

}
