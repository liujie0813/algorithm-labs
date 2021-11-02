package com.timberliu.algorithm.leetcode.back.track.no0090_2_subsetsII;

import java.util.*;

/**
 * 90. 子集 II
 *
 * @author Timber
 * @date 2021/11/2
 */
public class Solution1 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		// 排序后，使用 set 去重
		Set<List<Integer>> res = new HashSet<>();
		dfs(nums, 0, new ArrayList<>(), res);
		return new ArrayList<>(res);
	}

	private void dfs(int[] nums, int begin, List<Integer> cur, Set<List<Integer>> res) {
		if (begin == nums.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		cur.add(nums[begin]);
		dfs(nums, begin + 1, cur, res);

		cur.remove(cur.size() - 1);
		dfs(nums, begin + 1, cur, res);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/subsets-ii/ -----");
		Solution1 solution1 = new Solution1();
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
