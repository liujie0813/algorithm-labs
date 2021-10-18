package com.timberliu.algorithm.leetcode.dp.linear.no0053_1_maximumSubarray;

/**
 * 53. 最大子序和
 *
 *  f[i] 考虑前 i 个数字，其总和的最大值
 *
 *  f[i] = max(nums[i], f[i-1] + nums[i])
 *
 *  空间优化
 *
 * @author liujie
 * @date 2021/10/18
 */

public class Solution2 {

	public static int maxSubArray(int[] nums) {
		int n = nums.length;
		int last = nums[0];
		int res = nums[0];
		for (int i = 1; i < n; i++) {
			last = Math.max(nums[i], last + nums[i]);
			res = Math.max(res, last);
		}
		return res;
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
