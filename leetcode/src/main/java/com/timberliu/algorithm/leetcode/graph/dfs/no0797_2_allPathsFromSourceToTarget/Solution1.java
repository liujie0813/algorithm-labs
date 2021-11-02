package com.timberliu.algorithm.leetcode.graph.dfs.no0797_2_allPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 *
 * @author Timber
 * @date 2021/9/26
 */
public class Solution1 {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		cur.add(0);
		allPathsSourceTarget(graph, 0, cur, res);
		return res;
	}

	private void allPathsSourceTarget(int[][] graph, int cur, List<Integer> path, List<List<Integer>> res) {
		if (cur == graph.length - 1) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i : graph[cur]) {
			path.add(i);
			allPathsSourceTarget(graph, i, path, res);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/all-paths-from-source-to-target/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		List<List<Integer>> res1 = solution1.allPathsSourceTarget(new int[][]{
				{1, 2}, {3}, {3}, {}
		});
		for (List<Integer> r1 : res1) {
			for (Integer a : r1) {
				System.out.print(a + "->");
			}
			System.out.println();
		}

		System.out.println("----- 2 -----");
		List<List<Integer>> res2 = solution1.allPathsSourceTarget(new int[][]{
				{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}
		});
		for (List<Integer> r1 : res2) {
			for (Integer a : r1) {
				System.out.print(a + "->");
			}
			System.out.println();
		}

		System.out.println("----- 3 -----");
		List<List<Integer>> res3 = solution1.allPathsSourceTarget(new int[][]{
				{1}, {}
		});
		for (List<Integer> r1 : res3) {
			for (Integer a : r1) {
				System.out.print(a + "->");
			}
			System.out.println();
		}

		System.out.println("----- 4 -----");
		List<List<Integer>> res4 = solution1.allPathsSourceTarget(new int[][]{
				{1, 2, 3}, {2}, {3}, {}
		});
		for (List<Integer> r1 : res4) {
			for (Integer a : r1) {
				System.out.print(a + "->");
			}
			System.out.println();
		}

		System.out.println("----- 5 -----");
		List<List<Integer>> res5 = solution1.allPathsSourceTarget(new int[][]{
				{1, 3}, {2}, {3}, {}
		});
		for (List<Integer> r1 : res5) {
			for (Integer a : r1) {
				System.out.print(a + "->");
			}
			System.out.println();
		}

	}

}
