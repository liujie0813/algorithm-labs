package com.timberliu.algorithm.leetcode.back_track.combination.no0040_2_combinationSumII;

import java.util.*;

/**
 * 40. 组合总和 II
 *   给定数组中和为 target 的组合
 *
 *   每个元素只能选择一次
 *
 * @author Timber
 * @date 2021/11/1
 */
public class Solution1 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		dfs(candidates, 0, target, new ArrayList<>(), res);
		return new ArrayList<>(res);
	}

	private void dfs(int[] candidates, int begin, int target, List<Integer> cur, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}
		// 从 begin 位置开始搜索
		for (int i = begin; i < candidates.length; i++) {
			// 大剪枝：减去 candidates[i] 小于 0，后面肯定也会小于 0
			if (target - candidates[i] < 0) {
				break;
			}
			// 小剪枝：相同数值的结点，跳过
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}
			cur.add(candidates[i]);
			dfs(candidates, i + 1,target - candidates[i], cur, res);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/combination-sum-ii/ ------");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 ------");
		List<List<Integer>> res1 = solution1.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
		for (List<Integer> res : res1) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<List<Integer>> res2 = solution1.combinationSum2(new int[]{2,5,2,1,2}, 5);
		for (List<Integer> res : res2) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

	}

}
