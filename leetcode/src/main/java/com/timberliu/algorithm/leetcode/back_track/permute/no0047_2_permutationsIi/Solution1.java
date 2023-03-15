package com.timberliu.algorithm.leetcode.back_track.permute.no0047_2_permutationsIi;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列II
 *   可包含重复数字的全排列
 *
 *   set 记录当前路径上哪些数字已经使用过
 *
 *   使用 !used[i - 1]，说明两个重复的数字在同一层，去重更彻底
 *   使用 used[i - 1]，说明两个重复的数字在上下两层
*/
public class Solution1 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.asList(nums);
		backtracking(nums, new boolean[nums.length], new ArrayList<>(), res);
		return res;
	}

	private static void backtracking(int[] nums, boolean[] used, List<Integer> curList, List<List<Integer>> res) {
		if (nums.length == curList.size()) {
			res.add(new ArrayList<>(curList));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			if (used[i]) {
				continue;
			}
			used[i] = true;
			curList.add(nums[i]);
			backtracking(nums, used, curList, res);
			used[i] = false;
			curList.remove(curList.size() - 1);
		}
	}

    public static void main(String[] args) {
		List<List<Integer>> res1 = permuteUnique(new int[]{1, 1, 2});
		PrintUtils.printListListInteger(res1);

	}

}