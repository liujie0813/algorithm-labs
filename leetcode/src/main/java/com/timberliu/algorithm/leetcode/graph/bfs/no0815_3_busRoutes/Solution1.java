package com.timberliu.algorithm.leetcode.graph.bfs.no0815_3_busRoutes;

import java.util.*;

/**
 * 815. 公交路线
 *
 * @author liujie
 * @date 2021/9/18
 */

public class Solution1 {

	public int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) {
			return 0;
		}
		Deque<Integer> queue = new LinkedList<>();
		Map<Integer, Set<Integer>> stationRouteMap = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < routes.length; i++) {
			for (int station : routes[i]) {
				if (station == source) {
					queue.offer(i);
					set.add(i);
				}
				Set<Integer> routeSet = stationRouteMap.getOrDefault(station, new HashSet<>());
				routeSet.add(i);
				stationRouteMap.put(station, routeSet);
			}
		}

		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			while (size-- > 0) {
				int route = queue.poll();
				if (set.contains(route)) {
					continue;
				}
				for (int i : routes[route]) {
					if (target == i) {
						return level;
					}
					for (Integer r : stationRouteMap.get(i)) {
						if (!set.contains(r)) {
							queue.offer(r);
							set.add(route);
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/bus-routes/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.numBusesToDestination(new int[][]{
				{1,2,7},{3,6,7}
		}, 1, 6));

		System.out.println("----- 2 -----");
		System.out.println(solution1.numBusesToDestination(new int[][]{
				{7,12},{4,5,15},{6},{15,19},{9,12,13}
		}, 15, 12));

	}

}
