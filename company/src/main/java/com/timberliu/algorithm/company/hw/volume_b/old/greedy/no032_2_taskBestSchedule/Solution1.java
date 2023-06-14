package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no032_2_taskBestSchedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 32. 任务最优调度
 *
 * @author liujie
 * @date 2023/6/13
 */

public class Solution1 {

	public static int taskBestSchedule(int[] tasks, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int task : tasks) {
			map.put(task, map.getOrDefault(task, 0) + 1);
		}
		List<int[]> list = map.values().stream().map(v -> new int[]{v, 0}).sorted((a, b) -> b[0] - a[0]).collect(Collectors.toList());

		int total = tasks.length;
		int res = 0;
		while (total > 0) {
			res++;
			// 本轮时间是否可用
			boolean flag = true;
			for (int[] task : list) {
				if (flag && task[0] > 0 && task[1] == 0) {
					// 本轮时间已用
					flag = false;
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
