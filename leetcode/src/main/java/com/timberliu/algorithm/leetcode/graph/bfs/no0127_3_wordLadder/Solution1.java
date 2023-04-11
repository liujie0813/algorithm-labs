package com.timberliu.algorithm.leetcode.graph.bfs.no0127_3_wordLadder;

import java.util.*;

/**
 * 127. 单词接龙
 *   求两个节点之间的最短路径
 *
 *   无线图求最短路，适合用广搜（广搜只要到达了终点，那么一定是最短路径）
 *
 *   无向图，使用标记位，标记节点是否走过，否则会死循环
 *
 *
 * 最坏情况下，搜索图需要 O(n^2)
 *          字符串替换遍历 wordList，需要 O(n * m)
 *       时间复杂度为 O(n^3 * m)
 *       空间复杂度为 O(n^2 * m)
 *
 * @author liujie
 * @date 2021/9/16
 */

public class Solution1 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Deque<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> marked = new HashSet<>();
		marked.add(beginWord);

		int level = 1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			level++;
			// 层级遍历
			for (int i = 0; i < len; i++) {
				String head = queue.poll();
				// 遍历 wordList，判断是否可以转换
				for (String str : wordList) {
					if (marked.contains(str)) {
						continue;
					}
					if (canTransform(head, str)) {
						if (str.equals(endWord)) {
							// 返回 level
							return level;
						}
						// 可以转换添加到队列
						queue.offer(str);
						marked.add(str);
					}
				}
			}
		}
		return 0;
	}

	// n * len
	private boolean canTransform(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
		}
		// 有一个字母不同即可以转换
		return count == 1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/word-ladder/ -----");
		/*
		 *            hit
		 *             |
		 *            hot
		 *          /    \
		 *        dot    lot
		 *       /      /
		 *     dog     log
		 *    /
		 *   cog
		 *
		 */
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.ladderLength("hit", "cog",
				Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

		Solution1 solution2 = new Solution1();
		System.out.println(solution2.ladderLength("hit", "cog",
				Arrays.asList("hot", "dot", "dog", "lot", "log")));

	}
}
