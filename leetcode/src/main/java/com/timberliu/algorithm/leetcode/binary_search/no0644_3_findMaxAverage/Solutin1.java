package com.timberliu.algorithm.leetcode.binary_search.no0644_3_findMaxAverage;

/**
 * 644. 子数组最大平均数 II
 *
 * @author liujie
 * @date 2023/4/13
 */

public class Solutin1 {

	public static double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		double maxVal = Integer.MIN_VALUE;
		double minVal = Integer.MAX_VALUE;
		for (int num : nums) {
			maxVal = Math.max(maxVal, num);
			minVal = Math.min(minVal, num);
		}
		double preMid = Integer.MAX_VALUE, error = Integer.MAX_VALUE;
		while (error > Math.pow(10, -5)) {
			double mid = (maxVal + minVal) * 0.5;
			if (check(nums, mid, k)) {
				minVal = mid;
			} else {
				maxVal = mid;
			}
			error = Math.abs(preMid - mid);
			preMid = mid;
		}
		return minVal;
	}

	/**
	 * 是否存在子数组，平均值大于等于 mid
	 */
	private static boolean check(int[] nums, double mid, int k) {
		double prefixSum = 0;
		for (int i = 0; i < k; i++) {
			prefixSum += nums[i] - mid;
		}
		if (prefixSum >= 0) {
			return true;
		}
		double prePrefixSum = 0;
		double minPrePrefixSum = 0; // 赋值为 0
		for (int i = k; i < nums.length; i++) {
			// [0, i] 前缀和
			prefixSum += nums[i] - mid;
			// [0, i-k] 前缀和，取最小的 minPrePrefixSum（如对应 j）
			prePrefixSum += nums[i - k] - mid;
			minPrePrefixSum = Math.min(minPrePrefixSum, prePrefixSum);
			// [j, i] 满足条件
			if (prefixSum - minPrePrefixSum >= 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		double res = findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
		System.out.println(res);
	}

}
