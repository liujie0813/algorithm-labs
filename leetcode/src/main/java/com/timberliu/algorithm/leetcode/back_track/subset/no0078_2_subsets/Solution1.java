package com.timberliu.algorithm.leetcode.back_track.subset.no0078_2_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 *  元素互不相同，返回所有可能的子集
 *
 * @author liujie
 * @date 2022/4/26
 */

public class Solution1 {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		doSubsets(nums, new ArrayList<>(), 0, res);
		return res;
	}

	private void doSubsets(int[] nums, List<Integer> curList, int begin, List<List<Integer>> res) {
		res.add(new ArrayList<>(curList));
		for (int i = begin; i < nums.length; i++) {
			curList.add(nums[i]);
			doSubsets(nums, curList, i + 1, res);
			curList.remove(curList.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		List<List<Integer>> subsets = solution1.subsets(new int[]{1, 2, 3});
		System.out.println();
	}
}
