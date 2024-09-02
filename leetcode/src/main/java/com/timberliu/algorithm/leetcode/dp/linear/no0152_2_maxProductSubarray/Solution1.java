package com.timberliu.algorithm.leetcode.dp.linear.no0152_2_maxProductSubarray;

/**
 * 152. 最大非空连续子数组
 *
 * @author liujie
 * @date 2024/9/2
 */

public class Solution1 {

	public int maxProduct(int[] nums) {
		int min = nums[0], max = nums[0], res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = max;
				max = min;
				min = tmp;
				// 当前数小于 0，乘以当前数之后，最大变最小，最小变最大
			}
			max = Math.max(max * nums[i], nums[i]);
			min = Math.max(min * nums[i], nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int res = solution1.maxProduct(new int[]{2, 3, -2, 4});
		System.out.println(res);

	}

}
