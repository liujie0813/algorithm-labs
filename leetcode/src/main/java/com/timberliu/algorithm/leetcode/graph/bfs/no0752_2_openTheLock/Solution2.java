package com.timberliu.algorithm.leetcode.graph.bfs.no0752_2_openTheLock;

import java.util.*;

/**
 * 752. 打开转盘锁
 *
 *  类似「127. 单词接龙」，双向 BFS
 *
 * @author liujie
 * @date 2021/9/17
 */

public class Solution2 {

	private String start = "0000";
	private int[] dist = new int[]{-1, 1};

	public int openLock(String[] deadends, String target) {
		Set<String> deadendSet = new HashSet<>();
		deadendSet.addAll(Arrays.asList(deadends));
		if (deadendSet.contains(start)) {
			return -1;
		}
		if (start.equals(target)) {
			return 0;
		}

		Map<String, Integer> visited1 = new HashMap<>();
		Map<String, Integer> visited2 = new HashMap<>();
		visited1.put(start, 0);
		visited2.put(target, 0);

		Deque<String> queue1 = new LinkedList<>();
		Deque<String> queue2 = new LinkedList<>();
		queue1.offer(start);
		queue2.offer(target);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			int len;
			if (queue1.size() < queue2.size()) {
				len = update(queue1, visited1, visited2, deadendSet);
			} else {
				len = update(queue2, visited2, visited1, deadendSet);
			}
			if (len != -1) {
				return len;
			}
		}
		return -1;
	}

	private int update(Deque<String> queue, Map<String, Integer> map, Map<String, Integer> another, Set<String> deadendSet) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			String prevStr = queue.poll();
			char[] prev = prevStr.toCharArray();
			for (int j = 0; j < 4; j++) {
				for (int d : dist) {
					turn(prev, j, d);
					String cur = String.valueOf(prev);
					if (another.containsKey(cur)) {
						return map.get(prevStr) + 1 + another.get(cur);
					}
					if (deadendSet.contains(cur) || map.containsKey(cur)) {
						turnBack(prev, j, d);
						continue;
					}
					map.put(cur, map.get(prevStr) + 1);
					queue.offer(cur);
					turnBack(prev, j, d);
				}
			}
		}
		return -1;
	}

	private void turn(char[] prev, int j, int d) {
		if (prev[j] == '9' && d == 1) {
			prev[j] = '0';
		} else if (prev[j] == '0' && d == -1){
			prev[j] = '9';
		} else {
			prev[j] += d;
		}
	}

	private void turnBack(char[] prev, int j, int d) {
		if (prev[j] == '0' && d == 1) {
			prev[j] = '9';
		} else if (prev[j] == '9' && d == -1){
			prev[j] = '0';
		} else {
			prev[j] -= d;
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/open-the-lock/ -----");
		Solution2 solution1 = new Solution2();
		/*
		 *   0000
		 *   0900
		 *   0800
		 *   0700
		 *   0600
		 *   0500
		 *   0400
		 *   0300
		 *   0200
		 *   0209
		 *   0208
		 *   0207
		 *   0206
		 *   0205
		 *   0204
		 *   0203
		 *   0202
		 */
		System.out.println(solution1.openLock(new String[]{
				"0201", "0101", "0102", "1212", "2002"
		}, "0202"));

		System.out.println(solution1.openLock(new String[]{
				"8888",
		}, "0009"));

		System.out.println(solution1.openLock(new String[]{
				"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"
		}, "8888"));

		System.out.println(solution1.openLock(new String[]{
				"0000"
		}, "8888"));

		System.out.println(solution1.openLock(new String[]{
				"5557","5553","5575","5535","5755","5355","7555","3555","6655","6455","4655","4455","5665","5445","5645","5465","5566","5544","5564","5546","6565","4545","6545","4565","5656","5454","5654","5456","6556","4554","4556","6554"
		}, "5555"));

	}

}
