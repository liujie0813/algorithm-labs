package com.timberliu.algorithm.leetcode.back_track.permute.no0046_2_permutations;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *   不包含重复数字的全排列
 *
 */
public class Solution1 {

    public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtracking(nums, new boolean[nums.length], new ArrayList<>(), res);
		return res;
    }

    private static void backtracking(int[] nums, boolean[] set, List<Integer> curList, List<List<Integer>> res) {
    	if (nums.length == curList.size()) {
    		res.add(new ArrayList<>(curList));
    		return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (set[i]) {
				continue;
			}
			set[i] = true;
			curList.add(nums[i]);
			backtracking(nums, set, curList, res);
			set[i] = false;
			curList.remove(curList.size() - 1);
		}
	}

    public static void main(String[] args) {
		List<List<Integer>> res1 = permute(new int[]{1, 2, 3});
		PrintUtils.printListList(res1);

		List<List<Integer>> res2 = permute(new int[]{1, 3, 5, 7});
		PrintUtils.printListList(res2);

		List<List<Integer>> res3 = permute(new int[]{1});
		PrintUtils.printListList(res3);
	}

}