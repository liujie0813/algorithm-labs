package com.timberliu.algorithm.leetcode.graph.bfs.no0773_3_slidingPuzzle;

import java.util.*;

/**
 * 773. 滑动谜题
 *
 * @author liujie
 * @date 2021/9/17
 */

public class Solution1 {

	private int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private String endState = "123450";

	public int slidingPuzzle(int[][] board) {
		String initState = getState(board);
		if (initState.equals(endState)) {
			return 0;
		}

		Map<String, Integer> visited1 = new HashMap<>();
		Map<String, Integer> visited2 = new HashMap<>();
		visited1.put(initState, 0);
		visited2.put(endState, 0);

		Deque<String> queue1 = new LinkedList<>();
		Deque<String> queue2 = new LinkedList<>();
		queue1.offer(initState);
		queue2.offer(endState);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			int len;
			if (queue1.size() < queue2.size()) {
				len = update(queue1, visited1, visited2);
			} else {
				len = update(queue2, visited2, visited1);
			}
			if (len != -1) {
				return len;
			}
		}
		return -1;
	}

	private int update(Deque<String> queue, Map<String, Integer> map, Map<String, Integer> another) {
		String prevState = queue.poll();
		int zero = prevState.indexOf("0");
		int zeroX = zero / 3;
		int zeroY = zero % 3;
		for (Integer neighbor : getNeighbors(zeroX, zeroY)) {
			String curState = swapZero(prevState, zero, neighbor);
			if (another.containsKey(curState)) {
				return map.get(prevState) + 1 + another.get(curState);
			}
			if (map.containsKey(curState)) {
				continue;
			}
			queue.offer(curState);
			map.put(curState, map.get(prevState) + 1);
		}
		return -1;
	}

	private String swapZero(String prevState, int zero, int another) {
		char[] chars = prevState.toCharArray();
		char tmp = chars[zero];
		chars[zero] = chars[another];
		chars[another] = tmp;
		return String.valueOf(chars);
	}

	private String getState(int[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int[] ints : board) {
			for (int i : ints) {
				sb.append(i);
			}
		}
		return sb.toString();
	}

	private List<Integer> getNeighbors(int x, int y) {
		List<Integer> res = new ArrayList<>();
		for (int[] diff : dist) {
			int nextX = x + diff[0];
			int nextY = y + diff[1];
			if (nextX < 0 || nextX >= 2 || nextY < 0 || nextY >= 3) {
				continue;
			}
			res.add(nextX * 3 + nextY);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/sliding-puzzle/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.slidingPuzzle(new int[][]{
				{1, 2, 3},
				{4, 0, 5}
		}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.slidingPuzzle(new int[][]{
				{1, 2, 3},
				{5, 4, 0}
		}));

		System.out.println("----- 3 -----");
		/*
		 *   4 1 2  -->  4 1 2  -->  0 1 2  -->  1 0 2  -->  1 2 0  -->  1 2 3
		 *   5 0 3       0 5 3       4 5 3       4 5 3       4 5 3       4 5 0
		 */
		System.out.println(solution1.slidingPuzzle(new int[][]{
				{4, 1, 2},
				{5, 0, 3}
		}));

		System.out.println("----- 4 -----");
		System.out.println(solution1.slidingPuzzle(new int[][]{
				{3, 2, 4},
				{1, 5, 0}
		}));

	}
}
