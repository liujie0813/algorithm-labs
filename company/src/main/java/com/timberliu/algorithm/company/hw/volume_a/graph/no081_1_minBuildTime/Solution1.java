package com.timberliu.algorithm.company.hw.volume_a.graph.no081_1_minBuildTime;

import java.util.*;

/**
 * 81. 快速开组建站
 *
 * @author liujie
 * @date 2023/4/20
 */

public class Solution1 {

	public static int minBuildTime(int taskNum, int[][] relations) {
		// 构造一个数
		Map<Integer, List<Integer>> nextTaskMap = new HashMap<>();
		// 依赖的任务（入度）
		int[] inDegree = new int[taskNum];

		for (int[] relation : relations) {
			int cur = relation[0];
			int next = relation[1];
			List<Integer> nextTasks = nextTaskMap.computeIfAbsent(cur, (val) -> new ArrayList<>());
			nextTasks.add(next);
			inDegree[next]++;
		}

		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < taskNum; i++) {
			// 入度为 0，或者说没有依赖的任务，可以同时启动
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		// 层级遍历
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer peek = queue.pop();
				if (nextTaskMap.containsKey(peek) && nextTaskMap.get(peek).size() > 0) {
					for (Integer next : nextTaskMap.get(peek)) {
						queue.offer(next);
					}
				}
			}
			level++;
		}
		return level;
	}

	/*
	 * 5
	 * 5
	 * 0 4
	 * 1 2
	 * 1 3
	 * 2 3
	 * 2 4
	 */
	/**
	 * 5
	 * 3
	 * 0 3
	 * 0 4
	 * 1 3
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int taskNum = scanner.nextInt();
		int relationsNum = scanner.nextInt();
		int[][] relations = new int[relationsNum][2];
		for (int i = 0; i < relationsNum; i++) {
			relations[i][0] = scanner.nextInt();
			relations[i][1] = scanner.nextInt();
		}

		int res = minBuildTime(taskNum, relations);
		System.out.println(res);
	}

}
