package com.timberliu.algorithm.leetcode.dp.linear.no0053_1_maximumSubarray;

/**
 * 53. 最大子序和
 *
 *  贪心
 *   局部最优：当连续和为负数时，应该放弃，从下一个元素开始重新计算
 *
 *   等到连续和为负数时，就丢弃掉；因为 sum 为正数，就会后面的元素起到 增大总和 的作用
 *
 * @author liujie
 * @date 2021/10/18
 */

public class Solution3 {

	public static int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > result) {
				result = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/maximum-subarray/ -----");
		System.out.println("----- 1 -----");
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

		System.out.println("----- 2 -----");
		System.out.println(maxSubArray(new int[]{1}));

		System.out.println("----- 3 -----");
		System.out.println(maxSubArray(new int[]{0}));

		System.out.println("----- 4 -----");
		System.out.println(maxSubArray(new int[]{-1}));

		System.out.println("----- 5 -----");
		System.out.println(maxSubArray(new int[]{-100000}));

	}

}
