package com.timberliu.algorithm.company.hw.back_track.no102_2_threeOrderPermutation;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 102. 三阶幻积方
 *
 *  九宫格，各行各列/斜线 乘积相同，输出满足条件的所有排列
 *
 * @author liujie
 * @date 2023/4/14
 */

public class Solution1 {

	public static List<List<Integer>> threeOrderPermutaion(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, new ArrayList<>(), new boolean[nums.length], res);

		res.sort((a, b) -> {
			for (int i = 0; i < 9; i++) {
				if (!a.get(i).equals(b.get(i))) {
					return a.get(i) - b.get(i);
				}
			}
			return 0;
		});
		return res;
	}

	private static void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
		if (path.size() == nums.length) {
			if (check(path)) {
				res.add(new ArrayList<>(path));
			}
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			path.add(nums[i]);
			used[i] = true;
			dfs(nums, path, used, res);
			path.remove(path.size() - 1);
			used[i] = false;
		}
	}

	private static boolean check(List<Integer> path) {
		// 三横
		int val = path.get(0) * path.get(1) * path.get(2);
		if (path.get(3) * path.get(4) * path.get(5) != val) {
			return false;
		}
		if (path.get(6) * path.get(7) * path.get(8) != val) {
			return false;
		}
		// 三竖
		if (path.get(0) * path.get(3) * path.get(6) != val) {
			return false;
		}
		if (path.get(1) * path.get(4) * path.get(7) != val) {
			return false;
		}
		if (path.get(2) * path.get(5) * path.get(8) != val) {
			return false;
		}
		// 两斜
		if (path.get(0) * path.get(4) * path.get(8) != val) {
			return false;
		}
		if (path.get(2) * path.get(4) * path.get(6) != val) {
			return false;
		}
		return true;
	}

	/**
	 * 75 36 10 4 30 225 90 25 12
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = scanner.nextInt();
		}

		List<List<Integer>> res = threeOrderPermutaion(nums);
		PrintUtils.printListListIntegerV2(res);
	}

}
