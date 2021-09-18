package com.timberliu.algorithm.leetcode.graph.bfs.lcp_no007_1_transmitInformation;

import java.util.*;

/**
 * LCP 07. 传递信息
 *
 *   bfs 扩展 k 层，统计队列中 n-1 的次数
 *
 *   时间复杂度：O(n^k)
 *   空间复杂度：O(n^k + n^2)
 *
 * @author liujie
 * @date 2021/9/18
 */

public class Solution1 {

	public int numWays(int n, int[][] relation, int k) {
		Map<Integer, List<Integer>> map1 = new HashMap<>();
		for (int[] ints : relation) {
			if (map1.containsKey(ints[0])) {
				map1.get(ints[0]).add(ints[1]);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(ints[1]);
				map1.put(ints[0], list);
			}
		}

		Deque<Integer> queue = new LinkedList<>();
		queue.offer(0);
		while (!queue.isEmpty() && k-- > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer prev = queue.poll();
				List<Integer> list = map1.get(prev);
				if (list == null) {
					continue;
				}
				for (Integer v : list) {
					queue.offer(v);
				}
			}
		}

		int res = 0;
		while (!queue.isEmpty()) {
			if (queue.poll() == n - 1) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/chuan-di-xin-xi/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.numWays(5, new int[][]{
				{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}
		}, 3));

		System.out.println("----- 2 -----");
		System.out.println(solution1.numWays(3, new int[][]{
				{0,2},{2,1}
		}, 2));

	}

}
