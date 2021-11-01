package com.timberliu.algorithm.leetcode.back.track.no0039_2_combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author Timber
 * @date 2021/11/1
 */
public class Solution1 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(candidates, -1, 0, target, new ArrayList<>(), res);
		return res;
	}

	private void dfs(int[] candidates, int last, int sum, int target, List<Integer> cur, List<List<Integer>> res) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int candidate : candidates) {
			if (candidate >= last) {
				cur.add(candidate);
				dfs(candidates, candidate, sum + candidate, target, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/combination-sum/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		List<List<Integer>> res1 = solution1.combinationSum(new int[]{2, 3, 6, 7}, 7);
		for (List<Integer> res : res1) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<List<Integer>> res2 = solution1.combinationSum(new int[]{2, 3, 5}, 8);
		for (List<Integer> res : res2) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

		System.out.println("----- 3 -----");
		List<List<Integer>> res3 = solution1.combinationSum(new int[]{2}, 1);
		for (List<Integer> res : res3) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

		System.out.println("----- 4 -----");
		List<List<Integer>> res4 = solution1.combinationSum(new int[]{1}, 1);
		for (List<Integer> res : res4) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

		System.out.println("----- 5 -----");
		List<List<Integer>> res5 = solution1.combinationSum(new int[]{1}, 2);
		for (List<Integer> res : res5) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

	}

}
