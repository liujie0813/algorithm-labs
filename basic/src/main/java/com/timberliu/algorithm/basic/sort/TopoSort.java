package com.timberliu.algorithm.basic.sort;

import java.util.*;

/**
 * @author liujie
 * @date 2024/8/29
 */

public class TopoSort {

	public int[] topoSort(int[][] dependencies, int num) {
		Map<Integer, List<Integer>> edges = new HashMap<>();
		int[] degrees = new int[num];
		for (int[] dependency : dependencies) {
			List<Integer> list = edges.computeIfAbsent(dependency[1], val -> new ArrayList<>());
			list.add(dependency[0]);
			degrees[dependency[0]]++;
		}

		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < num; i++) {
			if (degrees[i] == 0) {
				queue.offer(i);
			}
		}

		int[] res = new int[num];
		int index = 0;
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			res[index++] = poll;
			List<Integer> nodes = edges.get(poll);
			if (nodes == null) {
				continue;
			}
			for (Integer node : nodes) {
				degrees[node]--;
				if (degrees[node] == 0) {
					queue.offer(node);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TopoSort solution1 = new TopoSort();
		int[] res1 = solution1.topoSort(new int[][]{
				{2,0},{1,0}, {3,1}, {3,2}
		}, 4);
		System.out.println(Arrays.toString(res1));

	}

}
