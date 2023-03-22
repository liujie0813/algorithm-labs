package com.timberliu.algorithm.leetcode.greedy.no0056_2_mergeIntervals;

import com.timberliu.algorithm.leetcode.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 *  区间类的问题，基本都是先按左边界或右边界排序，然后再看重叠区间
 *  56 是区间重叠时，合并区间
 *
*/

public class Solution1 {

    public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		List<int[]> res = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				// 有重叠，更新右边界
				end = Math.max(intervals[i][1], end);
			} else {
				res.add(new int[]{start, end});
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		res.add(new int[]{start, end});
		return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
		int[][] res = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
		PrintUtils.printIntArray(res);

		int[][] res1 = merge(new int[][]{{1, 4}, {4, 5}});
		PrintUtils.printIntArray(res1);
	}

}