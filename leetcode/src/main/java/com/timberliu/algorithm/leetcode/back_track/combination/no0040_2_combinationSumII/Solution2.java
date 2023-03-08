package com.timberliu.algorithm.leetcode.back_track.combination.no0040_2_combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author liujie
 * @date 2023/3/8
 */

public class Solution2 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	private static void backtrack(int[] candidates, int target, int beginIndex, List<Integer> curList, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(curList));
			return;
		}
		for (int i = beginIndex; i < candidates.length; i++) {
			if (target < candidates[i]) {
				// 小于下标为 i 的元素，后面的肯定也不满足
				break;
			}
			if (i > 0 && candidates[i] == candidates[i - 1]) {
				// 跳过重复元素
				continue;
			}
			curList.add(candidates[i]);
			backtrack(candidates, target - candidates[i], i + 1, curList, res);
			curList.remove(curList.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
		printListList(lists);

		List<List<Integer>> lists1 = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
		printListList(lists1);
	}


	private static void printListList(List<List<Integer>> list) {
		for (List<Integer> list1 : list) {
			for (Integer val1 : list1) {
				System.out.print(val1 + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();
	}


}
