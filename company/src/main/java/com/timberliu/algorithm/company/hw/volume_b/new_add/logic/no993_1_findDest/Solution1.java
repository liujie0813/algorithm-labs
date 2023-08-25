package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no993_1_findDest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找终点
 *
 * @author liujie
 * @date 2023/5/26
 */

public class Solution1 {

	public static int findDest(Integer[] nums) {
		int[] res = {Integer.MAX_VALUE};
		// 第一步走完可能在 [1, len/2]
		for (int i = 1; i <= nums.length / 2; i++) {
			cal(nums, i, 1, res);
		}
		return res[0] == Integer.MAX_VALUE ? -1 : res[0];
	}

	private static void cal(Integer[] nums, int curIndex, int curStep, int[] res) {
		if (curIndex == nums.length - 1) {
			res[0] = Math.min(res[0], curStep);
			return;
		}
		int nextIndex = curIndex + nums[curIndex];
		if (nextIndex < nums.length) {
			cal(nums, nextIndex, curStep + 1, res);
		}
	}

	/*
	 * 7 5 9 4 2 6 8 3 5 4 3 9
	 */
	/**
	 * 1 2 3 7 1 5 9 3 2 1
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] splits = scanner.nextLine().split(" ");
		Integer[] nums = Arrays.stream(splits).map(Integer::parseInt).toArray(Integer[]::new);

		int res = findDest(nums);
		System.out.println(res);
	}

}
