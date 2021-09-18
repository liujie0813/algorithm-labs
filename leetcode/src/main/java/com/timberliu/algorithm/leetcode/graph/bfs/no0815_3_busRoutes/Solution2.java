package com.timberliu.algorithm.leetcode.graph.bfs.no0815_3_busRoutes;

import java.util.*;

/**
 * 815. 公交路线
 *
 *  双向 DFS
 *
 * @author liujie
 * @date 2021/9/18
 */

public class Solution2 {

	public int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) {
			return 0;
		}
		// <车站，List<路线>>
		Map<Integer, Set<Integer>> stationRouteMap = new HashMap<>();
		Deque<Integer> queue1 = new LinkedList<>();
		Deque<Integer> queue2 = new LinkedList<>();
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		for (int i = 0; i < routes.length; i++) {
			for (int station : routes[i]) {
				if (station == source) {
					queue1.offer(i);
					map1.put(i, 1);
				}
				if (station == target) {
					queue2.offer(i);
					map2.put(i, 1);
				}
				Set<Integer> routeSet = stationRouteMap.getOrDefault(station, new HashSet<>());
				routeSet.add(i);
				stationRouteMap.put(station, routeSet);
			}
		}

		Set<Integer> sourceRoute = stationRouteMap.get(source);
		Set<Integer> targetRoute = stationRouteMap.get(target);
		// source 和 target 是否在某条路线中
		if (sourceRoute == null || targetRoute == null) {
			return -1;
		}
		sourceRoute.retainAll(targetRoute);
		// 是否有交集
		if (!sourceRoute.isEmpty()) {
			return 1;
		}

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			int res = -1;
			if (queue1.size() < queue2.size()) {
				res = update(queue1, map1, map2, routes, stationRouteMap);
			} else {
				res = update(queue2, map2, map1, routes, stationRouteMap);
			}
			if (res != -1) {
				return res;
			}
		}
		return -1;
	}

	private int update(Deque<Integer> queue, Map<Integer, Integer> map, Map<Integer, Integer> another,
					   int[][] routes, Map<Integer, Set<Integer>> stationRouteMap) {
		int route = queue.poll();
		Integer step = map.get(route);
		for (int station : routes[route]) {
			Set<Integer> lines = stationRouteMap.get(station);
			if (lines == null) {
				continue;
			}
			// 该车站可乘的路径
			for (Integer r : lines) {
				if (another.containsKey(r)) {
					return step + another.get(r);
				}
				if (!map.containsKey(r)) {
					queue.offer(r);
					map.put(r, step + 1);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/bus-routes/ -----");
		Solution2 solution1 = new Solution2();
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
