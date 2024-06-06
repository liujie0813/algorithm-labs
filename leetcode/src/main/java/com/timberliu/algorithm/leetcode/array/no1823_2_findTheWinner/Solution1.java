package com.timberliu.algorithm.leetcode.array.no1823_2_findTheWinner;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1823. 找出游戏的获胜者
 *
 * @author liujie
 * @date 2024/6/5
 */

public class Solution1 {

	public int findTheWinner(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int index = 1;
		while (queue.size() > 1) {
			Integer poll = queue.poll();
			if (index++ % k != 0) {
				queue.offer(poll);
			}
		}
		return queue.poll();
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int res1 = solution1.findTheWinner(5, 2);
		System.out.println(res1);

		int res2 = solution1.findTheWinner(6, 5);
		System.out.println(res2);
	}

}
