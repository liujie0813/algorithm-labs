package com.timberliu.algorithm.leetcode.dp.sequence.no0368_2_largestDivisibleSubSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 *
 *  对 nums 排好序，从前往后处理时，对于 nums[i]，检查位置 i 之前，形成的所有【整除子集】中，最长的【整除子集】，将 nums[i] 接在后面
 *
 *  序列 DP：某个状态的转移 依赖于 前一个状态的关系。
 *         nums[i] 能够接在 nums[j] 后面，取决于是否满足 nums[i] % nums[j] == 0
 *
 *  状态定义：f[i] 考虑前 i 个数字，且以第 i 个数为结尾的最长【整除子集】长度
 *
 *  状态转移方程：
 *      对于位置 i：
 *      1. 如果 i 之前找不到符合条件的位置 j（nums[i] % nums[j] == 0）
 *          只能自己独立作为【整除子集】的第一个数，有 f[i] = 1
 *      2. 如果 i 之前能找到符合条件的位置 j，取最大值
 *           有 f[i] = f[j] + 1
 *
 *   g[i]：记录 f[i] 是由哪个下标的状态转移而来，如果 f[i] = f[j] + 1，则有 g[i] = j
 *
 * @author Timber
 * @date 2021/10/22
 */
public class Solution1 {

	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int[] dp = new int[n];
		int[] g = new int[n];

		for (int i = 0; i < n; i++) {
			// 至少包含自身一个数，因此长度为 1，由自身转移而来
			int maxLen = 1, prev = i;
			// 剪枝，最大到 nums[i] / 2
			int pivot = nums[i] / 2;
			for (int j = 0; nums[j] <= pivot && j < i; j++) {
				// 较大的 对 较小的 取余
				if (nums[i] % nums[j] == 0) {
					if (dp[j] + 1 > maxLen) {
						maxLen = dp[j] + 1;
						prev = j;
					}
				}
			}
			dp[i] = maxLen;
			g[i] = prev;
		}

		// 遍历得到最大长度，及其对应的下标
		int maxLen = -1, idx = -1;
		for (int i = 0; i < n; i++) {
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				idx = i;
			}
		}

		// g[] 回溯
		List<Integer> res = new ArrayList<>();
		while (res.size() < maxLen) {
			res.add(nums[idx]);
			idx = g[idx];
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/largest-divisible-subset/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		List<Integer> res1 = solution1.largestDivisibleSubset(new int[]{1, 2, 3});
		for (Integer a : res1) {
			System.out.print(a + " ");
		}
		System.out.println();

		System.out.println("----- 2 -----");
		List<Integer> res2 = solution1.largestDivisibleSubset(new int[]{1, 2, 4, 8});
		for (Integer a : res2) {
			System.out.print(a + " ");
		}
		System.out.println();


	}

}
