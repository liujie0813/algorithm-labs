package com.timberliu.algorithm.leetcode.dp.sequence.no0446_3_arithmeticSlicesiiSubsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 *
 *  状态定义：f[i][j] 表示以 nums[i] 为结尾，且差值为 j 的子序列个数
 *
 *  令差值为 d = nums[i] - nums[j]
 *    f[i][d] = sum(f[j][d] + 1)  0 <= j <= i-1
 *
 * @author Timber
 * @date 2021/10/26
 */
public class Solution1 {

	public int numberOfArithmeticSlices(int[] nums) {
		int n = nums.length;
		// f[i] 为哈希表
		List<Map<Long, Integer>> f = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Map<Long, Integer> cur = new HashMap<>();
			for (int j = 0; j < i; j++) {
				Long d = (long) nums[i] - nums[j];
				Map<Long, Integer> prev = f.get(j);
				// cnt 以 nums[i] 结尾，且差值为 d 的子序列数量
				int cnt = cur.getOrDefault(d, 0);
				cnt += prev.getOrDefault(d, 0);
				cnt++;
				cur.put(d, cnt);
			}
			f.add(cur);
		}

		// 所有长度大于等于 2 的等差子序列个数
		int res = 0;
		for (int i = 0; i < n; i++) {
			Map<Long, Integer> cur = f.get(i);
			for (Integer val : cur.values()) {
				res += val;
			}
		}
		// 长度为 2 的等差子序列个数
		int cnt = n * (n - 1) / 2;
		return res - cnt;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));

	}

}
