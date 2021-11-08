package com.timberliu.algorithm.leetcode.greedy.no0435_2_nonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
 *  按照右边界排序，从左向右记录非交叉区间的个数。区间总数减去非交叉区间个数 即 移除的区间最小个数
 *
 *  求非交叉区间的最大个数
 *
 *  局部最优：优先选右边界最小的区间。如此从左向右遍历，留给下一个区间的空间就更大
 *  全局最优：选取最多的非交叉区间
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
		// 记录非交叉区间的个数
		// 区间 end
		int count = 1;
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			// 下一个非交叉区间 >= end
			if (end <= intervals[i][0]) {
				end = intervals[i][1];
				count++;
			}
		}
		return intervals.length - count;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/non-overlapping-intervals/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		System.out.println(solution1.eraseOverlapIntervals(new int[][]{
				{1, 2},
				{2, 3},
				{3, 4},
				{1, 3},
		}));

		System.out.println("----- 2 -----");
		System.out.println(solution1.eraseOverlapIntervals(new int[][]{
				{1, 2},
				{1, 2},
				{1, 2},
		}));

		System.out.println("----- 3 -----");
		System.out.println(solution1.eraseOverlapIntervals(new int[][]{
				{1, 2},
				{2, 3},
		}));

	}

}
