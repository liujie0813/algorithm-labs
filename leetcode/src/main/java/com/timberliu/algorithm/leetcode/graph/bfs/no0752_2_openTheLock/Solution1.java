package com.timberliu.algorithm.leetcode.graph.bfs.no0752_2_openTheLock;

import java.util.*;

/**
 * 752. 打开转盘锁
 *
 * @author liujie
 * @date 2021/9/17
 */

public class Solution1 {

	private String start = "0000";

	public int openLock(String[] deadends, String target) {
		int[] dist = new int[]{-1, 1};

		Set<String> visited = new HashSet<>();
		visited.addAll(Arrays.asList(deadends));
		if (visited.contains(start)) {
			return -1;
		}
		if (start.equals(target)) {
			return 0;
		}

		visited.add(start);
		Deque<String> queue = new LinkedList<>();
		queue.offer(start);

		int level = 0;
		while (!queue.isEmpty()) {
			int len = queue.size();
			level++;
			for (int i = 0; i < len; i++) {
				char[] prev = queue.poll().toCharArray();
				for (int j = 0; j < 4; j++) {
					for (int d : dist) {
						turn(prev, j, d);
						String cur = String.valueOf(prev);
						if (cur.equals(target)) {
							return level;
						}
						if (visited.contains(cur)) {
							turnBack(prev, j, d);
							continue;
						}
						visited.add(cur);
						queue.offer(cur);
						turnBack(prev, j, d);
					}
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
		Solution1 solution1 = new Solution1();
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

	}

}
