package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no032_2_taskBestSchedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 32. 任务最优调度
 *
 *  同类型任务需要间隔 n 个时间单位
 *
 *  完成所有任务所需的最短时间
 *
 *
 *  task[0] 该类型的任务数
 *  task[1] 任务的冷却时间
 *
 * @author liujie
 * @date 2023/6/13
 */

public class Solution1 {

	public static int taskBestSchedule(int[] tasks, int n) {
		// 统计各类型任务的数量
		Map<Integer, Integer> map = new HashMap<>();
		for (int task : tasks) {
			map.put(task, map.getOrDefault(task, 0) + 1);
		}
		// 按照任务数量倒排序
		List<int[]> list = map.values().stream().map(v -> new int[]{v, 0}).sorted((a, b) -> b[0] - a[0]).collect(Collectors.toList());

		// 任务总数
		int total = tasks.length;
		// 执行时间
		int res = 0;
		while (total > 0) {
			res++;
			// 本轮时间是否用过
			boolean used = false;
			for (int[] task : list) {
				if (!used && task[0] > 0 && task[1] == 0) {
					// 本轮时间已用
					used = true;
					// 本任务数减 1
					task[0]--;
					total--;
					// 本任务进入冷却
					task[1] = n;
				} else {
					if (task[1] > 0) {
						task[1]--;
					}
				}
			}
		}
		return res;
	}

	/**
	 * 2,2,2,3
	 */
	/**
	 * 1,1,2,2,3,3,4,4
	 * 2
	 * 本解法有误
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(",");
		int[] task = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			task[i] = Integer.parseInt(splits[i]);
		}
		int n = Integer.parseInt(scanner.nextLine());

		int res = taskBestSchedule(task, n);
		System.out.println(res);
	}

}
