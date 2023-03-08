package com.timberliu.algorithm.leetcode.back_track.combination.no0216_2_combinationSumIii;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *   [1, 9] 中和为 n 的 k 个数的组合
 *
 *   剪枝：
 *    1. target 小于后续任何一个数，直接返回
 *    2. for 循环，后面不能少于 k 个数
 */

public class Solution1 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(n, k, 1, new ArrayList<>(), res);
		return res;
    }

    private static void backtrack(int target, int remain, int startVal, List<Integer> curList, List<List<Integer>> res) {
		if (remain == 0) {
			if (target == 0) {
				res.add(new ArrayList<>(curList));
			}
			return;
		}
		if (target < startVal) {
			return;
		}
		for (int i = startVal; i <= 9 - remain + 1; i++) {
			curList.add(i);
			backtrack(target - i, remain - 1, i + 1, curList, res);
			curList.remove(curList.size() - 1);
		}
	}

    public static void main(String[] args) {
		List<List<Integer>> lists1 = combinationSum3(3, 7);
		printListList(lists1);

		List<List<Integer>> lists2 = combinationSum3(3, 9);
		printListList(lists2);

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