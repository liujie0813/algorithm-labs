package com.timberliu.algorithm.leetcode.back_track.combination.no0698_2_partitionTokEqualSumSubsets;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 *
 *
 *  回溯 + 剪枝
 *
 *  时间复杂度：O(k ^ n)
 *
 * @author Timber
 * @date 2023/4/7
 */
public class Solution1 {

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		Arrays.sort(nums);

		int target = sum / k;
		int[] bucket = new int[k];
		// 每次考虑第 cur 个球，尝试放入各个桶中
		return canSplit(nums, nums.length - 1, bucket, k, target);
	}

	private static boolean canSplit(int[] nums, int cur, int[] bucket, int k, int target) {
		if (cur == -1) {
			// 如果所有球能按要求放入桶中，则每个桶内的球的和一定为 target
//			for (int val : bucket) {
//				if (val != target) {
//					return false;
//				}
//			}
			return true;
		}
		for (int i = 0; i < k; i++) {
			// 如果和上一个桶的元素和相等，则可以跳过当前桶
			// 放到上一个桶，和放入当前桶，结果是一致的
			if (i > 0 && bucket[i] == bucket[i - 1]) {
				continue;
			}
			// 放入球后，桶内元素和超过 target，尝试下一个桶
			if (bucket[i] + nums[cur] > target) {
				continue;
			}
			bucket[i] += nums[cur];
			if (canSplit(nums, cur - 1, bucket, k, target)) {
				return true;
			}
			bucket[i] -= nums[cur];
		}
		return false;
	}

	public static void main(String[] args) {
		boolean res = canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
		System.out.println(res);
	}

}
