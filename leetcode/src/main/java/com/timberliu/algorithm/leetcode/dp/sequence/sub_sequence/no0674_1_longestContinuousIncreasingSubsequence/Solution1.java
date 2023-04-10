package com.timberliu.algorithm.leetcode.dp.sequence.no0674_1_longestContinuousIncreasingSubsequence;

import java.util.Arrays;

/**
 * 674. 最长连续递增子序列
 *
 *  dp[i]：考虑以 nums[i] 结尾的最长连续递增子序列的长度
 *
 *  推导：
 *   dp[i] = max(dp[i], dp[j] + 1), j=i-1
 *
 *  初始化：
 *   dp[i] = 1
 *
 */

public class Solution1 {

    public int findLengthOfLCIS(int[] nums) {
    	int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int res = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
			}
			res = Math.max(res, dp[i]);
		}
		return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
		int res = solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
		System.out.println(res);

    }
}