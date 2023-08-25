package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no032_2_taskBestSchedule;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 32. 任务最优调度
 *
 *  同类型任务需要间隔 n 个时间单位
 *  完成所有任务所需的最短时间
 *
 *  统计各任务数量，找到数量最多的任务，如果数量为 k，则最短时间为 (k-1) * (n+1) + 1
 *  其他任务数量较少，直接在数量最多的任务的冷却时间中运行即可
 *
 *  特殊情况1：数量最多的任务有多个 p，则最短时间为 (k-1) * (n+1) + p
 *
 *  特殊情况2：数量最多的任务有多个 p，且大于冷却时间 n，则最短时间为 总任务数量本身
 *
 * @author liujie
 * @date 2023/6/13
 */

public class Solution2 {

	public static int taskBestSchedule(int[] tasks, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int task : tasks) {
			map.put(task, map.getOrDefault(task, 0) + 1);
		}
		Integer k = map.values().stream().max(Comparator.naturalOrder()).orElse(0);
		int p = 0;
		for (Integer value : map.values()) {
			if (Objects.equals(value, k)) {
				p++;
			}
		}
		return Math.max((k - 1) * (n + 1) + p, tasks.length);
	}

	/**
	 * 2,2,2,3
	 */
	/**
     * 1,1,2,2,3,3,4,4
	 * 2
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
