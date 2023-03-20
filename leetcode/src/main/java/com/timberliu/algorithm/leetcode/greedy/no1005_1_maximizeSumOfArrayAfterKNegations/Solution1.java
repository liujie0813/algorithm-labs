package com.timberliu.algorithm.leetcode.greedy.no1005_1_maximizeSumOfArrayAfterKNegations;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1005. K 次取反后最大化的数组和
 *
 *  贪心：
 *    局部最优：绝对值大的负数变为正数
 *           如果所有数都为正数了，k 仍大于 0，反复转变数值最小的正数，将 k 用完
 *
 *    用了两次贪心
 */

public class Solution1 {

    public static int largestSumAfterKNegations(int[] nums, int k) {
    	// 按照绝对值从大到小排序
		nums = IntStream.of(nums).boxed().sorted((a1, a2) -> Math.abs(a2) - Math.abs(a1)).mapToInt(Integer::intValue).toArray();
		// 优先将绝对值较大的负数变为正数
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0 && k > 0) {
				// 如果是负数，才反转
				nums[i] = -nums[i];
				k--;
			}
		}
		// 如果 k 还大于 0，反复转变数值最小的正数
		if (k % 2 == 1) {
			nums[nums.length - 1] = -nums[nums.length - 1];
		}
		return Arrays.stream(nums).sum();
	}

	public static int largestSumAfterKNegations2(int[] nums, int k) {
    	if (nums.length == 1) {
    		return k % 2 == 0 ? nums[0] : -nums[0];
		}
    	Arrays.sort(nums);
    	int index = 0;
		for (int i = 0; i < k; i++) {
			if (i < nums.length - 1 && nums[index] < 0) {
				nums[index] = -nums[index];
				// [-3, -3]、[-3, 0]、[-3, 3]
				if (nums[index] >= Math.abs(nums[index + 1])) {
					index++;
				}
			} else {
				nums[index] = -nums[index];
			}
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

    public static void main(String[] args) {
		int res1 = largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
		System.out.println(res1);

		int res2 = largestSumAfterKNegations2(new int[]{2, -3, -1, 5, -4}, 2);
		System.out.println(res2);
	}

}