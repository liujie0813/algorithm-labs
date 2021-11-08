package com.timberliu.algorithm.leetcode.back_track.no0090_2_subsetsII;

import java.util.*;

/**
 * 90. 子集 II
 *
 * @author Timber
 * @date 2021/11/2
 */
public class Solution2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		// 排序后，使用 set 去重
		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private void dfs(int[] nums, int begin, List<Integer> cur, List<List<Integer>> res) {
		if (begin == nums.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		// 数值为 nums[begin] 的连续一段，end 指向下一个元素
		int end = begin;
		while (end < nums.length && nums[end] == nums[begin]) {
			end++;
		}
		// 不选当前位置，直接跳到 end 决策
		dfs(nums, end, cur, res);
		// 选择不同个数的 nums[begin]
		for (int i = begin; i < end; i++) {
			cur.add(nums[i]);
			dfs(nums, end, cur, res);
		}
		for (int i = begin; i < end; i++) {
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/subsets-ii/ -----");
		Solution2 solution1 = new Solution2();
		System.out.println("----- 1 -----");
		List<List<Integer>> res1 = solution1.subsetsWithDup(new int[]{1, 2, 2});
		for (List<Integer> res : res1) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<List<Integer>> res2 = solution1.subsetsWithDup(new int[]{0});
		for (List<Integer> res : res2) {
			for (Integer a : res) {
				System.out.print(a + ", ");
			}
			System.out.print("\t");
		}
		System.out.println();

	}

}
