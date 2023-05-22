package com.timberliu.algorithm.company.hw.volume_a.tree.no069_2_findNode;

import java.util.*;

/**
 * 69. 查找二叉树节点
 *
 *  <x, y>：第 x 层，第 y 个（相对偏移量）
 *
 *  1. 多叉树
 *  2. 不是完全二叉树
 *
 * @author liujie
 * @date 2023/4/23
 */

public class Solution1 {

	public static String findNode(List<List<Integer>> tree, int x, int y) {
		if (x < 0 && y < 0) {
			return "{}";
		}
		Deque<List<Integer>> queue = new LinkedList<>();
		queue.offer(tree.get(0));
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				List<Integer> node = queue.poll();
				if (level == x && i == y) {
					return "{" + node.get(0) + "}";
				}
				for (int j = 1; j < node.size(); j++) {
					queue.offer(tree.get(node.get(j)));
				}
			}
			level++;
		}
		return "{}";
	}

	/*
	 * 6
	 * 10 1 2
	 * -21 3 4
	 * 23 5
	 * 14
	 * 35
	 * 66
	 * 1 1
	 */
	/**
	 * 6
	 * 10 1 2
	 * -21 3 4
	 * 23 5
	 * 14
	 * 35
	 * 66
	 * -1 -1
	 */
	/**
	 * 14
	 * 0 1 2 3 4
	 * -11 5 6 7 8
	 * 113 9 10 11
	 * 24 12
	 * 35
	 * 66 13
	 * 77
	 * 88
	 * 99
	 * 101
	 * 102
	 * 103
	 * 25
	 * 104
	 * 2 5
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		List<List<Integer>> tree = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] strs = scanner.nextLine().split(" ");
			List<Integer> levelList = new ArrayList<>();
			for (int j = 0; j < strs.length; j++) {
				levelList.add(Integer.parseInt(strs[j]));
			}
			tree.add(levelList);
		}
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		String res = findNode(tree, x, y);
		System.out.println(res);
	}

}
