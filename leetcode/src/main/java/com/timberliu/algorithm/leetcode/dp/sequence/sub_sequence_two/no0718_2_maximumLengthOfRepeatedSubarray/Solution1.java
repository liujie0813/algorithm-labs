package com.timberliu.algorithm.leetcode.dp.sequence.sub_sequence_two.no0718_2_maximumLengthOfRepeatedSubarray;

/**
 * 718. 最长重复子数组
 *
 *  dp[i][j]：考虑前 i 个元素的 nums1，和前 j 个元素的 nums2，的最长重复子数组长度
 *
 *  推导：
 *   如果 nums[i - 1] = nums[j - 1]，则 dp[i][j] = dp[i - 1][j - 1] + 1
 *
 *  初始化：
 *   遍历时 i 和 j 从 1 开始，不用单独初始化 dp[0][j] 和 dp[i][0]
 *   dp[0][j] 和 dp[i][0] 表示 0 个元素，赋为 0 即可
 */

public class Solution1 {

    public int findLength(int[] nums1, int[] nums2) {
    	int m = nums1.length, n = nums2.length;
		int[][] dp = new int[m + 1][n + 1];
		int res = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
    }

	public int findLength1(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int[] dp = new int[n + 1];
		int res = 0;
		for (int i = 1; i <= m; i++) {
			// 从后往前，防止覆盖
			for (int j = n; j >= 1; j--) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[j] = dp[j - 1] + 1;
				} else {
					// 不等时需要赋为 0
					dp[j] = 0;
				}
				res = Math.max(res, dp[j]);
			}
		}
		return res;
	}

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
		int res = solution.findLength1(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
		System.out.println(res);
	}

}