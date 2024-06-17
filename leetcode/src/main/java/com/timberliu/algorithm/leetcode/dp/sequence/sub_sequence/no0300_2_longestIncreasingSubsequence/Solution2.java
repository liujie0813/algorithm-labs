package com.timberliu.algorithm.leetcode.dp.sequence.sub_sequence.no0300_2_longestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class Solution2 {

	public List<Integer> lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] path = new int[n];
		Arrays.fill(path, -1);

		int index = 0, len = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						path[i] = j;
					}
				}
			}
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}

		List<Integer> res = new ArrayList<>();
		while (index != -1) {
			res.add(nums[index]);
			index = path[index];
		}
		return res;
    }

    public static void main(String[] args) {
		Solution2 solution1 = new Solution2();
		List<Integer> res = solution1.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(res);

	}

}