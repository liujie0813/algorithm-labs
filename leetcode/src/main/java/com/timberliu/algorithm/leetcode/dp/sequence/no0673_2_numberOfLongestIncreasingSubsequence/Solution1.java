package com.timberliu.algorithm.leetcode.dp.sequence.no0673_2_numberOfLongestIncreasingSubsequence;

/**
 * 673. 最长递增子序列的个数
 *
 *   f[i] 考虑以 nums[i] 为结尾的最长上升子序列的长度
 *
 *   f[i] 如何转移
 *     1. 每个数都能独自一个成为子序列，起始必然有 f[i] = 1
 *     2. 枚举 [0, i) 的所有数 nums[j]，如果 nums[j] < nums[i]，则 nums[i] 可以接在 nums[j] 后面，f[i] = f[j] + 1
 *
 *   g[i] 考虑以 nums[i] 结尾的最长上升子序列的个数
 *
 *   g[i] 如何转移
 *     1. 每个数都能独自一个成为子序列，起始必然有 g[i] = 1
 *     2. 枚举 [0, i) 的所有数 nums[j]，如果 nums[j] < nums[i]，则 nums[i] 可以接在 nums[j] 后面
 *        a. f[i] < f[j] + 1：直接更新 g[i] = g[j]
 *        b. f[i] = f[j] + 1：累加方案数，g[i] += g[j]
 *
 * @author Timber
 * @date 2021/10/25
 */
public class Solution1 {

	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] f = new int[n], g = new int[n];
		int max = 1;
		for (int i = 0; i < n; i++) {
			f[i] = g[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (f[i] < f[j] + 1) {
						f[i] = f[j] + 1;
						g[i] = g[j];
					} else if (f[i] == f[j] + 1) {
						g[i] += g[j];
					}
				}
			}
			max = Math.max(max, f[i]);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (f[i] == max) {
				res += g[i];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));

	}

}
