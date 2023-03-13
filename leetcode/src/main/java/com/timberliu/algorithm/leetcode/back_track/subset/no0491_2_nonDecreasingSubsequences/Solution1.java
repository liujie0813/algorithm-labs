package com.timberliu.algorithm.leetcode.back_track.subset.no0491_2_nonDecreasingSubsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 *  找到所有的递增子序列（要去重），序列长度至少为 2
 *
 *  数组中整数范围是 [-100, 100]
 *
 */
public class Solution1 {

    public static List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, 0, new ArrayList<>(), res);
		return res;
    }

    private static void dfs(int[] nums, int begin, List<Integer> curList, List<List<Integer>> res) {
		if (curList.size() > 1) {
			res.add(new ArrayList<>(curList));
		}
		int[] set = new int[201];
		for (int i = begin; i < nums.length; i++) {
			if ((!curList.isEmpty() && nums[i] < curList.get(curList.size() - 1))
					|| set[nums[i] + 100] == 1) {
				continue;
			}
			set[nums[i] + 100] = 1;
			curList.add(nums[i]);
			dfs(nums, i + 1, curList, res);
			curList.remove(curList.size() - 1);
		}
	}

    public static void main(String[] args) {
		List<List<Integer>> res = findSubsequences(new int[]{4, 6, 7, 7});
		printListList(res);
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