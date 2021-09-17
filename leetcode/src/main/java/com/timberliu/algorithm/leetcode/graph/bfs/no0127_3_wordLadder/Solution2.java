package com.timberliu.algorithm.leetcode.graph.bfs.no0127_3_wordLadder;

import java.util.*;

/**
 * 127. 单词接龙
 *
 *  双向 BFS（有效解决搜索空间爆炸问题）
 *     从起点或者终点
 *
 *  最坏情况下，wordList 形成的图所有节点都连通，搜索图需要 O(n^2)
 *            字符串替换 遍历a-z 从set查找，需要 O(m)
 *          总时间复杂度为 O(n^2 * m)
 *          总空间复杂度为 O(n^2 * m)
 *
 *  本质是一个【所有边权重为 1 】的最短路问题
 *
 * @author liujie
 * @date 2021/9/16
 */

public class Solution2 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>();
		set.addAll(wordList);
		if (!set.contains(endWord)) {
			return 0;
		}

		// 正方向 从 beginWord 开始
		Deque<String> queue1 = new LinkedList<>();
		// 反方向 从 endWord 开始
		Deque<String> queue2 = new LinkedList<>();
		queue1.offer(beginWord);
		queue2.offer(endWord);

		// 记录 转换过的字符串 及 需要转换的次数
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		map1.put(beginWord, 0);
		map2.put(endWord, 0);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			int len = -1;
			// 哪边少 从哪边开始
			if (queue1.size() <= queue2.size()) {
				len = update(queue1, map1, map2, set);
			} else {
				len = update(queue2, map2, map1, set);
			}
			if (len != -1) {
				// 上面求出的是最短转换路径的长度
				// 题目需要的是最短转换序列的长度，故 +1
				return len + 1;
			}
		}

		return 0;
	}

	// len * 26
	private int update(Deque<String> queue, Map<String, Integer> cur, Map<String, Integer> another, Set<String> set) {
		String head = queue.poll();
		int len = head.length();
		// 当前字符串
		for (int i = 0; i < len; i++) {
			// 每个字符替换成 26 个字符
			for (int j = 0; j < 26; j++) {
				String sub = head.substring(0, i) + (char)('a' + j) + head.substring(i + 1);
				// 替换后的字符串在 wordList 中
				if (set.contains(sub)) {
					if (cur.containsKey(sub)) {
						continue;
					}
					// 另一个方向遍历过，长度相加返回
					if (another.containsKey(sub)) {
						return cur.get(head) + 1 + another.get(sub);
					}
					queue.offer(sub);
					cur.put(sub, cur.get(head) + 1);
				}
			}
		}
		return -1;
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
		Solution2 solution1 = new Solution2();
		System.out.println(solution1.ladderLength("hit", "cog",
				Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

		Solution2 solution2 = new Solution2();
		System.out.println(solution2.ladderLength("hit", "cog",
				Arrays.asList("hot", "dot", "dog", "lot", "log")));

	}
}
