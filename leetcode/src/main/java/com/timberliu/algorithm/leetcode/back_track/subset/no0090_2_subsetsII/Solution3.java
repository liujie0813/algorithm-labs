package com.timberliu.algorithm.leetcode.back_track.subset.no0090_2_subsetsII;

import java.util.*;

/**
 * 90. 子集 II
 *
 *  包含重复元素，返回所有可能的子集
 *
 * @author Timber
 * @date 2021/11/2
 */
public class Solution3 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, 0, new ArrayList<>(), res);
		return new ArrayList<>(res);
	}

	private void dfs(int[] nums, int begin, List<Integer> cur, List<List<Integer>> res) {
		res.add(new ArrayList<>(cur));
		for (int i = begin; i < nums.length; i++) {
			if (i > begin && nums[i] == nums[i - 1]) {
				continue;
			}
			cur.add(nums[i]);
			dfs(nums, i + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/subsets-ii/ -----");
		Solution3 solution1 = new Solution3();
		System.out.println("----- 1 -----");
		List<List<Integer>> res1 = solution1.subsetsWithDup(new int[]{1, 2, 2});
		for (List<Integer> res : res1) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.println();
		}

		System.out.println("----- 2 -----");
		List<List<Integer>> res2 = solution1.subsetsWithDup(new int[]{0});
		for (List<Integer> res : res2) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.println();
		}

	}

}
