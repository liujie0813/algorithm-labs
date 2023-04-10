package com.timberliu.algorithm.leetcode.dp.sequence.sub_sequence.no0300_2_longestIncreasingSubsequence;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 *  dp[i] 表示考虑以 nums[i] 结尾的最长递增子序列的长度
 *
 *  推导:
 *   dp[i] = max(dp[i], dp[j] + 1)， 0 <= j < i, nums[i] > nums[j]
 *
 *  初始化：
 *   dp[i] = 1
 *
 */

public class Solution1 {

	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
    }

    public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int res = solution1.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(res);

	}

}