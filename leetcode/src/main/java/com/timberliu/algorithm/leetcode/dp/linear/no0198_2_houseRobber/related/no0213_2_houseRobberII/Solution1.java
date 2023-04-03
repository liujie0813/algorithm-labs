package com.timberliu.algorithm.leetcode.dp.linear.no0198_2_houseRobber.related.no0213_2_houseRobberII;

/**
 * 219. 打家劫舍 II
 *
 *  与 198 不同的是，数组成环了
 *
 *  有几种情况：
 *   1. 不包含首尾元素
 *   2. 不包含首元素
 *   3. 不包含尾元素
 *
 *
 *
 * @author liujie
 * @date 2023/4/3
 */

public class Solution1 {

	public static int rob(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int res1 = doRob(nums, 0, nums.length - 2);
		int res2 = doRob(nums, 1, nums.length - 1);
		return Math.max(res1, res2);
	}

	public static int doRob(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int[] dp = new int[nums.length];
		dp[start] = nums[start];
		dp[start + 1] = Math.max(nums[start], nums[start + 1]);

		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[end];
	}

	public static void main(String[] args) {
		int res = rob(new int[]{2, 7, 9, 3, 1});
		System.out.println(res);
	}

}
