package com.timberliu.algorithm.company.hw.volume_a.priority_queue.no053_1_taskExecuteOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 53. 任务调度
 *
 *  任务id、任务优先级、到达时间、执行时间
 *
 * @author liujie
 * @date 2023/4/24
 */

public class Solution1 {

	public static List<int[]> taskExecutorOrder(List<int[]> task) {
		List<int[]> res = new ArrayList<>();
		// 等待队列
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[1] == b[1]) {
				return a[2] - b[2];
			}
			return b[1] - a[1];
		});
		pq.offer(task.get(0));
		int curTime = task.get(0)[2];
		for (int i = 1; i < task.size(); i++) {
			int[] curTask = pq.peek();
			int[] nextTask = task.get(i);

			int curTaskEndTime = curTime + curTask[3];
			// 当前任务的结束时间 大于下一个任务的到达时间，即当前任务还未执行完
			if (curTaskEndTime > nextTask[2]) {
				// 能执行多少，就执行多少
				curTask[3] -= (nextTask[2] - curTime);
				curTime = nextTask[2];
			} else {
				// 当前任务可以执行完
				pq.poll();
				res.add(new int[]{curTask[0], curTaskEndTime});
				curTime = curTaskEndTime;
				// 当前任务执行结束后，下次任务还没到
				if (curTaskEndTime < nextTask[2]) {
					while (!pq.isEmpty()) {
						int[] idleTask = pq.peek();
						int idleTaskEndTime = curTime + idleTask[3];
						if (idleTaskEndTime > nextTask[2]) {
							idleTask[3] -= nextTask[2] - curTime;
							break;
						} else {
							pq.poll();
							res.add(new int[]{idleTask[0], idleTaskEndTime});
							curTime = idleTaskEndTime;
						}
					}
					curTime = nextTask[2];
				}
			}
			pq.offer(nextTask);
		}

		while (!pq.isEmpty()) {
			int[] pollTask = pq.poll();
			int pollTaskEndTime = curTime + pollTask[3];
			res.add(new int[]{pollTask[0], pollTaskEndTime});
			curTime = pollTaskEndTime;
		}
		return res;
	}

	/**
	 * 1 2 1 1
	 * 2 2 3 3
	 * 3 3 3 2
	 * 4 4 3 4
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<int[]> list = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if ("".equals(line)) {
				break;
			}
			String[] strs = line.split(" ");
			int[] arr = new int[strs.length];
			for (int i = 0; i < strs.length; i++) {
				arr[i] = Integer.parseInt(strs[i]);
			}
			list.add(arr);
		}
		List<int[]> res = taskExecutorOrder(list);
		for (int[] a : res) {
			System.out.println(a[0] + " " + a[1]);
		}
	}

}
