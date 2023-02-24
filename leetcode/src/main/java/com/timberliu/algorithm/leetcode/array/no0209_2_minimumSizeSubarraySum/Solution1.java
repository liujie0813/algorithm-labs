package com.timberliu.algorithm.leetcode.array.no0209_2_minimumSizeSubarraySum;

/**
 * 209. 长度最小的子数组
 *   和等于 target 的子数组的最小长度
 *
 *  滑动窗口
 *   1. end 遍历不断右移
 *   2. start 判断是否符合 target 条件
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static int minSubArrayLen(int target, int[] nums) {
		int res = nums.length;
		int sum = 0;
		int start = 0;
		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];
			while (sum >= target) {
				res = Math.min(end - start + 1, res);
				sum -= nums[start];
				start++;
			}
		}
		return res;
    }

    public static void main(String[] args) {
		int res = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
		System.out.println(res);
	}

}